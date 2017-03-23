package com.forjun.thirdpartydemos;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 发布事件
 */

public class PublishActivity extends AppCompatActivity {

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
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.event_main_posting, R.id.event_sub_posting, R.id.event_main_main, R.id.event_sub_main, R.id.event_main_background, R.id.event_sub_background, R.id.event_main_async, R.id.event_sub_async})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.event_main_posting:
                break;
            case R.id.event_sub_posting:
                break;
            case R.id.event_main_main:
                break;
            case R.id.event_sub_main:
                break;
            case R.id.event_main_background:
                break;
            case R.id.event_sub_background:
                break;
            case R.id.event_main_async:
                break;
            case R.id.event_sub_async:
                break;
        }
    }
}
