package com.example.constantinozamora.daqazucar;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Formatter;

public class produccion extends Fragment {


    //----------------------------------------------------------------------
    ImageView Moliendo,Paro;

    TextView DIAZAF;
    TextView AZCRUD;
    TextView AZCRUZ;
    TextView AZBLAD;
    TextView AZBLAZ;
    TextView TOTAZD;
    TextView TOTAZZ;
    TextView CAMOLD;
    TextView CAMOLZ;
    TextView MOLPRD;
    TextView RELAZD;
    TextView RELAZZ;
    TextView AZUPRO;
    TextView EFIVAP;


    //  Button BM;


    private Handler customHandler = new Handler();

    //----------------------------------------------------------------------


    public produccion() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_produccion, container, false);



        Moliendo = v.findViewById(R.id.imageMoliendo);
        Paro = v.findViewById(R.id.imageParo);

        DIAZAF = (TextView)v.findViewById(R.id.DIAZAF);
        AZCRUD = (TextView)v.findViewById(R.id.AZCRUD);
        AZCRUZ = (TextView)v.findViewById(R.id.AZCRUZ);
        AZBLAD = (TextView)v.findViewById(R.id.AZBLAD);
        AZBLAZ = (TextView)v.findViewById(R.id.AZBLAZ);
        TOTAZD = (TextView)v.findViewById(R.id.TOTAZD);
        TOTAZZ = (TextView)v.findViewById(R.id.TOTAZZ);
        CAMOLD = (TextView)v.findViewById(R.id.CAMOLD);
        CAMOLZ = (TextView)v.findViewById(R.id.CAMOLZ);
        MOLPRD = (TextView)v.findViewById(R.id.MOLPRD);
        RELAZD = (TextView)v.findViewById(R.id.RELAZD);
        RELAZZ = (TextView)v.findViewById(R.id.RELAZZ);
        AZUPRO = (TextView)v.findViewById(R.id.AZUPRO);
        EFIVAP = (TextView)v.findViewById(R.id.EFIVAP);

        customHandler.postDelayed(updateTimerThread, 500);


        return v;
    }


    private Runnable updateTimerThread = new Runnable() {

        public void run() {
            //AQUI SE UTILIZA SERVIDORES 1 Y 2, ASEGURARSE QUE ESTEN CONECTADOS: (pero no funcionó)
            //  if (funciones.isDatoOkS1 && funciones.isDatoOkS2) {
            if (funciones.MasterON) {
                DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
                DecimalFormat enteros = new DecimalFormat("##0");

                if (funciones.Val1[121] == 1) {
                    Moliendo.setVisibility(View.VISIBLE);
                    Paro.setVisibility(View.GONE);
                } else {
                    Moliendo.setVisibility(View.GONE);
                    Paro.setVisibility(View.VISIBLE);
                }

                Double TOTAZDIA= (funciones.Val1[62]+(funciones.Val1[66]*50/1000));
                Double TOTAZZAF= (funciones.Val1[63]+(funciones.Val1[67]*50/1000));
                Double Transcu = (funciones.Val1[128]-25200)/3600;
                Double MolidaPH=0.0;
                Double EfiVapor=0.0;

                if(Transcu<0){
                    Transcu=Transcu+24;
                }

                if (Transcu!=0){
                    MolidaPH=funciones.Val1[59]/Transcu;
                }


                Double RelaDia=0.0;
                if (funciones.Val1[59]!=0){
                    RelaDia=TOTAZDIA*1000/funciones.Val1[59];
                }

                Double RelaZaf=0.0;
                if (funciones.Val1[60]!=0){
                    RelaZaf=TOTAZZAF*1000/funciones.Val1[60];
                }

                if (funciones.Val1[59]!=0) {
                    EfiVapor = funciones.Val1[58] * 1000 / funciones.Val1[59];
                }

                DIAZAF.setText(formatter.format(funciones.Val1[ 64]) + " ");
                AZCRUD.setText(formatter.format(funciones.Val1[ 62]) + " ");
                AZCRUZ.setText(formatter.format(funciones.Val1[ 63]) + " ");
                AZBLAD.setText(formatter.format(funciones.Val1[ 66]) + " ");
                AZBLAZ.setText(formatter.format(funciones.Val1[ 67]) + " ");
                TOTAZD.setText(formatter.format(TOTAZDIA)+ " ");
                TOTAZZ.setText(formatter.format(TOTAZZAF)+ " ");
                CAMOLD.setText(formatter.format(funciones.Val1[ 59]) + " ");
                CAMOLZ.setText(formatter.format(funciones.Val1[ 60]) + " ");
                MOLPRD.setText(formatter.format(MolidaPH)+ " ");
                RELAZD.setText(formatter.format(RelaDia)+ " ");
                RELAZZ.setText(formatter.format(RelaZaf)+ " ");
                AZUPRO.setText(formatter.format(funciones.Val4[ 54]) + " ");
                EFIVAP.setText(formatter.format(EfiVapor)+ " ");

                DIAZAF.setTextColor(Color.parseColor(funciones.Color1[ 64]));
                AZCRUD.setTextColor(Color.parseColor(funciones.Color1[ 62]));
                AZCRUZ.setTextColor(Color.parseColor(funciones.Color1[ 63]));
                AZBLAD.setTextColor(Color.parseColor(funciones.Color3[ 66]));
                AZBLAZ.setTextColor(Color.parseColor(funciones.Color3[ 67]));
                TOTAZD.setTextColor(Color.WHITE);
                TOTAZZ.setTextColor(Color.WHITE);
                CAMOLD.setTextColor(Color.parseColor(funciones.Color3[ 59]));
                CAMOLZ.setTextColor(Color.parseColor(funciones.Color1[ 60]));
                MOLPRD.setTextColor(Color.WHITE);
                RELAZD.setTextColor(Color.WHITE);
                RELAZZ.setTextColor(Color.WHITE);
                AZUPRO.setTextColor(Color.parseColor(funciones.Color4[ 54]));
                EFIVAP.setTextColor(Color.WHITE);




                //  }
            }
            customHandler.postDelayed(this, 500);

        }

    };
}
