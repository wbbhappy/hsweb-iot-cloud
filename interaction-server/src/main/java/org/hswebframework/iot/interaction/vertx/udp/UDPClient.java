package org.hswebframework.iot.interaction.vertx.udp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.vertx.core.datagram.DatagramSocket;
import io.vertx.core.net.SocketAddress;
import lombok.extern.slf4j.Slf4j;
import org.hswebframework.iot.interaction.core.IotCommand;
import org.hswebframework.iot.interaction.vertx.client.Client;

@Slf4j
public class UDPClient implements Client {

    private String clientId;
    private SocketAddress clientAddress;
    private DatagramSocket socket;
    private long lastPingTime = System.currentTimeMillis();

    public UDPClient(String clientId, SocketAddress clientAddress, DatagramSocket socket) {
        this.clientId = clientId;
        this.clientAddress = clientAddress;
        this.socket = socket;
    }

    public String getId() {
        return clientAddress.host() + ":" + clientAddress.port();
    }
    public String getClientId() {
        return clientId;
    }
    public long lastPingTime() {
        return lastPingTime;
    }
    public void send(String topic, IotCommand command) {
        JSONObject json = (JSONObject) JSON.toJSON(command);
        json.put("type", topic);
        socket.send(json.toString(), clientAddress.port(), clientAddress.host(), result -> {
            if (result.succeeded()) {
                log.debug("向UDP客户端:[{}]发送数据完成:{}", clientAddress, command);
            } else {
                log.error("向UDP客户端:[{}]发送数据失败:{}", clientAddress, command, result.cause());
            }
        });
    }

    public void close() {

    }

    public String toString() {
        return "UDP Client[" + getClientId() + "]:[" + clientAddress + "]";
    }

    public void ping() {
        log.debug("udp client[{}] ping", clientAddress);
        lastPingTime = System.currentTimeMillis();
    }
}
