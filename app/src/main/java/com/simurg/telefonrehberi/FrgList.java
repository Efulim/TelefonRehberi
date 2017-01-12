package com.simurg.telefonrehberi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by uyegen on 12.01.2017.
 */

public class FrgList extends Fragment {
    TelRehberi telRehberi;
    ListView listView;

    public FrgList() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_list, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (savedInstanceState != null)
            return;

        telRehberi = new TelRehberi(getActivity().getApplicationContext());

        ArrayList<DBLine_rehber> allContacts = telRehberi.getAllContacts();
        if (allContacts != null) {
            if (listView == null)
                listView = (ListView) getActivity().findViewById(R.id.frgListView);
            listView.setAdapter(new CustRehberListAdapter(allContacts, getContext()));
        }
    }
}
