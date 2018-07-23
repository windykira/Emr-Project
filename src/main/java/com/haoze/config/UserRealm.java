package com.haoze.config;

import com.haoze.dao.system.EmrUserDao;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.service.system.EmrMenuService;
import com.haoze.utils.ApplicationContextUtil;
import com.haoze.utils.CurrentUser;
import com.haoze.utils.ShiroUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户授权认证信息。
 * @author maxl
 * @time 2018-04-27。
 */
public class UserRealm extends AuthorizingRealm {

	/*@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

		Long userId = ShiroUtil.getUserId();
		MenuService menuService = ApplicationContextUtil.getBean(MenuService.class);
		Set<String> perms = menuService.listPerms(userId);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		return info;
	}*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

		String userID = ShiroUtil.getUserId();
		EmrMenuService emrMenuService = ApplicationContextUtil.getBean(EmrMenuService.class);
		Set<String> perms = emrMenuService.listUserPermissions(userID);
		Set<String> roles = emrMenuService.listUserRoles(userID);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(perms);
		info.setRoles(roles);
		return info;
	}

	/*@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Map<String, Object> map = new HashMap(16);
		map.put("username", username);
		String password = new String((char[]) token.getCredentials());

		UserDao userMapper = ApplicationContextUtil.getBean(UserDao.class);
		//查询用户信息
		UserEntity user = userMapper.list(map).get(0);
		// 账号不存在
		if (user == null) {
			throw new UnknownAccountException("不存在的账号。");
		}
		// 密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("密码不正确。");
		}

		// 账号锁定
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号已被锁定,请联系管理员。");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}*/

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String userName = (String) token.getPrincipal();
		Map<String, Object> map = new HashMap();
		map.put("account", userName);
		String passWord = new String((char[]) token.getCredentials());

		EmrUserDao emrUserMapper = ApplicationContextUtil.getBean(EmrUserDao.class);
		//查询用户账号是否存在
		List<EmrUserEntity> emrUsers = emrUserMapper.listUsers(map);

		if (emrUsers.size() == 0) {
			throw new UnknownAccountException("不存在的账号。");
		}
		EmrUserEntity emrUserEntity = emrUsers.get(0);
		if (!passWord.equals(emrUserEntity.getPassWord())) {
			throw new IncorrectCredentialsException("密码不正确。");
		}
		if ("2".equals(emrUserEntity.getStatus())) {
			throw new LockedAccountException("账号已被锁定,请联系管理员。");
		}
		//CurrentUser.setCurrentUserOrganization(emrUserEntity.getUserOrganization());
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(emrUserEntity, passWord, getName());
		return simpleAuthenticationInfo;
	}

}
