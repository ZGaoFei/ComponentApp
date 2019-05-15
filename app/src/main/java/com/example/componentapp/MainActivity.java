package com.example.componentapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.componentapp.adapter.MainViewPagerAdapter;
import com.example.libs.base.BaseActivity;
import com.example.libs.base.BaseFragment;
import com.example.libs.utils.SPUtils;

public class MainActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    private void initView() {
        mTabLayout = findViewById(R.id.tab_layout_main);
        mViewPager = findViewById(R.id.vp_main);

        initTabLayout();

        initViewPagerWithARouter();

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
    }

    private void initData() {
        SPUtils.instance().putString("name", "zgf");
        SPUtils.instance().putString("age", "21");
    }

    private void initTabLayout() {
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
    }

    /**
     * 使用ARouter的方式来获取fragment
     */
    private void initViewPagerWithARouter() {
        BaseFragment oneFragment = (BaseFragment) ARouter.getInstance().build("/one/homefragment").navigation();
        BaseFragment twoFragment = (BaseFragment) ARouter.getInstance().build("/two/homefragment").navigation();
        BaseFragment threeFragment = (BaseFragment) ARouter.getInstance().build("/three/homefragment").navigation();
        List<BaseFragment> list = new ArrayList<>();
        list.add(oneFragment);
        list.add(twoFragment);
        list.add(threeFragment);
        mViewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), list));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("zgf", "===activity=====" + requestCode + "=====" + resultCode + "====" + data);
    }
}
