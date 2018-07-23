package com.haoze.model.emr.emrwriting.po;

/**
 * HIS病人检查信息。
 * @author maxl
 * @time 2018-06-03。
 */
public class HisPatientCheckupPO implements HisResponseDataPO{

    /*private String applyTime;//检查时间
    private String checkClass;//检查项目
    private String checkNo;//检查编号
    private String description;//印象可见
    private String impression;//检查结论*/

    //HIS返回字段
    private String REPORT_DATE_TIME;//报告日期
    private String EXAM_NO;//检查单号
    private String EXAM_ITEM;//检查项目
    private String DESCRIPTION;//印象可见
    private String IMPRESSION;//检查结论

    /*public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime() {
        this.applyTime = getREPORT_DATE_TIME();
    }

    public String getCheckClass() {
        return checkClass;
    }

    public void setCheckClass(String checkClass) {
        this.checkClass = checkClass;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }*/

    public String getREPORT_DATE_TIME() {
        return REPORT_DATE_TIME;
    }

    public void setREPORT_DATE_TIME(String REPORT_DATE_TIME) {
        this.REPORT_DATE_TIME = REPORT_DATE_TIME;
    }

    public String getEXAM_NO() {
        return EXAM_NO;
    }

    public void setEXAM_NO(String EXAM_NO) {
        this.EXAM_NO = EXAM_NO;
    }

    public String getEXAM_ITEM() {
        return EXAM_ITEM;
    }

    public void setEXAM_ITEM(String EXAM_ITEM) {
        this.EXAM_ITEM = EXAM_ITEM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getIMPRESSION() {
        return IMPRESSION;
    }

    public void setIMPRESSION(String IMPRESSION) {
        this.IMPRESSION = IMPRESSION;
    }
}
