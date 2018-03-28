package com.example.wxj.my_fragement;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.wxj.my_fragement.fragment.OneFragment;
import com.example.wxj.my_fragement.fragment.ThreeFragment;
import com.example.wxj.my_fragement.fragment.TwoFragment;

public class DynamicActivity extends AppCompatActivity implements View.OnClickListener,
        CallBackValue {
    private Button btnOne, btnTwo, btnThree;
    private TextView tvShowMsg;
    private Fragment mOneFragment, mTwoFragment, mThreeFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnThree = (Button) findViewById(R.id.btn_three);

        tvShowMsg = (TextView) findViewById(R.id.tv_show_msg);


        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.btn_one:
                if (mOneFragment == null) {
                    mOneFragment = new OneFragment();
                }
                ft.replace(R.id.container, mOneFragment);
                break;
            case R.id.btn_two:
                if (mTwoFragment == null) {
                    mTwoFragment = new TwoFragment();
                }
                ft.replace(R.id.container, mTwoFragment);
                break;
            case R.id.btn_three:
                if (mThreeFragment == null) {
                    mThreeFragment = new ThreeFragment();
                    /*从DynamicActivity向ThreeFragement发送数据*/
                    Bundle bundle = new Bundle();
                    bundle.putString("key", "Activity to Fragment");
                    mThreeFragment.setArguments(bundle);
                }
                ft.replace(R.id.container, mThreeFragment);
                break;
        }
        ft.commit();
    }

    @Override
    public void sendMessageValue(String strValue) {
        tvShowMsg.setText(strValue);
    }
}
