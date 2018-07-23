package com.haoze.controller.system;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.Tree;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.service.system.EmrMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 菜单控制器信息。
 * @author maxl
 * @time 2018-05-09。
 */
@RequestMapping("/emrsys/menu")
@Controller
public class EmrMenuController extends BaseController {

    @Autowired
    EmrMenuService emrMenuService;

    private String prefix = "emrsys/menu";

    @RequiresPermissions("sys:menu:menu")
    @GetMapping()
    String menu(Model model) {
        return prefix+"/menu";
    }

    @RequiresPermissions("sys:menu:menu")
    @RequestMapping("/list")
    @ResponseBody
    List<EmrMenuEntity> list(@RequestParam Map<String, Object> params) {
        List<EmrMenuEntity> menus = emrMenuService.listMenus(params);
        return menus;
    }

    @Note("添加菜单")
    @RequiresPermissions("sys:menu:add")
    @GetMapping("/add/{pId}")
    String add(Model model, @PathVariable("pId") String pId) {

        model.addAttribute("pId", pId);
        if ("0".equals(pId)) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", emrMenuService.get(pId).getMenuName());
        }
        return prefix + "/add";
    }

    @Note("保存菜单")
    @RequiresPermissions("sys:menu:add")
    @PostMapping("/save")
    @ResponseBody
    ResponseResult save(EmrMenuEntity menu) {
        return emrMenuService.save(menu);
    }

    @Note("删除菜单")
    @RequiresPermissions("sys:menu:remove")
    @PostMapping("/remove")
    @ResponseBody
    ResponseResult remove(String menuID) {
        return emrMenuService.remove(menuID);
    }

    @Note("编辑菜单")
    @RequiresPermissions("sys:menu:edit")
    @GetMapping("/edit/{menuID}")
    String edit(Model model, @PathVariable("menuID") String menuID) {

        EmrMenuEntity menuEntity = emrMenuService.get(menuID);
        String parentID = menuEntity.getParentMenu();
        model.addAttribute("pId", parentID);
        if ("0".equals(parentID)) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", emrMenuService.get(parentID).getMenuName());
        }
        model.addAttribute("menu", menuEntity);
        return prefix+"/edit";
    }

    @Note("更新菜单")
    @RequiresPermissions("sys:menu:edit")
    @PostMapping("/update")
    @ResponseBody
    ResponseResult update(EmrMenuEntity menu) {

        return emrMenuService.update(menu);
    }

    @GetMapping("/tree")
    @ResponseBody
    Tree<EmrMenuEntity> tree() {
        Tree<EmrMenuEntity> tree = emrMenuService.getTree();
        return tree;
    }

    @GetMapping("/tree/{roleId}")
    @ResponseBody
    Tree<EmrMenuEntity> tree(@PathVariable("roleId") String roleId) {
        Tree<EmrMenuEntity> tree = emrMenuService.getTree(roleId);
        return tree;
    }
}
