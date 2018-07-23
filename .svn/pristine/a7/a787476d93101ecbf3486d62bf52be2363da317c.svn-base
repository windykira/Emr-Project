package com.haoze.common.filter;

import com.haoze.model.system.user.entity.EmrUserEntity;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单账号登录控制。
 * @author maxl
 * @time 2018-05-19。
 */
public class KickoffSessionFilter extends AccessControlFilter {

    private String kickoffUrl; //踢下线后地址
    private boolean kickoffAfter = false; //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    private int maxSession = 1; //同一个帐号最大会话数
    private SessionManager sessionManager;
    private Cache<String, Deque<Serializable>> cache;

    public void setKickoffUrl(String kickoffUrl) {
        this.kickoffUrl = kickoffUrl;
    }

    public void setKickoffAfter(boolean kickoffAfter) {
        this.kickoffAfter = kickoffAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-activeSessionCache");
    }

    /**
     * 是否允许访问，返回true表示允许
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    /**
     * 表示访问拒绝时是否自己处理，如果返回true表示自己不处理且继续拦截器链执行，返回false表示自己已经处理了（比如重定向到另一个页面）。
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            //如果没有登录，直接进行之后的流程
            return true;
        }

        Session session = subject.getSession();
        EmrUserEntity emrUserEntity = (EmrUserEntity) subject.getPrincipal();
        String userName = emrUserEntity.getAccount();
        Serializable sessionId = session.getId();

        //TODO 同步控制
        Deque<Serializable> deque = cache.get(userName);
        if (deque == null) {
            deque = new LinkedList();
            cache.put(userName, deque);
        }

        //如果队列里没有此sessionId，且用户没有被踢出；放入队列
        if (!deque.contains(sessionId) && session.getAttribute("kickoff") == null) {
            deque.push(sessionId);
        }

        //如果队列里的sessionId数超出最大会话数，开始踢人
        while (deque.size() > maxSession) {
            Serializable kickoffSessionId;
            if (kickoffAfter) {
                //踢出后者
                //kickoffSessionId = deque.getFirst();
                kickoffSessionId = deque.removeFirst();
            } else {
                //踢出前者
                kickoffSessionId = deque.removeLast();
            }
            try {
                Session kickoffSession = sessionManager.getSession(new DefaultSessionKey(kickoffSessionId));
                if (kickoffSession != null) {
                    //设置会话的kickoff属性表示踢出了
                    kickoffSession.setAttribute("kickoff", true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //如果被踢出了，直接退出，重定向到踢出后的地址
        if (session.getAttribute("kickoff") != null) {
            try {
                subject.logout();
            } catch (Exception e) {
            }
            saveRequest(request);
            WebUtils.issueRedirect(request, response, kickoffUrl);
            return false;
        }

        return true;
    }
}
