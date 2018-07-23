package com.haoze.controller.template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.service.emr.EmrCataLogService;
import com.haoze.service.template.TemplateClassService;
import com.haoze.utils.ChineseCharactersCode;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 知识库模板类型字典控制器信息。
 * @author huangl
 * @time 2018-06-14。
 */
@RequestMapping("template/tempClass")
@Controller
public class TemplateTmpClassController extends BaseController{

    @Autowired
    TemplateClassService templateClassService;
    @Autowired
    EmrCataLogService emrCataLogService;
    
    private String prefix = "template/templateclass";
    
    

    @GetMapping("index")
    String tempClass(Model model) {
        return prefix + "/index";
    }

    @GetMapping("/list")
    @ResponseBody()
    List<EmrTemplateClassEntity> list() {
        List<EmrTemplateClassEntity> roles = templateClassService.listRoles();
        return roles;
    }
    
    @GetMapping("/catalogTree")
    String catalogTree(Model model) {
        return prefix + "/emrcatalog";
    }
    
    @GetMapping("/tree")
    @ResponseBody
    public Tree<EmrCataLogEntity> tree() {
        Tree<EmrCataLogEntity> tree = emrCataLogService.getTree();
        return tree;
    }
    
//  @GetMapping("/list/{cataLogId}")
//  @ResponseBody
//  List<EmrTemplateClassEntity> list(Model model, @PathVariable("cataLogId") String cataLogId) {
//      QueryParam queryParam = QueryParam.getDefaultQueryParam();
//      queryParam.put("cataLogId",cataLogId);
//      return templateClassService.list(queryParam);
//  }

    @Note("新增模板类型")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Note("返回五笔和拼音码")
    @GetMapping("/getWbPy")
    @ResponseBody
    Map getTypes(String nameClass) {
    	ChineseCharactersCode cc = new ChineseCharactersCode();
		String wb = cc.getWBCode(nameClass);
		String py = "";
		try {
			py = cc.getPinyinCode(nameClass);
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap<String,String>();
    	map.put("py", py);
    	map.put("wb", wb);
    	return map;
    }
//
    @Note("编辑模板类型")
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") String id, Model model) {
        EmrTemplateClassEntity tempClass = templateClassService.get(id);
        String pkCatalog = tempClass.getPkCatalog();
        //查询上级目录名称
        EmrCataLogEntity emr = emrCataLogService.getNameCatalog(pkCatalog);
        
        model.addAttribute("nameCatalog", emr.getNameCatalog());
        model.addAttribute("tempClass", tempClass);
        return prefix + "/edit";
    }
    
    @Note("更新模板类型")
    @PostMapping("/update")
    @ResponseBody()
    ResponseResult update(EmrTemplateClassEntity tempClass) {
        return templateClassService.update(tempClass);
    }
    
    @Note("删除菜单")
    @PostMapping("/remove")
    @ResponseBody
    ResponseResult remove(String id) {
        return templateClassService.remove(id);
    }
     
    
    @Note("状态")
    @PostMapping("/stop")
    @ResponseBody
    ResponseResult stop(String id) {
        EmrTemplateClassEntity tempClass = templateClassService.get(id);
        String stopFlag  = tempClass.getStopFlag();
        if("1".equals(stopFlag)) {
        	tempClass.setStopFlag("0");
        }
        if("0".equals(stopFlag)) {
        	tempClass.setStopFlag("1");
        }
        return templateClassService.update(tempClass);
    }
//
    @Note("保存模板类型")
    @PostMapping("/save")
    @ResponseBody()
    ResponseResult save(EmrTemplateClassEntity role) {
    	
       return templateClassService.save(role);
    }
}
