package com.forjun.thirdpartydemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.forjun.thirdpartydemos.Events.Event;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // ---------------- 线程模型,

    /**
     * POSTING线程模型：在哪个线程发布事件，就在哪个线程执行onPostingEvent方法
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEventPosting(Event event){

    }

    /**
     * Main线程模型：不管是哪个线程发布事件，都在主线程执行onMainEvent方法
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void  onEventMain(Event event){

    }

    /**
     * BACKGROUND线程模型：事件如果是在子线程发布，onBackgroundEvent方法就在该子线程执行，事件如果是在
     * 主线程中发布，onBackgroundEvent方法就在EventBus内部的线程池中执行
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventBackgound(Event event){

    }

    /**
     * ASYNC线程模型：不管事件在哪个线程发布，onAsyncEvent方法都在EventBus内部的线程池中执行
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventAsync(Event event){

    }



}
