package com.moni.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by moni on 15-5-31.
 */
public class ThirdActivity extends Activity {

    Button discard;
    EditText eText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        discard = (Button) findViewById(R.id.discard);
        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        eText = (EditText) findViewById(R.id.editText);
    }
}
