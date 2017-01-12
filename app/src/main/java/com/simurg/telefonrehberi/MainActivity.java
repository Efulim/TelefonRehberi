package com.simurg.telefonrehberi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    FrgWelcome frgWelcome;
    FrgInsert frgInsert;
    FrgList frgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.holder_of_frg) != null) {
            if (savedInstanceState != null) {
                return;
            }
            frgWelcome = new FrgWelcome();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.holder_of_frg, frgWelcome)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuYeniKayit:
                frgInsert = new FrgInsert();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.holder_of_frg, frgInsert)
                        .commit();
                return true;
            case R.id.menuListe:
                frgList = new FrgList();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.holder_of_frg, frgList)
                        .commit();
                return true;
            default:
                return false;
        }
    }
}
