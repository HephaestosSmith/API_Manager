package com.ruoyi.system.domain;

import com.ruoyi.common.utils.StringUtils;

/**
 * 快取資訊
 * 
 * @author ruoyi
 */
public class SysCache
{
    /** 快取名稱 */
    private String cacheName = "";

    /** 快取鍵名 */
    private String cacheKey = "";

    /** 快取內容 */
    private String cacheValue = "";

    /** 備註 */
    private String remark = "";

    public SysCache()
    {

    }

    public SysCache(String cacheName, String remark)
    {
        this.cacheName = cacheName;
        this.remark = remark;
    }

    public SysCache(String cacheName, String cacheKey, String cacheValue)
    {
        this.cacheName = StringUtils.replace(cacheName, ":", "");
        this.cacheKey = StringUtils.replace(cacheKey, cacheName, "");
        this.cacheValue = cacheValue;
    }

    public String getCacheName()
    {
        return cacheName;
    }

    public void setCacheName(String cacheName)
    {
        this.cacheName = cacheName;
    }

    public String getCacheKey()
    {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey)
    {
        this.cacheKey = cacheKey;
    }

    public String getCacheValue()
    {
        return cacheValue;
    }

    public void setCacheValue(String cacheValue)
    {
        this.cacheValue = cacheValue;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
