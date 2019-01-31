package org.hswebframework.iot.interaction.vertx.mqtt;

import org.hswebframework.iot.interaction.vertx.VerticleSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import static org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE;
@Component
public class MqttServerVerticleSupplier implements VerticleSupplier {

    @Autowired
    private ApplicationContext context;

    public VertxMqttServer get() {
        //使用spring上下文创建实例,并注入spring中的bean
        return (VertxMqttServer) context.getAutowireCapableBeanFactory()
                .autowire(VertxMqttServer.class, AUTOWIRE_BY_TYPE, true);
    }

    public String toString() {
        return "MqttServer(" + getInstances() + ")";
    }
}
