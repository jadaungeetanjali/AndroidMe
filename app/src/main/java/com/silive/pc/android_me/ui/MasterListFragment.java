package com.silive.pc.android_me.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.silive.pc.android_me.R;
import com.silive.pc.android_me.data.AndroidImageAssets;

/**
 * A simple {@link Fragment} subclass.
 */
// This fragment displays all of the AndroidMe images in one large list
// The list appears as a grid of images
public class MasterListFragment extends Fragment {


    public MasterListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(mAdapter);
        return rootView;
    }

}
