package com.bacy.view.titlebar;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.titlebar.R;


public class MainActivity extends Activity {
    private ImageView mCollectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (hasKitKat()) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        final TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);

        titleBar.setImmersive(true);

        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setLeftImageResource(R.drawable.back_green);
        titleBar.setLeftText("返回");
        titleBar.setLeftTextColor(Color.WHITE);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titleBar.setTitle("文章详情");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

        titleBar.setActionTextColor(Color.WHITE);
        mCollectView = (ImageView) titleBar.addAction(new TitleBar.ImageAction(R.drawable.collect) {
            @Override
            public void performAction(View view) {
                Toast.makeText(MainActivity.this, "点击了收藏", Toast.LENGTH_SHORT).show();
                mCollectView.setImageResource(R.drawable.fabu);
                titleBar.setTitle("文章详情\n朋友圈");
            }
        });

        titleBar.addAction(new TitleBar.TextAction("发布") {
            @Override
            public void performAction(View view) {
                Toast.makeText(MainActivity.this, "点击了发布", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }
}
