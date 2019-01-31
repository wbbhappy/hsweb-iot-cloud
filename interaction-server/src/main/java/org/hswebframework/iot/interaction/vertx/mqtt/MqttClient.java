package org.hswebframework.iot.interaction.vertx.mqtt;

import io.netty.handler.codec.mqtt.MqttQoS;
import io.vertx.core.buffer.Buffer;
import io.vertx.mqtt.MqttEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.hswebframework.iot.interaction.core.IotCommand;
import org.hswebframework.iot.interaction.vertx.client.Client;

@Slf4j
public class MqttClient implements Client {

    private MqttEndpoint endpoint;

    private volatile long lastPingTime = System.currentTimeMillis();

    public MqttClient(MqttEndpoint endpoint) {
        endpoint.pingHandler(r -> ping());
        this.endpoint = endpoint;
    }

    public String getId() {
        return getClientId();
    }

    public String getClientId() {
        return endpoint.clientIdentifier();
    }

    public long lastPingTime() {
        return lastPingTime;
    }

    public void send(String topic, IotCommand command) {
        endpoint.publish(topic, Buffer.buffer(command.toString()), MqttQoS.AT_MOST_ONCE, false, false);
    }

    public void close() {
        if (endpoint.isConnected()) {
            endpoint.close();
        }
    }

    public void ping() {
        log.debug("mqtt client[{}] ping", getClientId());
        lastPingTime = System.currentTimeMillis();
    }

    public String toString() {
        return "MQTT Client[" + getClientId() + "]";
    }
}
