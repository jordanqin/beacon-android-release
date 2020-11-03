package com.tencent.qcloud.beaconw;

import android.content.Context;

import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;

import java.util.Map;

public class BeaconWrapper {
    private static final String TAG = "BeaconWrapper";

    private static BeaconWrapper instance;

    private BeaconWrapper() {
    }

    /**
     * 初始化
     */
    public static void init(Context applicationContext) {
        synchronized (BeaconWrapper.class) {
            if (instance == null) {
                instance = new BeaconWrapper();

                BeaconConfig config = BeaconConfig.builder()
                        .build();
                BeaconReport beaconReport = BeaconReport.getInstance();
                beaconReport.start(applicationContext, "", config);
            }
        }
    }

    public static BeaconWrapper getInstance() {
        return instance;
    }

    private void report(String eventcode, Map<String, String> params) {
        BeaconEvent event = BeaconEvent.builder()
                .withParams(params)
                .withIsSimpleParams(true)
                .build();
        BeaconReport.getInstance().report(event);
    }
}
