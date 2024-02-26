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

public class extraccion extends Fragment {


    //----------------------------------------------------------------------
    ImageView Moliendo,Paro;
    TextView diaZ,TIPDIA, Ritmo,Peso,Velocidad,Temp,Flu;
    TextView R1,R2,R3,R4,R5,FLUMEZ;
    TextView FLOTR1, FLOTR2,FLOTR3,FLOTR4,FLOTR5,FLOTL1,FLOTL2,FLOTL3,FLOTL4,FLOTL5;
    TextView PRESR1, PRESR2,PRESR3,PRESR4,PRESR5,PRESL1,PRESL2,PRESL3,PRESL4,PRESL5;
    TextView NIVELM1,NIVELM2,NIVELM3,NIVELM4,NIVELM5;
    TextView RPMPRE1,AMPPRE1,RPMPICA,AMPPICA,RPMDESF,AMPDESF;
    TextView TORQM1,TORQM2,TORQM3,TORQM4,TORQM5;
    TextView CORRM1,CORRM2,CORRM3,CORRM4,CORRM5;

    //  Button BM;


    private Handler customHandler = new Handler();

    //----------------------------------------------------------------------


    public extraccion() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View v = inflater.inflate(R.layout.fragment_extraccion, container, false);



        Moliendo = v.findViewById(R.id.imageMoliendo);
        Paro = v.findViewById(R.id.imageParo);

        diaZ = (TextView)v.findViewById(R.id.V1);
        TIPDIA = (TextView)v.findViewById(R.id.TIPDIA);
        Ritmo = (TextView)v.findViewById(R.id.V2);
        Peso = (TextView)v.findViewById(R.id.V3);
        Velocidad = (TextView)v.findViewById(R.id.V4);
        Temp = (TextView)v.findViewById(R.id.V5);
        Flu = (TextView)v.findViewById(R.id.V6);

        R1 = (TextView)v.findViewById(R.id.RPM1);
        R2 = (TextView)v.findViewById(R.id.RPM2);
        R3 = (TextView)v.findViewById(R.id.RPM3);
        R4 = (TextView)v.findViewById(R.id.RPM4);
        R5 = (TextView)v.findViewById(R.id.RPM5);
        FLUMEZ = (TextView)v.findViewById(R.id.FLUMEZ);

        FLOTR1 = (TextView)v.findViewById(R.id.FLOTR1);
        FLOTR2 = (TextView)v.findViewById(R.id.FLOTR2);
        FLOTR3 = (TextView)v.findViewById(R.id.FLOTR3);
        FLOTR4 = (TextView)v.findViewById(R.id.FLOTR4);
        FLOTR5 = (TextView)v.findViewById(R.id.FLOTR5);
        FLOTL1 = (TextView)v.findViewById(R.id.FLOTL1);
        FLOTL2 = (TextView)v.findViewById(R.id.FLOTL2);
        FLOTL3 = (TextView)v.findViewById(R.id.FLOTL3);
        FLOTL4 = (TextView)v.findViewById(R.id.FLOTL4);
        FLOTL5 = (TextView)v.findViewById(R.id.FLOTL5);

        PRESR1 = (TextView)v.findViewById(R.id.PRESR1);
        PRESR2 = (TextView)v.findViewById(R.id.PRESR2);
        PRESR3 = (TextView)v.findViewById(R.id.PRESR3);
        PRESR4 = (TextView)v.findViewById(R.id.PRESR4);
        PRESR5 = (TextView)v.findViewById(R.id.PRESR5);

        PRESL1 = (TextView)v.findViewById(R.id.PRESL1);
        PRESL2 = (TextView)v.findViewById(R.id.PRESL2);
        PRESL3 = (TextView)v.findViewById(R.id.PRESL3);
        PRESL4 = (TextView)v.findViewById(R.id.PRESL4);
        PRESL5 = (TextView)v.findViewById(R.id.PRESL5);

        NIVELM1 = (TextView)v.findViewById(R.id.NIVELM1);
        NIVELM2 = (TextView)v.findViewById(R.id.NIVELM2);
        NIVELM3 = (TextView)v.findViewById(R.id.NIVELM3);
        NIVELM4 = (TextView)v.findViewById(R.id.NIVELM4);
        NIVELM5 = (TextView)v.findViewById(R.id.NIVELM5);

       RPMPRE1 = (TextView)v.findViewById(R.id.RPMPRE1);
       AMPPRE1 = (TextView)v.findViewById(R.id.AMPPRE1);
       RPMPICA = (TextView)v.findViewById(R.id.RPMPICA);
       AMPPICA = (TextView)v.findViewById(R.id.AMPPICA);
       RPMDESF = (TextView)v.findViewById(R.id.RPMDESF);
       AMPDESF = (TextView)v.findViewById(R.id.AMPDESF);

       TORQM1 = (TextView)v.findViewById(R.id.TORQM1);
       TORQM2 = (TextView)v.findViewById(R.id.TORQM2);
       TORQM3 = (TextView)v.findViewById(R.id.TORQM3);
       TORQM4 = (TextView)v.findViewById(R.id.TORQM4);
       TORQM5 = (TextView)v.findViewById(R.id.TORQM5);

       CORRM1 = (TextView)v.findViewById(R.id.CORRM1);
       CORRM2 = (TextView)v.findViewById(R.id.CORRM2);
       CORRM3 = (TextView)v.findViewById(R.id.CORRM3);
       CORRM4 = (TextView)v.findViewById(R.id.CORRM4);
       CORRM5 = (TextView)v.findViewById(R.id.CORRM5);



        //   BM=(Button)v.findViewById(R.id.buttonM);
     //   BM.setOnClickListener(new View.OnClickListener() {
     //       @Override
     //       public void onClick(View view) {
     //           customHandler.postDelayed(updateTimerThread, 0);
     //       }
     //   });
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
                  diaZ.setText(enteros.format(funciones.Val1[64]) + " ");
                  TIPDIA.setText(formatter.format(funciones.Val1[117]) + " ");
                  Ritmo.setText(formatter.format(funciones.Val1[102]) + " ");
                  Peso.setText(formatter.format(funciones.Val1[101]) + " ");
                  Velocidad.setText(formatter.format(funciones.Val1[100]) + " ");
                  Temp.setText(formatter.format(funciones.Val1[10]) + " ");
                  //Temp.setTextColor(Color.parseColor("#FFCD0B0B"));


                  Flu.setText(formatter.format(funciones.Val1[11]) + " ");

                  R1.setText(formatter.format(funciones.Val1[3]) + " ");
                  R2.setText(formatter.format(funciones.Val1[4]) + " ");
                  R3.setText(formatter.format(funciones.Val1[52]) + " ");
                  R4.setText(formatter.format(funciones.Val1[6]) + " ");
                  R5.setText(formatter.format(funciones.Val1[7]) + " ");
                  FLUMEZ.setText(formatter.format(funciones.Val1[92]) + " ");

                  FLOTR1.setText(formatter.format(funciones.Val3[48]) + " ");
                  FLOTR2.setText(formatter.format(funciones.Val3[49]) + " ");
                  FLOTR3.setText(formatter.format(funciones.Val3[50]) + " ");
                  FLOTR4.setText(formatter.format(funciones.Val3[51]) + " ");
                  FLOTR5.setText(formatter.format(funciones.Val3[52]) + " ");
                  FLOTL1.setText(formatter.format(funciones.Val3[53]) + " ");
                  FLOTL2.setText(formatter.format(funciones.Val3[54]) + " ");
                  FLOTL3.setText(formatter.format(funciones.Val3[55]) + " ");
                  FLOTL4.setText(formatter.format(funciones.Val3[56]) + " ");
                  FLOTL5.setText(formatter.format(funciones.Val3[57]) + " ");

                  PRESR1.setText(formatter.format(funciones.Val4[71]) + " ");
                  PRESR2.setText(formatter.format(funciones.Val4[73]) + " ");
                  PRESR3.setText(formatter.format(funciones.Val4[75]) + " ");
                  PRESR4.setText(formatter.format(funciones.Val4[77]) + " ");
                  PRESR5.setText(formatter.format(funciones.Val4[79]) + " ");
                  PRESL1.setText(formatter.format(funciones.Val4[72]) + " ");
                  PRESL2.setText(formatter.format(funciones.Val4[74]) + " ");
                  PRESL3.setText(formatter.format(funciones.Val4[76]) + " ");
                  PRESL4.setText(formatter.format(funciones.Val4[78]) + " ");
                  PRESL5.setText(formatter.format(funciones.Val4[80]) + " ");

                  NIVELM1.setText(formatter.format(funciones.Val1[8]) + " ");
                  NIVELM2.setText(formatter.format(funciones.Val1[19]) + " ");
                  NIVELM3.setText(formatter.format(funciones.Val1[20]) + " ");
                  NIVELM4.setText(formatter.format(funciones.Val1[21]) + " ");
                  NIVELM5.setText(formatter.format(funciones.Val1[9]) + " ");

                  RPMPRE1.setText(formatter.format(funciones.Val1[5]) + " ");
                  AMPPRE1.setText(formatter.format(funciones.Val3[116]) + " ");
                  RPMPICA.setText(formatter.format(funciones.Val1[119]) + " ");
                  AMPPICA.setText(formatter.format(funciones.Val3[118]) + " ");
                  RPMDESF.setText(formatter.format(funciones.Val1[16]) + " ");
                  AMPDESF.setText(formatter.format(funciones.Val3[119]) + " ");

                  TORQM1.setText(formatter.format(funciones.Val3[67]) + " ");
                  TORQM2.setText(formatter.format(funciones.Val3[68]) + " ");
                  TORQM3.setText(formatter.format(funciones.Val3[69]) + " ");
                  TORQM4.setText(formatter.format(funciones.Val3[70]) + " ");
                  TORQM5.setText(formatter.format(funciones.Val3[71]) + " ");

                  CORRM1.setText(formatter.format(funciones.Val3[58]) + " ");
                  CORRM2.setText(formatter.format(funciones.Val3[59]) + " ");
                  CORRM3.setText(formatter.format(funciones.Val3[60]) + " ");
                  CORRM4.setText(formatter.format(funciones.Val3[61]) + " ");
                  CORRM5.setText(formatter.format(funciones.Val3[62]) + " ");



                  diaZ.setTextColor(Color.parseColor(funciones.Color1[64]));
                  TIPDIA.setTextColor(Color.parseColor(funciones.Color1[117]));
                  Ritmo.setTextColor(Color.parseColor(funciones.Color1[102]));
                  Peso.setTextColor(Color.parseColor(funciones.Color1[101]));
                  Velocidad.setTextColor(Color.parseColor(funciones.Color1[100]));
                  Temp.setTextColor(Color.parseColor(funciones.Color1[10]));
                  Flu.setTextColor(Color.parseColor(funciones.Color1[11]));
                  FLUMEZ.setTextColor(Color.parseColor(funciones.Color1[92]));

                  R1.setTextColor(Color.parseColor(funciones.Color1[3]));
                  R2.setTextColor(Color.parseColor(funciones.Color1[4]));
                  R3.setTextColor(Color.parseColor(funciones.Color1[52]));
                  R4.setTextColor(Color.parseColor(funciones.Color1[6]));
                  R5.setTextColor(Color.parseColor(funciones.Color1[7]));

                  FLOTR1.setTextColor(Color.parseColor(funciones.Color3[48]));
                  FLOTR2.setTextColor(Color.parseColor(funciones.Color3[49]));
                  FLOTR3.setTextColor(Color.parseColor(funciones.Color3[50]));
                  FLOTR4.setTextColor(Color.parseColor(funciones.Color3[51]));
                  FLOTR5.setTextColor(Color.parseColor(funciones.Color3[52]));
                  FLOTL1.setTextColor(Color.parseColor(funciones.Color3[53]));
                  FLOTL2.setTextColor(Color.parseColor(funciones.Color3[54]));
                  FLOTL3.setTextColor(Color.parseColor(funciones.Color3[55]));
                  FLOTL4.setTextColor(Color.parseColor(funciones.Color3[56]));
                  FLOTL5.setTextColor(Color.parseColor(funciones.Color3[57]));

                  PRESR1.setTextColor(Color.parseColor(funciones.Color4[71]));
                  PRESR2.setTextColor(Color.parseColor(funciones.Color4[73]));
                  PRESR3.setTextColor(Color.parseColor(funciones.Color4[75]));
                  PRESR4.setTextColor(Color.parseColor(funciones.Color4[77]));
                  PRESR5.setTextColor(Color.parseColor(funciones.Color4[79]));
                  PRESL1.setTextColor(Color.parseColor(funciones.Color4[72]));
                  PRESL2.setTextColor(Color.parseColor(funciones.Color4[74]));
                  PRESL3.setTextColor(Color.parseColor(funciones.Color4[76]));
                  PRESL4.setTextColor(Color.parseColor(funciones.Color4[78]));
                  PRESL5.setTextColor(Color.parseColor(funciones.Color4[80]));

                  NIVELM1.setTextColor(Color.parseColor(funciones.Color1[8]));
                  NIVELM2.setTextColor(Color.parseColor(funciones.Color1[19]));
                  NIVELM3.setTextColor(Color.parseColor(funciones.Color1[20]));
                  NIVELM4.setTextColor(Color.parseColor(funciones.Color1[21]));
                  NIVELM5.setTextColor(Color.parseColor(funciones.Color1[9]));

                  RPMPRE1.setTextColor(Color.parseColor(funciones.Color1[5]));
                  AMPPRE1.setTextColor(Color.parseColor(funciones.Color1[116]));
                  RPMPICA.setTextColor(Color.parseColor(funciones.Color1[119]));
                  AMPPICA.setTextColor(Color.parseColor(funciones.Color1[118]));
                  RPMDESF.setTextColor(Color.parseColor(funciones.Color1[16]));
                  AMPDESF.setTextColor(Color.parseColor(funciones.Color3[119]));

                  TORQM1.setTextColor(Color.parseColor(funciones.Color3[67]));
                  TORQM2.setTextColor(Color.parseColor(funciones.Color3[68]));
                  TORQM3.setTextColor(Color.parseColor(funciones.Color3[69]));
                  TORQM4.setTextColor(Color.parseColor(funciones.Color3[70]));
                  TORQM5.setTextColor(Color.parseColor(funciones.Color3[71]));
                                                                      
                  CORRM1.setTextColor(Color.parseColor(funciones.Color3[58]));
                  CORRM2.setTextColor(Color.parseColor(funciones.Color3[59]));
                  CORRM3.setTextColor(Color.parseColor(funciones.Color3[60]));
                  CORRM4.setTextColor(Color.parseColor(funciones.Color3[61]));
                  CORRM5.setTextColor(Color.parseColor(funciones.Color3[62]));

                  //  }
              }
            customHandler.postDelayed(this, 500);

        }

    };
}
