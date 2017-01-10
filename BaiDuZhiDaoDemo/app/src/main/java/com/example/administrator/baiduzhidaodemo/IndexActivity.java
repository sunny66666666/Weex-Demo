package com.example.administrator.baiduzhidaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${zhangqiong} on 2017/1/10.
 * Description: 当实现动画进入后，利用 weex的 render  方法，将。js文件在原生的activity中显示
 */
public class IndexActivity extends AppCompatActivity implements IWXRenderListener {
    WXSDKInstance mWXSDKInstance;
    private static final String DEFAULT_IP = "your_current_IP";
    private static String CURRENT_IP= DEFAULT_IP; // your_current_IP
    private static final String WEEX_INDEX_URL = "http://"+CURRENT_IP+":12580/examples/build/index.js";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        mWXSDKInstance = new WXSDKInstance(this);
        mWXSDKInstance.registerRenderListener(this);
        /**
         * WXSample 可以替换成自定义的字符串，针对埋点有效。
         * template 是.we transform 后的 js文件。
         * option 可以为空，或者通过option传入 js需要的参数。例如bundle js的地址等。
         * jsonInitData 可以为空。
         * width 为-1 默认全屏，可以自己定制。
         * height =-1 默认全屏，可以自己定制。
         */
//        mWXSDKInstance.render("WXSample", WXFileUtils.loadFileContent("test.js", this), null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
        renderPage(WXFileUtils.loadFileContent("test.js", this), WEEX_INDEX_URL,null);

    }

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        setContentView(view);


    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mWXSDKInstance!=null){
            mWXSDKInstance.onActivityDestroy();
        }
    }

    protected void renderPage(String template,String source,String jsonInitData){
        Map<String, Object> options = new HashMap<>();
        options.put(WXSDKInstance.BUNDLE_URL, source);
        mWXSDKInstance.render(
                "package",
                template,
                options,
                jsonInitData,
                ScreenUtil.getDisplayWidth(this),
                ScreenUtil.getDisplayHeight(this),
                WXRenderStrategy.APPEND_ASYNC);
    }
}
