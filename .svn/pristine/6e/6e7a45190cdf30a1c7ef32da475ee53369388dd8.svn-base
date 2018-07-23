package com.haoze.controller.system;

import com.haoze.common.controller.BaseController;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.model.system.department.entity.EmrDepartmentEntity;
import com.haoze.model.system.department.po.UserDepartmentPO;
import com.haoze.service.system.EmrDepartmentService;
import com.haoze.utils.PageUtil;
import com.haoze.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 科室控制器信息。
 * @author maxl
 * @time 2018-05-08。
 */
@Controller
@RequestMapping("/emrsys/dept")
public class EmrDepartmentController extends BaseController {

    @Autowired
    EmrDepartmentService emrDepartmentService;

    private String prefix="emrsys/department";

    @GetMapping("/department")
    String department(){
        return prefix+"/department";
    }

    @GetMapping("/choose")
    String choose(){
        return prefix+"/choose";
    }
    
    @GetMapping("/add")
    String add(){
        return prefix+"/add";
    }

    @RequestMapping("/list")
    @ResponseBody
    PageUtil list(@RequestParam Map<String, Object> params) {
    	/*int limit = Integer.parseInt(params.get("limit").toString());
    	int offset = Integer.parseInt(params.get("offset").toString());
    	params.put("begin", offset+1);
    	params.put("end", offset+limit);*/
        QueryParam queryParam = new QueryParam(params);
        List<EmrDepartmentEntity> departments = emrDepartmentService.list(queryParam);
        int total = emrDepartmentService.count(params);
        PageUtil pageUtil = new PageUtil(departments, total);
        return pageUtil;
    }

    @PostMapping("/add")
    @ResponseBody
    ResponseResult add(@RequestParam Map<String, Object> params) {
    	params.put("ID", UUIDUtil.randomString());
    	params.put("organizationID", "5f2682c17b894a9cb964b10bde92652f");
        if (emrDepartmentService.save(params) > 0) {
            return ResponseResult.success();
        }else {
        	return ResponseResult.failure(1, "添加失败");
        }
    }

    @GetMapping("/deptTree")
    String treeView() {
        return  prefix + "/deptTree";
    }

    /*@GetMapping("/tree/{queryJson}")
    @ResponseBody
    public Tree<EmrDepartmentEntity> tree(@PathVariable("queryJson") String queryJson) {
        Map<String,Object> paramMap = new HashedMap();
        //paramMap.put("orgId",orgId);
        Tree<EmrDepartmentEntity> tree = emrDepartmentService.getTree(paramMap);
        return tree;
    }*/

    @GetMapping("/tree")
    @ResponseBody
    public Tree<EmrDepartmentEntity> tree(@RequestParam Map<String,Object> paramMap) {
        Tree<EmrDepartmentEntity> tree = emrDepartmentService.getTree(paramMap);
        return tree;
    }

    @RequestMapping("/listByUserId/{userId}")
    @ResponseBody
    List<EmrDepartmentEntity> listByUserId(@PathVariable("userId") String userId) {
        List<EmrDepartmentEntity> list = emrDepartmentService.listEmrDepartmentsByUserId(userId);
        return list;
    }
}
