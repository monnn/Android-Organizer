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
    static TextView seditTitle;
    static TextView seditDescription;
    static TextView seditPriority;
    static TextView seditDate;
    static TextView seditTime;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        seditTitle = (TextView) findViewById(R.id.seditTitle);
        seditDescription = (TextView) findViewById(R.id.seditDescription);
        seditPriority = (TextView) findViewById(R.id.seditPriority);
        seditDate = (TextView) findViewById(R.id.seditDate);
        seditTime = (TextView) findViewById(R.id.seditTime);
        modify = (Button) findViewById(R.id.modify);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //прави полетата editable, чете новите стойности и ги записва в базата
            }
        });
        markAsDone = (Button) findViewById(R.id.done);
        markAsDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //изтрива записа от таблицата
            }
        });
    }
}
