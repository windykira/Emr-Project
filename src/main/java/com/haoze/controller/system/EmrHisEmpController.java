package com.haoze.controller.system;

import com.github.pagehelper.Page;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.PaginationResult;
import com.haoze.common.model.QueryParam;
import com.haoze.dao.system.EmrHisEmpDao;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.service.system.EmrHisEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * HIS人员控制器信息。
 * @author maxl
 * @time 2018-05-15。
 */
@Controller
@RequestMapping("/emrsys/emp")
public class EmrHisEmpController extends BaseController {

    @Autowired
    EmrHisEmpService emrHisEmpService;
    @Autowired
    EmrHisEmpDao emrHisEmpMapper;

    @GetMapping("/list")
    @ResponseBody
    PaginationResult list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        QueryParam queryParam = new QueryParam(params);
        Page<EmrHisEmpEntity> sysUserList = emrHisEmpService.listHisEmp(queryParam);
        int total = emrHisEmpMapper.countHisEmp(queryParam);
        PaginationResult paginationResult = new PaginationResult(sysUserList,total);
        return paginationResult;
    }
}
