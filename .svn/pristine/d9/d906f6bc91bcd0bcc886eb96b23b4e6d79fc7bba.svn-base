package com.haoze.service.system;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import org.springframework.stereotype.Service;

/**
 * EMP人员数据服务接口。
 * @author maxl
 * @time 2018-05-15。
 */
@Service
public interface EmrHisEmpService {

    /**
     * 查询EMP人员信息
     * @param queryParam
     * @return
     */
    Page<EmrHisEmpEntity> listHisEmp(QueryParam queryParam);

    /**
     * 查询EMP人员信息
     * @param empId
     * @return
     */
    EmrHisEmpEntity get(String empId);

    /**
     * 更新EMP人员信息
     * @param emrHisEmpEntity
     */
    ResponseResult update(EmrHisEmpEntity emrHisEmpEntity);
}
