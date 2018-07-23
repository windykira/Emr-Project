package com.haoze.service.repository;

import com.haoze.common.model.BaseService;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.Tree;
import com.haoze.common.model.ZTree;
import com.haoze.model.repository.entity.DataDictionaryEntity;

import java.util.List;

/**
 * 数据字典服务接口。
 * @author maxl
 * @time 2018-07-19。
 */
public interface DataDictionaryService extends BaseService<DataDictionaryEntity,String>{

    /**
     * 获取树形菜单数据
     * @return
     */
    Tree<DataDictionaryEntity> getTree();

    List<ZTree> getZtree(QueryParam queryParam);
}
