package com.example.aiy.crime;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

/**
 * Created by Aiy on 2016/11/27.
 */

public class CrimeListActivity extends AppCompatActivity implements CrimeListFragment.Callbacks,CrimeFragment.Callbacks{//appCom是工具栏

    protected int getLayoutResID(){
        return R.layout.activity_masterdetail;
    }
    //onCreate是通用写法 就是把id和new fragment类修改。
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());

        FragmentManager fm=getSupportFragmentManager();//创建Fragment管理器 都是一样的写法
        Fragment fragment=fm.findFragmentById(R.id.fragment_container);

        if(fragment==null){
            fragment=new CrimeListFragment();//fragment的类
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)//把activity给fragment托管
                    .commit();
        }

    }

    @Override
    public void onCrimeSelected(Crime crime) {
        if((findViewById(R.id.detail_fragment_container)==null)){
            Intent i=PagerActivity.newIntent(this,crime.getId());
            startActivity(i);
        }else{
            Fragment detail=CrimeFragment.newInstance(crime.getId());
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container,detail)
                    .commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {
        CrimeListFragment listFragment=(CrimeListFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.fragment_container);
        listFragment.update();

    }
}
