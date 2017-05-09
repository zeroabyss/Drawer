package zero.talk;

/**
 * Created by Aiy on 2017/3/14.
 */

public class Msg  {
    public static  final int TYPE_SEND=1;
    public static  final int TYPE_RECEIVE=0;
    private String content;
    private int type;

    public Msg(String content,int type){
        this.content=content;
        this.type=type;
    }

    public String getContent() {
        return content;
    }


    public int getType() {
        return type;
    }

}
