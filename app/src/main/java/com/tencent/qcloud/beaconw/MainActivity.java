package com.tencent.qcloud.beaconw;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.tencent.beacon.event.open.BeaconConfig;
import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.beacon.event.open.EventResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BeaconConfig config = BeaconConfig.builder()
                .build();
        BeaconReport beaconReport = BeaconReport.getInstance();
        beaconReport.start(getApplicationContext(), "aaaaaaaa", config);

        BeaconEvent event = BeaconEvent.builder()
                .withCode("base_service")
                .withIsSimpleParams(true)
                .build();
        EventResult result = BeaconReport.getInstance().report(event);
        Log.d("qjd", "EventResult{ eventID:" + result.eventID + ", errorCode: " + result.errorCode + ", errorMsg: " + result.errMsg + "}");
    }
}