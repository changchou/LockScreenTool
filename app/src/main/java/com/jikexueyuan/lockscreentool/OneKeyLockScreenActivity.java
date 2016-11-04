package com.jikexueyuan.lockscreentool;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;

public class OneKeyLockScreenActivity extends Activity {

    private DevicePolicyManager devicePolicyManager;
    private ComponentName componentName;

    @Override
    protected void onResume() {
        super.onResume();
        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        componentName = new ComponentName(this, MyDeviceAdminReceiver.class);

        if (devicePolicyManager.isAdminActive(componentName)){
            devicePolicyManager.lockNow();
            finish();
        } else {
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }
}
