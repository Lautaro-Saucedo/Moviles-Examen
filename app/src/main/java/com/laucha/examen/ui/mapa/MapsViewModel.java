package com.laucha.examen.ui.mapa;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MapsViewModel extends AndroidViewModel {
    private MutableLiveData<Location> mLocation;
    private FusedLocationProviderClient fused;
    private LocationCallback callback;
    public MapsViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());
    }

    public LiveData<Location> getLocation(){
        if(mLocation==null){
            mLocation=new MutableLiveData<>();
        }
        return mLocation;
    }

    public void ubicacionActual(){
        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationRequest lr = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,10000).build();
        callback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if(locationResult==null){
                    return;
                };
                mLocation.postValue(locationResult.getLastLocation());
            }
        };
        fused.requestLocationUpdates(lr,callback,null);
    }

    public void borrarCallback(){
        fused.removeLocationUpdates(callback);
    }


}
