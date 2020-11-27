package com.example.fragmentexamples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class BookActivity extends AppCompatActivity {

    List<String> pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        pages = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++)
            pages.add(faker.lorem.paragraph());

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        BookAdapter bookAdapter = new BookAdapter(this);
        viewPager.setAdapter(bookAdapter);
    }

    private class BookAdapter extends FragmentStateAdapter {

        public BookAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return PageFragment.newInstance(pages.get(position), String.valueOf(position + 1));
        }

        @Override
        public int getItemCount() {
            return pages.size();
        }
    }
}