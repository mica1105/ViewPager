package com.mika.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class PropiedadesViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    public PropiedadesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles==null){
            inmuebles= new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmuebles(){
        ArrayList<Inmueble> propiedades= new ArrayList<>();
        propiedades.add(new Inmueble(R.drawable.casa1,"España 489",4,"casa","domestico",25000,true));
        propiedades.add(new Inmueble(R.drawable.casa2,"Mitre 1080",3,"casa","domestico",20000,true));
        propiedades.add(new Inmueble(R.drawable.dpto1,"Av Illia 379",3,"departamento","domestico",18000,true));
        propiedades.add(new Inmueble(R.drawable.local1,"Junin",2,"Local","comercial",25000,true));
        inmuebles.setValue(propiedades);
    }
}
