package com.haoze.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.enumeration.common.DelFlagEnum;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.dao.system.*;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.model.system.user.entity.EmrUserDepartmentEntity;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.system.user.entity.EmrUserRoleEntity;
import com.haoze.model.system.user.vo.EmrUserVO;
import com.haoze.service.system.EmrUserService;
import com.haoze.utils.FixedFieldInitializedUtil;
import com.haoze.utils.MD5Util;
import com.haoze.utils.ShiroUtil;
import com.haoze.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户数据服务接口实现类。
 * @author maxl
 * @time 2018-05-07。
 */
@Service
public class EmrUserServiceImpl implements EmrUserService {

    @Autowired
    EmrUserDao emrUserMapper;
    @Autowired
    EmrDepartmentDao emrDepartmentMapper;
    @Autowired
    EmrUserRoleDao emrUserRoleMapper;
    @Autowired
    EmrUserDepartmentDao emrUserDepartmentMapper;
    @Autowired
    EmrHisEmpDao emrHisEmpMapper;

    @Override
    public EmrUserEntity get(String userId) {

        EmrUserEntity user = emrUserMapper.get(userId);
        return user;
    }

    @Override
    public EmrUserEntity getByAccountAndPassword(Map<String, Object> paramMap) {
        return emrUserMapper.getByAccountAndPassword(paramMap);
    }

    @Override
    public Page<EmrUserEntity> listUsers(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(),queryParam.getLimit());
        queryParam.put("delFlag", DelFlagEnum.Not_Deleted.getEnumValue());
        return emrUserMapper.listUsers(queryParam);
    }

    @Override
    public int countUsers(Map<String, Object> map) {
        map.put("delFlag", DelFlagEnum.Not_Deleted.getEnumValue());
        return emrUserMapper.countUsers(map);
    }

    @Override
    @Transactional
    public ResponseResult batchSave(List<EmrUserEntity> list) {

        try {
            emrUserMapper.batchSave(list);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.failure(0,"保存失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult save(EmrUserVO emrUserVO) {

        try {
            //新增用户信息
            EmrUserEntity emrUser = emrUserVO.getEmrUser();
            FixedFieldInitializedUtil.initialize(emrUser);
            emrUser.setUserCode(emrUser.getAccount());
            emrUserMapper.save(emrUser);
            //删除用户科室关联关系数据
            emrUserDepartmentMapper.removeByUserId(emrUser.getID());
            //新增用户科室关联关系
            if(emrUserVO.getDepartmentIds() != null && emrUserVO.getDepartmentIds().size() > 0){

                List<EmrUserDepartmentEntity> departments = new ArrayList();
                for(String departmentId : emrUserVO.getDepartmentIds()){
                    EmrUserDepartmentEntity emrUserDepartmentEntity = new EmrUserDepartmentEntity();
                    emrUserDepartmentEntity.setID(UUIDUtil.randomString());
                    emrUserDepartmentEntity.setCreator(ShiroUtil.getUserId());
                    emrUserDepartmentEntity.setCreateTime(new Date());
                    emrUserDepartmentEntity.setModifyTime(new Date());
                    emrUserDepartmentEntity.setModifier(ShiroUtil.getUserId());
                    emrUserDepartmentEntity.setOrganization(ShiroUtil.getUser().getUserOrganization());
                    emrUserDepartmentEntity.setDelFlag(DelFlagEnum.Not_Deleted.getEnumValue());
                    emrUserDepartmentEntity.setUserId(emrUser.getID());
                    emrUserDepartmentEntity.setDepartmentId(departmentId);
                    departments.add(emrUserDepartmentEntity);
                }
                emrUserDepartmentMapper.batchSave(departments);
            }

            //删除用户角色关联关系
            emrUserRoleMapper.removeByUserId(emrUser.getID());
            //新增用户角色关联关系
            if(emrUserVO.getRoleIds() != null && emrUserVO.getRoleIds().size() > 0){

                List<EmrUserRoleEntity> roles = new ArrayList();
                emrUserVO.getRoleIds().forEach(roleId->{

                    EmrUserRoleEntity emrUserRoleEntity = new EmrUserRoleEntity();
                    emrUserRoleEntity.setID(UUIDUtil.randomString());
                    emrUserRoleEntity.setCreator(ShiroUtil.getUserId());
                    emrUserRoleEntity.setCreateTime(new Date());
                    emrUserRoleEntity.setModifyTime(new Date());
                    emrUserRoleEntity.setModifier(ShiroUtil.getUserId());
                    emrUserRoleEntity.setOrganization(ShiroUtil.getUser().getUserOrganization());
                    emrUserRoleEntity.setDelFlag(DelFlagEnum.Not_Deleted.getEnumValue());
                    emrUserRoleEntity.setUserId(emrUser.getID());

                    emrUserRoleEntity.setRoleId(roleId);
                    roles.add(emrUserRoleEntity);
                });

                emrUserRoleMapper.batchSave(roles);
            }
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "新增失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult remove(String userId) {

        try {
            //删除用户科室关联关系
            emrUserDepartmentMapper.removeByUserId(userId);
            //删除用户角色关联关系
            emrUserRoleMapper.removeByUserId(userId);
            //删除用户信息--逻辑删除
            EmrUserEntity emrUserEntity = new EmrUserEntity();
            emrUserEntity.setID(userId);
            emrUserEntity.setDelFlag(DelFlagEnum.Deleted.getEnumValue());
            emrUserMapper.update(emrUserEntity);
            //更新EMP人员创建状态
            EmrHisEmpEntity emrHisEmpEntity = new EmrHisEmpEntity();

            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "删除失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult resetPassWord(EmrUserEntity emrUserEntity) {
        try {
            if("admin".equals(emrUserEntity.getAccount())){
                return ResponseResult.failure(0,"超级管理员的账号不允许重置！");
            }
            emrUserEntity.setPassWord(MD5Util.encrypt(emrUserEntity.getAccount(), emrUserEntity.getPassWord()));
            emrUserMapper.update(emrUserEntity);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "重置失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult update(EmrUserVO emrUserVO) {

        try {
            emrUserMapper.update(emrUserVO.getEmrUser());
            //刪除用戶部门关联关系
            emrUserDepartmentMapper.removeByUserId(emrUserVO.getEmrUser().getID());
            if(emrUserVO.getDepartmentIds() != null && emrUserVO.getDepartmentIds().size() > 0){

                List<EmrUserDepartmentEntity> userDepartmentEntities = new ArrayList();
                emrUserVO.getDepartmentIds().forEach(departmentId->{

                    EmrUserDepartmentEntity emrUserDepartmentEntity = new EmrUserDepartmentEntity();
                    emrUserDepartmentEntity.setDepartmentId(departmentId);
                    emrUserDepartmentEntity.setUserId(emrUserVO.getEmrUser().getID());
                    emrUserDepartmentEntity.setOrganization(emrUserVO.getEmrUser().getUserOrganization());
                    emrUserDepartmentEntity.setDelFlag(DelFlagEnum.Not_Deleted.getEnumValue());
                    emrUserDepartmentEntity.setID(UUIDUtil.randomString());
                    emrUserDepartmentEntity.setCreateTime(new Date());
                    emrUserDepartmentEntity.setCreator(ShiroUtil.getUserId());
                    emrUserDepartmentEntity.setModifier(ShiroUtil.getUserId());
                    emrUserDepartmentEntity.setModifyTime(new Date());
                    userDepartmentEntities.add(emrUserDepartmentEntity);
                });
                emrUserDepartmentMapper.batchSave(userDepartmentEntities);
            }
            //删除用户角色关系
            emrUserRoleMapper.removeByUserId(emrUserVO.getEmrUser().getID());
            if(emrUserVO.getRoleIds() != null && emrUserVO.getRoleIds().size() > 0){

                List<EmrUserRoleEntity> roleEntities = new ArrayList();
                emrUserVO.getRoleIds().forEach(roleId->{

                    EmrUserRoleEntity emrUserRoleEntity = new EmrUserRoleEntity();
                    emrUserRoleEntity.setID(UUIDUtil.randomString());
                    emrUserRoleEntity.setUserId(emrUserVO.getEmrUser().getID());
                    emrUserRoleEntity.setRoleId(roleId);
                    emrUserRoleEntity.setOrganization(emrUserVO.getEmrUser().getUserOrganization());
                    emrUserRoleEntity.setDelFlag(DelFlagEnum.Not_Deleted.getEnumValue());
                    emrUserRoleEntity.setCreator(ShiroUtil.getUserId());
                    emrUserRoleEntity.setCreateTime(new Date());
                    emrUserRoleEntity.setModifier(ShiroUtil.getUserId());
                    emrUserRoleEntity.setModifyTime(new Date());
                    roleEntities.add(emrUserRoleEntity);
                });
                emrUserRoleMapper.batchSave(roleEntities);
            }
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public String getUserRoleNames(String userId) {
        return emrUserRoleMapper.getUserRoleNames(userId);
    }

    @Override
    public String getUserDepartmentNames(String userId) {
        return emrUserDepartmentMapper.getUserDepartmentNames(userId);
    }


}
