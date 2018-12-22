package com.squareoneinsights.instrumentation;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.squareoneinsights.instrumentation.test", appContext.getPackageName());
    }

    @Test
    public void sendActivity_Test() {
        JSONObject postDataParams = new JSONObject();
        try {
            postDataParams.put("userId", "morpheus");
            postDataParams.put("activityName", "leader4455");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String strURL = "http://192.168.0.8:9000/api/v1/activity-engine/activity";

        assertEquals("{\"activityId\":\"386a3b79-5019-47bf-98b8-309aaf75cc49\",\"offerCode\":\"A10023\"," +
                "\"offerDetail\":\"5% off on Pizza.\"}", WebUtil.SendActivity(strURL, postDataParams.toString()));
    }
}
