package com.example.myapp2021;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapp2021.databinding.ActivityMainBinding;

import com.example.myapp2021.main.TabsAdapter;
import com.example.myapp2021.main.contact.ContactFragment;
import com.example.myapp2021.main.favorite.FavoriteFragment;
import com.example.myapp2021.main.home.HomeFragment;
import com.example.myapp2021.main.shoppinglist.ShoppingFragment;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TabsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new FavoriteFragment());
        fragmentList.add(new ShoppingFragment());
        fragmentList.add(new ContactFragment());

        adapter = new TabsAdapter(getSupportFragmentManager(), getLifecycle(), fragmentList);
        binding.pager.setAdapter(adapter);


        binding.btnNav.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home:
                    binding.pager.setCurrentItem(0);
                    binding.btnNav.getMenu().findItem(R.id.home).setChecked(true);
                    break;
                case R.id.favorite:
                    binding.pager.setCurrentItem(1);
                    binding.btnNav.getMenu().findItem(R.id.favorite).setChecked(true);
                    break;
                case R.id.shoppinglist:
                    binding.pager.setCurrentItem(2);
                    binding.btnNav.getMenu().findItem(R.id.shoppinglist).setChecked(true);
                    break;
                case R.id.contact_us:
                    binding.pager.setCurrentItem(3);
                    binding.btnNav.getMenu().findItem(R.id.contact_us).setChecked(true);

            }
            return false;
        });

        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        binding.btnNav.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        binding.btnNav.getMenu().findItem(R.id.favorite).setChecked(true);
                        break;
                    case 2:
                        binding.btnNav.getMenu().findItem(R.id.shoppinglist).setChecked(true);
                        break;
                    case 3:
                        binding.btnNav.getMenu().findItem(R.id.contact_us).setChecked(true);
                        break;
                }
            }
        });

    }


}
