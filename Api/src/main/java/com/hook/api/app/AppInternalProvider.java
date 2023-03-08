package com.hook.api.app;

import org.springframework.beans.factory.InitializingBean;

/**
 * Description 维护每个app内部信息
 * Author hebaokai
 * Date 2023/3/8 16:29
 *
 * @Version 1.0
 **/
public class AppInternalProvider implements InitializingBean {

    private String appId;

    @Override
    public void afterPropertiesSet() throws Exception {
        //todo load runtime context from persistence
    }
}
