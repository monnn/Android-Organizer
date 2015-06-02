package com.moni.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by moni on 15-5-31.
 */
public class SecondActivity extends Activity {

    Button modify;
    Button markAsDone;
    TextView seditTitle;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        modify = (Button) findViewById(R.id.modify);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seditTitle = (TextView) findViewById(R.id.seditTitle);
                //прави полето editable, чете новите стойности и ги записва в базата
            }
        });
        markAsDone = (Button) findViewById(R.id.done);
        markAsDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //изтрива записът от таблицата
            }
        });
    }
}
