package com.haoze.controller.emr;

import com.haoze.common.controller.BaseController;
import com.haoze.service.emr.SymptomService;
import com.haoze.utils.MyFileUtil;
import com.haoze.utils.SystemConfigParseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * 用户相关控制器信息。
 *
 * @author maxl
 * @time 2018-05-02。
 */
@RequestMapping("emr/dc")
@Controller
public class DcController extends BaseController {

    @Autowired
    private SymptomService service;

    private String prefix = "emr/dc";

    // @RequiresPermissions("sys:user:user")
    @GetMapping("index")
    String index(Model model) {
        return prefix + "/index";
    }

    @GetMapping("fontMenu")
    String fontMenu(Model model) {
        return prefix + "/fontMenu";
    }

    @GetMapping("sizeMenu")
    String sizeMenu(Model model) {
        return prefix + "/sizeMenu";
    }

    @GetMapping("colorMenu")
    String colorMenu(Model model) {
        return prefix + "/colorMenu";
    }

    @GetMapping("bgcolorMenu")
    String bgcolorMenu(Model model) {
        return prefix + "/bgcolorMenu";
    }

    @GetMapping("getSympTree")
    @ResponseBody
    List<Map> getSympTree(Model model) {
        return service.getSympTree();
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("getSympInfo")
    @ResponseBody
    List<Map> getSympInfo(Model model) {
        List list = service.getSympInfo();
        return list;
    }

    @GetMapping("getSimuInfo")
    @ResponseBody
    List<Map> getSimuInfo(Model model) {
        return service.getSimuInfo();
    }

    @GetMapping("getSympAndSimuInfo")
    @ResponseBody
    Map getSympAndSimuInfo(Model model) {
        Map m = service.getSympAndSimuInfo();
        return m;
    }

    @RequestMapping(value = "/getTemplate/{fileId}")
    @ResponseBody
    public String getTemplate(HttpServletRequest request, @PathVariable String fileId) throws IOException {
        String path = service.getTemplateFilePathById(fileId);
        //String xml = MyFileUtil.resolveFile("/static/cab/index.xml");
        String xml = MyFileUtil.readFile(SystemConfigParseUtil.getProperty("FILE_PATH") + path);
        return xml;
    }
    @RequestMapping(value="/getXML/{fileId}")
    @ResponseBody
    public String getXML(HttpServletRequest request, @PathVariable String fileId) throws IOException {
        String xml = MyFileUtil.readFile("C:\\dc\\tgjc\\"+fileId+".xml");
        return xml;
    }
}

