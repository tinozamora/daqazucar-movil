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

public class gel extends Fragment {

    //----------------------------------------------------------------------
    ImageView Moliendo,Paro;

    TextView PRESC2;
    TextView TEMPC2;
    TextView FLUJC2;
    TextView PRESMI;
    TextView TEMPMI;
    TextView FLUJMI;
    TextView POTENG;
    TextView VOLTNG;
    TextView FACTNG;
    TextView POTTGM;
    TextView VOLTGM;
    TextView FACTGM;
    TextView POTEXP;
    TextView VOLEXP;
    TextView FACEXP;
    TextView FLUETG;
    TextView PREESC;
    TextView NIVTC3;
    TextView NIVTC4;
    //  Button BM;


    private Handler customHandler = new Handler();

    //----------------------------------------------------------------------


    public gel() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_gel, container, false);



        Moliendo = v.findViewById(R.id.imageMoliendo);
        Paro = v.findViewById(R.id.imageParo);

        PRESC2 = (TextView)v.findViewById(R.id.PRESC2);
        TEMPC2 = (TextView)v.findViewById(R.id.TEMPC2);
        FLUJC2 = (TextView)v.findViewById(R.id.FLUJC2);
        PRESMI = (TextView)v.findViewById(R.id.PRESMI);
        TEMPMI = (TextView)v.findViewById(R.id.TEMPMI);
        FLUJMI = (TextView)v.findViewById(R.id.FLUJMI);
        POTENG = (TextView)v.findViewById(R.id.POTENG);
        VOLTNG = (TextView)v.findViewById(R.id.VOLTNG);
        FACTNG = (TextView)v.findViewById(R.id.FACTNG);
        POTTGM = (TextView)v.findViewById(R.id.POTTGM);
        VOLTGM = (TextView)v.findViewById(R.id.VOLTGM);
        FACTGM = (TextView)v.findViewById(R.id.FACTGM);
        POTEXP = (TextView)v.findViewById(R.id.POTEXP);
        VOLEXP = (TextView)v.findViewById(R.id.VOLEXP);
        FACEXP = (TextView)v.findViewById(R.id.FACEXP);
        FLUETG = (TextView)v.findViewById(R.id.FLUETG);
        PREESC = (TextView)v.findViewById(R.id.PREESC);
        NIVTC3 = (TextView)v.findViewById(R.id.NIVTC3);
        NIVTC4 = (TextView)v.findViewById(R.id.NIVTC4);

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


                PRESC2.setText(formatter.format(funciones.Val1[ 34]) + " ");
                TEMPC2.setText(formatter.format(funciones.Val1[ 39]) + " ");
                FLUJC2.setText(formatter.format(funciones.Val1[ 44]) + " ");
                PRESMI.setText(formatter.format(funciones.Val3[ 79]) + " ");
                TEMPMI.setText(formatter.format(funciones.Val3[ 82]) + " ");
                FLUJMI.setText(formatter.format(funciones.Val3[114]) + " ");
                POTENG.setText(formatter.format(funciones.Val1[ 69]) + " ");
                VOLTNG.setText(formatter.format(funciones.Val1[ 72]) + " ");
                FACTNG.setText(formatter.format(funciones.Val1[ 68]) + " ");
                POTTGM.setText(formatter.format(funciones.Val3[ 95]) + " ");
                VOLTGM.setText(formatter.format(VoltPromTGM) + " ");
                FACTGM.setText(formatter.format(funciones.Val3[ 92]) + " ");
                POTEXP.setText(formatter.format(funciones.Val3[106]) + " ");
                VOLEXP.setText(formatter.format(VoltPromEXP) + " ");
                FACEXP.setText(formatter.format(funciones.Val3[103]) + " ");
                FLUETG.setText(formatter.format(funciones.Val3[ 75]) + " ");
                PREESC.setText(formatter.format(funciones.Val1[ 97]) + " ");
                NIVTC3.setText(formatter.format(funciones.Val4[125]) + " ");
                NIVTC4.setText(formatter.format(funciones.Val4[126]) + " ");

                PRESC2.setTextColor(Color.parseColor(funciones.Color1[ 34]));
                TEMPC2.setTextColor(Color.parseColor(funciones.Color1[ 39]));
                FLUJC2.setTextColor(Color.parseColor(funciones.Color1[ 44]));
                PRESMI.setTextColor(Color.parseColor(funciones.Color3[ 79]));
                TEMPMI.setTextColor(Color.parseColor(funciones.Color3[ 82]));
                FLUJMI.setTextColor(Color.parseColor(funciones.Color3[114]));
                POTENG.setTextColor(Color.parseColor(funciones.Color1[ 69]));
                VOLTNG.setTextColor(Color.parseColor(funciones.Color1[ 72]));
                FACTNG.setTextColor(Color.parseColor(funciones.Color1[ 68]));
                POTTGM.setTextColor(Color.parseColor(funciones.Color3[ 95]));
                VOLTGM.setTextColor(Color.parseColor(funciones.Color3[ 97]));
                FACTGM.setTextColor(Color.parseColor(funciones.Color3[ 92]));
                POTEXP.setTextColor(Color.parseColor(funciones.Color3[106]));
                VOLEXP.setTextColor(Color.parseColor(funciones.Color3[108]));
                FACEXP.setTextColor(Color.parseColor(funciones.Color3[103]));
                FLUETG.setTextColor(Color.parseColor(funciones.Color3[ 75]));
                PREESC.setTextColor(Color.parseColor(funciones.Color1[ 97]));
                NIVTC3.setTextColor(Color.parseColor(funciones.Color4[125]));
                NIVTC4.setTextColor(Color.parseColor(funciones.Color4[126]));

                //  }
            }
            customHandler.postDelayed(this, 500);

        }

    };
}
