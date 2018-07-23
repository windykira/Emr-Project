package com.haoze.controller.system;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.dao.system.EmrDepartmentDao;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.service.system.EmrDepartmentService;
import com.haoze.service.system.EmrMenuService;
import com.haoze.service.system.EmrUserService;
import com.haoze.utils.CurrentUser;
import com.haoze.utils.MD5Util;
import com.haoze.utils.ShiroUtil;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户相关控制器信息。
 * @author maxl
 * @time 2018-05-07。
 */
@Controller
public class EmrLoginController extends BaseController {

    @Autowired
    EmrMenuService emrMenuService;
    @Autowired
    EmrDepartmentService emrDepartmentService;
    @Autowired
    EmrDepartmentDao emrDepartmentDao;
    @Autowired
    EmrUserService emrUserService;

    @GetMapping({ "/", "" ,"/login"})
    String login(Model model) {
        model.addAttribute("userId", CurrentUser.getUserId());
        return "login";
    }

    @Note("登录")
    @PostMapping("/login")
    @ResponseBody
    ResponseResult userLogin(String username, String password,String departmentId) {
        password = MD5Util.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            CurrentUser.setCurrentUserDepartment(departmentId);
            return ResponseResult.success();
        } catch (AuthenticationException e) {
            return ResponseResult.failure("用户账号或密码错误");
        }
    }

    @Note("系统管理")
    @GetMapping("/emrsys/system/{menuId}")
    String system(Model model,@PathVariable("menuId") String menuId) {
        Map<String,Object> paramMap = new HashedMap();
        paramMap.put("parentMenu",menuId);
        List<EmrMenuEntity> menus = emrMenuService.listMenus(paramMap);
        model.addAttribute("menus",menus);
        model.addAttribute("userId", getUser().getID());
        return "emrsys/system";
    }

    @Note("请求访问主页")
    @GetMapping({ "/index" })
    String index(Model model) {

        List<Tree<EmrMenuEntity>> menus = emrMenuService.listMenuTree(getUser().getID());
        List<Tree<EmrMenuEntity>> returnMenus = new ArrayList();
        for(Tree<EmrMenuEntity> emrMenuEntityTree : menus){
            returnMenus.add(emrMenuEntityTree);
        }

        Map<String,Object> paramsMap = new HashMap();
        paramsMap.put("userID",getUser().getID());
        model.addAttribute("menus", returnMenus);
        model.addAttribute("name", getUser().getAccount());
        model.addAttribute("userName", getUser().getUserName());
        model.addAttribute("userId", getUser().getID());
        model.addAttribute("departmentId",CurrentUser.getCurrentUserDepartment());
        model.addAttribute("picUrl","/img/photo_s.jpg");
        model.addAttribute("footerName",getUser().getUserName());
        model.addAttribute("dept",CurrentUser.getDepartmentNames());
        model.addAttribute("role",CurrentUser.getUserRoleNames());
        return "index";
    }

    @GetMapping("/logout")
    String logout() {
        ShiroUtil.logout();
        return "redirect:/login";
    }

}
