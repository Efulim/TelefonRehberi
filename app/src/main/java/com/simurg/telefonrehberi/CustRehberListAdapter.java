package com.simurg.telefonrehberi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by uyegen on 12.01.2017.
 */

public class CustRehberListAdapter extends BaseAdapter {
    private ArrayList<DBLine_rehber> allContacts;
    private static LayoutInflater layoutInflater = null;
    private Context context;
    private TelRehberi telRehberi;

    public CustRehberListAdapter(ArrayList<DBLine_rehber> allContacts, Context context, TelRehberi telRehberi) {
        this.allContacts = allContacts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.telRehberi = telRehberi;
    }

    @Override
    public int getCount() {
        return allContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder {
        TextView ad, soyad, telefon;
        long dbId;
        Button btnDelete;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final Holder h = new Holder();

        View rowView = layoutInflater.inflate(R.layout.list_item, null);

        h.ad = (TextView) rowView.findViewById(R.id.list_item_ad);
        h.soyad = (TextView) rowView.findViewById(R.id.list_item_soyad);
        h.telefon = (TextView) rowView.findViewById(R.id.list_item_telefon);
        h.btnDelete = (Button) rowView.findViewById(R.id.list_item_BtnDelete);

        h.dbId = allContacts.get(i).getDbId();
        h.ad.setText(allContacts.get(i).getAd());
        h.soyad.setText(allContacts.get(i).getSoyad());
        h.telefon.setText(allContacts.get(i).getTelefon());
        h.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int affectedRows = telRehberi.deleteContact((int) h.dbId);
                if (affectedRows > 0) {
                    int index = 0;
                    for (int i = 0; i < allContacts.size(); i ++) {
                        if (h.dbId == allContacts.get(i).getDbId()) {
                            index = i;
                            i = allContacts.size();
                        }
                    }
                    allContacts.remove(index);
                    refresh();
                    Toast.makeText(context, "Kayit Silindi!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Kayit Silinemedi!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rowView;
    }

    private void refresh() {
        this.notifyDataSetChanged();
    }
}
