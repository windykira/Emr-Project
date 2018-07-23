package com.haoze.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.net.URL;

/**
 * Ehcache缓存。
 * @author maxl
 * @time 2018-05-05。
 */
public class OcsCache {

    private static final String path = "/config/ehcache.xml";
    private static final String defaultCache = "businessCache";
    private static CacheManager manager;

    private static final int timeToLive = 30 * 60;

    public static void put(String key, String value,int minutes) {
        Cache cache = manager.getCache(defaultCache);
        Element element = new Element(key, value);
        element.setTimeToLive(minutes * 60);
        cache.put(element);
    }

    public static void put(String key, String value) {
        Cache cache = manager.getCache(defaultCache);
        Element element = new Element(key, value);
        element.setTimeToLive(timeToLive);
        cache.put(element);
    }

    public static void put(String cacheName,String key, String value) {
        Cache cache = manager.getCache(cacheName);
        Element element = new Element(key, value);
        element.setTimeToLive(timeToLive);
        cache.put(element);
    }

    public static Object get(String key) {
        Cache cache = manager.getCache(defaultCache);
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    public static Object get(String cacheName,String key) {
        Cache cache = manager.getCache(cacheName);
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    public static void remove(String key) {
        Cache cache = manager.getCache(defaultCache);
        cache.remove(key);
    }

    public static void remove(String cacheName,String key) {
        Cache cache = manager.getCache(cacheName);
        cache.remove(key);
    }

    private static void init() {
        URL url = OcsCache.class.getResource(path);
        manager = CacheManager.create(url);
    }

    static {
        init();
    }
}
