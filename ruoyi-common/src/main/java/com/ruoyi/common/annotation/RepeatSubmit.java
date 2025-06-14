package com.ruoyi.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定義註解防止表單重複提交
 * 
 * @author ruoyi
 *
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit
{
    /**
     * 間隔時間(ms)，小於此時間視為重複提交
     */
    public int interval() default 5000;

    /**
     * 提示訊息
     */
    public String message() default "不允許重複提交，請稍候再試";
}
