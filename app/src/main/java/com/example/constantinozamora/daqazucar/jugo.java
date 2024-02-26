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

public class jugo extends Fragment {

    //----------------------------------------------------------------------
    ImageView Moliendo,Paro;

    TextView FLUJME;
    TextView FLUJPU;
    TextView FLUJAL;
    TextView FLUMEL;
    TextView FLUCLA;
    TextView NIVJME;
    TextView NIVJPU;
    TextView NIVJAL;
    TextView NIVCLA;
    TextView NIVMEL;
    TextView PHJUGP;
    TextView PHJUGA;
    TextView BRIXME;
    TextView PREESF;
    TextView TSALC1;
    TextView TSALC2;
    TextView TSALC3;
    TextView TJUGAL;
    TextView PREEV1;
    TextView PREEV2;
    TextView PREEV3;
    TextView PREEV4;
    TextView PREEV5;
    TextView PREEV6;
    TextView PREEV7;
    TextView PREEV8;
    TextView TEVEV1;
    TextView TEVEV2;
    TextView TEVEV3;
    TextView TEVEV4;
    TextView TEVEV5;
    TextView TEVEV6;
    TextView TEVEV7;
    TextView TEVEV8;
    TextView NIVEV1;
    TextView NIVEV2;
    TextView NIVEV3;
    TextView NIVEV4;
    TextView NIVEV5;
    TextView NIVEV6;
    TextView NIVEV7;
    TextView NIVEV8;
    TextView TEJEV1;
    TextView TEJEV2;
    TextView TEJEV3;
    TextView TEJEV4;
    TextView TEJEV5;
    TextView TEJEV6;
    TextView TEJEV7;
    TextView TEJEV8;


    //  Button BM;


    private Handler customHandler = new Handler();

    //----------------------------------------------------------------------


    public jugo() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_jugo, container, false);



        Moliendo = v.findViewById(R.id.imageMoliendo);
        Paro = v.findViewById(R.id.imageParo);

        FLUJME = (TextView)v.findViewById(R.id.FLUJME);
        FLUJPU = (TextView)v.findViewById(R.id.FLUJPU);
        FLUJAL = (TextView)v.findViewById(R.id.FLUJAL);
        FLUMEL = (TextView)v.findViewById(R.id.FLUMEL);
        FLUCLA = (TextView)v.findViewById(R.id.FLUCLA);
        NIVJME = (TextView)v.findViewById(R.id.NIVJME);
        NIVJPU = (TextView)v.findViewById(R.id.NIVJPU);
        NIVJAL = (TextView)v.findViewById(R.id.NIVJAL);
        NIVCLA = (TextView)v.findViewById(R.id.NIVCLA);
        NIVMEL = (TextView)v.findViewById(R.id.NIVMEL);
        PHJUGP = (TextView)v.findViewById(R.id.PHJUGP);
        PHJUGA = (TextView)v.findViewById(R.id.PHJUGA);
        BRIXME = (TextView)v.findViewById(R.id.BRIXME);
        PREESF = (TextView)v.findViewById(R.id.PREESF);
        TSALC1 = (TextView)v.findViewById(R.id.TSALC1);
        TSALC2 = (TextView)v.findViewById(R.id.TSALC2);
        TSALC3 = (TextView)v.findViewById(R.id.TSALC3);
        TJUGAL = (TextView)v.findViewById(R.id.TJUGAL);
        PREEV1 = (TextView)v.findViewById(R.id.PREEV1);
        PREEV2 = (TextView)v.findViewById(R.id.PREEV2);
        PREEV3 = (TextView)v.findViewById(R.id.PREEV3);
        PREEV4 = (TextView)v.findViewById(R.id.PREEV4);
        PREEV5 = (TextView)v.findViewById(R.id.PREEV5);
        PREEV6 = (TextView)v.findViewById(R.id.PREEV6);
        PREEV7 = (TextView)v.findViewById(R.id.PREEV7);
        PREEV8 = (TextView)v.findViewById(R.id.PREEV8);
        TEVEV1 = (TextView)v.findViewById(R.id.TEVEV1);
        TEVEV2 = (TextView)v.findViewById(R.id.TEVEV2);
        TEVEV3 = (TextView)v.findViewById(R.id.TEVEV3);
        TEVEV4 = (TextView)v.findViewById(R.id.TEVEV4);
        TEVEV5 = (TextView)v.findViewById(R.id.TEVEV5);
        TEVEV6 = (TextView)v.findViewById(R.id.TEVEV6);
        TEVEV7 = (TextView)v.findViewById(R.id.TEVEV7);
        TEVEV8 = (TextView)v.findViewById(R.id.TEVEV8);
        NIVEV1 = (TextView)v.findViewById(R.id.NIVEV1);
        NIVEV2 = (TextView)v.findViewById(R.id.NIVEV2);
        NIVEV3 = (TextView)v.findViewById(R.id.NIVEV3);
        NIVEV4 = (TextView)v.findViewById(R.id.NIVEV4);
        NIVEV5 = (TextView)v.findViewById(R.id.NIVEV5);
        NIVEV6 = (TextView)v.findViewById(R.id.NIVEV6);
        NIVEV7 = (TextView)v.findViewById(R.id.NIVEV7);
        NIVEV8 = (TextView)v.findViewById(R.id.NIVEV8);
        TEJEV1 = (TextView)v.findViewById(R.id.TEJEV1);
        TEJEV2 = (TextView)v.findViewById(R.id.TEJEV2);
        TEJEV3 = (TextView)v.findViewById(R.id.TEJEV3);
        TEJEV4 = (TextView)v.findViewById(R.id.TEJEV4);
        TEJEV5 = (TextView)v.findViewById(R.id.TEJEV5);
        TEJEV6 = (TextView)v.findViewById(R.id.TEJEV6);
        TEJEV7 = (TextView)v.findViewById(R.id.TEJEV7);
        TEJEV8 = (TextView)v.findViewById(R.id.TEJEV8);

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

                Double VoltPromTGM= (funciones.Val3[97]+funciones.Val3[98]+funciones.Val3[99])/3*1000;
                Double VoltPromEXP= (funciones.Val3[108]+funciones.Val3[109]+funciones.Val3[110])/3*1000;


                FLUJME.setText(formatter.format(funciones.Val1[ 92]) + " ");
                FLUJPU.setText(formatter.format(funciones.Val3[  6]) + " ");
                FLUJAL.setText(formatter.format(funciones.Val2[ 35]) + " ");
                FLUMEL.setText(formatter.format(funciones.Val3[ 38]) + " ");
                FLUCLA.setText(formatter.format(funciones.Val1[ 24]) + " ");
                NIVJME.setText(formatter.format(funciones.Val1[ 22]) + " ");
                NIVJPU.setText(formatter.format(funciones.Val3[  1]) + " ");
                NIVJAL.setText(formatter.format(funciones.Val2[ 34]) + " ");
                NIVCLA.setText(formatter.format(funciones.Val1[ 15]) + " ");
                NIVMEL.setText(formatter.format(funciones.Val3[ 27]) + " ");
                PHJUGP.setText(formatter.format(funciones.Val3[  5]) + " ");
                PHJUGA.setText(formatter.format(funciones.Val2[ 61]) + " ");
                BRIXME.setText(formatter.format(funciones.Val1[ 17]) + " ");
                PREESF.setText(formatter.format(funciones.Val1[ 97]) + " ");
                TSALC1.setText(formatter.format(funciones.Val3[121]) + " ");
                TSALC2.setText(formatter.format(funciones.Val3[122]) + " ");
                TSALC3.setText(formatter.format(funciones.Val3[123]) + " ");
                TJUGAL.setText(formatter.format(funciones.Val2[ 10]) + " ");
                PREEV1.setText(formatter.format(funciones.Val1[112]) + " ");
                PREEV2.setText(formatter.format(funciones.Val1[ 83]) + " ");
                PREEV3.setText(formatter.format(funciones.Val1[ 84]) + " ");
                PREEV4.setText(formatter.format(funciones.Val1[ 85]) + " ");
                PREEV5.setText(formatter.format(funciones.Val3[ 21]) + " ");
                PREEV6.setText(formatter.format(funciones.Val4[ 64]) + " ");
                PREEV7.setText(formatter.format(funciones.Val4[ 65]) + " ");
                PREEV8.setText(formatter.format(funciones.Val4[ 66]) + " ");
                TEVEV1.setText(formatter.format(funciones.Val3[ 13]) + " ");
                TEVEV2.setText(formatter.format(funciones.Val3[ 14]) + " ");
                TEVEV3.setText(formatter.format(funciones.Val3[ 15]) + " ");
                TEVEV4.setText(formatter.format(funciones.Val3[ 16]) + " ");
                TEVEV5.setText(formatter.format(funciones.Val3[ 17]) + " ");
                TEVEV6.setText(formatter.format(funciones.Val3[ 18]) + " ");
                TEVEV7.setText(formatter.format(funciones.Val3[ 19]) + " ");
                TEVEV8.setText(formatter.format(funciones.Val3[ 20]) + " ");
                NIVEV1.setText(formatter.format(funciones.Val1[123]) + " ");
                NIVEV2.setText(formatter.format(funciones.Val1[ 73]) + " ");
                NIVEV3.setText(formatter.format(funciones.Val1[ 74]) + " ");
                NIVEV4.setText(formatter.format(funciones.Val1[ 75]) + " ");
                NIVEV5.setText(formatter.format(funciones.Val1[ 76]) + " ");
                NIVEV6.setText(formatter.format(funciones.Val1[ 77]) + " ");
                NIVEV7.setText(formatter.format(funciones.Val1[ 78]) + " ");
                NIVEV8.setText(formatter.format(funciones.Val1[ 79]) + " ");
                TEJEV1.setText(formatter.format(funciones.Val1[113]) + " ");
                TEJEV2.setText(formatter.format(funciones.Val1[ 86]) + " ");
                TEJEV3.setText(formatter.format(funciones.Val1[ 87]) + " ");
                TEJEV4.setText(formatter.format(funciones.Val1[ 88]) + " ");
                TEJEV5.setText(formatter.format(funciones.Val3[ 26]) + " ");
                TEJEV6.setText(formatter.format(funciones.Val3[ 22]) + " ");
                TEJEV7.setText(formatter.format(funciones.Val3[ 23]) + " ");
                TEJEV8.setText(formatter.format(funciones.Val3[ 24]) + " ");




                FLUJME.setTextColor(Color.parseColor(funciones.Color1[ 92]));
                FLUJPU.setTextColor(Color.parseColor(funciones.Color3[  6]));
                FLUJAL.setTextColor(Color.parseColor(funciones.Color2[ 35]));
                FLUMEL.setTextColor(Color.parseColor(funciones.Color3[ 38]));
                FLUCLA.setTextColor(Color.parseColor(funciones.Color1[ 24]));
                NIVJME.setTextColor(Color.parseColor(funciones.Color1[ 22]));
                NIVJPU.setTextColor(Color.parseColor(funciones.Color3[  1]));
                NIVJAL.setTextColor(Color.parseColor(funciones.Color2[ 34]));
                NIVCLA.setTextColor(Color.parseColor(funciones.Color1[ 15]));
                NIVMEL.setTextColor(Color.parseColor(funciones.Color3[ 27]));
                PHJUGP.setTextColor(Color.parseColor(funciones.Color3[  5]));
                PHJUGA.setTextColor(Color.parseColor(funciones.Color2[ 61]));
                BRIXME.setTextColor(Color.parseColor(funciones.Color1[ 17]));
                PREESF.setTextColor(Color.parseColor(funciones.Color1[ 97]));
                TSALC1.setTextColor(Color.parseColor(funciones.Color3[121]));
                TSALC2.setTextColor(Color.parseColor(funciones.Color3[122]));
                TSALC3.setTextColor(Color.parseColor(funciones.Color3[123]));
                TJUGAL.setTextColor(Color.parseColor(funciones.Color2[ 10]));
                PREEV1.setTextColor(Color.parseColor(funciones.Color1[112]));
                PREEV2.setTextColor(Color.parseColor(funciones.Color1[ 83]));
                PREEV3.setTextColor(Color.parseColor(funciones.Color1[ 84]));
                PREEV4.setTextColor(Color.parseColor(funciones.Color1[ 85]));
                PREEV5.setTextColor(Color.parseColor(funciones.Color3[ 21]));
                PREEV6.setTextColor(Color.parseColor(funciones.Color4[ 64]));
                PREEV7.setTextColor(Color.parseColor(funciones.Color4[ 65]));
                PREEV8.setTextColor(Color.parseColor(funciones.Color4[ 66]));
                TEVEV1.setTextColor(Color.parseColor(funciones.Color3[ 13]));
                TEVEV2.setTextColor(Color.parseColor(funciones.Color3[ 14]));
                TEVEV3.setTextColor(Color.parseColor(funciones.Color3[ 15]));
                TEVEV4.setTextColor(Color.parseColor(funciones.Color3[ 16]));
                TEVEV5.setTextColor(Color.parseColor(funciones.Color3[ 17]));
                TEVEV6.setTextColor(Color.parseColor(funciones.Color3[ 18]));
                TEVEV7.setTextColor(Color.parseColor(funciones.Color3[ 19]));
                TEVEV8.setTextColor(Color.parseColor(funciones.Color3[ 20]));
                NIVEV1.setTextColor(Color.parseColor(funciones.Color1[123]));
                NIVEV2.setTextColor(Color.parseColor(funciones.Color1[ 73]));
                NIVEV3.setTextColor(Color.parseColor(funciones.Color1[ 74]));
                NIVEV4.setTextColor(Color.parseColor(funciones.Color1[ 75]));
                NIVEV5.setTextColor(Color.parseColor(funciones.Color1[ 76]));
                NIVEV6.setTextColor(Color.parseColor(funciones.Color1[ 77]));
                NIVEV7.setTextColor(Color.parseColor(funciones.Color1[ 78]));
                NIVEV8.setTextColor(Color.parseColor(funciones.Color1[ 79]));
                TEJEV1.setTextColor(Color.parseColor(funciones.Color1[113]));
                TEJEV2.setTextColor(Color.parseColor(funciones.Color1[ 86]));
                TEJEV3.setTextColor(Color.parseColor(funciones.Color1[ 87]));
                TEJEV4.setTextColor(Color.parseColor(funciones.Color1[ 88]));
                TEJEV5.setTextColor(Color.parseColor(funciones.Color3[ 26]));
                TEJEV6.setTextColor(Color.parseColor(funciones.Color3[ 22]));
                TEJEV7.setTextColor(Color.parseColor(funciones.Color3[ 23]));
                TEJEV8.setTextColor(Color.parseColor(funciones.Color3[ 24]));

                //  }
            }
            customHandler.postDelayed(this, 500);

        }

    };
}
