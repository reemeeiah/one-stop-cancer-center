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
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Menu_user extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_user);
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

        getMenuInflater().inflate(R.menu.activity_usermenu_drawer , menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //Toast.makeText(Admin_menu.this, "item selected", LENGTH_SHORT).show();


        int id = item.getItemId();

        if (id == R.id.Nav_home) {

          //  Toast.makeText(Menu_user.this, "home", LENGTH_SHORT).show();

            Intent intent = new Intent(this,Homepage.class);
            this.startActivity(intent);

        } else if (id == R.id.Nav_stories) {

            Toast.makeText(Menu_user.this, "stories", LENGTH_SHORT).show();

        }


        else if (id == R.id.Nav_awareness) {

            Intent intent = new Intent(this, Awareness_List.class);
            this.startActivity(intent);

            // Toast.makeText(Menu_user.this, "awareness", LENGTH_SHORT).show();


        } else if (id == R.id.Nav_cancer_type) {

                Intent intent = new Intent(this,Cancer_type_view.class);
                this.startActivity(intent);

                // Toast.makeText(Menu_user.this, "awareness", LENGTH_SHORT).show();

        } else if (id == R.id.Nav_logout) {

            Toast.makeText(Menu_user.this, "logout", LENGTH_SHORT).show();


        }


        return true;
    }



    }

