package com.youkumenu.lfw.youku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView icon_home, icon_menu;
    private RelativeLayout level1, level2, level3;
    private boolean isShowLevel3 = true;
    private boolean isShowLevel2 = true;
    private boolean isShowLevel1 = true;

    Tools tools = new Tools();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        level1 = (RelativeLayout) findViewById(R.id.level1);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        level3 = (RelativeLayout) findViewById(R.id.level3);
        icon_home = (ImageView) findViewById(R.id.icon_home);
        icon_menu = (ImageView) findViewById(R.id.icon_menu);

        MyOnClickListener myOnClickListener = new MyOnClickListener();
        icon_home.setOnClickListener(myOnClickListener);
        icon_menu.setOnClickListener(myOnClickListener);
    }

    class MyOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {

            switch (v.getId())
            {
                case R.id.icon_home:
                    if (isShowLevel2)
                    {
                        //level2隐藏
                        tools.hideView(level2);
                        isShowLevel2 = false;
                        if(isShowLevel3)
                        {
                            //level3隐藏
                            tools.hideView(level3, 200);
                            isShowLevel3 = false;
                        }
                    }
                    else
                    {
                        //level2显示
                        tools.showView(level2);
                        isShowLevel2 = true;
                    }

                    break;
                case R.id.icon_menu:
                    if(isShowLevel3)
                    {
                        //隐藏
                        tools.hideView(level3);
                        isShowLevel3 = false;
                    }
                    else
                    {
                        //显示；
                        tools.showView(level3);
                        isShowLevel3 = true;
                    }
                    break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //隐藏一级菜单、二级菜单、三级菜单
        if(isShowLevel1)
        {
            tools.hideView(level1);
            isShowLevel1 = false;
            if (isShowLevel2)
            {
                tools.hideView(level2, 200);
                isShowLevel2 = false;
                if (isShowLevel3)
                {
                    tools.hideView(level3, 400);
                    isShowLevel3 = false;
                }
            }
        }
        //显示一级菜单、二级菜单
        else
        {
            tools.showView(level1);
            isShowLevel1 = true;
            tools.showView(level2, 200);
            isShowLevel2 = true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
