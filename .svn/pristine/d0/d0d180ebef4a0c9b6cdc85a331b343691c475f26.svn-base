package com.haoze.service.template.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.dao.emr.SymptomDao;
import com.haoze.dao.template.TemplateDao;
import com.haoze.model.template.temp.entity.TemplateEntity;
import com.haoze.service.template.TemplateService;
import com.haoze.utils.HumpUnderlineUtil;
import com.haoze.utils.MyFileUtil;
import com.haoze.utils.SystemConfigParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

/**
 * 模板管理实现类。
 * @author yangyb
 * @time 2018-05-19。
 */
@SuppressWarnings("rawtypes")
@Service
@Transactional
public class TemplateServiceImpl implements TemplateService {
	
    @Autowired
    private TemplateDao dao;
    @Autowired
    private SymptomDao symptomDao;
    @Override
    public List<Map> getTypes() {
    	return dao.getTypes();
    }

    @Override
    public ResponseResult save(TemplateEntity entity,String xml) {

        try {
            dao.insert(entity);
            String name = entity.getNameTmp();
            String path = entity.getContent();
            String id = entity.getPkTemplate();
            MyFileUtil.writeFile(SystemConfigParseUtil.getProperty("TEMP_FILE_PATH"),id+name+".xml",xml);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "新增失败");
        }
    }

    @Override
    public ResponseResult update(TemplateEntity entity,String xml) {

        try {
            dao.update(entity);
            String path = symptomDao.getTemplateFilePathById(entity.getPkTemplate());
            MyFileUtil.rewriteFile(SystemConfigParseUtil.getProperty("TEMP_FILE_PATH")+path,xml);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "修改失败");
        }
    }

    @Override
    public ResponseResult startUsing(Map<String, Object> params) {
        try {
            dao.startUsing(params);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "操作失败");
        }
    }

    @Override
    public ResponseResult stopUsing(Map<String, Object> params) {
        try {
            dao.stopUsing(params);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "操作失败");
        }
    }

    @Override
    public ResponseResult deleteTemplate(Map<String, Object> params) {
        try {
            dao.deleteTemplate(params);
            return ResponseResult.success();
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.failure(0, "操作失败");
        }
    }


    @Override
    public Page<TemplateEntity> list(QueryParam queryParam) {
    	PageHelper.startPage(queryParam.getPage(),queryParam.getLimit());
    	if(queryParam.get("sort") != null){
            queryParam.put("sort",HumpUnderlineUtil.humpToLine(queryParam.get("sort").toString()));
        }
        return dao.list(queryParam);
    }
    
    @Override
    public int count(QueryParam queryParam) {
    	return dao.count(queryParam);
    }

    @Override
    public boolean codeCheck(Map<String, Object> params) {
        boolean exit;
        exit = dao.codeCheck(params) > 0;
        return exit;
    }

    @Override
    public boolean codeCheckWhenEdit(Map<String, Object> params) {
        boolean exit;
        exit = dao.codeCheckWhenEdit(params) > 0;
        return exit;
    }

    @Override
    public TemplateEntity get(String templateId) {
        return dao.get(templateId);
    }
}
