package com.example.tradehub;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigstionview);
        Intent intent=getIntent();
        int position=intent.getIntExtra("position",0);
        if(position==1) bottomNavigationView.setSelectedItemId(R.id.mine);
        else if(position==0) bottomNavigationView.setSelectedItemId(R.id.home);
        else if(position==2) bottomNavigationView.setSelectedItemId(R.id.message);
        selectedFragment(position);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    selectedFragment(0);
                }else if(item.getItemId()==R.id.mine){
                    selectedFragment(1);
                }else if(item.getItemId()==R.id.message){
                    selectedFragment(2);
                }
                return true;
            }
        });
    }
    private void selectedFragment(int position){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if(position==0) {
            if (mHomeFragment == null) {
                mHomeFragment = new HomeFragment();
                fragmentTransaction.add(R.id.content, mHomeFragment);
            } else {
                fragmentTransaction.show(mHomeFragment);
            }
        }else if(position==1){
            if(mMineFragment==null){
                mMineFragment=new MineFragment();
                fragmentTransaction.add(R.id.content,mMineFragment);
            }else{
                fragmentTransaction.show(mMineFragment);
            }
        }else if(position==2){
            if(mMessageFragment==null){
                mMessageFragment=new MessageFragment();
                fragmentTransaction.add(R.id.content,mMessageFragment);
            }else{
                fragmentTransaction.show(mMessageFragment);
            }
        }
        fragmentTransaction.commit();
    }
    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(mHomeFragment!=null){
            fragmentTransaction.hide(mHomeFragment);
        }
        if(mMineFragment!=null){
            fragmentTransaction.hide(mMineFragment);
        }
        if(mMessageFragment!=null){
            fragmentTransaction.hide(mMessageFragment);
        }
    }


    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("您真的要退出TradeHub吗？")
                .setNegativeButton("暂时不要", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }


};

