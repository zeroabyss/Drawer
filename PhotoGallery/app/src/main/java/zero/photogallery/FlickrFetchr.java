package zero.photogallery;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Aiy on 2017/1/8.
 */

public class FlickrFetchr {
    public byte[] getUrlBytes(String urlSpec)throws IOException{

        URL url=new URL(urlSpec);
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();

        try {
            ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
            InputStream inputStream=connection.getInputStream();

            if (connection.getResponseCode()!=HttpURLConnection.HTTP_OK){
                throw new IOException(connection.getResponseMessage()+": with"+urlSpec);

            }

            int read=0;
            byte[] buffer=new byte[1024];
            while((read= inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,read);
            }
            outputStream.close();
            return outputStream.toByteArray();
        }finally {
            connection.disconnect();
        }

    }

    public String getUrlString(String urlSpec) throws IOException{
        return new String(getUrlBytes(urlSpec));
    }
 }
