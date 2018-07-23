package com.haoze.service.emr.bom;

import com.haoze.model.emr.emrwriting.po.HisResponseDataPO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * HIS接口返回数据信息。
 * @author maxl
 * @time 2018-06-13。
 */
public interface HisResponseData {

    List<? extends HisResponseDataPO> getHisResponseDatas(Map<String, Object> paramMap) throws IOException;
}
