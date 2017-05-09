package zero.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

/**
 * Created by Aiy on 2017/1/4.
 */

public class PhotoGalleryFragment extends Fragment {
    private RecyclerView recyclerView;
    private static  final String TAG="PhotoGalleryFragment";
    public static PhotoGalleryFragment newInstant(){
        return new PhotoGalleryFragment();
    }

    private class FetchrItemsTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... params) {
            try{
                String result=new FlickrFetchr().getUrlString("http://www.baidu.com");
                Log.i(TAG,"Fetched contents of URL:" + result);
            }catch (IOException ioe){
                Log.e(TAG,"Failed to fetch URL: ",ioe);
            }
            return null;
        }
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_photo_gallery,container,false);
        recyclerView=(RecyclerView) v.findViewById(R.id.fragment_photo_gallery_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchrItemsTask().execute();
    }
}
