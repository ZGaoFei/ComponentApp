package com.example.module_one.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.libs.base.BaseFragment;
import com.example.module_one.R;


public class ModuleOneFragment extends BaseFragment {

    public ModuleOneFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module_one, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }

}
