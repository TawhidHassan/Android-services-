package com.example.androidservicesworking.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.androidservicesworking.MainActivity;

public class MyDwonloadService extends Service {
    private static final String TAG ="MyTag" ;

    public MyDwonloadService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate Call");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand Call");
        String songName=intent.getStringExtra(MainActivity.MESSAGE_KEY);
        downloadSong(songName);
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG,"onBind Call");
        return null;
    }

    private void downloadSong(final String songName){
        Log.d(TAG, "run: staring download");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "downloadSong: "+songName+" Downloaded...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy Call");
    }
}