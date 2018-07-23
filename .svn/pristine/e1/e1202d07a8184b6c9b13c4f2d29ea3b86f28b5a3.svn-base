package com.haoze.dao.system;

import com.github.pagehelper.Page;
import com.haoze.common.model.BaseDao;
import com.haoze.common.model.QueryParam;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;

import java.util.Map;

/**
 * EMP人员数据操作类。
 * @author maxl
 * @time 2018-05-15。
 */
public interface EmrHisEmpDao extends BaseDao<EmrHisEmpEntity,String> {

    /**
     * 查询EMP人员信息列表
     * @param queryParam
     * @return
     */
    Page<EmrHisEmpEntity> listHisEmp(QueryParam queryParam);

    /**
     * 统计EMP人员信息
     * @param paramMap
     * @return
     */
    int countHisEmp(Map<String, Object> paramMap);

    /**
     * 查询EMP人员信息
     * @param empId
     * @return
     */
    EmrHisEmpEntity get(String empId);

    /**
     * 更新人员信息
     * @param emrHisEmpEntity
     */
    void update(EmrHisEmpEntity emrHisEmpEntity);

    void insert(EmrHisEmpEntity record);

    int insertSelective(EmrHisEmpEntity record);
}