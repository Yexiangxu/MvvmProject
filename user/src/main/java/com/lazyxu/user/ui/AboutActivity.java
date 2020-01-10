package com.lazyxu.user.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lazyxu.base.router.RouterUrl;
import com.lazyxu.user.R;

/**
 * User:Lazy_xu
 * Data:2019/12/26
 * Description:
 * FIXME
 */
@Route(path = RouterUrl.User.ABOUTUS)
public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

}
