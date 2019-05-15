package com.example.module_one.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.libs.base.BaseActivity;
import com.example.module_one.R;

@Route(path = "/one/one")
public class OneActivity extends BaseActivity {
    @Autowired(name = "name")
    String name;
    @Autowired(name = "age")
    String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initView();
    }

    private void initView() {
        TextView textView = findViewById(R.id.tv_show_data);

        textView.setText("name: " + name + " age: " + age);
    }
}
