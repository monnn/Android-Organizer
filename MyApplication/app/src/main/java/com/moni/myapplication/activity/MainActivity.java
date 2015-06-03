package com.moni.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.moni.myapplication.R;
import com.moni.myapplication.util.Preconditions;


public class MainActivity extends AppCompatActivity {

    private Button addNew;
    private TextView task;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.linear);

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

        generateTextViewDynamically();
    }

    private void generateTextViewDynamically() {
        //layout = (LinearLayout) findViewById(R.id.linear);
        String newTaskTitle = getIntent().getStringExtra(ThirdActivity.NEW_TASK_TITLE);
        if (!Preconditions.isNullOrEmpty(newTaskTitle)) {
            layout.setOrientation(LinearLayout.VERTICAL);
            final TextView tv = new TextView(this);
            //tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            tv.setText(newTaskTitle);
            tv.setTextAppearance(this, android.R.style.TextAppearance_DeviceDefault_Medium);
            layout.addView(tv);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getTaskInfo(tv.getText().toString());
                }
            });
        }
    }

    void getTaskInfo(String title) {
           // SecondActivity.seditTitle.setText(title);
        // TODO select task from database by searching the title and send info to SecondActivity
            Intent intent2 = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent2);
        }
}
