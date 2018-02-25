package com.onestopcancercenter.onestopcancercenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Admin_menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener   {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_adminmenu_drawer,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //Toast.makeText(Admin_menu.this, "item selected", LENGTH_SHORT).show();
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            Toast.makeText(Admin_menu.this, "home", LENGTH_SHORT).show();

        } else if (id == R.id.nav_hospitallist) {

            Toast.makeText(Admin_menu.this, "hospitallist", LENGTH_SHORT).show();

        } else if (id == R.id.nav_addhospital) {

            Toast.makeText(Admin_menu.this, "addhospital", LENGTH_SHORT).show();

        } else if (id == R.id.nav_logout) {

            Toast.makeText(Admin_menu.this, "logout", LENGTH_SHORT).show();


        }


        return true;
    }



}