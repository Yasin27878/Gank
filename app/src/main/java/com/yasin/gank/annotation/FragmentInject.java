package com.yasin.gank.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description :Fragment的布局注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface FragmentInject {
    /**
     * 顶部局的id
     *
     * @return
     */
    int contentViewId() default -1;
}
