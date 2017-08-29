package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

/**
 * Created by Oficina on 28/08/2017.
 */

public class BodyPartFragment extends Fragment {

    private static final String TAG = BodyPartFragment.class.getSimpleName();
    private List<Integer> mImageList;
    private int mImageIndex;

    //Mandatory constructor to instantiating the fragment
    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        //Get a reference to the imageview in the fragment layout
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        if(mImageList != null) {
            //Set the image resource to display
            imageView.setImageResource(mImageList.get(mImageIndex));
        }else{
            Log.d(TAG, "ImageList is null");
        }
        return rootView;

    }

    public List<Integer> getmImageList() {
        return mImageList;
    }

    public void setmImageList(List<Integer> mImageList) {
        this.mImageList = mImageList;
    }

    public int getmImageIndex() {
        return mImageIndex;
    }

    public void setmImageIndex(int mImageIndex) {
        this.mImageIndex = mImageIndex;
    }
}
