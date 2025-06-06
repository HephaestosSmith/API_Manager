package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 資料許可權過濾註解
 * 
 * @author ruoyi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope
{
    /**
     * 部門表的別名
     */
    public String deptAlias() default "";

    /**
     * 使用者表的別名
     */
    public String userAlias() default "";

    /**
     * 許可權字元（用於多個角色匹配符合要求的許可權）預設根據許可權註解@ss獲取，多個許可權用逗號分隔開來
     */
    public String permission() default "";
}
