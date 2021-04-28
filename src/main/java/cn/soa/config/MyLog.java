package cn.soa.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类
 */
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Documented //生成文档
public @interface MyLog {
    String value() default "";
}