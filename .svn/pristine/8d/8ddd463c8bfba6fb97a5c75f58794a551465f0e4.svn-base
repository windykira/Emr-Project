package com.haoze.controller.kb;

import com.github.pagehelper.Page;
import com.haoze.common.annotation.Note;
import com.haoze.common.model.PaginationResult;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.repository.entity.DataGroupEntity;
import com.haoze.model.repository.vo.DataDictionaryVO;
import com.haoze.service.repository.DataDictionaryService;
import com.haoze.service.repository.DataGroupService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 数据组控制器信息。
 * @author maxl
 * @time 2018-07-18。
 */
@RequestMapping("repository/datagroup")
@Controller
public class DataGroupController {

    @Autowired
    DataGroupService dataGroupService;
    @Autowired
    DataDictionaryService dataDictionaryService;

    private String prefix = "repository/dictionary/datagroup";


    //@RequiresPermissions("repository:datagroup:datagroup")
    @GetMapping("")
    String dataGroup(Model model) {
        return prefix + "/datagroup";
    }

    @PostMapping("/list")
    @ResponseBody
    PaginationResult list(@RequestParam Map<String, Object> params) {

        QueryParam queryParam = new QueryParam(params);
        Page<DataGroupEntity> dataGroups = dataGroupService.list(queryParam);
        int total = dataGroupService.count(queryParam);
        PaginationResult paginationResult = new PaginationResult(dataGroups, total);
        return paginationResult;
    }

    @Note("新增数据组")
    //@RequiresPermissions("repository:dataGroup:add")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }

    @Note("新增数据组")
    //@RequiresPermissions("repository:dataGroup:add")
    @PostMapping("/save")
    @ResponseBody
    ResponseResult save(DataDictionaryVO dataDictionaryVO) {
        return dataGroupService.insert(dataDictionaryVO);
    }

    @PostMapping("/delete")
    @ResponseBody
    ResponseResult delete(String dataDictionaryId) {
        return dataGroupService.deleteByDataDictionaryId(dataDictionaryId);
    }

    @PostMapping("/update")
    @ResponseBody
    ResponseResult update(DataGroupEntity dataGroup) {
        return dataGroupService.update(dataGroup);
    }

    @GetMapping("/get/{dataDictionaryId}")
    @ResponseBody
    DataGroupEntity get(@PathVariable("dataDictionaryId") String dataDictionaryId) {
        return dataGroupService.getByDataDictionaryId(dataDictionaryId);
    }

    @PostMapping("/exist")
    @ResponseBody
    boolean exist(@RequestParam Map<String, Object> params) {
        int count = dataGroupService.count(new QueryParam(params));
        return count == 0;
    }
}
