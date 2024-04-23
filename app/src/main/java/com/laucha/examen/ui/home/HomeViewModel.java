package com.laucha.examen.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.laucha.examen.Lugar;
import com.laucha.examen.R;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Lugar>> mLista;

    public HomeViewModel() {

    }

    public LiveData<List<Lugar>> getLista() {
        if(mLista==null){
            mLista=new MutableLiveData<>();
        }
        return mLista;
    }

    public void lugares(){
        mLista.setValue(Lugar.lista());
    }
}