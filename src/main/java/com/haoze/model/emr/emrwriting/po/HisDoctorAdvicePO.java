package com.haoze.model.emr.emrwriting.po;

/**
 * HIS病人医嘱信息。
 * @author maxl
 * @time 2018-06-03。
 */
public class HisDoctorAdvicePO implements HisResponseDataPO{

    private String id;
    private String patientId;//住院号
    private String orderText;//医嘱内容
    private String freqDetail;//医嘱辅助信息
    private String startDateTime;//医嘱开始日期
    private String endDateTime;//医嘱结束日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getOrderText() {
        return orderText;
    }

    public void setOrderText(String orderText) {
        this.orderText = orderText;
    }

    public String getFreqDetail() {
        return freqDetail;
    }

    public void setFreqDetail(String freqDetail) {
        this.freqDetail = freqDetail;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }
}
