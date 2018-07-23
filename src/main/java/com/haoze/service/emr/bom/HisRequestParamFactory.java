package com.haoze.service.emr.bom;

import com.haoze.model.emr.emrwriting.po.HisDoctorAdvicePO;
import com.haoze.model.emr.emrwriting.po.HisPatientCheckupPO;
import com.haoze.model.emr.emrwriting.po.HisPatientInspectPO;
import com.haoze.model.emr.emrwriting.po.HisPatientPrescriptionPO;
import com.haoze.service.emr.enumeration.HisCallTypeEnum;
import com.haoze.utils.SystemConfigParseUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 * HIS请求参数构造。
 *
 * @author maxl
 * @time 2018-06-03。
 */
public class HisRequestParamFactory {

    /**
     * 构建HIS请求参数
     * @param hisCallTypeEnum
     * @return
     * @throws IOException
     */
    /*public static HisRequestParam createHisRequestParam(HisCallTypeEnum hisCallTypeEnum) throws IOException {

        //不同请求类型对应不同返回数据类型
        switch (hisCallTypeEnum.getEnumValue()){
            case "1":return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_DOCTOR_ADVICE")
                    ,HisResponseDataKey.DOCTOR_ADVICE,new ArrayList<HisDoctorAdvicePO>().getClass());
            case "2":return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_CHECKUP")
                    ,HisResponseDataKey.PATIENT_CHECKUP,new ArrayList<HisPatientCheckupPO>().getClass());
            case "3":return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_INSPECT")
                    ,HisResponseDataKey.PATIENT_INSPECT,new ArrayList<HisPatientInspectPO>().getClass());
            case "4":return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_PRESCRIPTION")
                    ,HisResponseDataKey.PRESCRIPTION,new ArrayList<HisPatientPrescriptionPO>().getClass());
        }
        return null;
    }*/

    /**
     * 构建HIS请求参数
     * @param hisCallTypeEnum
     * @return
     * @throws IOException
     */
    public static HisRequestParam createHisRequestParam(HisCallTypeEnum hisCallTypeEnum) throws IOException {

        //不同请求类型对应不同返回数据类型
        switch (hisCallTypeEnum.getEnumValue()) {
            case "1":
                return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_DOCTOR_ADVICE")
                        , SystemConfigParseUtil.getProperty("HIS_DOCTOR_ADVICE_KEY"));
            case "2":
                return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_CHECKUP")
                        , SystemConfigParseUtil.getProperty("HIS_DATA_KEY"));
            case "3":
                return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_COLLECTINSPECT")
                        , SystemConfigParseUtil.getProperty("HIS_DATA_KEY"));
            case "4":
                return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_PRESCRIPTION")
                        , SystemConfigParseUtil.getProperty("HIS_DATA_KEY"));
            case "6":
                return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_URL")
                        , SystemConfigParseUtil.getProperty("HIS_DATA_KEY"));
            case "7":
                return new HisRequestParam(SystemConfigParseUtil.getProperty("HIS_PATIENT_DETAILINSPECT")
                        , SystemConfigParseUtil.getProperty("HIS_DATA_KEY"));
        }
        return null;
    }

    public static String createHisRequestUrl(HisCallTypeEnum hisCallTypeEnum) throws IOException {

        //不同请求类型对应不同返回数据类型
        switch (hisCallTypeEnum.getEnumValue()) {
            case "1":
                return SystemConfigParseUtil.getProperty("HIS_PATIENT_DOCTOR_ADVICE");
            case "2":
                return SystemConfigParseUtil.getProperty("HIS_PATIENT_CHECKUP");
            case "3":
                return SystemConfigParseUtil.getProperty("HIS_PATIENT_INSPECT");
            case "4":
                return SystemConfigParseUtil.getProperty("HIS_PATIENT_PRESCRIPTION");
            case "6":
                return SystemConfigParseUtil.getProperty("HIS_PATIENT_URL");
        }
        return null;
    }
}
