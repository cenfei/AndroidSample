package com.jackie.sample.progress_bar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.jackie.sample.R;
import com.jackie.sample.custom_view.CircleProgressBar;
import com.jackie.sample.custom_view.HorizontalBoldProgressBar;
import com.jackie.sample.custom_view.HorizontalProgressBar;
import com.jackie.sample.custom_view.ObliqueProgressBar;

public class ProgressBarActivity extends AppCompatActivity {
    private HorizontalProgressBar mHorizontalProgressBar;
    private CircleProgressBar mCircleProgressBar;

    private HorizontalBoldProgressBar mHorizontalBoldProgressBar;
    private ObliqueProgressBar mObliqueProgressBar;

    private static final int MSG_UPDATE_PROGRESS = 0x110;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int progress = mHorizontalProgressBar.getProgress();
            mHorizontalProgressBar.setProgress(++progress);
            mCircleProgressBar.setProgress(++progress);

            if (progress >= 100) {
                mHandler.removeMessages(MSG_UPDATE_PROGRESS);
            }

            mHandler.sendEmptyMessageDelayed(MSG_UPDATE_PROGRESS, 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        mHorizontalProgressBar = (HorizontalProgressBar) findViewById(R.id.horizontal_progressbar);
        mCircleProgressBar = (CircleProgressBar) findViewById(R.id.circle_progressbar);

        mHandler.sendEmptyMessage(MSG_UPDATE_PROGRESS);

        mHorizontalBoldProgressBar = (HorizontalBoldProgressBar) findViewById(R.id.horizontal_bold_progressbar);
        mHorizontalBoldProgressBar.setProgress(100, 100);

        mObliqueProgressBar = (ObliqueProgressBar) findViewById(R.id.oblique_progress_bar);
        mObliqueProgressBar.setProgress(80);
    }
}
