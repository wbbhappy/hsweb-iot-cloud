package org.hswebframework.iot.interaction.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hswebframework.iot.interaction.vertx.client.message.ClientMessage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceReportEvent extends ClientMessage{
    @NotBlank
    private String action;
}
