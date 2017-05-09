package zero.talk;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Msg> list;
    public Adapter(List<Msg>  list){
        this.list=list;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView left;
        TextView right;

        public ViewHolder(View itemView) {
            super(itemView);
            left= (TextView) itemView.findViewById(R.id.left_view);
            right= (TextView) itemView.findViewById(R.id.right_view);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg=list.get(position);
        if (msg.getType()==Msg.TYPE_SEND){
            holder.left.setVisibility(View.GONE);
            holder.right.setVisibility(View.VISIBLE);
            holder.right.setText(msg.getContent());
        }
        if (msg.getType()==Msg.TYPE_RECEIVE){
            holder.right.setVisibility(View.GONE);
            holder.left.setVisibility(View.VISIBLE);
            holder.left.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

