package com.hook.api.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

/**
 * Description 注册AppInternalProvider到context中
 * Author hebaokai
 * Date 2023/3/8 16:44
 *
 * @Version 1.0
 **/
public class AppBeanDefinitionBuilder implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }



    public void initializingAppBean(String id) {
        Assert.isTrue(!context.containsBean("app"+id),"context contains already");
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.add("appId", id);
        gbd.setPropertyValues(mpv);
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) this.context;
        registry.registerBeanDefinition("app"+id,gbd);
    }
}
