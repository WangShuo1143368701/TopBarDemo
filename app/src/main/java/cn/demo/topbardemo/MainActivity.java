package cn.demo.topbardemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;



public class MainActivity extends Activity implements View.OnClickListener {

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StatusBarCompat.compat(this, Color.parseColor("#000000"));
        WidgetTopBar wtbOne = (WidgetTopBar) findViewById(R.id.wtb_one);
        wtbOne.getLeftBtnText().setOnClickListener(this);
        wtbOne.getRightBtnImage().setOnClickListener(this);

        WidgetTopBar wtbTwo = (WidgetTopBar) findViewById(R.id.wtb_two);
        wtbTwo.getLeftBtnImage().setOnClickListener(this);
        wtbTwo.getRightBtnText().setOnClickListener(this);

        WidgetTopBar wtbThree = (WidgetTopBar) findViewById(R.id.wtb_three);
        wtbThree.getLeftBtnImage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "第三个标题 左边按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /** * 动态的设置状态栏 实现沉浸式状态栏 * */
    public void compat2(Activity activity, int statusColor) {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            LinearLayout linear_bar = (LinearLayout) findViewById(R.id.ll_bar);
            linear_bar.setVisibility(View.VISIBLE);
            linear_bar.setBackgroundColor(statusColor);
            // 获取到状态栏的高度
            int statusHeight = StatusBarCompat.getStatusBarHeight(activity);
            // 动态的设置隐藏布局的高度
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linear_bar.getLayoutParams();
            params.height = statusHeight; linear_bar.setLayoutParams(params);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_left_top_bar: {
                Toast.makeText(mContext, "第二个标题 左边按钮", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.ib_right_top_bar: {
                Toast.makeText(mContext, "第一个标题 右边按钮", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_left_top_bar: {
                Toast.makeText(mContext, "第一个标题 左边按钮", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_right_top_bar: {
                Toast.makeText(mContext, "第二个标题 右边按钮", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
