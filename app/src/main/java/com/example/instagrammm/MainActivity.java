package com.example.instagrammm;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.instagrammm.databinding.ActivityMainBinding;
import com.example.instagrammm.ui.dashboard.DashboardFragment;
import com.example.instagrammm.ui.home.HomeFragment;
import com.example.instagrammm.ui.notifications.NotificationsFragment;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        com.example.instagrammm.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();

        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        BottomNavigationView naive = findViewById(R.id.nav_view);



        // for removing default actionbar
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        //change taskbar color
        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            window.setStatusBarColor(this.getResources().getColor(R.color.Status));
        }



        ImageView imageView = findViewById(R.id.Camera);
        imageView.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Camera clicked", Toast.LENGTH_SHORT).show());

       HomeFragment firstFragment = new HomeFragment();
        DashboardFragment secondFragment = new DashboardFragment();
        NotificationsFragment thirdFragment = new NotificationsFragment();
        PlusFragment fourthFragment = new PlusFragment();
        HeartFragment fifthFragment = new HeartFragment();

        naive.setOnNavigationItemSelectedListener(menuItem -> {

            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, firstFragment).commit();
                    return true;

                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                    return true;

                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                    return true;

                case R.id.plus:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fourthFragment).commit();
                    return true;

                case R.id.heart:
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fifthFragment).commit();
                    return true;
            }
            return true;

        });






    }


}