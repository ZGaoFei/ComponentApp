package com.example.module_two.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.libs.base.BaseActivity;
import com.example.module_two.R;

@Route(path = "/two/two")
public class TwoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        initView();
    }

    private void initView() {
        Button button = findViewById(R.id.bt_finish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "zgf");
                intent.putExtra("age", "21");
                setResult(10, intent);
                finish();
            }
        });
    }
}
