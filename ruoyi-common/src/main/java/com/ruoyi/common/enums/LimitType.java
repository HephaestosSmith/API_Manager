package com.ruoyi.common.enums;

/**
 * 限流型別
 *
 * @author ruoyi
 */

public enum LimitType
{
    /**
     * 預設策略全侷限流
     */
    DEFAULT,

    /**
     * 根據請求者IP進行限流
     */
    IP
}
