package org.crazyit.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by 松林 on 2015/9/16.
 */
public class HomeActivity extends Activity {

    private TextView start;
    private TextView review;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        initView();
    }

    public void initView() {
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        start = (TextView) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });

        review = (TextView) findViewById(R.id.review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentReview = new Intent(HomeActivity.this,ReviewResultActivity.class);
                startActivity(intentReview);
            }
        });
    }
}
