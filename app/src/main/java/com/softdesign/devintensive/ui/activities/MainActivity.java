package com.softdesign.devintensive.ui.activities;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.ui.util.ConstantManager;

public class MainActivity extends BaseActivity  implements View.OnClickListener{

    public static final String TAG = ConstantManager.TAG_PREFIX + "Main activity";
    private ImageView mCallImg;
    private CoordinatorLayout mCoordinatorLayoutMain;
    private Toolbar mToolbar;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");


        mCallImg = (ImageView)findViewById(R.id.call_img);
        mCoordinatorLayoutMain = (CoordinatorLayout)findViewById(R.id.main_coordinator_layout);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);


        mCallImg.setOnClickListener(this);
        if(savedInstanceState == null){
            showSnackkbar("Активити запускается впервые");
        }else {
            showSnackkbar("Активити уже было запущено");
        }



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.call_img:
               /* showProgress();
                runWithDelay();*/
                break;
        }
    }

    private void showSnackkbar(String message){
        Snackbar.make(mCoordinatorLayoutMain, message, Snackbar.LENGTH_LONG).show();
    }

    private void setupTollbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar !=null)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }


}