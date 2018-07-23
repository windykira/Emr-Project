package com.haoze.service.kb;

import java.util.List;

import org.springframework.stereotype.Service;

import com.haoze.common.model.ResponseResult;
import com.haoze.model.kb.symp.entity.SympEntity;

/**
 * 知识库症状服务接口。
 * @author daiyiming
 * @time 2018-05-09。
 */
@Service
public interface EmrSympService {

    /**
     * 新增症状
     * @param role
     * @return
     */
	ResponseResult save(SympEntity role);

    /**
     *删除症状
     * @param roleId
     * @return
     */
    ResponseResult remove(String roleId);

    /**
     * 批量删除症状
     * @param ids
     */
    ResponseResult batchRemove(String[] ids);

    /**
     * 更新症状
     * @param role
     */
    ResponseResult update(SympEntity role);

    /**
     * 查询症状列表
     * @return
     */
    List<SympEntity> listRoles();

    /**
     * 获取症状信息
     * @param roleId
     * @return
     */
    SympEntity get(String roleId);

	SympEntity getByName(String sympName);
}
