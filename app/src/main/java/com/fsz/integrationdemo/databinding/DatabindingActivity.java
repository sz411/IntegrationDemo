package com.fsz.integrationdemo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fsz.integrationdemo.R;

/**
 * Created by fsz on 2017/2/9.
 */

public class DatabindingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_databinding);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_databinding);
        User user = new User();
        binding.setUser(user);
    }

}
