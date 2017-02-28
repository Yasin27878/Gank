package com.yasin.gank.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Yasin on 2017/2/28.
 * Email : yasin27878@163.com
 * Description : Activity的布局注解
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ActivityInject {
    /**
     * 菜单id
     *
     * @return
     */
    int menuId() default -1;


    /**
     * toolbar的标题id
     *
     * @return
     */
    int toolbarTitle() default -1;

    /**
     * contentView id
     *
     * @return
     */
    int contentView() default -1;
}
