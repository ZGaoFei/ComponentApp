package com.example.module_two.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.libs.base.BaseActivity;
import com.example.module_two.R;
import com.example.module_two.fragment.ModuleTwoFragment;

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
                .add(R.id.fl_fragment, new ModuleTwoFragment())
                .commit();
    }
}
