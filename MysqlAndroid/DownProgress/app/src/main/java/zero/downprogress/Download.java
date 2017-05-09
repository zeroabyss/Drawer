package zero.downprogress;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import static android.content.ContentValues.TAG;

/**
 * Created by Aiy on 2017/3/27.
 */

public class Download extends AsyncTask<String,Integer,Integer> {

    private int STATUS=0;
    private final int START=0;
    private final int PAUSE=1;
    private final int FAILED=2;
    private final int SUCCESS=3;
    private Call call;
    private int lastProgress;
    public Download(Call call) {
        this.call=call;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        switch (integer){
            case PAUSE:
                call.pause();
                break;
            case FAILED:
                call.failed();
                break;
            case SUCCESS:
                call.success();
                break;
            default:
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress=values[0];
        if (progress>lastProgress) {
            call.progress(progress);
            lastProgress=progress;
        }
    }

    @Override
    protected Integer doInBackground(String... params) {
        String url=params[0];
        InputStream inputStream=null;
        File file=null;
        RandomAccessFile saveFile=null;
        try {
            long downloadlength=0;
            String filename=url.substring(url.lastIndexOf("/"));
            Log.d(TAG, filename);
            String directory= Environment.getExternalStoragePublicDirectory
                    (Environment.DIRECTORY_DOWNLOADS).getPath();
            Log.d(TAG, directory);
            file=new File(directory+filename);
            if (file.exists()){
                downloadlength=file.length();
            }

            OkHttpClient okHttpClient1=new OkHttpClient();
            Request request1=new Request.Builder()
                    .url(url)
                    .build();
            Response response1=okHttpClient1.newCall(request1).execute();
            long contentLength=response1.body().contentLength();
            response1.body().close();
            if (contentLength==0){
                return FAILED;
            }else if (downloadlength==contentLength){
                Log.e(TAG, "se");
                return SUCCESS;
            }

            OkHttpClient okHttpClient=new OkHttpClient();
            Request request=new Request.Builder()
                    .url(url)
                    .addHeader("RANGE","bytes="+downloadlength+"-")
                    .build();
            Response response=okHttpClient.newCall(request).execute();
            if (response!=null){
                inputStream=response.body().byteStream();
                byte[] b=new byte[1024];
                int len;
                int total=0;
                saveFile=new RandomAccessFile(file,"rw");
                saveFile.seek(downloadlength);
                Log.d(TAG, "doInBackground: ");
                while ((len=inputStream.read(b))!=-1){
                    if (STATUS==PAUSE){
                        Log.e(TAG, "PAUSE" );
                        return PAUSE;
                    }
                    total+=len;
                    saveFile.write(b,0,len);
                    int pr= (int) ((total+downloadlength)*100/contentLength);
                    publishProgress(pr);
                }
                Log.e(TAG, "ok" );
                response.body().close();
                return SUCCESS;
            }
            response.body().close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
           try{
               if (inputStream!=null) {
                   inputStream.close();
               }
               if (saveFile!=null) {
                   saveFile.close();
               }
           }catch (IOException e){
               e.printStackTrace();
           }

        }
        return FAILED;
    }


    public void Pause(){
        STATUS=PAUSE;
    }


}
