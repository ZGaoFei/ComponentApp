package com.example.module_three.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.libs.base.BaseFragment;
import com.example.libs.utils.SPUtils;
import com.example.module_three.R;

@Route(path = "/three/homefragment")
public class ModuleThreeFragment extends BaseFragment {

    private TextView textView;

    private String name;
    private String age;

    public ModuleThreeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module_three, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        textView = view.findViewById(R.id.tv_show_result_data);
        Button button = view.findViewById(R.id.bt_skip_with_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // activity 中获取数据
                 ARouter.getInstance().build("/two/two").navigation(getBaseActivity(), 1);
            }
        });

        textView.setText("name: " + name + " age: " + age);
    }

    private void initData() {
        name = SPUtils.instance().getString("name");
        age = SPUtils.instance().getString("age");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("zgf", "====fragment====" + requestCode + "=====" + resultCode + "====" + data);

        if (resultCode == 1 && requestCode == 1) {
            String name = data.getStringExtra("name");
            String age = data.getStringExtra("age");
            textView.setText("name: " + name + " age: " + age);
        }
    }
}
