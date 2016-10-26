package com.hangover.java.notification;

import com.hangover.java.util.CommonUtil;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: ashqures
 * Date: 9/11/16
 * Time: 10:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class FCMPushNotificationService extends FCMConfig implements PushNotificationService {

    private static Logger logger = LoggerFactory.getLogger(FCMPushNotificationService.class);

    protected static final String UTF8 = "UTF-8";

    @Override
    public void promotional(Message message) {
        JSONObject jsonObject = new JSONObject();
        // makeGCMRequest(jsonObject);
    }

    @Override
    public void transactional(Message message) {
        //sendPush(message);
        addAllMulticasts(Arrays.asList(message.getTo()))
                .collapse_key(message.getSubject())
                .priority(message.getPriority())
                .delay_while_idle(true)
                .time_to_live(Integer.parseInt(CommonUtil.getProperty("FCM_MESSAGE_TIME_TO_LIVE")))
                .restricted_package_name(CommonUtil.getProperty("FCM_PACKAGE_NAME"))
                .dry_run(false)
                .data(message.getContext())
                .title(message.getSubject())
                .body(message.getContent())
                .color(CommonUtil.getProperty("FCM_MESSAGE_DISPLAY_COLOR"));
        FCMResponse response = push();
        System.out.println(response);
    }

    public FCMPushNotificationService() {
        super();
    }

    public FCMResponse push() {
        System.out.println(toJSON());
        HttpsURLConnection con = null;
        try {
            String url = CommonUtil.getProperty("FCM_END_POINTS");
            URL obj = new URL(url);
            con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            // Set POST headers
            con.setRequestProperty("Authorization", "key="+CommonUtil.getProperty("FCM_API_KEY")/*"key=AIzaSyCiaKah_owr0yhEbIcULkEC3CosDqj75mI"*/);
            con.setRequestProperty("Content-Type", CommonUtil.getProperty("FCM_CONTENT_TYPE"));
            // Send POST body
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(this.toJSON());
            wr.flush();
            wr.close();
            con.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new FCMResponse(con);
    }

}
