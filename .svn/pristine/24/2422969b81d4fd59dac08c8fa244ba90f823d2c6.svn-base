package com.haoze.controller.emr;

import com.haoze.common.controller.BaseController;
import com.haoze.utils.CurrentUser;
import com.haoze.utils.GsonUtil;
import com.haoze.utils.JsoupHttpRequest;
import com.haoze.utils.SystemConfigParseUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.jsoup.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 病人控制器信息。
 * @author maxl
 * @time 2018-05-23。
 */
@RequestMapping("emr/patient")
@Controller
public class EmrPatientController extends BaseController{

    private String prefix = "emr/patient/";

    @GetMapping("/patients/{menuId}")
    String index(Model model,@PathVariable("menuId") String menuId) {
        return prefix + "patients";
    }

    @GetMapping("getPatientList")
    @ResponseBody
    Map getPatientList(Model model, HttpServletRequest request,@RequestParam Map<String, Object> params) {
//        String name = request.getParameter("name");
//        String bedNo = request.getParameter("bedNo");
//        String type = request.getParameter("type");
//        String patientId = request.getParameter("patientId");
//        name=name==null?"":name;
//        bedNo=bedNo==null?"":bedNo;
//        type=type==null?"":type;
//        patientId=patientId==null?"":patientId;
//        String empNo = "";
//        String deptNo = "";
        if("1".equals(params.get("type").toString())){
            params.put("empNo",CurrentUser.getUser().getUserCode());
//            empNo = CurrentUser.getUser().getUserCode();
        }
        if("2".equals(params.get("type").toString())){
//            deptNo =  CurrentUser.getCurrentUserDepartment();
            params.put("deptCode",CurrentUser.getCurrentUserDepartment().getDepartmentCode());
        }
        String paramString = paramsMap2UrlString(params);
        Map resultMap = new HashMap();
        try {
            Connection.Response response = (Connection.Response) JsoupHttpRequest.sendHttpRequest(SystemConfigParseUtil.getProperty("HIS_PATIENT_URL")+paramString, "",null);
            String res = response.body();
            Map<String,Object> m = GsonUtil.fromJson(res,Map.class);
            List rows = GsonUtil.fromJson(GsonUtil.toJson(m.get("ROWS")),List.class);
//            int total = Integer.parseInt(GsonUtil.toJson(m.get("TOTALRECORDS")));
            resultMap.put("rows",rows);
            resultMap.put("total",(int)Float.parseFloat(GsonUtil.toJson(m.get("TOTALRECORDS"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }
    public static String paramsMap2UrlString(Map<String,Object> m){
        String result = "?";
        for (Map.Entry<String, Object> entry : m.entrySet()) {
            result += entry.getKey()+"="+entry.getValue().toString()+"&";
        }
        return result;
    }

    @GetMapping("getJYListByPatientId/{patientId}")
    @ResponseBody
    String getJYListByPatientId(Model model, HttpServletRequest request,@PathVariable("patientId") String patientId) {
        String res = "";
        try {
            Connection.Response response = (Connection.Response) JsoupHttpRequest.sendHttpRequest("http://58.216.175.154:8181/getDecisionJyxx?visitId=1&patientId="+patientId, "",null);
            res = response.body();
            Map<String,Object> m = GsonUtil.fromJson(res,Map.class);
            res = m.get("decisionJyxx").toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }



    @GetMapping("getJCDetailByCheckNo/{checkNo}")
    @ResponseBody
    String getJCDetailByCheckNo(Model model, HttpServletRequest request,@PathVariable("checkNo") String checkNo) {
        String res = "";
        try {
            Connection.Response response = (Connection.Response) JsoupHttpRequest.sendHttpRequest("http://58.216.175.154:8181/getDecisionJcxxDetail?checkNo="+checkNo, "",null);
            res = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @GetMapping("getJYDetailByCheckNo/{checkNo}")
    @ResponseBody
    List getJYDetailByCheckNo(Model model, HttpServletRequest request,@PathVariable("checkNo") String checkNo) {
        List rows = new ArrayList();
        try {
            Connection.Response response = (Connection.Response) JsoupHttpRequest.sendHttpRequest("http://58.216.175.154:8181/getDecisionJyxxDetail?examCode="+checkNo, "",null);
            String res = response.body();
            Map<String,Object> m = GsonUtil.fromJson(res,Map.class);
            rows = GsonUtil.fromJson(GsonUtil.toJson(m.get("decisionJyxxDetail")),List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }
    @GetMapping("getPrescByPatientId/{patientId}")
    @ResponseBody
    String getPrescByPatientId(Model model, HttpServletRequest request,@PathVariable("patientId") String patientId) {
        String res = "";
        try {
            Connection.Response response = (Connection.Response) JsoupHttpRequest.sendHttpRequest("http://58.216.175.154:8181/getDecisionMzcf?patientId="+patientId+"&visitId=11", "",null);
            res = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    @GetMapping("getDecisionByPrescNo/{patientId}/{prescNo}")
    @ResponseBody
    String getDecisionByPrescNo(Model model, HttpServletRequest request,@PathVariable("patientId") String patientId,@PathVariable("prescNo") String prescNo) {
        String res = "";
        try {
            Connection.Response response = (Connection.Response) JsoupHttpRequest.sendHttpRequest("http://58.216.175.154:8181/getDecisionMzcfDiag?patientId="+patientId+"&visitId=11&prescNo="+prescNo, "",null);
            res = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
