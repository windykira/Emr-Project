package com.haoze.service.emr;

import com.haoze.common.model.BaseService;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.Tree;
import com.haoze.common.model.ZTree;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 病历目录数据服务接口。
 * @author maxl
 * @time 2018-05-31。
 */
@Service
public interface EmrCataLogService extends BaseService<EmrCataLogEntity,String> {

    /**
     * 查询病历目录树形结构数据
     * @return
     */
    List<ZTree> getZtree(QueryParam queryParam);

    /**
     * 查询病历目录树形结构数据
     * @return
     */
    Tree<EmrCataLogEntity> getTree();

	EmrCataLogEntity getNameCatalog(String id);

}
