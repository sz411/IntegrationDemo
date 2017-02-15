package com.fsz.integrationdemo.databinding;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by fsz on 2017/2/9.
 */

public class Event {

    public void show(View view){
        Toast.makeText(view.getContext(),"zheshiyige ",Toast.LENGTH_SHORT).show();
    }

}
