package com.haoze.controller.kb;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.service.system.EmrMenuService;

@RequestMapping("/emrsys/repository")
@Controller
public class RepositoryController extends BaseController{
	
	@Autowired
	EmrMenuService emrMenuService;
	
    @GetMapping("/repository/{menuId}")
    String system(Model model,@PathVariable("menuId") String menuId) {
        Map<String,Object> paramMap = new HashedMap();
        paramMap.put("parentMenu",menuId);
        List<EmrMenuEntity> menus = emrMenuService.listMenus(paramMap);
        model.addAttribute("menus",menus);
        model.addAttribute("userId", getUser().getID());
        return "repository/repository";
    }


}
