package cn.demo.topbardemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by WangShuo on 2017/8/24.
 *
 */
public class WidgetTopBar extends RelativeLayout {

    private ImageButton ibLeft;
    private ImageButton ibRight;
    private TextView btnLeft;
    private TextView btnRight;
    private TextView tvTitle;
    private String title;
    private String leftText;
    private String rightText;
    private Drawable leftDrawable;
    private Drawable rightDrawable;

    public WidgetTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化属性
        initAttrs(context, attrs);
        //填充视图
        View.inflate(context, R.layout.widget_top_bar, this);
        btnLeft = (TextView) findViewById(R.id.btn_left_top_bar);
        ibLeft = (ImageButton) findViewById(R.id.ib_left_top_bar);
        tvTitle = (TextView) findViewById(R.id.tv_title_top_bar);
        btnRight = (TextView) findViewById(R.id.btn_right_top_bar);
        ibRight = (ImageButton) findViewById(R.id.ib_right_top_bar);

        //如果属性有值的话，那我们就需要给控件初始化数据了
        initData();
    }

    //初始化属性
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WidgetTopBar);
        //标题
        title = typedArray.getString(R.styleable.WidgetTopBar_m_title);
        //左边按钮的文字
        leftText = typedArray.getString(R.styleable.WidgetTopBar_m_left_text);
        //左边按钮的图片
        rightText = typedArray.getString(R.styleable.WidgetTopBar_m_right_text);
        //右边按钮的文字
        leftDrawable = typedArray.getDrawable(R.styleable.WidgetTopBar_m_left_image);
        //右边按钮的图片
        rightDrawable = typedArray.getDrawable(R.styleable.WidgetTopBar_m_right_image);

        typedArray.recycle();
    }

    private void initData() {
        if (title != null) {
            tvTitle.setText(title);
        }
        if (leftText != null) {
            btnLeft.setVisibility(VISIBLE);
            btnLeft.setText(leftText);
        }
        if (rightText != null) {
            btnRight.setVisibility(VISIBLE);
            btnRight.setText(rightText);
        }
        if (leftDrawable != null) {
            ibLeft.setVisibility(VISIBLE);
            ibLeft.setBackground(leftDrawable);
        }
        if (rightDrawable != null) {
            ibRight.setVisibility(VISIBLE);
            ibRight.setBackground(rightDrawable);
        }
    }

    //设置背景色
    public void setBackgroundColor(int color ) {
        setBackgroundColor(color);
    }

    //获取左边文字按钮
    public TextView getLeftBtnText() {
        return btnLeft;
    }

    //获取右边文字按钮
    public TextView getRightBtnText() {
        return btnRight;
    }

    //获取左边图片按钮
    public ImageButton getLeftBtnImage() {
        return ibLeft;
    }

    //获取右边图片按钮
    public ImageButton getRightBtnImage() {
        return ibRight;
    }
}
