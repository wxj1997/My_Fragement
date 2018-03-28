package com.example.wxj.my_fragement.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.wxj.my_fragement.CallBackValue;
import com.example.wxj.my_fragement.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment {
    private TextView tvShowMsg;
    private Button button;
    private CallBackValue callBackValue;

    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_three, container, false);
        tvShowMsg=(TextView) v.findViewById(R.id.tv_show_msg);
        button=(Button) v.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*从ThreeFragement向DynamicActivity发送数据*/
                ((CallBackValue)getActivity()).sendMessageValue("Fragement to activity");
            }
        });
        return v;

    }
/*接收从DynamicActivity传来的数据*/
    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle=getArguments();
        tvShowMsg.setText(bundle.getString("key"));
    }
}
