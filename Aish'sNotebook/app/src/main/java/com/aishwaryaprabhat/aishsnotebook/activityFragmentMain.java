package com.aishwaryaprabhat.aishsnotebook;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class activityFragmentMain extends ListFragment {



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String [] mylist = new String[]{"JAVA","python","C","C#"};
        ArrayAdapter<String> my_adapter = new ArrayAdapter<String>(
                getActivity(),android.R.layout.simple_list_item_1,mylist
        );

        setListAdapter(my_adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
