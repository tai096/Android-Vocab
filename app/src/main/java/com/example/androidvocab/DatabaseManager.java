package com.example.androidvocab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public DatabaseManager(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // Thêm một dòng mới vào cơ sở dữ liệu
    public void addData(String term, String ipa, String def) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_TERM, term);
        values.put(DBHelper.COLUMN_IPA, ipa);
        values.put(DBHelper.COLUMN_DEF, def);
        database.insert(DBHelper.TABLE_NAME, null, values);
    }

    // Lấy tất cả dữ liệu từ cơ sở dữ liệu
    public List<VocabModel> getAllData() {
        List<VocabModel> dataList = new ArrayList<>();
        Cursor cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_ID));
            String term = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_TERM));
            String ipa = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_IPA));
            String def = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_DEF));

            dataList.add(new VocabModel(id, term, ipa, def));
            cursor.moveToNext();
        }
        cursor.close();
        return dataList;
    }
}
