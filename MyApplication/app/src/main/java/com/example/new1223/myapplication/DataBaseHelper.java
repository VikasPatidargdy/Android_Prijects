package com.example.new1223.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static android.app.SearchManager.QUERY;


public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "studentsDatabase";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "student_table";
    public static final String TABLE_NAME1 = "student_table_1";
    public static final String STUDENT_COLUMN_NAME = "student_name";
    public static final String STUDENT_COLUMN_ID = "student_id";
    public static final String STUDENT_COLUMN_BRANCH = "student_branch";

    String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            STUDENT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            STUDENT_COLUMN_NAME + " TEXT," +
            STUDENT_COLUMN_BRANCH + " TEXT);";
    String query1 = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + " (" +
            STUDENT_COLUMN_ID + " INTEGER PRIMARY KEY," +
            STUDENT_COLUMN_NAME + " TEXT," +
            STUDENT_COLUMN_BRANCH + " TEXT);";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query);
        sqLiteDatabase.execSQL(query1);
        Log.e("DATABASE_Created", "!!!!!!!!!!!!!!!!!!!!!!DATABASE_CREATED!!!!!!!!!!!!!!!!\n" + query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        //onCreate(db);
    }


    public boolean insertStudentDetail(int id, String name, String branch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(STUDENT_COLUMN_ID, id);
        contentValues.put(STUDENT_COLUMN_NAME, name);
        contentValues.put(STUDENT_COLUMN_BRANCH, branch);
        Log.e("Insert", db.insert(TABLE_NAME, null, contentValues) + "");
        db.close();
        return true;
    }

    boolean insertStudentDetail1(int id, String name, String branch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_COLUMN_ID, id);
        contentValues.put(STUDENT_COLUMN_NAME, name);
        contentValues.put(STUDENT_COLUMN_BRANCH, branch);
        Log.e("Insert", db.insert(TABLE_NAME1, null, contentValues) + "");
        db.close();
        return true;
    }


    public Cursor getData(Context c, int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("Select * From " + TABLE_NAME1 + " where " + STUDENT_COLUMN_ID + "=" + id + ";", null);
        if (res != null) {
            if (res.moveToFirst()) {
                String str = res.getString(res.getColumnIndex(STUDENT_COLUMN_BRANCH));
                String str1 = res.getString(res.getColumnIndex(STUDENT_COLUMN_NAME));
                Log.e("student details", str + ", " + str1);
            }
            res.close();
            Toast toast = Toast.makeText(c, "DATA will be SHOW", Toast.LENGTH_SHORT);
            Log.e("student details", "");
            toast.show();
        } else {
            Log.e("Res null", "");
        }
        return res;
    }


    public boolean updateStudentDetails(int id, String name, String branch) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_COLUMN_NAME, name);
        contentValues.put(STUDENT_COLUMN_BRANCH, branch);
        db.update(TABLE_NAME1, contentValues, STUDENT_COLUMN_ID + " = ? ", new String[]{Integer.toString(id)});
        return true;
    }

}
