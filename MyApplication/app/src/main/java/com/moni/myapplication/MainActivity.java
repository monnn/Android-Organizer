package com.moni.myapplication;

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
    TextView view;
    int count;
    TextView task;

    private LinearLayout mLayout;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addNew = (Button) findViewById(R.id.add_new);
        //view = (TextView) findViewById(R.id.textView);
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mEditText = (EditText) findViewById(R.id.editText);
        task = (TextView) findViewById(R.id.feed_the_dog);
        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

//        addNew.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count++;
//            }
//        });

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent2);
            }
        });
//        addNew.setOnClickListener(onClick());
//        TextView textView = new TextView(this);
//        textView.setText("New text");
//    }
//
//    private View.OnClickListener onClick() {
//        return new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                mLayout.addView(createNewTextView(mEditText.getText().toString()));
//            }
//        };
//    }
//
//    private TextView createNewTextView(String text) {
//        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        final TextView textView = new TextView(this);
//        textView.setLayoutParams(lparams);
//        textView.setText("New text: " + text);
//        return textView;
    }
}
