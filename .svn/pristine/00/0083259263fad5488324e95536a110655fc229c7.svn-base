package com.haoze.service.kb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoze.common.model.ResponseResult;
import com.haoze.dao.kb.EmrSympDao;
import com.haoze.model.kb.symp.entity.SympEntity;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.service.kb.EmrSympService;
import com.haoze.utils.UUIDUtil;

/**
 * 知识库症状数据服务接口实现类。
 * @author daiyiming
 * @time 2018-05-09。
 */
@Service
public class EmrSympServiceImpl implements EmrSympService{

    @Autowired
    EmrSympDao emrRoleMapper;

    @Transactional
    @Override
    public ResponseResult save(SympEntity role) {
    	 try {
       role.setID(UUIDUtil.randomString());
       emrRoleMapper.save(role);
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
            emrRoleMapper.remove(sympId);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0,"删除失败");
        }
    }


    @Override
    @Transactional
    public ResponseResult update(SympEntity role) {

        try {
            emrRoleMapper.update(role);
            //删除原先角色菜单关联关系
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public List<SympEntity> listRoles() {
        return emrRoleMapper.list();
    }

	@Override
	public ResponseResult batchRemove(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.haoze.model.kb.symp.entity.SympEntity get(String roleId) {
		// TODO Auto-generated method stub
		SympEntity sympEntity = emrRoleMapper.get(roleId);
	     return sympEntity;
	}

	@Override
	public SympEntity getByName(String sympName) {
		// TODO Auto-generated method stub
		SympEntity sympEntity = emrRoleMapper.getByName(sympName);
	     return sympEntity;
	}

}
