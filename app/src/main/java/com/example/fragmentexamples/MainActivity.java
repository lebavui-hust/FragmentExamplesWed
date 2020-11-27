package com.example.fragmentexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlueFragment.OnUpdateItemListener {

    BlueFragment blueFragment;
    RedFragment redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueFragment = BlueFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_blue, blueFragment);
        ft.commit();

        redFragment = RedFragment.newInstance("", "");
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_red, redFragment);
        ft.commit();

        BlueFragment otherFragment = BlueFragment.newInstance();
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_green, otherFragment);
        ft.commit();
    }


    @Override
    public void updateItem(String item) {
        redFragment.updateContent(item);
    }
}