package com.haoze.common.model;

import com.github.pagehelper.Page;

/**
 * 基本服务接口。
 * @author maxl
 * @time 2018-05-31。
 */
public interface BaseService<T,K> {

    ResponseResult insert(T t);
    ResponseResult delete(K k);
    ResponseResult update(T t);
    T get(K k);
    Page<T> list(QueryParam queryParam);
    int count(QueryParam queryParam);
}
