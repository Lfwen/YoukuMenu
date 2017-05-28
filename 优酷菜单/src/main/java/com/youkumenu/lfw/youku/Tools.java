package com.youkumenu.lfw.youku;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;

/**
 * Created by LiFei on 2017/5/27.
 */

public class Tools {
    public void hideView(ViewGroup view)
    {
        hideView(view, 0);
    }

    public void hideView(ViewGroup view, int startOffset)
    {
        /*
        for (int i = 0; i < view.getChildCount(); i++)
        {
            View v = view.getChildAt(i);
            v.setEnabled(false);
        }
        //旋转中心相对于自己
        RotateAnimation rotate = new RotateAnimation(0, 180, view.getWidth()/2, view.getHeight());
        //设置动画播放持续的时间
        rotate.setDuration(500);
        //动画停留在播放完成的状态
        rotate.setFillAfter(true);
        //延迟多久后开始动画
        rotate.setStartOffset(startOffset);
        view.startAnimation(rotate);
        */
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0, 180);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();
        view.setPivotX(view.getWidth()/2);
        view.setPivotY(view.getHeight());
    }

    public void showView(ViewGroup view)
    {
       showView(view, 0);
    }

    public void showView(ViewGroup view, int startOffSet)
    {
        /*for (int i = 0; i < view.getChildCount(); i++)
        {
            View v = view.getChildAt(i);
            v.setEnabled(true);
        }
        RotateAnimation rotate = new RotateAnimation(180, 360, view.getWidth()/2, view.getHeight());
        rotate.setDuration(500);
        rotate.setFillAfter(true);
        rotate.setStartOffset(startOffSet);
        view.startAnimation(rotate);
        */
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 180, 360);
        animator.setDuration(500);
        animator.setStartDelay(startOffSet);
        animator.start();
        view.setPivotX(view.getWidth()/2);
        view.setPivotY(view.getHeight());
    }
}
