package com.simurg.telefonrehberi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by uyegen on 13.01.2017.
 */

public class FrgUpdate extends Fragment {
    private long dbId;
    public FrgUpdate() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_update, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            return;
        }

        final EditText ad, soyad, telefon;
        ad = (EditText) view.findViewById(R.id.et_frg_update_ad);
        soyad = (EditText) view.findViewById(R.id.et_frg_update_soyad);
        telefon = (EditText) view.findViewById(R.id.et_frg_update_telefon);

        Bundle b = getArguments();
        dbId = b.getLong("dbId");
        final TelRehberi telRehberi = new TelRehberi(getActivity().getApplicationContext());
        DBLine_rehber line_rehber = telRehberi.selectKayit(dbId);
        if (line_rehber.getDbId() > 0) {
            ad.setText(line_rehber.getAd());
            soyad.setText(line_rehber.getSoyad());
            telefon.setText(line_rehber.getTelefon());
        }

        Button guncelle;
        guncelle = (Button) view.findViewById(R.id.btn_frg_update_update);
        guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = telRehberi.updateKayit(dbId, ad.getText().toString(), soyad.getText().toString(), telefon.getText().toString());
                if (result > 0) {
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.holder_of_frg, new FrgList())
                            .commit();
                    Toast.makeText(getActivity().getApplicationContext(), "Güncelleme başarılı!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Güncelleme başarısız!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
