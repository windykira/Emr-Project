package com.haoze.controller.kb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.haoze.common.model.ResponseResult;
import com.haoze.model.kb.symp.entity.SimuSympEntity;
import com.haoze.service.kb.EmrSimuSympService;
import com.haoze.utils.ChineseCharactersCode;

import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/*
package com.haoze.controller.kb;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haoze.common.controller.BaseController;
import com.haoze.model.system.role.entity.SimuSympEntity;
import com.haoze.service.system.simuService;

*/
/**
 * 知识库伴随症状字典控制器信息。
 * @author daiyiming
 * @time 2018-05-03。
 */

@RequestMapping("emrsys/kb/simusymp/")
@Controller
public class SimuSympController extends BaseController{

    String prefix = "repository/kb/simusymp";
    @Autowired
    EmrSimuSympService emrSympService;

    @GetMapping("index")
    String simusymp(Model model) {
        return prefix + "/simusymp";
    }

    @GetMapping("/list")
    @ResponseBody()
    List<SimuSympEntity> list() {
        List<SimuSympEntity> roles = emrSympService.listRoles();
        return roles;
    }

    @Note("新增症状")
    @GetMapping("/add")
    String add() {
        return prefix + "/add";
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Note("返回五笔和拼音码")
    @GetMapping("/getWbPy")
    @ResponseBody
    Map getTypes(String simuSympName) {
    	ChineseCharactersCode cc = new ChineseCharactersCode();
		String wb = cc.getWBCode(simuSympName);
		String py = "";
		try {
			py = cc.getPinyinCode(simuSympName);
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
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") String id, Model model) {
        SimuSympEntity sympDO = emrSympService.get(id);
        model.addAttribute("simusymp", sympDO);
        return prefix + "/edit";
    }
    
    @Note("更新症状")
    @PostMapping("/update")
    @ResponseBody()
    ResponseResult update(SimuSympEntity role) {
        return emrSympService.update(role);
    }
    
    @Note("删除菜单")
    @PostMapping("/remove")
    @ResponseBody
    ResponseResult remove(String id) {
        return emrSympService.remove(id);
    }
    
//    @Note("配置可用科室")
//    @RequiresPermissions("kb:simusymp:deployDept")
//    @GetMapping("/deployDept/{id}")
//    String deployDept(@PathVariable("id") String id, Model model) {
//        SimuSympEntity roleDO = emrSympService.get(id);
//        model.addAttribute("role", roleDO);
//        return prefix + "/deployDept";
//    }
    
//    @Note("配置伴随症状")
//    @RequiresPermissions("kb:simusymp:deploySimu")
//    @GetMapping("/deploySimu/{id}")
//    String deploySimu(@PathVariable("id") String id, Model model) {
//        SimuSympEntity roleDO = emrSympService.get(id);
//        model.addAttribute("role", roleDO);
//        return prefix + "/deploySimu";
//    }

//
    @Note("保存症状")
    @PostMapping("/save")
    @ResponseBody()
    ResponseResult save(SimuSympEntity role) {
     SimuSympEntity sympDO = emrSympService.getByName(role.getSimuSympName());
     if(sympDO==null) {
    	 
    	 return emrSympService.save(role);
     }
     else {
    	 ResponseResult re = new ResponseResult();
    	 re.put("code", 0);
    	 re.put("msg", "该伴随症状已录入");
    	 return re;
     }
    }
    
}

