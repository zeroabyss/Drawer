package zero.downprogress;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;


public class MyService extends Service {
    private Download download;
    private DownBinder downBinder=new DownBinder();
    private static final String TAG = "MyService";
    private Call call=new Call() {
        @Override
        public void progress(int progress) {
            getManager().notify(1,getNotification1("downing",progress));
        }

        @Override
        public void success() {
            download=null;
            Toast.makeText(MyService.this,"下载成功",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void pause() {
            download=null;
            Toast.makeText(MyService.this,"暂停下载",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void failed() {
            download=null;
            Toast.makeText(MyService.this,"下载失败",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return downBinder;
    }

    class DownBinder extends Binder{
        public void startDownload(String url){
            if (download==null){
                download=new Download(call);
                download.execute(url);
                Log.d(TAG, "startDownload: ");
                startForeground(1,getNotification1("DownLoad",0));
            }
        }

        public void pauseDownload(){
            if (download!=null){
                download.Pause();
            }
        }
    }
    private Notification getNotification(String contentText,int progress){
        NotificationCompat.Builder builder=new NotificationCompat.Builder(MyService.this)
                .setContentTitle(contentText)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        if (progress>0){
            builder.setContentText(progress+"%");
            builder.setProgress(100,progress,false);
        }
        return builder.build();
    }

    private NotificationManager getManager(){
        return (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }


    private Notification getNotification1(String title, int progress) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentIntent(pi);
        builder.setContentTitle(title);
        if (progress >= 0) {
            // 当progress大于或等于0时才需显示下载进度
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
        }
        return builder.build();
    }
}
