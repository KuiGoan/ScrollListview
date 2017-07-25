package com.ifi.kuirin.scrolllistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {
    private final static String TAG = "MainActivity";

    private ObservableListView mListView;

    private TextView mView;

    final String arr[] = {"Teo", "Ty", "Bin", "Bo", "Teo", "Ty", "Bin", "Bo", "Teo", "Ty", "Bin", "Bo", "Teo", "Ty", "Bin", "Bo", "Teo", "Ty", "Bin", "Bo", "Teo", "Ty", "Bin", "Bo", "Teo", "Ty", "Bin", "Bo"};

    Animation slideDown, slideUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = (TextView) findViewById(R.id.view);
        mListView = (ObservableListView) findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, arr);
        //4. Đưa Data source vào ListView
        mListView.setAdapter(adapter);
        mListView.setScrollViewCallbacks(this);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if (mView == null) {
            return;
        }

        if (scrollState == ScrollState.UP) {
            if (mView.getVisibility() == View.VISIBLE) {
                mView.setVisibility(View.GONE);
            }
        } else if (scrollState == ScrollState.DOWN) {
            if (mView.getVisibility() != View.VISIBLE) {
                mView.setVisibility(View.VISIBLE);
            }
        }
    }
}
