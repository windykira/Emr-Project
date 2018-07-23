package com.haoze.service.emr;

import com.haoze.common.model.BaseService;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ZTree;
import com.haoze.model.emr.emrwriting.entity.EmrFileEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 病历文件服务接口。
 * @author maxl
 * @time 2018-06-21。
 */
@Service
public interface EmrFileService extends BaseService<EmrFileEntity,String>{

    /**
     * 查询病历文件树形结构数据
     * @return
     */
    List<ZTree> getZtree(QueryParam queryParam);
}
