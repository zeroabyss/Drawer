package zero.beatbox;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BeatBoxFragment extends Fragment {

    public static BeatBoxFragment newInstance(){
        return new BeatBoxFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_beat_box,container,false);
        RecyclerView recyclerView=(RecyclerView)v.findViewById(R.id.fragment_beat_box_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setAdapter(new soundAdapter());
        return v;

    }

    private class soundHolder extends RecyclerView.ViewHolder{
        private Button button;

        public soundHolder(View itemView) {
            super(itemView);
            button=(Button)itemView.findViewById(R.id.list_item_sound_button);
        }
    }

    private class soundAdapter extends RecyclerView.Adapter<soundHolder>{

        @Override
        public soundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            View v=layoutInflater.inflate(R.layout.list_item_sound,parent,false);
            return new soundHolder(v);
        }

        @Override
        public void onBindViewHolder(soundHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
