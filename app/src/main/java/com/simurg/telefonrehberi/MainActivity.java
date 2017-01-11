package com.simurg.telefonrehberi;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
