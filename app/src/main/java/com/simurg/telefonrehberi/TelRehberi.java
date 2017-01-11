package com.simurg.telefonrehberi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by utkuyegen on 10/01/2017.
 */

public class TelRehberi extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TelRehberi.db";
    private static final String DATABASE_TABLE_NAME = "rehber";
    private static final String AD = "ad";
    private static final String SOYAD = "soyad";
    private static final String TELEFON = "telefon";

    public TelRehberi(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + DATABASE_TABLE_NAME
                + "(id integer primary key, "
                + AD + " text, "
                + SOYAD + " text, "
                + TELEFON + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }

    public boolean insertKayit(String ad, String soyad, String telefon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AD, ad);
        cv.put(SOYAD, soyad);
        cv.put(TELEFON, telefon);
        db.insert(DATABASE_TABLE_NAME, null, cv);
        return true;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DATABASE_TABLE_NAME);
        return numRows;
    }

    public ArrayList<DBLine_rehber> getAllContacts() {
        ArrayList<DBLine_rehber> array_list = new ArrayList<DBLine_rehber>();
        DBLine_rehber line_rehber;

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + DATABASE_TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            line_rehber = new DBLine_rehber();

            line_rehber.setAd(res.getString(res.getColumnIndex(AD)));
            line_rehber.setSoyad(res.getString(res.getColumnIndex(SOYAD)));
            line_rehber.setTelefon(res.getString(res.getColumnIndex(TELEFON)));

            array_list.add(line_rehber);
            res.moveToNext();
        }
        return array_list;
    }
}
