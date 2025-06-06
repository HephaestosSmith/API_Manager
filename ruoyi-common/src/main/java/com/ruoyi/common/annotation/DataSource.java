package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 自定義多資料來源切換註解
 *
 * 優先順序：先方法，後類，如果方法覆蓋了類上的資料來源型別，以方法的為準，否則以類上的為準
 *
 * @author ruoyi
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource
{
    /**
     * 切換資料來源名稱
     */
    public DataSourceType value() default DataSourceType.MASTER;
}
