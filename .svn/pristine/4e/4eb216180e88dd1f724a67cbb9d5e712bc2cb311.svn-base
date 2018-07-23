package com.haoze.controller.template;

import com.github.pagehelper.Page;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.PaginationResult;
import com.haoze.common.model.QueryParam;
import com.haoze.model.template.templateclass.entity.EmrTemplateClassEntity;
import com.haoze.model.template.templateclass.po.EmrTemplateClassPO;
import com.haoze.service.template.EmrTemplateClassService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 模板类型控制器。
 *
 * @author maxl
 * @time 2018-05-31。
 */
@RequestMapping("/template/class")
@Controller
public class TemplateClassController extends BaseController {

    @Autowired
    EmrTemplateClassService emrTemplateClassService;

    private String prefix = "template/templateclass";

    @GetMapping("/list/{cataLogId}")
    @ResponseBody
    List<EmrTemplateClassEntity> list(Model model, @PathVariable("cataLogId") String cataLogId) {
        QueryParam queryParam = QueryParam.getDefaultQueryParam();
        queryParam.put("cataLogId", cataLogId);
        return emrTemplateClassService.list(queryParam);
    }

    @GetMapping("/listEmrTemplateClass")
    @ResponseBody
    PaginationResult listEmrTemplateClass(Model model, @RequestParam Map<String, Object> params) {
        if (params.get("templateClassId") == null || "".equals(params.get("templateClassId"))) {
            return new PaginationResult(Collections.EMPTY_LIST, 0);
        }
        QueryParam queryParam = new QueryParam(params);
        Page<EmrTemplateClassPO> emrTemplateClasses = emrTemplateClassService.listEmrTemplateClass(queryParam);
        int total = emrTemplateClassService.count(queryParam);
        PaginationResult paginationResult = new PaginationResult(emrTemplateClasses, total);
        return paginationResult;
    }
}
