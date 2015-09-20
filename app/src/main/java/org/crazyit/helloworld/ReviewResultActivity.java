package org.crazyit.helloworld;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 松林 on 2015/9/17.
 */
public class ReviewResultActivity extends Activity {

    SharedPreferences preferences;

    private ImageView top_back;
    private TextView list1;
    private TextView list2;
    private TextView list3;
    private Button save_btn;

    private String[] listString = new String[12];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initView();
    }

    public void initView() {
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        preferences = getSharedPreferences("helloworld", MODE_PRIVATE);

        top_back = (ImageView) findViewById(R.id.top_back_iv);
        list1 = (TextView) findViewById(R.id.list1);
        list2 = (TextView) findViewById(R.id.list2);
        list3 = (TextView) findViewById(R.id.list3);
        save_btn = (Button) findViewById(R.id.save);
        save_btn.setVisibility(View.INVISIBLE);

        top_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        for (int i = 0; i < 12; i++) {
            listString[i] = preferences.getString("list" + Integer.toString(i) , "");
        }

        list1.setText(listString[1] + "  " + listString[2] + "  " + listString[3] + "  " + listString[0]);
        list2.setText(listString[4] + "  " + listString[5] + "  " + listString[6] + "  " + listString[10]);
        list3.setText(listString[7] + "  " + listString[8] + "  " + listString[9] + "  " + listString[11]);
    }
}
