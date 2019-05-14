package com.example.module_three;

import com.example.libs.base.BaseFragment;
import com.example.libs.base.IViewDelegate;
import com.example.module_three.fragment.ModuleThreeFragment;

public class ThreeViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment(String name) {
        return new ModuleThreeFragment();
    }
}
