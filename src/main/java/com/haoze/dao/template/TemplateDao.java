package com.haoze.dao.template;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.model.template.temp.entity.TemplateEntity;

import java.util.List;
import java.util.Map;

public interface TemplateDao {

	List<Map> getTypes();

	void insert(TemplateEntity e);

	int count(QueryParam queryParam);

	int codeCheck(Map<String, Object> params);

	Page<TemplateEntity> list(QueryParam queryParam);

	void deleteTemplate(Map<String, Object> params);

	void startUsing(Map<String, Object> params);

	void stopUsing(Map<String, Object> params);

	int codeCheckWhenEdit(Map<String, Object> params);

	void update(TemplateEntity entity);

	TemplateEntity get(String templateId);
}