package com.ruoyi.common.utils;

import java.util.Collection;
import java.util.List;
import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.spring.SpringUtils;

/**
 * 字典工具類
 * 
 * @author ruoyi
 */
public class DictUtils
{
    /**
     * 分隔符
     */
    public static final String SEPARATOR = ",";

    /**
     * 設定字典快取
     * 
     * @param key 引數鍵
     * @param dictDatas 字典資料列表
     */
    public static void setDictCache(String key, List<SysDictData> dictDatas)
    {
        SpringUtils.getBean(RedisCache.class).setCacheObject(getCacheKey(key), dictDatas);
    }

    /**
     * 獲取字典快取
     * 
     * @param key 引數鍵
     * @return dictDatas 字典資料列表
     */
    public static List<SysDictData> getDictCache(String key)
    {
        JSONArray arrayCache = SpringUtils.getBean(RedisCache.class).getCacheObject(getCacheKey(key));
        if (StringUtils.isNotNull(arrayCache))
        {
            return arrayCache.toList(SysDictData.class);
        }
        return null;
    }

    /**
     * 根據字典型別和字典值獲取字典標籤
     * 
     * @param dictType 字典型別
     * @param dictValue 字典值
     * @return 字典標籤
     */
    public static String getDictLabel(String dictType, String dictValue)
    {
        if (StringUtils.isEmpty(dictValue))
        {
            return StringUtils.EMPTY;
        }
        return getDictLabel(dictType, dictValue, SEPARATOR);
    }

    /**
     * 根據字典型別和字典標籤獲取字典值
     * 
     * @param dictType 字典型別
     * @param dictLabel 字典標籤
     * @return 字典值
     */
    public static String getDictValue(String dictType, String dictLabel)
    {
        if (StringUtils.isEmpty(dictLabel))
        {
            return StringUtils.EMPTY;
        }
        return getDictValue(dictType, dictLabel, SEPARATOR);
    }

    /**
     * 根據字典型別和字典值獲取字典標籤
     * 
     * @param dictType 字典型別
     * @param dictValue 字典值
     * @param separator 分隔符
     * @return 字典標籤
     */
    public static String getDictLabel(String dictType, String dictValue, String separator)
    {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);
        if (StringUtils.isNull(datas))
        {
            return StringUtils.EMPTY;
        }
        if (StringUtils.containsAny(separator, dictValue))
        {
            for (SysDictData dict : datas)
            {
                for (String value : dictValue.split(separator))
                {
                    if (value.equals(dict.getDictValue()))
                    {
                        propertyString.append(dict.getDictLabel()).append(separator);
                        break;
                    }
                }
            }
        }
        else
        {
            for (SysDictData dict : datas)
            {
                if (dictValue.equals(dict.getDictValue()))
                {
                    return dict.getDictLabel();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 根據字典型別和字典標籤獲取字典值
     * 
     * @param dictType 字典型別
     * @param dictLabel 字典標籤
     * @param separator 分隔符
     * @return 字典值
     */
    public static String getDictValue(String dictType, String dictLabel, String separator)
    {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);
        if (StringUtils.isNull(datas))
        {
            return StringUtils.EMPTY;
        }
        if (StringUtils.containsAny(separator, dictLabel))
        {
            for (SysDictData dict : datas)
            {
                for (String label : dictLabel.split(separator))
                {
                    if (label.equals(dict.getDictLabel()))
                    {
                        propertyString.append(dict.getDictValue()).append(separator);
                        break;
                    }
                }
            }
        }
        else
        {
            for (SysDictData dict : datas)
            {
                if (dictLabel.equals(dict.getDictLabel()))
                {
                    return dict.getDictValue();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 根據字典型別獲取字典所有值
     *
     * @param dictType 字典型別
     * @return 字典值
     */
    public static String getDictValues(String dictType)
    {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);
        if (StringUtils.isNull(datas))
        {
            return StringUtils.EMPTY;
        }
        for (SysDictData dict : datas)
        {
            propertyString.append(dict.getDictValue()).append(SEPARATOR);
        }
        return StringUtils.stripEnd(propertyString.toString(), SEPARATOR);
    }

    /**
     * 根據字典型別獲取字典所有標籤
     *
     * @param dictType 字典型別
     * @return 字典值
     */
    public static String getDictLabels(String dictType)
    {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);
        if (StringUtils.isNull(datas))
        {
            return StringUtils.EMPTY;
        }
        for (SysDictData dict : datas)
        {
            propertyString.append(dict.getDictLabel()).append(SEPARATOR);
        }
        return StringUtils.stripEnd(propertyString.toString(), SEPARATOR);
    }

    /**
     * 刪除指定字典快取
     * 
     * @param key 字典鍵
     */
    public static void removeDictCache(String key)
    {
        SpringUtils.getBean(RedisCache.class).deleteObject(getCacheKey(key));
    }

    /**
     * 清空字典快取
     */
    public static void clearDictCache()
    {
        Collection<String> keys = SpringUtils.getBean(RedisCache.class).keys(CacheConstants.SYS_DICT_KEY + "*");
        SpringUtils.getBean(RedisCache.class).deleteObject(keys);
    }

    /**
     * 設定cache key
     * 
     * @param configKey 引數鍵
     * @return 快取鍵key
     */
    public static String getCacheKey(String configKey)
    {
        return CacheConstants.SYS_DICT_KEY + configKey;
    }
}
