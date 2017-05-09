package com.example.aiy.second;

import java.util.UUID;

/**
 * Created by Aiy on 2016/12/2.
 */

public class Person {
    private String name;
    private int num;
    public Person(){
        num=0;
        name="空";
    }
    public Person(int num, String name){
        this.name=name;
        this.num=num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
