package com.onestopcancercenter.onestopcancercenter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Hospital_menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {




    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_menu);
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
        getMenuInflater().inflate(R.menu.activity_hospitalmenu_drawer,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //Toast.makeText(Admin_menu.this, "item selected", LENGTH_SHORT).show();
        int id = item.getItemId();

        if (id == R.id.nav_home) {

<<<<<<< HEAD
            //Toast.makeText(Hospital_menu.this, "home", LENGTH_SHORT).show();
=======
            // Toast.makeText(Hospital_menu.this, "home", LENGTH_SHORT).show();
>>>>>>> ربط في المنيو و ليست لسيرش و الفيو في كانسر تايب

            Intent intent = new Intent(this,Homepage.class);
            this.startActivity(intent);

        } else if (id == R.id.nav_addawarness) {

           // Toast.makeText(Hospital_menu.this, "add awarness", LENGTH_SHORT).show();

            Intent intent = new Intent(this,add_awareness_for_hospital.class);
            this.startActivity(intent);

        } else if (id == R.id.nav_awarness) {

<<<<<<< HEAD
            //Toast.makeText(Hospital_menu.this, "awarness", LENGTH_SHORT).show();

            Intent intent = new Intent(this,Hospital_info.class);
=======
           // Toast.makeText(Hospital_menu.this, "awarness", LENGTH_SHORT).show();

            Intent intent = new Intent(this,Awareness_List.class);
>>>>>>> ربط في المنيو و ليست لسيرش و الفيو في كانسر تايب
            this.startActivity(intent);

        } else if (id == R.id.nav_logout) {

            Toast.makeText(Hospital_menu.this, "logout", LENGTH_SHORT).show();


        }


        return true;
    }



}
