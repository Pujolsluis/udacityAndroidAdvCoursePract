package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener, MasterListFragment.OnNextButtonClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    private boolean TwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.android_me_linear_layout);

        if(linearLayout != null){
            TwoPane = true;

            Button nextButton = (Button) findViewById(R.id.fragment_master_list_button);
            nextButton.setVisibility(View.GONE);

            GridView gridView = (GridView) findViewById(R.id.fragment_master_list_grid_view);
            gridView.setNumColumns(2);

            if(savedInstanceState == null) {

                BodyPartFragment headFragment = new BodyPartFragment();

                headFragment.setmImageList(AndroidImageAssets.getHeads());
                headFragment.setmImageIndex(1);

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setmImageList(AndroidImageAssets.getBodies());
                bodyFragment.setmImageIndex(1);

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setmImageList(AndroidImageAssets.getLegs());
                legFragment.setmImageIndex(1);

                //Use Fragment Manager and transaction to add the fragment to the screen
                FragmentManager fragmentManager = getSupportFragmentManager();

                //Fragment Transaction
                fragmentManager.beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .add(R.id.body_container, bodyFragment)
                        .add(R.id.legs_container, legFragment)
                        .commit();
            }

        }else{
            TwoPane = false;
        }

    }

    @Override
    public void onImageSelected(int position) {
        Log.d(TAG, "the position" +  position + "was clicked.");

        Toast.makeText(this, "the position " + position + " was clicked.", Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position / 12;

        int listIndex = position - 12 * bodyPartNumber;

        if(TwoPane){

            BodyPartFragment newFragment = new BodyPartFragment();

            switch (bodyPartNumber) {
                case 0:
                    newFragment.setmImageList(AndroidImageAssets.getHeads());
                    newFragment.setmImageIndex(listIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, newFragment)
                            .commit();
                    break;
                case 1:
                    newFragment.setmImageList(AndroidImageAssets.getBodies());
                    newFragment.setmImageIndex(listIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, newFragment)
                            .commit();
                    break;
                case 2:
                    newFragment.setmImageList(AndroidImageAssets.getLegs());
                    newFragment.setmImageIndex(listIndex);

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.legs_container, newFragment)
                            .commit();
                    break;

            }

        }else {

            switch (bodyPartNumber) {
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
