package zero.outputstream_and_inputstream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.edit_text);
        editText.setText(reader());
    }

    private String reader(){
        StringBuffer buffer=new StringBuffer();
        FileInputStream inputStream=null;
        BufferedReader reader=null;
        try{
            inputStream=openFileInput("data");
            reader=new BufferedReader(new InputStreamReader(inputStream));
            String s="";
            while((s=reader.readLine())!=null){
                buffer.append(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (reader!=null){
               try{
                   reader.close();
               }catch (IOException e){
                   e.printStackTrace();
               }
            }

        }
        return buffer.toString();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        String s=editText.getText().toString();
        BufferedWriter writer=null;
        FileOutputStream output=null;
        try{
            output=openFileOutput("data",MODE_PRIVATE);
            writer=new BufferedWriter(new OutputStreamWriter(output));
            writer.write(s);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (writer!=null){
                try{
                    writer.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
