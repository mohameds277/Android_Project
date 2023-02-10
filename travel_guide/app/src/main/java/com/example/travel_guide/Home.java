package com.example.travel_guide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    DrawerLayout drawer;
    androidx.appcompat.widget.Toolbar toolbar;
    NavigationView nag_view;
    ActionBarDrawerToggle action_toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        toolbar =  findViewById(R.id.tool);
        //setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nag_view = (NavigationView)findViewById(R.id.nav_view);
        nag_view.setNavigationItemSelectedListener(this);

        action_toggle = new ActionBarDrawerToggle(this , drawer, toolbar , R.string.open_nav , R.string.close_nav);



        drawer.addDrawerListener(action_toggle);
        action_toggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            nag_view.setCheckedItem(R.id.nav_view);
        }
}

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;
            case R.id.all:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AllFragment()).commit();
                break;
            case R.id.favorite:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FavFragment()).commit();
                break;
            case R.id.sorted:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SortedFragment()).commit();
                break;
            case R.id.log_out:
                Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}