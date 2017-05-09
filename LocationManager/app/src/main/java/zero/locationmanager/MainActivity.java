package zero.locationmanager;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static final int SHOW_LOCATION=0;
    private TextView tv;
    private LocationManager lm;
    private String provider;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SHOW_LOCATION:
                    tv.setText((String)msg.obj);
                    break;
                default:
                    break;
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= (TextView) findViewById(R.id.position_text_view);
        lm= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providerList=lm.getProviders(true);
        if (providerList.contains(LocationManager.GPS_PROVIDER)){
            provider=LocationManager.GPS_PROVIDER;
        }if(providerList.contains(LocationManager.NETWORK_PROVIDER)) {
            provider = LocationManager.NETWORK_PROVIDER;
        }else{
            Toast.makeText(this,"没有开启GPS或者网络连接",Toast.LENGTH_SHORT);
        }
        try{
            Location location=lm.getLastKnownLocation(provider);
            if (location!=null){
                showLocation(location);

            }
            lm.requestLocationUpdates(provider, 2000, 1, locationListener);


        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (lm != null) {
                lm.removeUpdates(locationListener);
            }
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    LocationListener locationListener=new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            showLocation(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void showLocation(final Location location){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url=new URL("http://maps.google.cn/maps/api/geocode/json?latlng="
                            +location.getLatitude()+","
                            +location.getLongitude()
                            +"&sensor=false");
                    HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
                    ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
                    InputStream inputStream=urlConnection.getInputStream();
                    if (urlConnection.getResponseCode()!=200){
                        throw new IOException(urlConnection.getResponseMessage()+"with");
                    }
                    int bufferead=0;
                    byte[] buff=new byte[1024];
                    while((bufferead=inputStream.read(buff))>0){
                        outputStream.write(buff,0,bufferead);
                    }
                    outputStream.close();
                    Log.e("zero",outputStream.toString());
                    String add=outputStream.toString();
                    JSONObject jsonObject=new JSONObject(add);
                    JSONArray resultArray =jsonObject.getJSONArray("results");
                    if (resultArray.length()>0){
                        JSONObject jsonObject1=resultArray.getJSONObject(0);
                        JSONObject js2=jsonObject1.getJSONObject("geometry");
                        String js=js2.getString("location_type");
                        Log.e("sys",js);
                        Message message=new Message();
                        message.what=SHOW_LOCATION;
                        message.obj=js;
                        handler.sendMessage(message);
                    }


                    urlConnection.disconnect();

                }catch (IOException e){
                    Log.e("shiwu","没有找到");
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }).start();
        //tv.setText(""+location.getLatitude()+"\n"+location.getLongitude());
    }

}
