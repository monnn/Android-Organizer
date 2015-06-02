package com.moni.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by moni on 15-5-31.
 */
public class ThirdActivity extends Activity {

    Button discard;
    Button save;
    EditText editTitle;
    EditText editDescription;
    EditText editPriority;
    EditText editDate;
    EditText editTime;
    String title;
    String description;
    int priority;
    Date date;
    int time;
    DBAdapter dba;
    Task task;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
    MainActivity activity = new MainActivity();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        editTitle = (EditText) findViewById(R.id.editTitle);
        editDescription = (EditText) findViewById(R.id.editDescription);
        editPriority = (EditText) findViewById(R.id.editPriority);
        editDate = (EditText) findViewById(R.id.editDate);
        editTime = (EditText) findViewById(R.id.editTime);

        title = editTitle.getText().toString();
        description = editDescription.getText().toString();
        priority = Integer.parseInt(editPriority.getText().toString());
        try {
            date = dateFormat.parse(editDate.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        time = Integer.parseInt(editTime.getText().toString());
        task = new Task(title, description, priority, date, time);

        discard = (Button) findViewById(R.id.discard);
        discard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dba.addTask(task);
                activity.createNewTextView(title);
            }
        });
    }
}
