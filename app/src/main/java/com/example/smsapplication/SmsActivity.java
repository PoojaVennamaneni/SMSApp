package com.example.smsapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsActivity extends AppCompatActivity {
    private EditText edtPhone,edtMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        edtPhone = findViewById(R.id.edit_phone);
        edtMessage = findViewById(R.id.edit_message);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permission = ContextCompat.checkSelfPermission(SmsActivity.this, Manifest.permission.SEND_SMS);
                if(permission == PackageManager.PERMISSION_GRANTED) {
                    sendSms();
                    // then we can send sms
                }else{
                    //we need permission for run time
                    ActivityCompat.requestPermissions(SmsActivity.this,new String[]{Manifest.permission.SEND_SMS},5);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions, @NonNull  int[] grantResults) {
        switch (requestCode) {
            case 5:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //then we can send sms
                    sendSms();
                }else{
                    Toast.makeText(this,"We need sms permission",Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }
    }

    private void sendSms() {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(edtPhone.getText().toString().trim(),null,edtMessage.getText().toString().trim(),null,null);
        Toast.makeText(this,"Message sent succesfully",Toast.LENGTH_LONG).show();
    }
}