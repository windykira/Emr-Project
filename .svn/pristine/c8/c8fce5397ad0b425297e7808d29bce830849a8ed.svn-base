package com.haoze.common.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据基本信息。
 * @author maxl
 * @time 2018-04-27。
 */
public class ResponseResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public ResponseResult() {
        put("code", 1);
        put("msg", "操作成功");
    }

    public static ResponseResult failure() {
        return failure(0, "操作失败");
    }

    public static ResponseResult failure(String msg) {
        return failure(500, msg);
    }

    public static ResponseResult failure(int code, String msg) {
        ResponseResult result = new ResponseResult();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static ResponseResult success(String msg) {
        ResponseResult result = new ResponseResult();
        result.put("msg", msg);
        return result;
    }

    public static ResponseResult success(Map<String, Object> map) {
        ResponseResult result = new ResponseResult();
        result.putAll(map);
        return result;
    }

    public static ResponseResult success() {
        return new ResponseResult();
    }

    @Override
    public ResponseResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
