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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oficina on 28/08/2017.
 */

public class BodyPartFragment extends Fragment {

    private static final String TAG = BodyPartFragment.class.getSimpleName();
    private static final String IMAGE_LIST = "ImageList";
    private static final String IMAGE_INDEX = "ImageIndex";
    private List<Integer> mImageList;
    private int mImageIndex;
    ImageView imageView;

    //Mandatory constructor to instantiating the fragment
    public BodyPartFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate the Android-Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        if( savedInstanceState != null){
            mImageList = savedInstanceState.getIntegerArrayList(IMAGE_LIST);
            mImageIndex = savedInstanceState.getInt(IMAGE_INDEX);
        }

        //Get a reference to the imageview in the fragment layout
        imageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

        if(mImageList != null) {
            //Set the image resource to display
            imageView.setImageResource(mImageList.get(mImageIndex));
        }else{
            Log.d(TAG, "ImageList is null");
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mImageIndex < mImageList.size() - 1){
                    mImageIndex++;
                }else {
                    mImageIndex = 0;
                }
                if(mImageList != null) {
                    //Set the image resource to display
                    imageView.setImageResource(mImageList.get(mImageIndex));
                }else{
                    Log.d(TAG, "ImageList is null");
                }
            }
        });

        return rootView;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGE_LIST, (ArrayList<Integer>) mImageList);
        outState.putInt(IMAGE_INDEX, mImageIndex);
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
