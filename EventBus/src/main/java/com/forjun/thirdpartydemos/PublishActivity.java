package com.forjun.thirdpartydemos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import com.forjun.thirdpartydemos.Events.Event;
import com.forjun.thirdpartydemos.Events.EventAsync;
import com.forjun.thirdpartydemos.Events.EventBackground;
import com.forjun.thirdpartydemos.Events.EventMain;
import com.forjun.thirdpartydemos.Events.EventPosting;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 发布事件
 */

public class PublishActivity extends AppCompatActivity {
    private static final String TAG = "PublishActivity";

    @BindView(R.id.event_main_posting)
    Button mEventMainPosting;
    @BindView(R.id.event_sub_posting)
    Button mEventSubPosting;
    @BindView(R.id.event_main_main)
    Button mEventMainMain;
    @BindView(R.id.event_sub_main)
    Button mEventSubMain;
    @BindView(R.id.event_main_background)
    Button mEventMainBackground;
    @BindView(R.id.event_sub_background)
    Button mEventSubBackground;
    @BindView(R.id.event_main_async)
    Button mEventMainAsync;
    @BindView(R.id.event_sub_async)
    Button mEventSubAsync;
    @BindView(R.id.msg_main_posting)
    Button mMsgMainPosting;
    @BindView(R.id.msg_sub_posting)
    Button mMsgSubPosting;
    @BindView(R.id.activity_main)
    ScrollView mActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.event_main_posting, R.id.event_sub_posting, R.id.event_main_main, R.id.event_sub_main, R.id.event_main_background, R.id.event_sub_background, R.id.event_main_async, R.id.event_sub_async})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.event_main_posting:
                // 发布：主线程->订阅：Posting线程线程模型
                Event event_main_posting = new EventPosting("发布：主线程->订阅：Posting线程线程模型");
                EventBus.getDefault().post(event_main_posting);
                Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
                break;
            case R.id.event_sub_posting:
                // 发布：子线程->订阅：Posting线程线程模型
                runOnSubThread(new Runnable() {
                    @Override
                    public void run() {
                        Event event = new EventPosting("发布：子线程->订阅：Posting线程线程模型");
                        EventBus.getDefault().post(event);
                        Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
                    }
                });
                break;
            case R.id.event_main_main:
                // 发布：主线程->订阅：Main线程线程模型
                Event event_main_main = new EventMain("发布：主线程->订阅：Main线程线程模型");
                EventBus.getDefault().post(event_main_main);
                Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
                break;
            case R.id.event_sub_main:
                // 发布：子线程->订阅：Main线程线程模型
                runOnSubThread(new Runnable() {
                    @Override
                    public void run() {
                        Event event = new EventMain("发布：子线程->订阅：Main线程线程模型");
                        EventBus.getDefault().post(event);
                        Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
                    }
                });
                break;
            case R.id.event_main_background:
                // 发布：主线程->订阅：Background线程线程模型
                Event event_main_background = new EventBackground("发布：主线程->订阅：Background线程线程模型");
                EventBus.getDefault().post(event_main_background);
                Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());

                break;
            case R.id.event_sub_background:
                // 发布：子线程->订阅：Background线程线程模型
                runOnSubThread(new Runnable() {
                    @Override
                    public void run() {
                        Event event = new EventBackground("发布：子线程->订阅：Background线程线程模型");
                        EventBus.getDefault().post(event);
                        Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
                    }
                });
                break;
            case R.id.event_main_async:
                // 发布：主线程->订阅：async线程线程模型
                Event event_main_async = new EventAsync("发布：主线程->订阅：async线程线程模型");
                EventBus.getDefault().post(event_main_async);
                Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());

                break;
            case R.id.event_sub_async:
                // 发布：子线程->订阅：async线程线程模型
                runOnSubThread(new Runnable() {
                    @Override
                    public void run() {
                        Event event = new EventAsync("发布：子线程->订阅：async线程线程模型");
                        EventBus.getDefault().post(event);
                        Log.d(TAG, "run: currentThread().getName() =" + Thread.currentThread().getName() + "#currentThread().getThreadGroup() = " + Thread.currentThread().getThreadGroup());
                    }
                });
                break;
        }
    }

    public void runOnSubThread(Runnable runnable) {
        //这里能使用代理模式就好了 代理一下runnable 发送一下run的时候的线程
        new Thread(runnable).start();
    }

}
