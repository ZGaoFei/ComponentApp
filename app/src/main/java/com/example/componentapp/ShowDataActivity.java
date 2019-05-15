package com.example.componentapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.libs.base.BaseActivity;
import com.example.libs.utils.SPUtils;

@Route(path = "/main/showdata")
public class ShowDataActivity extends BaseActivity {
    private TextView tvName;
    private TextView tvAge;

    public static Intent createIntent(Context context) {
        return new Intent(context, ShowDataActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        initView();
    }

    private void initView() {
        tvName = findViewById(R.id.tv_show_name);
        tvAge = findViewById(R.id.tv_show_age);

        Button button = findViewById(R.id.bt_get_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }

    private void getData() {
        String name = SPUtils.instance().getString(SPUtils.KEY_NAME);
        String age = SPUtils.instance().getString(SPUtils.KEY_AGE);
        tvName.setText(name);
        tvAge.setText(age);
    }
}
