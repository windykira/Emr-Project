package com.haoze.controller.emr;

import com.github.pagehelper.Page;
import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.Tree;
import com.haoze.common.model.ZTree;
import com.haoze.model.emr.emrwriting.entity.EmrCataLogEntity;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.model.system.user.entity.EmrHisEmpEntity;
import com.haoze.service.emr.EmrCataLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 病历目录控制器信息。
 * @author maxl
 * @time 2018-05-31。
 */
@RequestMapping("emr/catalog")
@Controller
public class EmrCataLogController extends BaseController{

    @Autowired
    EmrCataLogService emrCataLogService;

    @GetMapping("/list")
    @ResponseBody
    List<ZTree> list(Model model) {
        List<ZTree> zTrees = emrCataLogService.getZtree(QueryParam.getDefaultQueryParam());
        return zTrees;
    }

}
