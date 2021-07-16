package com.ewer.mariokartcharacterrandomizer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BuildsDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Builds.db";

    public BuildsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_SAVED_TABLE =
                "CREATE TABLE " + BuildsDBContract.SavedEntry.TABLE_NAME + " (" +
                        BuildsDBContract.SavedEntry._ID + " INTEGER PRIMARY KEY, " +
                        BuildsDBContract.SavedEntry.COLUMN_BUILD_NAME + " TEXT NOT NULL, " +
                        BuildsDBContract.SavedEntry.COLUMN_BUILD_CHARACTER + " TEXT NOT NULL, " +
                        BuildsDBContract.SavedEntry.COLUMN_BUILD_FRAME + " TEXT NOT NULL, " +
                        BuildsDBContract.SavedEntry.COLUMN_BUILD_TIRES + " TEXT NOT NULL, " +
                        BuildsDBContract.SavedEntry.COLUMN_BUILD_GLIDER + " TEXT NOT NULL)";

        final String SQL_CREATE_HISTORY_TABLE =
                        "CREATE TABLE " + BuildsDBContract.HistoryEntry.TABLE_NAME + " (" +
                        BuildsDBContract.HistoryEntry._ID + " INTEGER PRIMARY KEY, " +
                        BuildsDBContract.HistoryEntry.COLUMN_BUILD_INDEX + "INTEGER NOT NULL, " +
                        BuildsDBContract.HistoryEntry.COLUMN_BUILD_CHARACTER + " TEXT NOT NULL, " +
                        BuildsDBContract.HistoryEntry.COLUMN_BUILD_FRAME + " TEXT NOT NULL, " +
                        BuildsDBContract.HistoryEntry.COLUMN_BUILD_TIRES + " TEXT NOT NULL, " +
                        BuildsDBContract.HistoryEntry.COLUMN_BUILD_GLIDER + " TEXT NOT NULL)";

        db.execSQL(SQL_CREATE_SAVED_TABLE);
        db.execSQL(SQL_CREATE_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
