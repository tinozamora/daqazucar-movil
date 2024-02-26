package com.example.constantinozamora.daqazucar;

import android.app.Application;
import android.content.Context;


public class funciones  {

    Context ctx;

    public  static Context ctx2;

    public static String INIX="Iniciando...",INIX1="Iniciando...",INIX2="Iniciando...",INIX3="Iniciando...",INIX4="Iniciando...";

    public static double[] Val =new double[128];
    public static String[] Nombres = new String[128];

    public static double[] Val1 =new double[129];
    public static String[] Nombres1 = new String[129];
    public static String[] Color1 =new String[129];

    public static double[] Val2 =new double[129];
    public static String[] Nombres2 = new String[129];
    public static String[] Color2 =new String[129];

    public static double[] Val3 =new double[129];
    public static String[] Nombres3 = new String[129];
    public static String[] Color3 =new String[129];

    public static double[] Val4 =new double[129];
    public static String[] Nombres4 = new String[129];
    public static String[] Color4 =new String[129];

    public static  boolean isOnlineS1=false, isOnlineS2=false, isOnlineS3=false, isOnlineS4=false;
    public static  boolean isDatoOkS1=false, isDatoOkS2=false, isDatoOkS3=false, isDatoOkS4=false;

    public static Integer largo1=0,largo2=0,largo3=0,largo4=0;

    public static  String statusS1="Desconectado", statusS2="Desconectado",statusS3="Desconectado", statusS4="Desconectado";

    public static  boolean MasterON=false, FragmentoON=false;

    //public static String ServerIP[] = new String[4];


//    public static String[] ServerIP =  ctx2.getResources().getStringArray(R.array.servers);
//    public static String[] PortIP = ctx2.getResources().getStringArray(R.array.puertos);

//     String[] SIP =  ctx2.getResources().getStringArray(R.array.servers);
//     String[] PIP = ctx2.getResources().getStringArray(R.array.puertos);

    public static String[] ServerIP =  {"190.86.180.200","190.86.180.200","190.86.180.200","190.86.180.200"};
    public static String[] PortIP = {"701","702","704","710"};



}
