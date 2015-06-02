package com.moni.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    Button addNew;
    TextView task;
    TextView seditTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addNew = (Button) findViewById(R.id.add_new);
        task = (TextView) findViewById(R.id.feed_the_dog);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTaskInfo(task.getText().toString());
            }
        });

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent3);
            }
        });
    }

        TextView createNewTextView(String title) {
            LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
            final TextView textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setText(title);
            layout.addView(textView);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTaskInfo(textView.getText().toString());
                }
            });
            return textView;
        }

        void getTaskInfo(String title) {
            seditTitle = (TextView) findViewById(R.id.seditTitle);
            seditTitle.setText(title);
            Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent2);
        }
}
