package com.mika.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class PropiedadesViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Fragment>> inmuebles;

    public PropiedadesViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<Fragment>> getInmuebles() {
        if (inmuebles==null){
            inmuebles=new MutableLiveData<>();
        }
        return inmuebles;
    }
    public void recuperarFragment(){
        ArrayList propiedades= new ArrayList();
        propiedades.add(new InmuebleFragment());
        propiedades.add(new InmuebleFragment());
        //propiedades.add(new InmuebleFragment2());
        inmuebles.setValue(propiedades);
    }
}
