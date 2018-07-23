package com.haoze.controller.template;

import com.github.pagehelper.Page;
import com.haoze.common.annotation.Note;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.model.emr.emrwriting.vo.EmrCataLogVO;
import com.haoze.model.system.department.entity.EmrDepartmentEntity;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.system.user.vo.EmrUserVO;
import com.haoze.service.emr.EmrCataLogService;
import com.haoze.service.system.enumeration.user.UserCreateStatusEnum;
import com.haoze.service.template.EmrTemplateClassService;
import com.haoze.utils.MD5Util;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 病历目录管理控制器。
 * @author maxl
 * @time 2018-06-14。
 */
@RequestMapping("/template/medicalrecord")
@Controller
public class MedicalRecordController {

    @Autowired
    EmrCataLogService emrCataLogService;
    @Autowired
    EmrTemplateClassService emrTemplateClassService;

    private String prefix = "template/medicalrecord";

    @RequiresPermissions("template:medicalrecord:medicalrecord")
    @GetMapping("/medicalrecord")
    String medicalrecord(Model model) {
        return prefix + "/medicalrecord";
    }

    @RequiresPermissions("template:medicalrecord:medicalrecord")
    @GetMapping("/catalogTree/{callSource}")
    String catalogTree(Model model,@PathVariable("callSource") String callSource) {
        model.addAttribute("callSource",callSource);
        return prefix + "/emrcatalog";
    }

    //@RequiresPermissions("template:medicalrecord:add")
    @GetMapping("/add")
    String add(Model model) {
        return prefix + "/add";
    }

    //@RequiresPermissions("template:medicalrecord:add")
    @PostMapping("/save")
    @ResponseBody
    ResponseResult save(EmrCataLogEntity emrCataLogEntity) {
        return emrCataLogService.insert(emrCataLogEntity);
    }

    //@RequiresPermissions("template:medicalrecord:delete")
    @PostMapping("/delete")
    @ResponseBody
    ResponseResult delete(String catalogId) {
        return emrCataLogService.delete(catalogId);
    }

    @PostMapping("/update")
    @ResponseBody
    ResponseResult update(EmrCataLogEntity emrCataLogEntity) {
        return emrCataLogService.update(emrCataLogEntity);
    }

    //@RequiresPermissions("sys:menu:edit")
    @GetMapping("/edit/{catalogId}")
    String edit(Model model, @PathVariable("catalogId") String catalogId) {

        EmrCataLogEntity emrCataLogEntity = emrCataLogService.get(catalogId);
        EmrCataLogEntity parentEmeCataLog = emrCataLogService.get(emrCataLogEntity.getPkFather());
        model.addAttribute("emrCataLog",emrCataLogEntity);
        model.addAttribute("parentEmrCataLog",parentEmeCataLog.getNameCatalog());
        return prefix+"/edit";
    }

    @GetMapping("/get/{catalogId}")
    @ResponseBody
    EmrCataLogVO get(Model model, @PathVariable("catalogId") String catalogId) {
        EmrCataLogVO emrCataLogVO = new EmrCataLogVO();
        EmrCataLogEntity emrCataLogEntity = emrCataLogService.get(catalogId);
        if(emrCataLogEntity == null){
            return emrCataLogVO;
        }

        emrCataLogVO.setEmrCataLog(emrCataLogEntity);
        if(emrCataLogEntity.getPkFather() == null){
            emrCataLogVO.setPkFatherName("病程");
        }else{
            EmrCataLogEntity parentEmrCataLog = emrCataLogService.get(emrCataLogEntity.getPkFather());
            emrCataLogVO.setPkFatherName(parentEmrCataLog.getNameCatalog());
        }
        return emrCataLogVO;
    }

    @GetMapping("/count/{catalogId}")
    @ResponseBody
    int count(Model model, @PathVariable("catalogId") String catalogId) {
        QueryParam queryParam = QueryParam.getDefaultQueryParam();
        queryParam.put("cataLogId",catalogId);
        Page emrTemplateClasses = emrTemplateClassService.list(queryParam);
        return emrTemplateClasses.size();
    }

    @PostMapping("/exist")
    @ResponseBody
    boolean exist(@RequestParam Map<String, Object> params) {
        int count = emrCataLogService.count(new QueryParam(params));
        return count == 0;
    }

    @GetMapping("/tree")
    @ResponseBody
    public Tree<EmrCataLogEntity> tree() {
        Tree<EmrCataLogEntity> tree = emrCataLogService.getTree();
        return tree;
    }
}
