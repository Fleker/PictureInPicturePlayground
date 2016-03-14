package com.hitherejoe.androidtvboilerplate.ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.hitherejoe.androidtvboilerplate.AndroidTvBoilerplateApplication;
import com.hitherejoe.androidtvboilerplate.injection.component.ActivityComponent;
import com.hitherejoe.androidtvboilerplate.injection.component.DaggerActivityComponent;
import com.hitherejoe.androidtvboilerplate.injection.module.ActivityModule;

public class BaseActivity extends Activity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(AndroidTvBoilerplateApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

}