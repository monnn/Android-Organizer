package com.moni.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by moni on 15-6-2.
 */
public class DBAdapter extends AbstractDBAdapter {

    private static final String DB_NAME = "TasksDB";
    private static final String CREATE_SCRIPT = "create.sql";
    private static final String UPDATE_SCRIPT = "update.sql";
    private static final int DB_VERSION = 1;

    public static final String TABLE_TASKS = "tasks";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_PRIORITY = "priority";
    public static final String COLUMN_NAME_DATE = "date";
    public static final String COLUMN_NAME_TIME = "time";

    private final Context context;
    private DBHelper dbHelper;

    public DBAdapter(Context context) {
        super(context);
        this.context = context;
        this.dbHelper = DBHelper.newInstance(context, DB_NAME, DB_VERSION)
                .withCreateScript(CREATE_SCRIPT)
                .withUpdateScript(UPDATE_SCRIPT);
    }

    public SQLiteDatabase openToRead() throws android.database.SQLException {
        return super.openToRead(DB_NAME);
    }

    public SQLiteDatabase openToWrite() throws android.database.SQLException {
        return super.openToWrite(DB_NAME);
    }

    public void addTask(Task task){
        SQLiteDatabase database = openToWrite();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_TITLE, task.getTitle());
        values.put(COLUMN_NAME_DESCRIPTION, task.getDescription());
        values.put(COLUMN_NAME_PRIORITY, task.getPriority());
        values.put(COLUMN_NAME_DATE, String.valueOf(task.getDate()));
        values.put(COLUMN_NAME_TIME, task.getTime());
        database.insert(TABLE_TASKS, null, values);
        database.close();
    }
}
