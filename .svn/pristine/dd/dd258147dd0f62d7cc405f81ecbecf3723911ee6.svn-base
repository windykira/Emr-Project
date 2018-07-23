package com.haoze.common.model;

/**
 * 操作结果集。
 * @author maxl
 * @time 2018-05-09。
 */
public class Result {

    private boolean success;
    private String errorMessage;
    private Object object;

    public Result(Object object){
        this.success = true;
        this.object = object;
    }

    public Result(String errorMessage){
        this.success = false;
        this.errorMessage = errorMessage;
    }

    public Object getObject() {
        return object;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
