package com.example.myapp2021.Utils;

import androidx.fragment.app.Fragment;

import com.example.myapp2021.main.favorite.FavoriteFragment;
import com.example.myapp2021.main.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public Utils() {

    }

    public static List<Fragment> fragmentList() {

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new FavoriteFragment());
        return fragmentList;
    }

}
