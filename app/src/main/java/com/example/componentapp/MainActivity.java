package com.example.componentapp;

import java.util.List;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.componentapp.adapter.MainViewPagerAdapter;
import com.example.libs.base.BaseActivity;
import com.example.libs.base.BaseFragment;
import com.example.libs.base.ClassUtils;
import com.example.libs.base.IApplicationDelegate;
import com.example.libs.base.IViewDelegate;
import com.example.libs.base.ViewManager;

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

        initViewPager();

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        mTabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
    }

    private void initData() {

    }

    private void initTabLayout() {
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
    }

    private void initViewPager() {
        List<BaseFragment> list = ViewManager.getInstance().getAllFragment();
        BaseFragment fragment = getFragment();
        list.add(fragment);
        mViewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), list));
    }

    /**
     * 根据路径单独进行查找
     */
    private BaseFragment getFragment() {
        BaseFragment baseFragment = null;
        List<IViewDelegate> delegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.example.module_three");
        if (delegates != null && !delegates.isEmpty()) {
            baseFragment = delegates.get(0).getFragment("");
        }

        return baseFragment;
    }
}
