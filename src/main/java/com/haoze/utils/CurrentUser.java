package com.haoze.utils;

import com.haoze.model.system.department.entity.EmrDepartmentEntity;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.service.system.EmrDepartmentService;
import com.haoze.service.system.EmrUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * 当前用户工具。
 * @author maxl
 * @time 2018-05-18。
 */
public class CurrentUser {

    private final static String CURRENT_DEPT_KEY = "userDepartment";
    private final static String CURRENT_Organization_KEY = "userOrganization";
    private static EmrUserService emrUserService = ApplicationContextUtil.getBean(EmrUserService.class);
    private static EmrDepartmentService emrDepartmentService = ApplicationContextUtil.getBean(EmrDepartmentService.class);;
    private static String roleNames = "";
    private static String departmentNames = "";

    public static void setCurrentUserOrganization(String organizationId){
        ShiroUtil.getSession().setAttribute(ShiroUtil.getUserId() + CURRENT_Organization_KEY,organizationId);
    }

    public static String getCurrentUserOrganization(){
        return ShiroUtil.getSession().getAttribute(ShiroUtil.getUserId() + CURRENT_Organization_KEY) == null ? "" :
                ShiroUtil.getSession().getAttribute(ShiroUtil.getUserId() + CURRENT_Organization_KEY).toString();
    }

    public static EmrDepartmentEntity getCurrentUserDepartment(){

        return ShiroUtil.getSession().getAttribute(ShiroUtil.getUserId() + CURRENT_DEPT_KEY) == null ? null :
                (EmrDepartmentEntity)ShiroUtil.getSession().getAttribute(ShiroUtil.getUserId() + CURRENT_DEPT_KEY);
    }

    public static void setCurrentUserDepartment(String departmentId){
        EmrDepartmentEntity emrDepartmentEntity = emrDepartmentService.get(departmentId);
        ShiroUtil.getSession().setAttribute(ShiroUtil.getUserId() + CURRENT_DEPT_KEY,emrDepartmentEntity);
        roleNames = emrUserService.getUserRoleNames(ShiroUtil.getUserId());
        departmentNames = emrUserService.getUserDepartmentNames(ShiroUtil.getUserId());
    }

    public static String getUserRoleNames(){
        return roleNames;
    }

    public static String getDepartmentNames(){
        return departmentNames;
    }

    public static EmrUserEntity getUser() {
        Object object = getSubjct().getPrincipal();
        return (EmrUserEntity)object;
    }

    public static String getUserId() {
        if(getUser() == null){
            return "";
        }
        return getUser().getID();
    }

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
}
