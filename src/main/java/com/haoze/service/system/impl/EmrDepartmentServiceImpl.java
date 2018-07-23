package com.haoze.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.Tree;
import com.haoze.dao.system.EmrDepartmentDao;
import com.haoze.dao.system.EmrUserDepartmentDao;
import com.haoze.model.system.department.entity.EmrDepartmentEntity;
import com.haoze.model.system.department.po.UserDepartmentPO;
import com.haoze.service.system.EmrDepartmentService;
import com.haoze.utils.TreeBuildUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 科室数据服务实现类。
 * @author maxl
 * @time 2018-05-08。
 */
@Service
public class EmrDepartmentServiceImpl implements EmrDepartmentService {

    @Autowired
    EmrDepartmentDao emrDepartmentMapper;
    @Autowired
    EmrUserDepartmentDao emrUserDepartmentMapper;

    @Override
    public List<EmrDepartmentEntity> listEmrDepartmentsByUserId(String userId) {
        return emrDepartmentMapper.listEmrDepartmentsByUserId(userId);
    }

    @Override
    public List<EmrDepartmentEntity> listEmrDepartments(Map<String, Object> paramMap) {
        return emrDepartmentMapper.listEmrDepartments(paramMap);
    }

    @Override
    public int count(Map<String, Object> paramMap) {
    	return emrDepartmentMapper.count(paramMap);
    }
    
    @Override
    public List<EmrDepartmentEntity> list(QueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(),queryParam.getLimit());
        return emrDepartmentMapper.list(queryParam);
    }
    @Override
    public int save(Map<String, Object> params) {
    	return emrDepartmentMapper.save(params);
    }

    @Override
    public Tree<EmrDepartmentEntity> getTree(Map<String,Object> paramMap) {

        /*if(OcsCache.get("deptTree" + paramMap.get("orgId")) != null){
            Tree<EmrDepartmentEntity> tree = GsonUtil.fromJson(OcsCache.get("deptTree" + paramMap.get("orgId")).toString(),Tree.class);
            return tree;
        }*/

        List<String> userDeptIds = new ArrayList();
        if(paramMap.get("userId") != null){
            //查询用户关联科室
            userDeptIds = emrUserDepartmentMapper.listUserDepartments(paramMap.get("userId").toString());
        }

        List<Tree<EmrDepartmentEntity>> trees = new ArrayList();
        List<EmrDepartmentEntity> departmentEntities = emrDepartmentMapper.list(paramMap);
        for (EmrDepartmentEntity departmentEntity : departmentEntities) {
            Tree<EmrDepartmentEntity> tree = new Tree();
            tree.setId(departmentEntity.getID());
            tree.setParentId(departmentEntity.getParentDepartmentID());
            tree.setText(departmentEntity.getDepartmentName());
            Map<String, Object> state = new HashMap();
            if(paramMap.get("userId") != null){
                if(userDeptIds.contains(departmentEntity.getID())){
                    state.put("selected", true);
                }else{
                    state.put("selected", false);
                }
            }
            state.put("opened", true);
            tree.setState(state);
            trees.add(tree);
        }
        // 默认顶级菜单为０，根据数据库实际情况调整
        Tree<EmrDepartmentEntity> tree = TreeBuildUtil.build(trees);
        //OcsCache.put("deptTree" + paramMap.get("orgId"),GsonUtil.toJson(tree));
        return tree;
    }

    @Override
    public EmrDepartmentEntity get(String departmentId) {
        return emrDepartmentMapper.get(departmentId);
    }
}
