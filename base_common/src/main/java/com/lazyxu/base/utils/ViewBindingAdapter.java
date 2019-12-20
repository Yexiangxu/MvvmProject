package com.lazyxu.base.utils;

import androidx.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * User:Lazy_xu
 * Data:2019/10/21
 * Description:
 * FIXME
 */
public class ViewBindingAdapter {

    @BindingAdapter("dbSelected")
    public static void setSelected(View view, boolean selected) {
        view.setSelected(selected);
    }

    @BindingAdapter(value = {"dbImageUrl", "dbError"}, requireAll = false)
    public static void loadImage(ImageView view, String url, Drawable error) {
        Glide.with(view.getContext()).load(url).into(view);
    }

}
