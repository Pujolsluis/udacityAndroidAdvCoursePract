package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by devs on 8/30/17.
 */

public class MasterListFragment extends Fragment {

    OnImageClickListener mCallback;

    public MasterListFragment(){

    }

    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.fragment_master_list_grid_view);

        MasterListAdapter masterListAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        gridView.setAdapter(masterListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    mCallback.onImageSelected(i);
            }
        });

        return rootView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mCallback = (OnImageClickListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString()
                    + "must implement OnImageClickListener");
        }
    }
}
