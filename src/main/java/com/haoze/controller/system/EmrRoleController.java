package com.haoze.controller.system;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.service.system.EmrRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色控制器信息。
 * @author maxl
 * @time 2018-05-09。
 */
@RequestMapping("/emrsys/role")
@Controller
public class EmrRoleController extends BaseController {

    @Autowired
    EmrRoleService emrRoleService;

    private String prefix = "emrsys/role";

    @RequiresPermissions("sys:role:role")
    @GetMapping()
    String role() {
        return prefix + "/role";
    }

    @RequiresPermissions("sys:role:role")
    @GetMapping("/list")
    @ResponseBody()
    List<EmrRoleEntity> list() {
        List<EmrRoleEntity> roles = emrRoleService.listRoles();
        return roles;
    }

    @Note("添加角色")
    @RequiresPermissions("sys:role:add")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }

    @Note("保存角色")
    @RequiresPermissions("sys:role:add")
    @PostMapping("/save")
    @ResponseBody()
    ResponseResult save(EmrRoleEntity role) {

        return emrRoleService.save(role);
    }

    @Note("编辑角色")
    @RequiresPermissions("sys:role:edit")
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") String id, Model model) {
        EmrRoleEntity role = emrRoleService.get(id);
        model.addAttribute("role", role);
        return prefix + "/edit";
    }

    @Note("更新角色")
    @RequiresPermissions("sys:role:edit")
    @PostMapping("/update")
    @ResponseBody()
    ResponseResult update(EmrRoleEntity role) {
        return emrRoleService.update(role);
    }

    @Note("删除角色")
    @RequiresPermissions("sys:role:remove")
    @PostMapping("/remove")
    @ResponseBody()
    ResponseResult remove(String id) {
        return emrRoleService.remove(id);
    }

    @Note("批量删除角色")
    @RequiresPermissions("sys:role:batchRemove")
    @PostMapping("/batchRemove")
    @ResponseBody
    ResponseResult batchRemove(@RequestParam("ids[]") String[] ids) {
        return emrRoleService.batchRemove(ids);
    }
}
