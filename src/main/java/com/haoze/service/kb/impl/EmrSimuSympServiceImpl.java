package com.haoze.service.kb.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haoze.common.model.ResponseResult;
import com.haoze.dao.kb.EmrSimuSympDao;
import com.haoze.model.kb.symp.entity.SimuSympEntity;
import com.haoze.service.kb.EmrSimuSympService;
import com.haoze.utils.UUIDUtil;

/**
 * 知识库症状数据服务接口实现类。
 * @author daiyiming
 * @time 2018-05-09。
 */
@Service
public class EmrSimuSympServiceImpl implements EmrSimuSympService{

    @Autowired
    EmrSimuSympDao emrSimuSympDao;


    @Transactional
    @Override
    public ResponseResult save(SimuSympEntity role) {
    	 try {
       role.setID(UUIDUtil.randomString());
       emrSimuSympDao.save(role);
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
            emrSimuSympDao.remove(sympId);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0,"删除失败");
        }
    }


    @Override
    @Transactional
    public ResponseResult update(SimuSympEntity role) {

        try {
            emrSimuSympDao.update(role);
            //删除原先角色菜单关联关系
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public List<SimuSympEntity> listRoles() {
        return emrSimuSympDao.list();
    }

	@Override
	public ResponseResult batchRemove(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.haoze.model.kb.symp.entity.SimuSympEntity get(String roleId) {
		// TODO Auto-generated method stub
		SimuSympEntity SimuSympEntity = emrSimuSympDao.get(roleId);
	     return SimuSympEntity;
	}

	@Override
	public SimuSympEntity getByName(String simuSympName) {
		// TODO Auto-generated method stub
		
		SimuSympEntity SimuSympEntity = emrSimuSympDao.getByName(simuSympName);
		return SimuSympEntity;
	}

}
