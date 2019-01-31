package org.hswebframework.iot.interaction.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@AllArgsConstructor
@Getter
public class DeviceConnectEvent {
    private String clientId;
    private Date connectTime;
}
