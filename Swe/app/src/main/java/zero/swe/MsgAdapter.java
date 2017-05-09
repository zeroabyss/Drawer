package zero.swe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aiy on 2017/1/22.
 */

public class MsgAdapter extends ArrayAdapter<Msg>{

    private int resourceid;

    public MsgAdapter(Context context, int resourceid, List<Msg> objects) {
        super(context, resourceid, objects);
        this.resourceid=resourceid;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg=getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceid,null);
            viewHolder=new ViewHolder();
            viewHolder.left= (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.right= (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.TV_Left= (TextView) view.findViewById(R.id.left_msg);
            viewHolder.TV_right= (TextView) view.findViewById(R.id.msg_right);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        if(msg.getType()==Msg.TYPE_RECEIVED){
            viewHolder.left.setVisibility(View.VISIBLE);
            viewHolder.right.setVisibility(View.GONE);
            viewHolder.TV_Left.setText(msg.getContent());
        }else if(msg.getType()==Msg.TYPE_SEND){
            viewHolder.left.setVisibility(View.GONE);
            viewHolder.right.setVisibility(View.VISIBLE);
            viewHolder.TV_right.setText(msg.getContent());
        }
        return view;
    }

    class ViewHolder{
        LinearLayout left;
        LinearLayout right;
        TextView  TV_Left;
        TextView TV_right;
    }
}
