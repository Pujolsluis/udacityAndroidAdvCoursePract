package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener, MasterListFragment.OnNextButtonClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int position) {
        Log.d(TAG, "the position" +  position + "was clicked.");

        Toast.makeText(this, "the position " +  position + " was clicked.", Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position/12;

        int listIndex = position - 12*bodyPartNumber;
        switch ( bodyPartNumber){
            case 0:
                headIndex = listIndex;
                break;
            case 1:
                bodyIndex = listIndex;
                break;
            case 2:
                legIndex = listIndex;
                break;
        }

    }

    @Override
    public void onNextButtonClicked() {
        Bundle b = new Bundle();
        b.putInt("headIndex", headIndex);
        b.putInt("bodyIndex", bodyIndex);
        b.putInt("legIndex", legIndex);

        final Intent intent  = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}
