package com.example.module_two.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.libs.base.BaseFragment;
import com.example.module_two.R;


public class ModuleTwoFragment extends BaseFragment {

    public ModuleTwoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_module_two, container, false);
        return view;
    }

}
