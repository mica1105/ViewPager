package com.mika.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class InmuebleFragment2 extends Fragment {
    private EditText domicilio, ambietes, tipo,uso,precio;
    private ImageView foto;
    private CheckBox disponible;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_inmueble2, container, false);
        inicializar(root);
        return root;
    }
    public void inicializar(View v){
        domicilio= v.findViewById(R.id.etdireccion);
        ambietes=v.findViewById(R.id.etambientes);
        tipo=v.findViewById(R.id.ettipo);
        uso=v.findViewById(R.id.etuso);
        precio=v.findViewById(R.id.etprecio);
        foto=v.findViewById(R.id.ivfoto);
        disponible=v.findViewById(R.id.cbdisponible);
        domicilio.setText("Mitre 1080");
        ambietes.setText("3");
        tipo.setText("casa");
        uso.setText("domestico");
        precio.setText("20000");
        foto.setImageResource(R.drawable.casa2);
        disponible.setChecked(true);
    }
}