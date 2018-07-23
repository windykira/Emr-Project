package com.haoze.controller.kb;

import com.haoze.common.annotation.Note;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.common.model.ZTree;
import com.haoze.model.repository.entity.DataDictionaryEntity;
import com.haoze.model.repository.entity.DataGroupEntity;
import com.haoze.model.repository.vo.DataDictionaryVO;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.service.repository.DataDictionaryService;
import com.haoze.service.repository.DataElementService;
import com.haoze.service.repository.DataElementValuesService;
import com.haoze.service.repository.DataGroupService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 数据集控制器信息。
 *
 * @author maxl
 * @time 2018-07-16。
 */
@RequestMapping("repository/dictionary")
@Controller
public class DataDictionaryController {

    @Autowired
    DataGroupService dataGroupService;
    @Autowired
    DataDictionaryService dataDictionaryService;
    @Autowired
    DataElementService dataElementService;
    @Autowired
    DataElementValuesService dataElementValuesService;

    private String prefix = "repository/dictionary";

    //@RequiresPermissions("repository:dictionary:dictionary")
    @GetMapping()
    String role() {
        return prefix + "/dictionary";
    }

    @GetMapping("/tree")
    @ResponseBody
    List<ZTree> tree() {
        List<ZTree> zTree = dataDictionaryService.getZtree(QueryParam.getDefaultQueryParam());
        return zTree;
    }


}
