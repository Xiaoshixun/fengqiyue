package com.jiyun.zhoumozuoye.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.jiyun.zhoumozuoye.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private WebView web_item;
    private ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        web_item.loadUrl(name);
        web_item.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                web_item.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private void initView() {
        web_item = (WebView) findViewById(R.id.web_item);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
         UMImage image = new UMImage(Main2Activity.this, R.mipmap.ic_launcher);
                         UMImage thumb =  new UMImage(this, R.mipmap.ic_launcher);
                         image.setThumb(thumb);
                         UMShareListener umShareListener=new UMShareListener() {
                             @Override
                             public void onStart(SHARE_MEDIA share_media) {

                             }

                             @Override
                             public void onResult(SHARE_MEDIA share_media) {

                             }

                             @Override
                             public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                             }

                             @Override
                             public void onCancel(SHARE_MEDIA share_media) {

                             }
                         };
                         new ShareAction(Main2Activity.this)
                                 .withText("hello")
                                 .withMedia(image)
                                 .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                                 .setCallback(umShareListener)
                                 .open();


    }
}
