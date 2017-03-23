package com.forjun.thirdpartydemos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.forjun.thirdpartydemos.Events.EventAsync;
import com.forjun.thirdpartydemos.Events.EventBackground;
import com.forjun.thirdpartydemos.Events.EventMain;
import com.forjun.thirdpartydemos.Events.EventPosting;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubscriberActivity extends AppCompatActivity {
    private static final String TAG = "SubscriberActivity";

    @BindView(R.id.btn_switch_publish)
    Button mBtnSwitchPublish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscriber);
        ButterKnife.bind(this);
        //注册事件总线
        EventBus.getDefault().register(this);
    }
    // ################### 线程模型

    /**
     * POSTING线程模型：在哪个线程发布事件，就在哪个线程执行onPostingEvent方法
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEventPosting(EventPosting event) {
        Log.d(TAG, "onEventPosting: " +event.getMsg());
        Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
    }

    /**
     * Main线程模型：不管是哪个线程发布事件，都在主线程执行onMainEvent方法
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMain(EventMain event) {
        Log.d(TAG, "onEventPosting: " +event.getMsg());
        Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
    }

    /**
     * BACKGROUND线程模型：事件如果是在子线程发布，onBackgroundEvent方法就在该子线程执行，事件如果是在
     * 主线程中发布，onBackgroundEvent方法就在EventBus内部的线程池中执行
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventBackgound(EventBackground event) {
        Log.d(TAG, "onEventPosting: " +event.getMsg());
        Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
    }

    /**
     * ASYNC线程模型：不管事件在哪个线程发布，onAsyncEvent方法都在EventBus内部的线程池中执行
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventAsync(EventAsync event) {
        Log.d(TAG, "onEventPosting: " +event.getMsg());
        Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
    }

    // !~################### 线程模型

    @OnClick(R.id.btn_switch_publish)
    public void onClick() {
        Intent intent = new Intent(this,PublishActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册事件总线
        EventBus.getDefault().unregister(this);
    }
}
