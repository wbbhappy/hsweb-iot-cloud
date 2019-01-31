package org.hswebframework.iot.authorization;

import org.hswebframework.web.authorization.basic.web.ParsedToken;
import org.hswebframework.web.authorization.basic.web.UserTokenParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
/**
 * 后台管理token解析器,解析请求头中的<code>iot-cloud-user</code>作为token
 */
@Component
public class SimpleUserTokenParser implements UserTokenParser {
    public ParsedToken parseToken(HttpServletRequest request) {
        String header = request.getHeader("iot-cloud-user");
        if (StringUtils.isEmpty(header)) {
            return null;
        }
        return new ParsedToken() {
            public String getToken() {
                return header;
            }
            public String getType() {
                return "iot-cloud-user";
            }
        };
    }
}
