package com.haoze.service.system;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.system.user.vo.EmrUserVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户数据服务接口。
 * @author maxl
 * @time 2018-05-07。
 */
@Service
public interface EmrUserService {

    /**
     * 查询用户
     * @param userId
     * @return
     */
    EmrUserEntity get(String userId);

    /**
     * 查询用户
     * @param paramMap
     * @return
     */
    EmrUserEntity getByAccountAndPassword(Map<String, Object> paramMap);

    /**
     * 查询用户信息
     * @param queryParam
     * @return
     */
    Page<EmrUserEntity> listUsers(QueryParam queryParam);

    /**
     * 统计用户信息
     * @param map
     * @return
     */
    int countUsers(Map<String, Object> map);

    /**
     * 新增用户
     * @param list
     */
    ResponseResult batchSave(List<EmrUserEntity> list);

    /**
     * 新增用户
     * @param emrUserVO
     * @return
     */
    ResponseResult save(EmrUserVO emrUserVO);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    ResponseResult remove(String userId);

    /**
     * 重置用户密码
     * @param emrUserEntity
     * @return
     */
    ResponseResult resetPassWord(EmrUserEntity emrUserEntity);

    /**
     * 更新用戶
     * @param emrUserVO
     * @return
     */
    ResponseResult update(EmrUserVO emrUserVO);

    /**
     * 查询用户关联全部角色名称
     * @param userId
     * @return
     */
    String getUserRoleNames(String userId);

    /**
     * 查询用户关联全部科室名称
     * @param userId
     * @return
     */
    String getUserDepartmentNames(String userId);

}
