package com.example.module_two.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.libs.base.BaseFragment;
import com.example.module_two.R;

@Route(path = "/two/homefragment")
public class ModuleTwoFragment extends BaseFragment {

    public ModuleTwoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module_two, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        Button button = view.findViewById(R.id.bt_skip_with_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build("/one/one")
                        .withString("name", "zgf")
                        .withString("age", "21")
                        .navigation();
            }
        });
    }

}
