package com.example.module_one;

import com.example.libs.base.IApplicationDelegate;
import com.example.libs.base.ViewManager;
import com.example.module_one.fragment.ModuleOneFragment;

public class OneDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        ViewManager.getInstance().addFragment(0, new ModuleOneFragment());
    }
}
