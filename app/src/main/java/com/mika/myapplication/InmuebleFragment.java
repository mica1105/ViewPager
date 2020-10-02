package com.mika.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class InmuebleFragment extends Fragment {
    private EditText domicilio, ambietes, tipo,uso,precio;
    private ImageView foto;
    private CheckBox disponible;
    private InmuebleViewModel vm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_inmueble, container, false);
        inicializar(root);
        return root;
    }
    public void inicializar(View v){
        domicilio= v.findViewById(R.id.etDireccion);
        ambietes=v.findViewById(R.id.etAmbientes);
        tipo=v.findViewById(R.id.etTipo);
        uso=v.findViewById(R.id.etUso);
        precio=v.findViewById(R.id.etPrecio);
        foto=v.findViewById(R.id.ivFoto);
        disponible=v.findViewById(R.id.cbDisponible);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleViewModel.class);
        vm.getInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                domicilio.setText(inmueble.getDireccion());
                ambietes.setText(inmueble.getAmbientes()+"");
                tipo.setText(inmueble.getTipo());
                uso.setText(inmueble.getUso());
                precio.setText(inmueble.getPrecio()+"");
                foto.setImageResource(inmueble.getFoto());
                disponible.setChecked(inmueble.getDisponible());
            }
        });
        vm.cargarInmueble(getArguments());
    }
}