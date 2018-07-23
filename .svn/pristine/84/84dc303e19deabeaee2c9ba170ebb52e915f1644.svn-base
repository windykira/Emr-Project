package com.haoze.service.template.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoze.common.model.ResponseResult;
import com.haoze.dao.template.TemplateClassDao;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.service.template.TemplateClassService;
import com.haoze.utils.UUIDUtil;

/**
 * 病历模板类型接口实现类。
 * @author maxl
 * @time 2018-05-31。
 */
@Service
public class TemplateClassServiceImpl implements TemplateClassService {

    @Autowired
    TemplateClassDao templateClassDao;

    @Transactional
    @Override
    public ResponseResult save(EmrTemplateClassEntity role) {
    	 try {
       role.setID(UUIDUtil.randomString());
       templateClassDao.save(role);
       return ResponseResult.success();
         }catch (Exception e){
             e.printStackTrace();
             return ResponseResult.failure(0, "保存失败");
         }
    }

    @Override
    @Transactional
    public ResponseResult remove(String sympId) {
        try {
            //TODO 如果角色绑定用户 则该角色不能删除

            //删除角色信息
            templateClassDao.remove(sympId);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0,"删除失败");
        }
    }


    @Override
    @Transactional
    public ResponseResult update(EmrTemplateClassEntity tempClass) {

        try {
            templateClassDao.update(tempClass);
            //删除原先角色菜单关联关系
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public List<EmrTemplateClassEntity> listRoles() {
        return templateClassDao.list();
    }


	@Override
	public EmrTemplateClassEntity get(String roleId) {
		// TODO Auto-generated method stub
		EmrTemplateClassEntity EmrTemplateClassEntity = templateClassDao.get(roleId);
	     return EmrTemplateClassEntity;
	}

}
