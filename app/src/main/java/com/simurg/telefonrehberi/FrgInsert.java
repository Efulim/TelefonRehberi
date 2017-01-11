package com.simurg.telefonrehberi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by utkuyegen on 10/01/2017.
 */

public class FrgInsert extends Fragment {
    EditText etAd, etSoyad, etTelefon;
    Button btnInsert;
    TelRehberi telRehberi;

    public FrgInsert() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_insert, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            return;
        } else {
            telRehberi = new TelRehberi(getContext());

            etAd = (EditText) getActivity().findViewById(R.id.et_frg_insert_ad);
            etSoyad = (EditText) getActivity().findViewById(R.id.et_frg_insert_soyad);
            etTelefon = (EditText) getActivity().findViewById(R.id.et_frg_insert_telefon);
            btnInsert = (Button) getActivity().findViewById(R.id.btn_frg_insert_insert);
            btnInsert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    telRehberi.insertKayit(etAd.getText().toString(),
                            etSoyad.getText().toString(),
                            etTelefon.getText().toString());
                }
            });
        }
    }
}
