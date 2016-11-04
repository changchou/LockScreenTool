package com.jikexueyuan.lockscreentool;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_LOCKSCREEN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRegDeviceAdmin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                i.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,new ComponentName(MainActivity.this,MyDeviceAdminReceiver.class));
                startActivityForResult(i, REQUEST_ENABLE_LOCKSCREEN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_ENABLE_LOCKSCREEN:
                switch (resultCode){
                    case RESULT_OK:
                        startActivity(new Intent(this,RegedActivity.class));
                        break;
                    default:
                        break;
                }
                break;
        }
    }
}
