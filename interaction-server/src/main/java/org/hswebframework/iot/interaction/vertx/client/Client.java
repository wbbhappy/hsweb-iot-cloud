package org.hswebframework.iot.interaction.vertx.client;

import org.hswebframework.iot.interaction.core.IotCommand;

public interface Client {
    String getId();
    String getClientId();
    long lastPingTime();
    void send(String topic, IotCommand command);
    void close();
    void ping();
}
