package com.haoze.service.repository.impl;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.common.model.ZTree;
import com.haoze.dao.repository.DataDictionaryDao;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.model.repository.entity.DataDictionaryEntity;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.service.repository.DataDictionaryService;
import com.haoze.utils.TreeBuildUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 数据字典服务接口实现类。
 *
 * @author maxl
 * @time 2018-07-19。
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    DataDictionaryDao dataDictionaryDao;

    @Override
    public Tree<DataDictionaryEntity> getTree() {

        List<Tree<DataDictionaryEntity>> trees = new ArrayList();
        Page<DataDictionaryEntity> dataDictionaryEntities = dataDictionaryDao.list(QueryParam.getDefaultQueryParam());
        for (DataDictionaryEntity dataDictionaryEntity : dataDictionaryEntities) {
            Tree<DataDictionaryEntity> tree = new Tree();
            tree.setId(dataDictionaryEntity.getPkNode());
            tree.setParentId(dataDictionaryEntity.getPkFather());
            tree.setText(dataDictionaryEntity.getNameNode());
            tree.setRootId(dataDictionaryEntity.getPkRoot());
            trees.add(tree);
        }

        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<DataDictionaryEntity> t = TreeBuildUtil.build(trees);
        return t;
    }

    @Override
    public List<ZTree> getZtree(QueryParam queryParam) {

        Page<DataDictionaryEntity> dataDictionaryEntities = dataDictionaryDao.list(QueryParam.getDefaultQueryParam());
        List<ZTree> zTrees = new ArrayList();

        for (DataDictionaryEntity dataDictionaryEntity : dataDictionaryEntities) {
            ZTree<DataDictionaryEntity> zTree = new ZTree();
            zTree.setId(dataDictionaryEntity.getPkNode());
            zTree.setpId(dataDictionaryEntity.getPkFather());
            zTree.setName(dataDictionaryEntity.getNameNode());
            zTree.setNodeType(dataDictionaryEntity.getNodeType());
            zTree.setPkBd(dataDictionaryEntity.getPkBd());
            zTree.setPkRoot(dataDictionaryEntity.getPkRoot());
            zTree.setOpen(true);
            zTrees.add(zTree);
        }
        return zTrees;
    }

    @Override
    public ResponseResult insert(DataDictionaryEntity dataDictionaryEntity) {
        return null;
    }

    @Override
    public ResponseResult delete(String s) {
        return null;
    }

    @Override
    public ResponseResult update(DataDictionaryEntity dataDictionaryEntity) {
        return null;
    }

    @Override
    public DataDictionaryEntity get(String dataDictionaryId) {
        return dataDictionaryDao.get(dataDictionaryId);
    }

    @Override
    public Page<DataDictionaryEntity> list(QueryParam queryParam) {
        return null;
    }

    @Override
    public int count(QueryParam queryParam) {
        return 0;
    }
}
