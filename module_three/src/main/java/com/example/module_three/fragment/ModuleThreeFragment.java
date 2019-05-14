package com.example.module_three.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.libs.base.BaseFragment;
import com.example.module_three.R;

public class ModuleThreeFragment extends BaseFragment {

    public ModuleThreeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module_three, container, false);

        return view;
    }

}
