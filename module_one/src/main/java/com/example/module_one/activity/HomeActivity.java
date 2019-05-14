package com.example.module_one.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.libs.base.BaseActivity;
import com.example.module_one.R;
import com.example.module_one.fragment.ModuleOneFragment;

public class HomeActivity extends BaseActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initData();
    }

    private void initData() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fl_fragment, new ModuleOneFragment())
                .commitNow();
    }
}
