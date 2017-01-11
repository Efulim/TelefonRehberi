package com.simurg.telefonrehberi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    FrgInsert frgInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.holder_of_frg) != null) {
            if (savedInstanceState != null) {
                return;
            }

            frgInsert = new FrgInsert();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.holder_of_frg, frgInsert)
                    .commit();
        }

//        TelRehberi telRehberi = new TelRehberi(getApplicationContext());
//        telRehberi.insertKayit("AD", "SOYAD", "05315554433");
//
//        TextView tv = (TextView) findViewById(R.id.tv1);
//        tv.setText(String.valueOf(telRehberi.numberOfRows()));
//
//
//        ArrayList<String> allContacts = new ArrayList<String>();
//        allContacts = telRehberi.getAllCotacts();
    }
}
