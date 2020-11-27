package com.example.fragmentexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity implements BlueFragment.OnUpdateItemListener {

    BlueFragment blueFragment;
    RedFragment redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment.getClass() == BlueFragment.class)
            blueFragment = (BlueFragment)fragment;
        else if (fragment.getClass() == RedFragment.class)
            redFragment = (RedFragment)fragment;
    }

    @Override
    public void updateItem(String item) {
        redFragment.updateContent(item);
    }
}