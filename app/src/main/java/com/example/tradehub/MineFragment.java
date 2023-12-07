package com.example.tradehub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MineFragment extends Fragment {



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mine, container, false);


        rootView.findViewById(R.id.login1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View fragmentView=getView();
                TextView minename=fragmentView.findViewById(R.id.mine_name);
                String name=minename.getText().toString() ;
                if(!name.isEmpty()){
                    Toast.makeText(rootView.getContext(),"您已登录！",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        rootView.findViewById(R.id.myrelease).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View fragmentView=getView();
                TextView minename=fragmentView.findViewById(R.id.mine_name);
                String name=minename.getText().toString() ;
                if(name.isEmpty()){
                    Toast.makeText(rootView.getContext(),"您未登录！",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent=new Intent(getActivity(), MyReleaseActivity.class);
                    startActivity(intent);
                }

            }
        });
        rootView.findViewById(R.id.myview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View fragmentView=getView();
                TextView minename=fragmentView.findViewById(R.id.mine_name);
                String name=minename.getText().toString() ;
                if(name.isEmpty()){
                    Toast.makeText(rootView.getContext(),"您未登录！",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent=new Intent(getActivity(),MyviewActivity.class);
                    startActivity(intent);
                }

            }
        });
        rootView.findViewById(R.id.outlogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View fragmentView=getView();
                TextView minename=fragmentView.findViewById(R.id.mine_name);
                String name=minename.getText().toString() ;
                if(name.isEmpty()){
                    Toast.makeText(rootView.getContext(),"您未登录！",Toast.LENGTH_LONG).show();
                }else{
                    // 获取FragmentManager
                    TextView minexueyuan=fragmentView.findViewById(R.id.mine_xueyuan);
                    minename.setText("");
                    minexueyuan.setText("");
                    MyApplication myApplication = (MyApplication) getActivity().getApplication();
                    myApplication.setSharedVariable(0);
                    Toast.makeText(rootView.getContext(),"您已退出！",Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View fragmentView=getView();
        TextView minename=fragmentView.findViewById(R.id.mine_name);
        TextView minexueyuan=fragmentView.findViewById(R.id.mine_xueyuan);
        Intent intent= getActivity().getIntent();
        minename.setText(intent.getStringExtra("minename"));
        minexueyuan.setText(intent.getStringExtra("minexueyuan"));
    }
}