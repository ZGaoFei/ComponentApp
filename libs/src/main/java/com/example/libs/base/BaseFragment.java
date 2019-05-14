package com.example.libs.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.libs.R;


public class BaseFragment extends Fragment {

    private BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mActivity = (BaseActivity) context;
    }

    protected BaseActivity getBaseActivity() {
        return mActivity;
    }
}
