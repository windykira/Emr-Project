package com.haoze.service.emr.bom;

import com.haoze.common.model.QueryParam;
import com.haoze.model.emr.emrwriting.po.HisResponseDataPO;
import com.haoze.service.emr.enumeration.HisCallTypeEnum;
import com.haoze.utils.GsonUtil;
import com.haoze.utils.JsoupHttpRequest;
import com.haoze.utils.SystemConfigParseUtil;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * HIS接口数据服务。
 * @author maxl
 * @time 2018-06-03。
 */
public final class HisResponseDataService {

    /**
     * 获取HIS返回接口数据
     * @param params
     * @return
     * @throws IOException
     */
    /*public static List<? extends HisResponseDataPO> listHisResponseData(Map<String,Object> params) throws IOException {

        HisResponseData hisResponseData = HisResponseDataFactory.getHisResponseData(String.valueOf(params.get("hisCallType")));
        List<? extends HisResponseDataPO> hisResponseDatas = hisResponseData.getHisResponseDatas(params);
        return hisResponseDatas;

    }*/

    /**
     * 获取HIS返回接口数据
     * @param params
     * @return
     * @throws IOException
     */
    public static List<Map> listHisResponseData(Map<String,Object> params) throws IOException {

        HisRequestParam hisRequestParam = HisRequestParamFactory.createHisRequestParam(HisCallTypeEnum.fromValue(String.valueOf(params.get("hisCallType"))));
        if(hisRequestParam == null){
            return Collections.EMPTY_LIST;
        }
        params.put("visitId", 1);
        params.put("repeatIndicator", 1);
        QueryParam queryParam = new QueryParam(params);
        queryParam.put("curPage", queryParam.getPage());
        queryParam.put("pageSize", queryParam.getLimit());
        //调用HIS接口
        Connection.Response response = JsoupHttpRequest.sendHttpRequest(hisRequestParam.getUrl(),"",queryParam);
        Map responseDataMap = GsonUtil.fromJson(response.body(),Map.class);
        //返回对应数据列表
        List<Map> advice = GsonUtil.fromJson(GsonUtil.toJson((responseDataMap.get(hisRequestParam.getResponseDataKey()))),new ArrayList<Map>().getClass());
        return advice;
    }

    /**
     * 获取HIS返回接口数据
     * @param params
     * @return
     * @throws IOException
     */
    /*public static List<Map> listHisResponseData(Map<String,Object> params) throws IOException{

        params.put("visitId", 1);
        params.put("repeatIndicator", 1);
        QueryParam queryParam = new QueryParam(params);
        queryParam.put("curPage", queryParam.getPage());
        queryParam.put("pageSize", queryParam.getLimit());
        String hisRequestUrl = HisRequestParamFactory.createHisRequestUrl(HisCallTypeEnum.fromValue(String.valueOf(params.get("hisCallType"))));
        if(StringUtils.isEmpty(hisRequestUrl)){
            return Collections.EMPTY_LIST;
        }
        //调用HIS接口
        Connection.Response response = JsoupHttpRequest.sendHttpRequest(hisRequestUrl,"",queryParam);
        Map responseDataMap = GsonUtil.fromJson(response.body(),Map.class);
        //返回对应数据列表
        List<Map> advice = GsonUtil.fromJson(GsonUtil.toJson(responseDataMap.get(SystemConfigParseUtil.getProperty("HIS_DATA_KEY")))
                ,new ArrayList<Map>().getClass());
        return advice;
    }*/
}
