package com.example.aiy.first;

/**
 * Created by Aiy on 2016/11/15.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int mTextResId,boolean mAnswerTrue){
        this.mAnswerTrue=mAnswerTrue;
        this.mTextResId=mTextResId;
    }
    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
