package com.forjun.thirdpartydemos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.forjun.thirdpartydemos.Events.EventAsync;
import com.forjun.thirdpartydemos.Events.EventBackground;
import com.forjun.thirdpartydemos.Events.EventMain;
import com.forjun.thirdpartydemos.Events.EventPosting;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_switch_publish)
    Button mBtnSwitchPublish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    // ---------------- 线程模型,

    /**
     * POSTING线程模型：在哪个线程发布事件，就在哪个线程执行onPostingEvent方法
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEventPosting(EventPosting event) {

    }

    /**
     * Main线程模型：不管是哪个线程发布事件，都在主线程执行onMainEvent方法
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMain(EventMain event) {

    }

    /**
     * BACKGROUND线程模型：事件如果是在子线程发布，onBackgroundEvent方法就在该子线程执行，事件如果是在
     * 主线程中发布，onBackgroundEvent方法就在EventBus内部的线程池中执行
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventBackgound(EventBackground event) {

    }

    /**
     * ASYNC线程模型：不管事件在哪个线程发布，onAsyncEvent方法都在EventBus内部的线程池中执行
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventAsync(EventAsync event) {

    }


    @OnClick(R.id.btn_switch_publish)
    public void onClick() {

    }
}
