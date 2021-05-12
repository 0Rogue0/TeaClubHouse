package com.example.confectioneryapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.confectioneryapplication.UI.AccountFragment;
import com.example.confectioneryapplication.UI.HomeFragment;
import com.example.confectioneryapplication.UI.LoyaltyFragment;
import com.example.confectioneryapplication.UI.ShoppingCartFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    public FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private LoyaltyFragment loyaltyFragment;
    private ShoppingCartFragment shoppingCartFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();
        loyaltyFragment = new LoyaltyFragment();
        shoppingCartFragment = new ShoppingCartFragment();

        mMainNav.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.nav_home:
                    mMainNav.setItemBackgroundResource(R.color.design_default_color_primary);
                    setFragment(homeFragment);
                    return true;
                case R.id.nav_account:
                    mMainNav.setItemBackgroundResource(R.color.design_default_color_primary_dark);
                    setFragment(accountFragment);
                    return true;
                case R.id.nav_loyalty:
                    mMainNav.setItemBackgroundResource(R.color.colorAccent);
                    setFragment(loyaltyFragment);
                    return true;
                case R.id.nav_shop_cart:
                    mMainNav.setItemBackgroundResource(R.color.shopCart);
                    setFragment(shoppingCartFragment);
                    return true;
                default:
                    return false;
            }
        });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

}