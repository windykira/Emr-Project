package com.haoze.common.controller;

import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.utils.ShiroUtil;
import org.springframework.stereotype.Controller;

/**
 * 基础Controller。
 * @author maxl
 * @time 2018-04-27。
 */
@Controller
public class BaseController {

	public EmrUserEntity getUser() {
		return ShiroUtil.getUser();
	}

	public String getUserId() {
		return getUser().getID();
	}

	public String getUsername() {
		return getUser().getAccount();
	}
}