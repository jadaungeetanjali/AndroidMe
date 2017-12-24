package com.silive.pc.android_me.ui;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.silive.pc.android_me.R;
import com.silive.pc.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // only create fragments when there is no previously saved state
        if (savedInstanceState == null) {

            //create a new head bodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();

            // Set the list of image id's for the head fragment and set the position to the second image in the list
            headFragment.setImageIds(AndroidImageAssets.getHeads());

            // Get the correct index to access in the array of head images from the intent
            // Set the default value to 0
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setListIndex(headIndex);

            // add the fragment to its container using FragmentManager and its transaction
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            //create and display the head and body BodyPartFragemnt
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex", 0);
            bodyFragment.setListIndex(bodyIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex", 0);
            legFragment.setListIndex(legIndex);
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }
}
