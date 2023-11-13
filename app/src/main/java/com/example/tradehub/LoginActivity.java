package com.example.tradehub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class LoginActivity extends AppCompatActivity {

    private MineFragment mMineFragment;
    private EditText mEtloginactivityPhonecodes;
    private ImageView mIvloginactivityShowcode;
    private String realCode;
    FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEtloginactivityPhonecodes = findViewById(R.id.et_loginactivity_phoneCodes);
        mIvloginactivityShowcode = findViewById(R.id.iv_loginactivity_showCode);
        mIvloginactivityShowcode.setImageBitmap(code.getInstance().createBitmap());
        realCode = code.getInstance().getCode().toLowerCase(); //将验证码用图片的形式显示出来
        mIvloginactivityShowcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvloginactivityShowcode.setImageBitmap(code.getInstance().createBitmap());
                realCode = code.getInstance().getCode().toLowerCase(); //将验证码用图片的形式显示出来
            }
        });

        findViewById(R.id.deng).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneCode = mEtloginactivityPhonecodes.getText().toString().toLowerCase();
                if(phoneCode.length()==0){
                    Toast.makeText(LoginActivity.this,"验证码不能为空",Toast.LENGTH_SHORT).show();
                }
                else if (!phoneCode.equals(realCode)){
                    Toast.makeText(LoginActivity.this,"验证码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("position",1);
                startActivity(intent);
            }
        });

    }
}