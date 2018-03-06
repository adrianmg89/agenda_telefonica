package com.example.admin.agenda2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vistaNuevoContacto();
                    return true;
                case R.id.navigation_dashboard:
                    vistaBusquedaContacto();
                    return true;
            }
            return false;
        }
    };

    private void vistaNuevoContacto(){
        Fragment NuevoContacto = new NuevoContacto();
        FragmentManager ncfm = getSupportFragmentManager();
        FragmentTransaction ncft = ncfm.beginTransaction();
        ncft.replace(R.id.content,NuevoContacto);
        ncft.commit();
    }

    public void vistaBusquedaContacto(){
        Fragment BusquedaContacto = new BusquedaContacto();
        FragmentManager bcfm = getSupportFragmentManager();
        FragmentTransaction bcft = bcfm.beginTransaction();
        bcft.replace(R.id.content,BusquedaContacto);
        bcft.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vistaNuevoContacto();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
