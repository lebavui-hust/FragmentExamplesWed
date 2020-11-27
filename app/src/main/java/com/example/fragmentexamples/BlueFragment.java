package com.example.fragmentexamples;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlueFragment extends Fragment {
    List<String> items;

    public BlueFragment() {
        // Required empty public constructor
    }

    public static BlueFragment newInstance() {
        return new BlueFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blue, container, false);

        TextView textTitle = view.findViewById(R.id.text_title);
        ListView listView = view.findViewById(R.id.list_view);

        items = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            items.add("Item " + i);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((OnUpdateItemListener)getActivity()).updateItem(items.get(i));
            }
        });

        return view;
    }

    public interface OnUpdateItemListener {
        void updateItem(String item);
    }
}