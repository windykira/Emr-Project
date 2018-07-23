package com.haoze.controller.emr;

import com.haoze.common.controller.BaseController;
import com.haoze.common.model.QueryParam;
import com.haoze.common.model.ResponseResult;
import com.haoze.common.model.ZTree;
import com.haoze.model.emr.emrwriting.entity.EmrFileEntity;
import com.haoze.model.emr.emrwriting.vo.EmrFileVO;
import com.haoze.model.template.temp.entity.TemplateEntity;
import com.haoze.service.emr.EmrFileService;
import com.haoze.service.emr.bom.HisResponseDataService;
import com.haoze.service.template.TemplateService;
import com.haoze.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 书写病历控制器信息。
 * @author maxl
 * @time 2018-05-31。
 */
@RequestMapping("emr/emrwriting")
@Controller
public class EmrWritingController extends BaseController {

    @Autowired
    EmrFileService emrFileService;
    @Autowired
    TemplateService  templateService;

    private String prefix = "emr/emrwriting";

    @GetMapping("/templatetable")
    String test(Model model) {
        return prefix + "/templatetable";
    }

    @GetMapping("/emrwrite")
    String emrWrite(Model model) {

        model.addAttribute("footerName",getUser().getUserName());
        model.addAttribute("dept",CurrentUser.getDepartmentNames());
        model.addAttribute("role",CurrentUser.getUserRoleNames());
        return prefix + "/emrwrite";
    }

    @GetMapping("/reportimport/{hisCallType}")
    String reportImport(Model model, @PathVariable("hisCallType") String hisCallType) {
        model.addAttribute("hisCallType", hisCallType);
        return prefix + "/reportimport";
    }

    @GetMapping("/reportimportNew/{hisCallType}")
    String reportImportNew(Model model, @PathVariable("hisCallType") String hisCallType) {
        model.addAttribute("hisCallType", hisCallType);
        return prefix + "/reportimportNew";
    }

    @GetMapping("/listHisResponseDatas")
    @ResponseBody
    List<Map> listHisResponseDatas(Model model, @RequestParam Map<String, Object> params) {

        try {
            //List<? extends HisResponseDataPO> advice = HisResponseDataService.listHisResponseData(params);
            //List<Map> advice = HisResponseDataService.listHisResponseData(queryParam);
            List<Map> advice = HisResponseDataService.listHisResponseData(params);
            return advice;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    @GetMapping("/list")
    @ResponseBody
    List<ZTree> list(Model model, String patientId) {
        QueryParam queryParam = QueryParam.getDefaultQueryParam();
        queryParam.put("patientId", patientId);
        List<ZTree> zTrees = emrFileService.getZtree(queryParam);
        return zTrees;
    }

    @PostMapping("/saveEmr")
    @ResponseBody
    ResponseResult saveEmr(EmrFileVO emrFileVO) {

        try {

            String fileName = CurrentUser.getUser().getUserName() + " " + CurrentUser.getUserRoleNames() + " " + emrFileVO.getCatalogName() + " "
                    + DateFormatUtil.formatDate(new Date());
            String diskFileName = CurrentUser.getUser().getUserName() + "_" + CurrentUser.getUserRoleNames()
                    + "_" + emrFileVO.getCatalogName() + "_" + DateFormatUtil.formatDate(new Date(), "yyyy-MM-dd HHmmss");
            boolean isSuccess = MyFileUtil.writeFile(SystemConfigParseUtil.getProperty("EMR_FILE_PATH"), diskFileName + ".xml",emrFileVO.getXmlContent());
            if (isSuccess) {
                EmrFileEntity emrFileEntity = emrFileVO.getEmrFile();
                FixedFieldInitializedUtil.initialize(emrFileEntity);
                emrFileEntity.setFileLoc(diskFileName + ".xml");
                emrFileEntity.setEmrFileName(fileName);
                emrFileEntity.setCodeDept(CurrentUser.getCurrentUserDepartment().getDepartmentCode());
                emrFileEntity.setPkDept(CurrentUser.getCurrentUserDepartment().getID());
                emrFileService.insert(emrFileEntity);
                return ResponseResult.success().put("emrFileId", emrFileEntity.getID());
            }
            return ResponseResult.failure(0, "新增失败");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.failure(0, "新增失败");
        }
    }

    @PostMapping("/updateEmr")
    @ResponseBody
    ResponseResult update(Model model, EmrFileVO emrFileVO) {

        try {
            String fileName = CurrentUser.getUser().getUserName() + " " + CurrentUser.getUserRoleNames() + " " + emrFileVO.getCatalogName() + " "
                    + DateFormatUtil.formatDate(new Date());
            String diskFileName = CurrentUser.getUser().getUserName() + "_" + CurrentUser.getUserRoleNames()
                    + "_" + emrFileVO.getCatalogName() + "_" + DateFormatUtil.formatDate(new Date(), "yyyy-MM-dd HHmmss");
            EmrFileEntity emrFileEntity = emrFileService.get(emrFileVO.getEmrFile().getID());

            //保存文件到磁盘
            FileUpload.upload(emrFileVO.getXmlContent(), SystemConfigParseUtil.getProperty("EMR_FILE_PATH"), diskFileName + ".xml");
            //删除磁盘旧文件
            FileUpload.delete(new File(SystemConfigParseUtil.getProperty("EMR_FILE_PATH") + emrFileEntity.getFileLoc()));

            emrFileEntity.setEmrFileName(fileName);
            emrFileEntity.setFileLoc(diskFileName + ".xml");
            emrFileEntity.setModifyTime(new Date());
            emrFileService.update(emrFileEntity);
            return ResponseResult.success().put("emrFileId", emrFileEntity.getID());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.failure(0, "更新失败");
        }
    }

    @RequestMapping(value = "/getEmrFile/{emrFileId}")
    @ResponseBody
    public String getEmrFile(HttpServletRequest request, @PathVariable String emrFileId) throws IOException {
        EmrFileEntity emrFileEntity = emrFileService.get(emrFileId);
        //String xml = MyFileUtil.resolveFile("/static/cab/index.xml");
        if (emrFileEntity == null) {
            return "";
        }
        String xml = MyFileUtil.readFile(SystemConfigParseUtil.getProperty("EMR_FILE_PATH") + emrFileEntity.getFileLoc());
        return xml;
    }

    @PostMapping("/delete")
    @ResponseBody
    ResponseResult delete(String emrFileId) {
        return emrFileService.delete(emrFileId);
    }

}
