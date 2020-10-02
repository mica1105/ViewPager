package com.mika.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

public class InmuebleViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    public InmuebleViewModel(@NonNull Application application) {
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
        inmuebles.setValue(propiedades);
    }
}
