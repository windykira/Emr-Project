package com.haoze.service.emr.bom;

import com.haoze.service.emr.enumeration.HisCallTypeEnum;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * HIS返回数据构造器。
 * @author maxl
 * @time 2018-06-03。
 */
public interface HisResponseDataFactory {

    Map<String,HisResponseData> hisResponseDataMap = new HashMap();

    static HisResponseData getHisResponseData(String hisCallType){

        if(StringUtils.isEmpty(hisCallType)){
            return null;
        }
        if(hisResponseDataMap.size() == 0){
            hisResponseDataMap.put(HisCallTypeEnum.DoctorAdice.getEnumValue(),new HisResponseAdviceData());
            hisResponseDataMap.put(HisCallTypeEnum.PatientCheckUp.getEnumValue(),new HisResponseCheckupData());
            hisResponseDataMap.put(HisCallTypeEnum.PatientInspect.getEnumValue(),new HisReponseInspectData());
            hisResponseDataMap.put(HisCallTypeEnum.Prescription.getEnumValue(),new HisResponsePrescriptionData());
        }
        return hisResponseDataMap.get(hisCallType);
    }

}
