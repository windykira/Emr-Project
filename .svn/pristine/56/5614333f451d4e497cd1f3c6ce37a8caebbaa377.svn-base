package com.haoze.service.template;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.template.temp.entity.TemplateEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 模板管理接口。
 * @author yangyb
 * @time 2018-05-19。
 */
@Service
public interface TemplateService {
	List<Map> getTypes();

	ResponseResult save(TemplateEntity e, String xml);

	ResponseResult update(TemplateEntity e, String xml);

	ResponseResult startUsing(Map<String, Object> params);

	ResponseResult stopUsing(Map<String, Object> params);

	ResponseResult deleteTemplate(Map<String, Object> params);

	Page<TemplateEntity> list(QueryParam queryParam);

	int count(QueryParam queryParam);

	boolean codeCheck(Map<String, Object> params);

	boolean codeCheckWhenEdit(Map<String, Object> params);

	TemplateEntity get(String templateId);
}
