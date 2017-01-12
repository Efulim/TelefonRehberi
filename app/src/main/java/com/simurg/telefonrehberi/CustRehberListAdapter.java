package com.simurg.telefonrehberi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by uyegen on 12.01.2017.
 */

public class CustRehberListAdapter extends BaseAdapter {
    ArrayList<DBLine_rehber> allContacts;
    private static LayoutInflater layoutInflater = null;
    Context context;

    public CustRehberListAdapter(ArrayList<DBLine_rehber> allContacts, Context context) {
        this.allContacts = allContacts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class Holder {
        TextView ad, soyad, telefon;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Holder h = new Holder();

        View rowView = layoutInflater.inflate(R.layout.list_item, null);

        h.ad = (TextView) rowView.findViewById(R.id.list_item_ad);
        h.soyad = (TextView) rowView.findViewById(R.id.list_item_soyad);
        h.telefon = (TextView) rowView.findViewById(R.id.list_item_telefon);

        h.ad.setText(allContacts.get(i).getAd());
        h.soyad.setText(allContacts.get(i).getSoyad());
        h.telefon.setText(allContacts.get(i).getTelefon());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked" + allContacts.get(i).getAd(), Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }
}
