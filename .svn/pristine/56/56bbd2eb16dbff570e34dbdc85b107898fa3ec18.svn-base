package com.haoze.utils;

import com.haoze.model.system.user.entity.EmrUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

/**
 * shiro操作工具。
 * @author maxl
 * @time 2018-04-27。
 */
public class ShiroUtil {

    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
    public static EmrUserEntity getUser() {
        Object object = getSubjct().getPrincipal();
        return (EmrUserEntity)object;
    }
    public static String getUserId() {
        return getUser().getID();
    }
    public static void logout() {
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

}
