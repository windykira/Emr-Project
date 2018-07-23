package com.haoze.controller.kb;

import com.github.pagehelper.Page;
import com.haoze.common.annotation.Note;
import com.haoze.common.model.PaginationResult;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.repository.entity.DataElementEntity;
import com.haoze.model.repository.entity.DataGroupEntity;
import com.haoze.model.repository.vo.DataDictionaryVO;
import com.haoze.service.repository.DataElementService;
import com.haoze.service.repository.DataGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 数据元控制器信息。
 * @author maxl
 * @time 2018-07-18。
 */
@RequestMapping("repository/dataelement")
@Controller
public class DataElementController {

    @Autowired
    DataElementService dataElementService;

    private String prefix = "repository/dictionary/dataelement";


    @GetMapping("")
    String dataElement(Model model) {
        return prefix + "/dataelement";
    }


    @Note("新增数据元")
    //@RequiresPermissions("repository:dataGroup:add")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }

    @GetMapping("/list")
    @ResponseBody
    PaginationResult list(@RequestParam Map<String, Object> params) {

        QueryParam queryParam = new QueryParam(params);
        Page<DataElementEntity> dataElements = dataElementService.list(queryParam);
        int total = dataElementService.count(queryParam);
        PaginationResult paginationResult = new PaginationResult(dataElements, total);
        return paginationResult;
    }

    @Note("新增数据元")
    //@RequiresPermissions("repository:dataGroup:add")
    @PostMapping("/save")
    @ResponseBody
    ResponseResult save(DataDictionaryVO dataDictionaryVO) {
        return dataElementService.insert(dataDictionaryVO);
    }

    @PostMapping("/delete")
    @ResponseBody
    ResponseResult delete(String dataElementId) {
        return dataElementService.delete(dataElementId);
    }

    @PostMapping("/update")
    @ResponseBody
    ResponseResult update(DataElementEntity dataElementEntity) {
        return dataElementService.update(dataElementEntity);
    }

    @GetMapping("/get/{dataDictionaryId}")
    @ResponseBody
    DataElementEntity get(@PathVariable("dataDictionaryId") String dataDictionaryId) {
        return dataElementService.getByDataDictionaryId(dataDictionaryId);
    }
}
