package com.example.nathan.sportsinjuryidentification;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FragmentManager manager = getSupportFragmentManager();
        Welcome welcome = new Welcome();
        manager.beginTransaction().replace(R.id.content_main, welcome).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
/*FragmentManager manager = getSupportFragmentManager();*/

        if (id == R.id.nav_Home) {
            Welcome fragment = new Welcome();
            FragmentTransaction frag = getSupportFragmentManager().beginTransaction();
            frag.replace(R.id.content_main, fragment);
            frag.commit();

        } else if (id == R.id.nav_DiagnoseInjury) {
            DiagnoseInjury fragment = new DiagnoseInjury();
            FragmentTransaction frag = getSupportFragmentManager().beginTransaction();
            frag.replace(R.id.content_main, fragment);
            frag.commit();

        } else if (id == R.id.nav_InjuriesRecoveryMethods) {
            InjuriesRecoveryMethods fragment = new InjuriesRecoveryMethods();
            FragmentTransaction frag = getSupportFragmentManager().beginTransaction();
            frag.replace(R.id.content_main, fragment);
            frag.commit();

        } else if (id == R.id.nav_History) {
            History fragment = new History();
            FragmentTransaction frag = getSupportFragmentManager().beginTransaction();
            frag.replace(R.id.content_main, fragment);
            frag.commit();

        } else if (id == R.id.nav_GPSLocator) {
            GPS fragment = new GPS();
            FragmentTransaction frag = getSupportFragmentManager().beginTransaction();
            frag.replace(R.id.content_main, fragment);
            frag.commit();

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
