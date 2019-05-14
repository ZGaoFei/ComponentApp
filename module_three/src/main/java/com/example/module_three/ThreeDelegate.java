package com.example.module_three;

import com.example.libs.base.IApplicationDelegate;
import com.example.libs.base.ViewManager;
import com.example.module_three.fragment.ModuleThreeFragment;

public class ThreeDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        // ViewManager.getInstance().addFragment(2, new ModuleThreeFragment());
    }
}
