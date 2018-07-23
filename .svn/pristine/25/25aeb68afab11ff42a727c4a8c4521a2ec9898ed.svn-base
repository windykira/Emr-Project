package com.haoze.controller.kb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoze.common.annotation.Note;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.Constant;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.kb.symp.entity.SimuSympEntity;
import com.haoze.model.kb.symp.entity.SympEntity;
import com.haoze.model.system.role.entity.EmrRoleEntity;
import com.haoze.service.kb.EmrSympService;
import com.haoze.utils.ChineseCharactersCode;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 知识库症状字典控制器信息。
 * @author daiyiming
 * @time 2018-05-03。
 */
@RequestMapping("/emrsys/kb")
@Controller
public class SympController extends BaseController{

    String prefix = "repository/kb/symp";
    @Autowired
    EmrSympService emrSympService;

    @RequiresPermissions("kb:symp:symp")
    @GetMapping()
    String symp(Model model) {
        return prefix + "/symp";
    }

    @RequiresPermissions("kb:symp:symp")
    @GetMapping("/list")
    @ResponseBody()
    List<SympEntity> list() {
        List<SympEntity> roles = emrSympService.listRoles();
        return roles;
    }

    @Note("新增症状")
    @RequiresPermissions("kb:symp:add")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Note("返回五笔和拼音码")
    @GetMapping("/getWbPy")
    @ResponseBody
    Map getTypes(String sympName) {
    	ChineseCharactersCode cc = new ChineseCharactersCode();
		String wb = cc.getWBCode(sympName);
		String py = "";
		try {
			py = cc.getPinyinCode(sympName);
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap<String,String>();
    	map.put("py", py);
    	map.put("wb", wb);
    	return map;
    }
//
    @Note("编辑症状")
    @RequiresPermissions("kb:symp:edit")
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") String id, Model model) {
        SympEntity sympDO = emrSympService.get(id);
        model.addAttribute("symp", sympDO);
        return prefix + "/edit";
    }
    
    @Note("更新症状")
    @RequiresPermissions("sys:role:edit")
    @PostMapping("/update")
    @ResponseBody()
    ResponseResult update(SympEntity role) {
        return emrSympService.update(role);
    }
    
    @Note("删除菜单")
    @RequiresPermissions("kb:symp:remove")
    @PostMapping("/remove")
    @ResponseBody
    ResponseResult remove(String id) {
        return emrSympService.remove(id);
    }
    
    @Note("配置可用科室")
    @RequiresPermissions("kb:symp:deployDept")
    @GetMapping("/deployDept/{id}")
    String deployDept(@PathVariable("id") String id, Model model) {
        SympEntity roleDO = emrSympService.get(id);
        model.addAttribute("role", roleDO);
        return prefix + "/deployDept";
    }
    
    @Note("配置伴随症状")
    @RequiresPermissions("kb:symp:deploySimu")
    @GetMapping("/deploySimu/{id}")
    String deploySimu(@PathVariable("id") String id, Model model) {
        SympEntity roleDO = emrSympService.get(id);
        model.addAttribute("role", roleDO);
        return prefix + "/deploySimu";
    }

//
    @Note("保存症状")
    @RequiresPermissions("kb:symp:add")
    @PostMapping("/save")
    @ResponseBody()
    ResponseResult save(SympEntity role) {
    	
    	
    	SympEntity sympDO = emrSympService.getByName(role.getSympName());
        if(sympDO==null) {
       	 
       	 return emrSympService.save(role);
        }
        else {
       	 ResponseResult re = new ResponseResult();
       	 re.put("code", 0);
       	 re.put("msg", "该症状已录入");
       	 return re;
        }
    	
    }
    
    
//
//    @Note("更新角色")
//    @RequiresPermissions("sys:role:edit")
//    @PostMapping("/update")
//    @ResponseBody()
//    ResponseResult update(SympEntity role) {
//        if (Constant.DEMO_ACCOUNT.equals(getUsername())) {
//            return ResponseResult.failure(1, "演示系统不允许修改,完整体验请部署程序");
//        }
//        if (emrSympService.update(role) > 0) {
//            return ResponseResult.success();
//        } else {
//            return ResponseResult.failure(1, "保存失败");
//        }
//    }
}
