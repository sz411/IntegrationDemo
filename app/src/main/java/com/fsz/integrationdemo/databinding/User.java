package com.fsz.integrationdemo.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by fsz on 2017/2/9.
 */

public class User extends BaseObservable{

    public String name = "成功了";

    public User(String name){
        this.name = name;
    }

    @Bindable
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
        notifyChange();
    }

}
