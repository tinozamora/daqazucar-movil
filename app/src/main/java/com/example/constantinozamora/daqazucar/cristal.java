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

public class cristal extends Fragment {


    //----------------------------------------------------------------------
    ImageView Moliendo,Paro;


    TextView DIAZAF;
    TextView SACDIA;
    TextView SACZAF;

    TextView NIVTA1;
    TextView NIVTA2;
    TextView NIVTA3;
    TextView NIVTA4;
    TextView NIVTA5;
    TextView NIVTA6;
    TextView NIVTA7;
    TextView BRIXT1;
    TextView BRIXT2;
    TextView BRIXT3;
    TextView BRIXT4;
    TextView BRIXT5;
    TextView BRIXT6;
    TextView BRIXT7;
    TextView VACTA1;
    TextView VACTA2;
    TextView VACTA3;
    TextView VACTA4;
    TextView VACTA5;
    TextView VACTA6;
    TextView VACTA7;
    TextView SACPRE;
    TextView SACVAN;
    TextView TEMPAZ;
    TextView NIVTQA;
    TextView VITAKG;
    TextView MELTQ1;
    TextView MELTQ2;
    TextView TEMMEL;

    //  Button BM;


    private Handler customHandler = new Handler();

    //----------------------------------------------------------------------


    public cristal() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_cristal, container, false);



        Moliendo = v.findViewById(R.id.imageMoliendo);
        Paro = v.findViewById(R.id.imageParo);

        DIAZAF = (TextView)v.findViewById(R.id.DIAZAF);
        SACDIA = (TextView)v.findViewById(R.id.SACDIA);
        SACZAF = (TextView)v.findViewById(R.id.SACZAF);

        NIVTA1= (TextView)v.findViewById(R.id.NIVTA1);
        NIVTA2= (TextView)v.findViewById(R.id.NIVTA2);
        NIVTA3= (TextView)v.findViewById(R.id.NIVTA3);
        NIVTA4= (TextView)v.findViewById(R.id.NIVTA4);
        NIVTA5= (TextView)v.findViewById(R.id.NIVTA5);
        NIVTA6= (TextView)v.findViewById(R.id.NIVTA6);
        NIVTA7= (TextView)v.findViewById(R.id.NIVTA7);
        BRIXT1= (TextView)v.findViewById(R.id.BRIXT1);
        BRIXT2= (TextView)v.findViewById(R.id.BRIXT2);
        BRIXT3= (TextView)v.findViewById(R.id.BRIXT3);
        BRIXT4= (TextView)v.findViewById(R.id.BRIXT4);
        BRIXT5= (TextView)v.findViewById(R.id.BRIXT5);
        BRIXT6= (TextView)v.findViewById(R.id.BRIXT6);
        BRIXT7= (TextView)v.findViewById(R.id.BRIXT7);
        VACTA1= (TextView)v.findViewById(R.id.VACTA1);
        VACTA2= (TextView)v.findViewById(R.id.VACTA2);
        VACTA3= (TextView)v.findViewById(R.id.VACTA3);
        VACTA4= (TextView)v.findViewById(R.id.VACTA4);
        VACTA5= (TextView)v.findViewById(R.id.VACTA5);
        VACTA6= (TextView)v.findViewById(R.id.VACTA6);
        VACTA7= (TextView)v.findViewById(R.id.VACTA7);
        NIVTQA= (TextView)v.findViewById(R.id.NIVTQA);
        SACPRE= (TextView)v.findViewById(R.id.SACPRE);
        SACVAN= (TextView)v.findViewById(R.id.SACVAN);
        TEMPAZ= (TextView)v.findViewById(R.id.TEMPAZ);
        VITAKG= (TextView)v.findViewById(R.id.VITAKG);
        MELTQ1= (TextView)v.findViewById(R.id.MELTQ1);
        MELTQ2= (TextView)v.findViewById(R.id.MELTQ2);
        TEMMEL= (TextView)v.findViewById(R.id.TEMMEL);

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
                SACDIA.setText(formatter.format(funciones.Val1[ 66]) + " ");
                SACZAF.setText(formatter.format(funciones.Val1[ 67]) + " ");

                NIVTA1.setText(formatter.format(funciones.Val4[ 27]) + " ");
                NIVTA2.setText(formatter.format(funciones.Val4[ 31]) + " ");
                NIVTA3.setText(formatter.format(funciones.Val4[ 35]) + " ");
                NIVTA4.setText(formatter.format(funciones.Val4[ 39]) + " ");
                NIVTA5.setText(formatter.format(funciones.Val4[ 43]) + " ");
                NIVTA6.setText(formatter.format(funciones.Val4[ 47]) + " ");
                NIVTA7.setText(formatter.format(funciones.Val4[ 51]) + " ");
                BRIXT1.setText(formatter.format(funciones.Val4[ 26]) + " ");
                BRIXT2.setText(formatter.format(funciones.Val4[ 30]) + " ");
                BRIXT3.setText(formatter.format(funciones.Val4[ 34]) + " ");
                BRIXT4.setText(formatter.format(funciones.Val4[ 38]) + " ");
                BRIXT5.setText(formatter.format(funciones.Val4[ 42]) + " ");
                BRIXT6.setText(formatter.format(funciones.Val4[ 46]) + " ");
                BRIXT7.setText(formatter.format(funciones.Val4[ 50]) + " ");
                VACTA1.setText(formatter.format(funciones.Val4[ 29]) + " ");
                VACTA2.setText(formatter.format(funciones.Val4[ 33]) + " ");
                VACTA3.setText(formatter.format(funciones.Val4[ 37]) + " ");
                VACTA4.setText(formatter.format(funciones.Val4[ 41]) + " ");
                VACTA5.setText(formatter.format(funciones.Val4[ 45]) + " ");
                VACTA6.setText(formatter.format(funciones.Val4[ 49]) + " ");
                VACTA7.setText(formatter.format(funciones.Val4[ 53]) + " ");
                NIVTQA.setText(formatter.format(funciones.Val4[ 63]) + " ");
                SACPRE.setText(formatter.format(funciones.Val2[104]) + " ");
                SACVAN.setText(formatter.format(funciones.Val2[103]) + " ");
                TEMPAZ.setText(formatter.format(funciones.Val2[ 49]) + " ");
                VITAKG.setText(formatter.format(funciones.Val3[ 64]) + " ");
                MELTQ1.setText(formatter.format(funciones.Val2[101]) + " ");
                MELTQ2.setText(formatter.format(funciones.Val2[102]) + " ");
                TEMMEL.setText(formatter.format(funciones.Val3[ 43]) + " ");



                DIAZAF.setTextColor(Color.parseColor(funciones.Color1[ 64]));
                SACDIA.setTextColor(Color.parseColor(funciones.Color3[ 66]));
                SACZAF.setTextColor(Color.parseColor(funciones.Color3[ 67]));

                NIVTA1.setTextColor(Color.parseColor(funciones.Color4[ 27]));
                NIVTA2.setTextColor(Color.parseColor(funciones.Color4[ 31]));
                NIVTA3.setTextColor(Color.parseColor(funciones.Color4[ 35]));
                NIVTA4.setTextColor(Color.parseColor(funciones.Color4[ 39]));
                NIVTA5.setTextColor(Color.parseColor(funciones.Color4[ 43]));
                NIVTA6.setTextColor(Color.parseColor(funciones.Color4[ 47]));
                NIVTA7.setTextColor(Color.parseColor(funciones.Color4[ 51]));
                BRIXT1.setTextColor(Color.parseColor(funciones.Color4[ 26]));
                BRIXT2.setTextColor(Color.parseColor(funciones.Color4[ 30]));
                BRIXT3.setTextColor(Color.parseColor(funciones.Color4[ 34]));
                BRIXT4.setTextColor(Color.parseColor(funciones.Color4[ 38]));
                BRIXT5.setTextColor(Color.parseColor(funciones.Color4[ 42]));
                BRIXT6.setTextColor(Color.parseColor(funciones.Color4[ 46]));
                BRIXT7.setTextColor(Color.parseColor(funciones.Color4[ 50]));
                VACTA1.setTextColor(Color.parseColor(funciones.Color4[ 29]));
                VACTA2.setTextColor(Color.parseColor(funciones.Color4[ 33]));
                VACTA3.setTextColor(Color.parseColor(funciones.Color4[ 37]));
                VACTA4.setTextColor(Color.parseColor(funciones.Color4[ 41]));
                VACTA5.setTextColor(Color.parseColor(funciones.Color4[ 45]));
                VACTA6.setTextColor(Color.parseColor(funciones.Color4[ 49]));
                VACTA7.setTextColor(Color.parseColor(funciones.Color4[ 53]));
                NIVTQA.setTextColor(Color.parseColor(funciones.Color4[ 63]));
                SACPRE.setTextColor(Color.parseColor(funciones.Color2[104]));
                SACVAN.setTextColor(Color.parseColor(funciones.Color2[103]));
                TEMPAZ.setTextColor(Color.parseColor(funciones.Color2[ 49]));
                VITAKG.setTextColor(Color.parseColor(funciones.Color3[ 64]));
                MELTQ1.setTextColor(Color.parseColor(funciones.Color2[101]));
                MELTQ2.setTextColor(Color.parseColor(funciones.Color2[102]));
                TEMMEL.setTextColor(Color.parseColor(funciones.Color3[ 43]));

                //  }
            }
            customHandler.postDelayed(this, 500);

        }

    };
}
