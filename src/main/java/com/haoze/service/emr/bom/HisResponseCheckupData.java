package com.haoze.service.emr.bom;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.haoze.model.emr.emrwriting.po.HisPatientCheckupPO;
import com.haoze.model.emr.emrwriting.po.HisResponseDataPO;
import com.haoze.utils.GsonUtil;
import com.haoze.utils.JsoupHttpRequest;
import com.haoze.utils.SystemConfigParseUtil;
import org.jsoup.Connection;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * HIS接口返回检查数据信息。
 * @author maxl
 * @time 2018-06-13。
 */
public class HisResponseCheckupData implements HisResponseData {

    private static String responseDataKey = HisResponseDataKey.PATIENT_CHECKUP;
    Gson gson = new Gson();

    @Override
    public List<? extends HisResponseDataPO> getHisResponseDatas(Map<String, Object> paramMap) throws IOException {
        //调用HIS接口
        Connection.Response response = JsoupHttpRequest.sendHttpRequest(SystemConfigParseUtil.getProperty("HIS_PATIENT_CHECKUP"), "", paramMap);
        Map responseDataMap = GsonUtil.fromJson(response.body(), Map.class);
        //返回对应数据列表
        List<HisPatientCheckupPO> advices = gson.fromJson(GsonUtil.toJson(responseDataMap.get(responseDataKey)),
                new TypeToken<List<HisPatientCheckupPO>>(){}.getType());
        return advices;
    }
}
