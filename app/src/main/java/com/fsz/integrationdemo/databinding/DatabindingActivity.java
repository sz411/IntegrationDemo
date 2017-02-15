package com.fsz.integrationdemo.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fsz.integrationdemo.R;

/**
 * Created by fsz on 2017/2/9.
 */

public class DatabindingActivity extends AppCompatActivity{

    User user;
    ActivityDatabindingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_databinding);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_databinding);
        user = new User("aaaaaaaaa");
        user.setName("cccccc");
        binding.setUser(user);
        Event event = new Event();
        binding.setEvent(event);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User user2 = new User("bbbbbbb");
                user2.setName("bbbbbb111111");
                binding.setUser(user2);
            }
        },3000);
    }

}
