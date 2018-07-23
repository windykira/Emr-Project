package com.haoze.service.emr.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.enumeration.common.DelFlagEnum;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.common.model.ZTree;
import com.haoze.dao.emr.EmrCataLogDao;
import com.haoze.dao.template.EmrTemplateClassDao;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.model.system.department.entity.EmrDepartmentEntity;
import com.haoze.service.emr.EmrCataLogService;
import com.haoze.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

/**
 * 病历目录数据服务实现类。
 *
 * @author maxl
 * @time 2018-05-31。
 */
@Service
public class EmrCataLogServiceImpl implements EmrCataLogService {

    @Autowired
    EmrCataLogDao emrCataLogDao;
    @Autowired
    EmrTemplateClassDao emrTemplateClassDao;

    @Override
    @Transactional
    public ResponseResult insert(EmrCataLogEntity emrCataLogEntity) {

        try {
            FixedFieldInitializedUtil.initialize(emrCataLogEntity);
            emrCataLogEntity.setWbCode(ChineseCharactersCode.getWBCode(emrCataLogEntity.getNameCatalog()));
            emrCataLogEntity.setPyCode(ChineseCharactersCode.getPinyinCode(emrCataLogEntity.getNameCatalog()));
            emrCataLogDao.insert(emrCataLogEntity);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "新增失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult delete(String catalogId) {
        try {

            int count = emrTemplateClassDao.countByCatalogId(catalogId);
            if(count > 0){
                return ResponseResult.failure(0, "该节点已关联模板类型，无法删除。");
            }
            emrCataLogDao.delete(catalogId);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "删除失败");
        }
    }

    @Override
    @Transactional
    public ResponseResult update(EmrCataLogEntity emrCataLogEntity) {
        try {
            emrCataLogEntity.setModifier(CurrentUser.getUserId());
            emrCataLogEntity.setModifyTime(new Date());
            emrCataLogDao.update(emrCataLogEntity);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @Override
    public EmrCataLogEntity get(String CatalogId) {
        return emrCataLogDao.get(CatalogId);
    }

    @Override
    public Page<EmrCataLogEntity> list(QueryParam queryParam) {
        return null;
    }

    @Override
    public List<ZTree> getZtree(QueryParam queryParam) {

        PageHelper.startPage(queryParam.getPage(), queryParam.getLimit());
        queryParam.put("delFlag", DelFlagEnum.Not_Deleted.getEnumValue());
        Page<EmrCataLogEntity> emrCataLogEntities = emrCataLogDao.list(queryParam);
        EmrCataLogEntity topCataLog = new EmrCataLogEntity();
        topCataLog.setID(UUIDUtil.randomString());
        topCataLog.setNameCatalog("病程");
        topCataLog.setPkFather("0");

        List<ZTree> zTrees = new ArrayList();
        Map<String, List<EmrCataLogEntity>> children = new HashMap();
        for (EmrCataLogEntity emrCataLogEntity : emrCataLogEntities) {

            List<EmrCataLogEntity> list;
            if (emrCataLogEntity.getPkFather() == null) {
                emrCataLogEntity.setPkFather(topCataLog.getID());
            }

            if (children.get(emrCataLogEntity.getPkFather()) == null) {
                list = new ArrayList();
            } else {
                list = children.get(emrCataLogEntity.getPkFather());
            }
            list.add(emrCataLogEntity);
            children.put(emrCataLogEntity.getPkFather(), list);
        }

        emrCataLogEntities.add(topCataLog);
        for (EmrCataLogEntity emrCataLogEntity : emrCataLogEntities) {
            ZTree<EmrCataLogEntity> zTree = new ZTree();
            zTree.setId(emrCataLogEntity.getID());
            zTree.setpId(emrCataLogEntity.getPkFather());
            zTree.setName(emrCataLogEntity.getNameCatalog());
            if(children.get(emrCataLogEntity.getID()) == null || children.get(emrCataLogEntity.getID()).size() == 0){
                zTree.setIsParent(false);
            }else{
                zTree.setIsParent(true);
            }
            zTree.setOpen(false);
            zTrees.add(zTree);
        }
        return zTrees;
    }

    @Override
    public Tree<EmrCataLogEntity> getTree() {

        Page<EmrCataLogEntity> cataLogEntities = emrCataLogDao.list(QueryParam.getDefaultQueryParam());
        List<Tree<EmrCataLogEntity>> trees = new ArrayList();
        cataLogEntities.forEach(emrCataLogEntity->{
            Tree<EmrCataLogEntity> tree = new Tree();
            tree.setId(emrCataLogEntity.getID());
            tree.setParentId(emrCataLogEntity.getPkFather());
            tree.setText(emrCataLogEntity.getNameCatalog());
            Map<String, Object> state = new HashMap();
            state.put("opened", true);
            tree.setState(state);
            trees.add(tree);
        });
        Tree<EmrCataLogEntity> tree = TreeBuildUtil.build(trees);
        return tree;
    }


    @Override
    public int count(QueryParam queryParam) {
        return emrCataLogDao.count(queryParam);
    }

	@Override
	public EmrCataLogEntity getNameCatalog(String id) {
		// TODO Auto-generated method stub
		return emrCataLogDao.getNameCatalog(id);
	}
}
