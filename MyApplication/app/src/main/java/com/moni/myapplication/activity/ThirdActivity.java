package com.moni.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moni.myapplication.MyApplication;
import com.moni.myapplication.R;
import com.moni.myapplication.database.DBAdapter;
import com.moni.myapplication.model.Task;
import com.moni.myapplication.util.Preconditions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by moni on 15-5-31.
 */
public class ThirdActivity extends AppCompatActivity {

    public static final String NEW_TASK_TITLE = "NEW_TASK_TITLE";

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
                if (!isTitleCorrect()) return;

                description = editDescription.getText().toString();

                if (!isPriorityCorrect()) return;

                if (date != null) {
                    try {
                        date = dateFormat.parse(editDate.getText().toString());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                if (!isTimeCorrect()) return;

                task = new Task(title, description, priority, date, time);

                //dba.addTask(task);
                sendNewlyCreatedTask();
            }
        });
    }

    private boolean isTimeCorrect() {
        final String timeStr = editTime.getText().toString();
        if (!Preconditions.isNullOrEmpty(timeStr)) {
            try {
                time = Integer.parseInt(timeStr);
            } catch (NumberFormatException e) {
                Toast.makeText(MyApplication.getContext(),
                        "Time field should contain only digits!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    private boolean isPriorityCorrect() {
        final String priorityStr = editPriority.getText().toString();
        if (!Preconditions.isNullOrEmpty(priorityStr)) {
            try {
                priority = Integer.parseInt(priorityStr);
            } catch (NumberFormatException e) {
                Toast.makeText(MyApplication.getContext(),
                        "Priority field has to be a number!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    private boolean isTitleCorrect() {
        title = editTitle.getText().toString();
        if (Preconditions.isNullOrEmpty(title)) {
            Toast.makeText(MyApplication.getContext(),
                    "Title field is mandatory!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void sendNewlyCreatedTask() {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        intent.putExtra(NEW_TASK_TITLE, title);
        startActivity(intent);
    }
}
