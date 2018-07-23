package com.haoze.service.system.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.dao.system.EmrHisEmpDao;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.service.system.EmrHisEmpService;
import com.haoze.utils.HumpUnderlineUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * EMP人员数据服务接口实现类。
 * @author maxl
 * @time 2018-05-15。
 */
@Service
public class EmrHisEmpServiceImpl implements EmrHisEmpService {

    @Autowired
    EmrHisEmpDao emrHisEmpDao;

    @Override
    public Page<EmrHisEmpEntity> listHisEmp(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(),queryParam.getLimit());
        if(queryParam.get("name") != null){
            queryParam.put("empName",queryParam.get("name"));
        }
        if(queryParam.get("sort") != null){
            queryParam.put("sort",HumpUnderlineUtil.humpToLine(queryParam.get("sort").toString()));
        }
        return emrHisEmpDao.listHisEmp(queryParam);
    }

    @Override
    public EmrHisEmpEntity get(String empId) {
        return emrHisEmpDao.get(empId);
    }

    @Override
    @Transactional
    public ResponseResult update(EmrHisEmpEntity emrHisEmpEntity) {

        try {
            emrHisEmpDao.update(emrHisEmpEntity);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "更新失败");
        }
    }
}
