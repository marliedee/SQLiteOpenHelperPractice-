package org.pursuit.sqlitehelper.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class CatDataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "cat.db";
    private static final String TABLE_NAME = "cats";
    private static final int SCHEMA_VERSION = 1;

    public CatDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "legs Integer, color TEXT, tail Integer);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     //Not in use.
    }

    public void addCat(Cat cat) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE legs = '" + cat.getLegs() +
                        "' AND color = '" + cat.getColor() + "' AND tail = '" + cat.isTail() +
                        "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(legs, color, tail) VALUES('" +
                    cat.getLegs() + "', '" +
                    cat.getColor() + "', '" +
                    cat.isTail() + "');");
        }
        cursor.close();
    }
    public List<Cat> getCatList() {
        List<Cat> catList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if(cursor != null) {
            if(cursor.moveToFirst()) {
                do {
                    Cat cat = new Cat(
                            cursor.getInt(cursor.getColumnIndex("legs")),
                            cursor.getString(cursor.getColumnIndex("color")),
                            cursor.getInt(cursor.getColumnIndex("tail")));
                    catList.add(cat);
                } while (cursor.moveToNext());
            }
        }
        return catList;
    }
}
