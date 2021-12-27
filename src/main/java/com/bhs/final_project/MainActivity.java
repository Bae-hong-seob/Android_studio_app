package com.bhs.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //메세지 -> 방송수신자 설정
    private int MY_PERMISSIONS_REQUEST_SMS_RECEIVE = 10;
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)){

                String smsBody = "";
                for (SmsMessage smsMessage :
                        Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    smsBody += smsMessage.getMessageBody();
                }
                Toast.makeText(getApplicationContext(), smsBody, Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startbtn = (Button) findViewById(R.id.start);
        Button login = (Button) findViewById(R.id.btn_login);

        //START 버튼 클릭시 Listmenu 화면으로 이동 - 인텐트 객체 사용
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, photo_list.class);
                startActivity(intent);
            }
        });

        //로그인버튼 -> 대화상자 CustomDialog
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog loginDialog = new Dialog(MainActivity.this);
                loginDialog.setContentView(R.layout.login);
                loginDialog.setTitle("로그인 화면");

                Button ok = (Button) loginDialog.findViewById(R.id.login);
                Button cancel = (Button) loginDialog.findViewById(R.id.cancel);
                final EditText username = (EditText) loginDialog
                        .findViewById(R.id.username);
                final EditText password = (EditText) loginDialog
                        .findViewById(R.id.password);

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().trim().length() > 0
                                && password.getText().toString().trim().length() > 0) {
                            Toast.makeText(getApplicationContext(), "로그인 성공",
                                    Toast.LENGTH_LONG).show();

                            loginDialog.dismiss();
                        } else {
                            Toast.makeText(getApplicationContext(), "다시 입력해주세요.",
                                    Toast.LENGTH_LONG).show();

                        }
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loginDialog.dismiss();
                    }
                });
                loginDialog.show();
            }
        });

        //메세지 왔을때 허가권한받기
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS},
                MY_PERMISSIONS_REQUEST_SMS_RECEIVE);
    }
    public void onResume() {
        super.onResume();
        IntentFilter filter=new IntentFilter();
        filter.addAction("andorid.provider.Telephony.SMS_RECEIVED");
        registerReceiver(receiver,filter);
    };
    public void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

}