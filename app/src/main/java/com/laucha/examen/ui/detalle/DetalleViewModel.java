package com.laucha.examen.ui.detalle;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.laucha.examen.Lugar;

public class DetalleViewModel extends AndroidViewModel {

    private MutableLiveData<Lugar> mLugar;
    public DetalleViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Lugar> getLugar(){
        if(mLugar==null){
            mLugar=new MutableLiveData<>();
        }
        return mLugar;
    }

    public void detalles(Bundle bundle){
        Lugar l = (Lugar) bundle.getSerializable("lugar");
        mLugar.setValue(l);
    }

}