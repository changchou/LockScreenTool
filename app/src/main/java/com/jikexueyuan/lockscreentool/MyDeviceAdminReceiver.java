package com.jikexueyuan.lockscreentool;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/12/16 0016.
 */
public class MyDeviceAdminReceiver extends DeviceAdminReceiver {

    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);

        Toast.makeText(context, R.string.Reged, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);

        Toast.makeText(context, R.string.UnReged,Toast.LENGTH_SHORT).show();
    }
}
