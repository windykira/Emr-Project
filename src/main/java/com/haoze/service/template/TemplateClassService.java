package com.haoze.service.template;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.model.template.templateclass.po.EmrTemplateClassPO;

/**
 * 病历模板类型接口。
 * @author maxl
 * @time 2018-05-31。
 */
@Service
public interface TemplateClassService{

    /**
     * 新增模板类型
     * @param role
     * @return
     */
	ResponseResult save(EmrTemplateClassEntity role);

    /**
     *删除模板类型
     * @param roleId
     * @return
     */
    ResponseResult remove(String roleId);


    /**
     * 更新模板类型
     * @param role
     */
    ResponseResult update(EmrTemplateClassEntity role);

    /**
     * 查询模板类型列表
     * @return
     */
    List<EmrTemplateClassEntity> listRoles();

    /**
     * 获取模板类型信息
     * @param roleId
     * @return
     */
    EmrTemplateClassEntity get(String roleId);

}
