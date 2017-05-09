package zero.beatbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Aiy on 2016/12/18.
 */

public class BeatBoxActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deep_activity);

        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.deep_activity_main);
        if (fragment==null){
            fragment=new BeatBoxFragment();
            fm.beginTransaction()
                    .add(R.id.deep_activity_main,fragment)
                    .commit();
        }
    }
}
