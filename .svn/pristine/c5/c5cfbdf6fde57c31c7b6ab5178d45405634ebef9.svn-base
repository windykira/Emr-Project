package com.haoze.dao.template;

import java.util.List;

import com.github.pagehelper.Page;
import com.haoze.common.model.BaseDao;
import com.haoze.common.model.QueryParam;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.model.template.templateclass.po.EmrTemplateClassPO;

/**
 * 模板类型数据操作类。
 * @author maxl
 * @time 2018-05-31。
 */
public interface TemplateClassDao extends BaseDao<EmrTemplateClassEntity,String>{

    /**
     * 查询模板相关信息
     * @param queryParam
     * @return
     */
//    Page<EmrTemplateClassPO> listEmrTemplateClass(QueryParam queryParam);
	

    /**
     * 新增角色
     * @param role
     * @return 
     */
    int save(EmrTemplateClassEntity role);

    /**
     * 删除角色
     * @param classId
     */
    void remove(String classId);

    /**
     * 更新角色
     */
    void update(EmrTemplateClassEntity tempClass);

    /**
     * 查询角色列表
     * @return
     */
    List<EmrTemplateClassEntity> list();

    /**
     * 获取角色详情
     * @param roleId
     * @return
     */
    EmrTemplateClassEntity get(String classId);

	Page<EmrTemplateClassPO> listEmrTemplateClass(QueryParam queryParam);

}