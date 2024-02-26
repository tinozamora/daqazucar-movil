package com.example.constantinozamora.daqazucar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.os.Handler;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Handler customHandler = new Handler();
    Switch swS1;
    TextView tvS1;
    Switch swS2;
    TextView tvS2;
    Switch swS3;
    TextView tvS3;
    Switch swS4;
    TextView tvS4;
    Button Salir;
    ImageButton MasterSW;
    Context ctx;

    ProgressBar ProgresB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        swS1 = (Switch)findViewById(R.id.swS1) ;
        tvS1 = (TextView)findViewById(R.id.textST1);
        swS2 = (Switch)findViewById(R.id.swS2) ;
        tvS2 = (TextView)findViewById(R.id.textST2);
        swS3 = (Switch)findViewById(R.id.swS3) ;
        tvS3 = (TextView)findViewById(R.id.textST3);
        swS4 = (Switch)findViewById(R.id.swS4) ;
        tvS4 = (TextView)findViewById(R.id.textST4);
        Salir = (Button)findViewById(R.id.buttonSalir);
        MasterSW = (ImageButton)findViewById(R.id.ibMaster);
        ProgresB=findViewById(R.id.progressBar);

        ProgresB.setVisibility(View.INVISIBLE);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        MasterSW.setImageResource(R.drawable.ic_button_off);


        customHandler.postDelayed(updateTimerThread, 500);


//        MasterSW.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//             funciones.MasterON =  true;  //!funciones.MasterON;
//            }
//        });



    }


    public void AccionMaster(View v){
        funciones.MasterON =  !funciones.MasterON;

        if (!funciones.isOnlineS1){
            ProgresB.setVisibility(View.VISIBLE);
            Client1 myClient1 = new Client1(funciones.ServerIP[0], Integer.parseInt(funciones.PortIP[0]),
                    funciones.ServerIP[1], Integer.parseInt(funciones.PortIP[1]),
                    funciones.ServerIP[2], Integer.parseInt(funciones.PortIP[2]),
                    funciones.ServerIP[3], Integer.parseInt(funciones.PortIP[3]));

            myClient1.execute();
        }else{

            funciones.isOnlineS1=false;
            funciones.isOnlineS2=false;
            funciones.isOnlineS3=false;
            funciones.isOnlineS4=false;


            funciones.statusS1="Desconectado";
            funciones.statusS2="Desconectado";
            funciones.statusS3="Desconectado";
            funciones.statusS4="Desconectado";
        }


//        if (!funciones.isOnlineS2){
//            Client2 myClient2 = new Client2(funciones.ServerIP[1], Integer.parseInt(funciones.PortIP[1]));
//            myClient2.execute();
//        }
//
    }

    public void Salir(View v){

        funciones.MasterON=false;

/*        funciones.isOnlineS1=false;
        funciones.isOnlineS2=false;
        funciones.isOnlineS3=false;
        funciones.isOnlineS4=false;

        funciones.statusS1="Desconectado";
        funciones.statusS2="Desconectado";
        funciones.statusS3="Desconectado";
        funciones.statusS4="Desconectado";
        */

        while (funciones.statusS1=="Conectado"){
            funciones.statusS2="Desconectando";
            funciones.statusS3="Desconectando";
            funciones.statusS4="Desconectando";
        }
        System.exit(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
           // super.onBackPressed();
            drawer.openDrawer(Gravity.LEFT);
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
        }else if(id==R.id.action_test){
            Intent PantallaTest = new Intent(MainActivity.this, activity_test.class);
            startActivity(PantallaTest);
        }

        return super.onOptionsItemSelected(item);
    }

    Fragment f = null;
    boolean fragmentSeleccionado = false;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            f= new dummy(); //solo para que no de error cuando quiera remover f
            fragmentSeleccionado=true;
            funciones.FragmentoON=false;
            Salir.setVisibility(View.VISIBLE);

        } else if (id == R.id.nav_molienda) {
            //funciones.Val[127]=555.555;
            //Intent PantallaMolienda = new Intent(MainActivity.this, molienda.class);
            //startActivity(PantallaMolienda);
            funciones.FragmentoON=true;
            Salir.setVisibility(View.INVISIBLE);
            f = new extraccion();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_jugo) {
            Salir.setVisibility(View.INVISIBLE);
            funciones.FragmentoON=true;
            f = new   jugo();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_cristalizacion){
            funciones.FragmentoON=true;
            Salir.setVisibility(View.INVISIBLE);
            f = new cristal();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_generacion){
            funciones.FragmentoON=true;
            Salir.setVisibility(View.INVISIBLE);
            f = new gel();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_produccion){
            funciones.FragmentoON=true;
            Salir.setVisibility(View.INVISIBLE);
            f = new produccion();
            fragmentSeleccionado=true;
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_salir) {
            funciones.MasterON=false;

            while (funciones.statusS1=="Conectado"){
                funciones.statusS2="Desconectando";
                funciones.statusS3="Desconectando";
                funciones.statusS4="Desconectando";
            }
            System.exit(0);
            //System.exit(0);
        }

        if (fragmentSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,f).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        }else{
            getSupportFragmentManager().beginTransaction().remove(f).commit();
            item.setChecked(false);
            getSupportActionBar().setTitle(item.getTitle());
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            //pruebas:

            //funciones.MasterON= funciones.isOnlineS1;

            if(funciones.FragmentoON){
                Salir.setVisibility(View.INVISIBLE);
            }else {
                Salir.setVisibility(View.VISIBLE);
            }

            if(!funciones.MasterON){

                funciones.isOnlineS1=false;
                funciones.isOnlineS2=false;
                funciones.isOnlineS3=false;
                funciones.isOnlineS4=false;


                funciones.statusS1="Desconectado";
                funciones.statusS2="Desconectado";
                funciones.statusS3="Desconectado";
                funciones.statusS4="Desconectado";
            }

            if (funciones.isOnlineS1 && funciones.isOnlineS2 && funciones.isOnlineS3 && funciones.isOnlineS4){
                ProgresB.setVisibility(View.INVISIBLE);
            }

            swS1.setChecked(funciones.isOnlineS1);
            tvS1.setText(funciones.statusS1);

            swS2.setChecked(funciones.isOnlineS2);
            tvS2.setText(funciones.statusS2);

            swS3.setChecked(funciones.isOnlineS3);
            tvS3.setText(funciones.statusS3);

            swS4.setChecked(funciones.isOnlineS4);
            tvS4.setText(funciones.statusS4);

           if (funciones.MasterON){
                MasterSW.setImageResource(R.drawable.ic_button_on);
            }else{ MasterSW.setImageResource(R.drawable.ic_button_off);

            }


            customHandler.postDelayed(this, 500);


        }

    };

}
