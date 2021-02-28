package com.example.androidservicesworking.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import com.example.androidservicesworking.DownloadThread;
import com.example.androidservicesworking.MainActivity;

public class MyDwonloadService extends Service {
    private static final String TAG ="MyTag" ;
    private DownloadThread mDownlaodThread;
    public MyDwonloadService() {
    }


    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: called");

        mDownlaodThread=new DownloadThread();
        mDownlaodThread.start();

        while (mDownlaodThread.mHandler == null){

        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand: called: Song Name: "+intent.getStringExtra(MainActivity.MESSAGE_KEY));
        Log.d(TAG, "onStartCommand: called: Intent Id: "+startId);
        final String songName=intent.getStringExtra(MainActivity.MESSAGE_KEY);

        Message message=Message.obtain();
        message.obj=songName;
        message.arg1=startId;
        mDownlaodThread.mHandler.sendMessage(message);


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