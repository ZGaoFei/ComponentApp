package com.example.module_one;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.libs.base.BaseActivity;
import com.example.module_one.activity.HomeActivity;

/**
 * module单独开发时的入口
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        TextView textView = findViewById(R.id.tv_skip_next_one);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomeActivity.createIntent(MainActivity.this));
            }
        });
    }
}
