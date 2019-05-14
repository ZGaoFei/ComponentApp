package com.example.module_two;

import com.example.libs.base.IApplicationDelegate;
import com.example.libs.base.ViewManager;
import com.example.module_two.fragment.ModuleTwoFragment;

public class TwoDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        ViewManager.getInstance().addFragment(1, new ModuleTwoFragment());
    }
}
