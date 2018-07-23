package com.haoze.controller.template;

import com.github.pagehelper.Page;
import com.haoze.common.controller.BaseController;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.model.system.menu.entity.EmrMenuEntity;
import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.template.temp.entity.TemplateEntity;
import com.haoze.service.system.EmrMenuService;
import com.haoze.service.template.TemplateService;
import com.haoze.utils.*;
import org.apache.commons.collections.map.HashedMap;
import org.jsoup.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 病历模板Controller。
 * @author yangyb
 * @time 2018-05-19。
 */
@RequestMapping("template/temp")
@Controller
public class TemplateController extends BaseController{

    @Autowired
    TemplateService templateService;
    @Autowired
    EmrMenuService emrMenuService;

    private String prefix="template/temp";

    @GetMapping("index")
    String index(Model model) {
        return prefix + "/index";
    }

    @GetMapping("/list")
    @ResponseBody
    PageUtil list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        QueryParam queryParam = new QueryParam(params);
        Page<TemplateEntity> list = templateService.list(queryParam);
        int total = templateService.count(queryParam);
        PageUtil pageUtil = new PageUtil(list, total);
        return pageUtil;
    }

    @GetMapping("/getTypes")
    @ResponseBody
    List<Map> getTypes() {
    	List<Map> list = templateService.getTypes();
    	return list;
    }

    @GetMapping("/add")
    String add(){
        return prefix+"/add";
    }

    @GetMapping("/edit")
    String edit(){
        return prefix+"/edit";
    }

    @PostMapping("/save")
    @ResponseBody
    ResponseResult save(HttpServletRequest request){
    	String xml = request.getParameter("xml");
    	EmrUserEntity user =  ShiroUtil.getUser();
        String deptId = "";
        if("1".equals(request.getParameter("rangeSel").toString())){//全院
            deptId = "0";
        }else{
            deptId = CurrentUser.getCurrentUserDepartment().getID();
        }
    	TemplateEntity e = new TemplateEntity();
    	e.setPkTemplate(UUIDUtil.randomString());
    	e.setCreator(user.getID());
    	e.setDelFlag("0");
    	e.setNameTmp(request.getParameter("templateName"));
    	e.setPkDept(deptId);
    	e.setPkOrg(CurrentUser.getUser().getUserOrganization());
    	e.setPkTmpClass(request.getParameter("typeSel"));
    	e.setPkUser(user.getID());
    	e.setRange(request.getParameter("rangeSel"));
    	e.setStopFlag(request.getParameter("statusSel"));
        e.setCodeTmp(request.getParameter("templateCode"));
        e.setPkCatalog(request.getParameter("catalogId"));
        e.setPatientType(request.getParameter("patientTypeSel"));

    	return templateService.save(e,xml);
    }

    @PostMapping("/update")
    @ResponseBody
    ResponseResult update(HttpServletRequest request){
        String xml = request.getParameter("xml");
        EmrUserEntity user =  ShiroUtil.getUser();

        TemplateEntity e = new TemplateEntity();
        e.setPkTemplate(request.getParameter("id"));
        e.setModifier(user.getID());
        e.setDelFlag("0");
        e.setNameTmp(request.getParameter("templateName"));
        e.setPkDept(CurrentUser.getCurrentUserDepartment().getID());
        e.setPkOrg(CurrentUser.getUser().getUserOrganization());
        e.setPkTmpClass(request.getParameter("typeSel"));
//        e.setPkUser(user.getID());
        e.setRange(request.getParameter("rangeSel"));
        e.setStopFlag(request.getParameter("statusSel"));
        e.setCodeTmp(request.getParameter("templateCode"));
        e.setPkCatalog(request.getParameter("catalogId"));
        e.setPatientType(request.getParameter("patientTypeSel"));

        return templateService.update(e,xml);
    }

    @GetMapping("/submenu/{menuId}")
    String submenu(Model model,@PathVariable("menuId") String menuId ) {
        Map<String,Object> paramMap = new HashedMap();
        paramMap.put("parentMenu",menuId);
        List<EmrMenuEntity> menus = emrMenuService.listMenus(paramMap);
        model.addAttribute("menus",menus);
        model.addAttribute("userId", getUser().getID());
        return "template/submenu";
    }

    @PostMapping("/codeCheck")
    @ResponseBody
    boolean codeCheck(@RequestParam Map<String, Object> params) {
        // 存在，不通过，false
        return !templateService.codeCheck(params);
    }

    @PostMapping("/codeCheckWhenEdit")
    @ResponseBody
    boolean codeCheckWhenEdit(@RequestParam Map<String, Object> params) {
        return !templateService.codeCheckWhenEdit(params);
    }

    @GetMapping("/startUsing")
    @ResponseBody
    ResponseResult startUsing(@RequestParam Map<String, Object> params) {
        return templateService.startUsing(params);
    }

    @GetMapping("/stopUsing")
    @ResponseBody
    ResponseResult stopUsing(@RequestParam Map<String, Object> params) {
        return templateService.stopUsing(params);
    }

    @GetMapping("/deleteTemplate")
    @ResponseBody
    ResponseResult deleteTemplate(@RequestParam Map<String, Object> params) {
        return templateService.deleteTemplate(params);
    }

    @GetMapping("getHisInfoByUrlParam/{urlType}")
    @ResponseBody
    List getHisInfoByUrlParam(@PathVariable String urlType,@RequestParam Map<String, Object> params) {
        String paramString = paramsMap2UrlString(params);
        Map resultMap = new HashMap();
        List resultList = new ArrayList();
        if(urlType!=""&&urlType!=null){
            try {
                Connection.Response response = (Connection.Response) JsoupHttpRequest.sendHttpRequest(SystemConfigParseUtil.getProperty(urlType)+paramString, "",null);
                String res = response.body();
                Map<String,Object> m = GsonUtil.fromJson(res,Map.class);
                resultList = GsonUtil.fromJson(GsonUtil.toJson(m.get("data")),List.class);
    //            int total = Integer.parseInt(GsonUtil.toJson(m.get("TOTALRECORDS")));
//                resultMap.put("rows",rows);
//                resultMap.put("total",(int)Float.parseFloat(GsonUtil.toJson(m.get("TOTALRECORDS"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }
    public static String paramsMap2UrlString(Map<String,Object> m){
        String result = "?";
        for (Map.Entry<String, Object> entry : m.entrySet()) {
            result += entry.getKey()+"="+entry.getValue().toString()+"&";
        }
        return result;
    }

}

