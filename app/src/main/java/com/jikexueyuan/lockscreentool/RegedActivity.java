package com.jikexueyuan.lockscreentool;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegedActivity extends AppCompatActivity implements View.OnClickListener {

    private DevicePolicyManager devicePolicyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reged);

        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);

        findViewById(R.id.btnUnRegDeviceAdmin).setOnClickListener(this);
        findViewById(R.id.btnLockScreen).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLockScreen:
                devicePolicyManager.lockNow();
                break;
            case R.id.btnUnRegDeviceAdmin:
                devicePolicyManager.removeActiveAdmin(new ComponentName(this, MyDeviceAdminReceiver.class));
                finish();
                break;
        }
    }
}
