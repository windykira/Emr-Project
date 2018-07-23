package com.haoze.service.template;

import com.github.pagehelper.Page;
import com.haoze.common.model.BaseService;
import com.haoze.common.model.QueryParam;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.model.template.templateclass.po.EmrTemplateClassPO;
import org.springframework.stereotype.Service;

/**
 * 病历模板类型接口。
 * @author maxl
 * @time 2018-05-31。
 */
@Service
public interface EmrTemplateClassService extends BaseService<EmrTemplateClassEntity,String>{

    /**
     * 查询模板相关信息
     * @param queryParam
     * @return
     */
    Page<EmrTemplateClassPO> listEmrTemplateClass(QueryParam queryParam);
}
