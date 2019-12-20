package com.lazyxu.base.view.webview;

import android.content.Context;
import androidx.core.content.ContextCompat;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by jingbin on 2016/11/17.
 */

public class FullscreenHolder extends FrameLayout {

    public FullscreenHolder(Context ctx) {
        super(ctx);
        setBackgroundColor(ContextCompat.getColor(ctx,android.R.color.black));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
