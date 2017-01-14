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
    private static final String ID = "id";
    private static final String AD = "ad";
    private static final String SOYAD = "soyad";
    private static final String TELEFON = "telefon";

    public TelRehberi(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + DATABASE_TABLE_NAME
                + "(" + ID + " integer primary key, "
                + AD + " text, "
                + SOYAD + " text, "
                + TELEFON + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }

    public long insertKayit(String ad, String soyad, String telefon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(AD, ad);
        cv.put(SOYAD, soyad);
        cv.put(TELEFON, telefon);

        return db.insert(DATABASE_TABLE_NAME, null, cv);
    }

    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(DATABASE_TABLE_NAME, ID + " = ? ", new String[] { Integer.toString(id) });
    }

    public ArrayList<DBLine_rehber> getAllContacts() {
        ArrayList<DBLine_rehber> array_list = new ArrayList<DBLine_rehber>();
        DBLine_rehber line_rehber;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + DATABASE_TABLE_NAME, null );
        res.moveToFirst();
        while(!res.isAfterLast()){
            line_rehber = new DBLine_rehber();

            line_rehber.setDbId(res.getLong(res.getColumnIndex(ID)));
            line_rehber.setAd(res.getString(res.getColumnIndex(AD)));
            line_rehber.setSoyad(res.getString(res.getColumnIndex(SOYAD)));
            line_rehber.setTelefon(res.getString(res.getColumnIndex(TELEFON)));

            array_list.add(line_rehber);
            res.moveToNext();
        }
        res.close();
        return array_list;
    }

    public DBLine_rehber selectKayit(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        DBLine_rehber line_rehber = new DBLine_rehber();
        Cursor res = db.rawQuery("select * from " + DATABASE_TABLE_NAME + " where id = ?", new String[] {Long.toString(id)});
        res.moveToFirst();
        while (!res.isAfterLast()) {
            line_rehber.setDbId(res.getLong(res.getColumnIndex(ID)));
            line_rehber.setAd(res.getString(res.getColumnIndex(AD)));
            line_rehber.setSoyad(res.getString(res.getColumnIndex(SOYAD)));
            line_rehber.setTelefon(res.getString(res.getColumnIndex(TELEFON)));

            res.moveToNext();
        }
        return line_rehber;
    }

    public int updateKayit(long id, String ad, String soyad, String telefon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID, id);
        cv.put(AD, ad);
        cv.put(SOYAD, soyad);
        cv.put(TELEFON, telefon);
        return db.update(DATABASE_TABLE_NAME, cv, "id = ?", new String[] {Long.toString(id)});
    }
}
