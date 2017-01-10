package com.example.administrator.baiduzhidaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.TextView;
/**
 * Created by ${zhangqiong} on 2017/1/10.
 * Description:   实现首页的动画进入效果
 */
public class MainActivity extends AppCompatActivity {
    private TextView tv_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    //实现进入动画
    private void initView(){
        tv_splash= (TextView) findViewById(R.id.tv_splash);
        AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,0.5f);
        AnimationSet animationSet=new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(2000);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this,IndexActivity.class));
                finish();

            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tv_splash.startAnimation(animationSet);
    }

}
