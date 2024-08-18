package com.os.opendialogonsinglelistitem;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.animation.Animation;

public class Constant {

    public static void clickUIFeel(Object obj){
        ObjectAnimator animator = ObjectAnimator.ofInt(obj, "backgroundColor", Color.WHITE, Color.TRANSPARENT);

        // duration of one color
        animator.setDuration(500);
        animator.setEvaluator(new ArgbEvaluator());

        // color will be show in reverse manner
//            animator.setRepeatCount(Animation.REVERSE);

        // It will be repeated up to infinite time
        animator.setRepeatCount(Animation.ABSOLUTE);
        animator.start();

    }
}
