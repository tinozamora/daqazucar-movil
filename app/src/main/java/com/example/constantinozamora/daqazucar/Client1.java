package com.example.constantinozamora.daqazucar;


import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

//import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
//import android.util.TimeUtils;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.nio.Buffer;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.*;


public class Client1 extends AsyncTask<Void, Void, Void> {

    public boolean nombres1OK=false;
    public boolean nombres2OK=false;
    public boolean nombres3OK=false;
    public boolean nombres4OK=false;
    
    public String[] motor={"--","\\","|","/"};
    public int mx=0;

    String dstAddress1,dstAddress2,dstAddress3,dstAddress4;
    int dsrPort1;
    int dsrPort2;
    int dsrPort3;
    int dsrPort4;

    int canBytes1=0;
    int canBytes2=0;
    int canBytes3=0;
    int canBytes4=0;

    public String response1 = "";
    public String response2 = "";
    public String response3 = "";
    public String response4 = "";

    public int rechazo1=0;
    public int rechazo2=0;
    public int rechazo3=0;
    public int rechazo4=0;

    public int cierre1=0;
    public int cierre2=0;
    public int cierre3=0;
    public int cierre4=0;

    public boolean nombrar1=false;
    public boolean nombrar2=false;
    public boolean nombrar3=false;
    public boolean nombrar4=false;


    public	Socket socket1 = null;
    public	Socket socket2 = null;
    public	Socket socket3 = null;
    public	Socket socket4 = null;

    Client1(String addr1, int port1,String addr2, int port2,String addr3, int port3,String addr4, int port4){
        dstAddress1 = addr1;
        dsrPort1 = port1;
        dstAddress2 = addr2;
        dsrPort2 = port2;
        dstAddress3 = addr3;
        dsrPort3 = port3;
        dstAddress4 = addr4;
        dsrPort4 = port4;
    }

    @Override
    protected Void doInBackground(Void... arg0) {

        //	Socket socket = null;
        int x1=1,x2=1,x3=1,x4=1;

        try {
            Date currentTime = Calendar.getInstance().getTime();

            funciones.statusS1="Conectando";
            funciones.statusS2="Conectando";
            funciones.statusS3="Conectando";
            funciones.statusS4="Conectando";

            socket1 = new Socket(dstAddress1, dsrPort1);
            socket2 = new Socket(dstAddress2, dsrPort2);
            socket3 = new Socket(dstAddress3, dsrPort3);
            socket4 = new Socket(dstAddress4, dsrPort4);

            socket1.setReceiveBufferSize(5120);
            socket2.setReceiveBufferSize(5120);
            socket3.setReceiveBufferSize(5120);
            socket4.setReceiveBufferSize(5120);

            socket1.setPerformancePreferences(2,-2,5);
            socket2.setPerformancePreferences(2,-2,5);
            socket3.setPerformancePreferences(2,-2,5);
            socket4.setPerformancePreferences(2,-2,5);

            socket1.setSoTimeout(0);
            socket2.setSoTimeout(0);
            socket3.setSoTimeout(0);
            socket4.setSoTimeout(0);

            ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream(5120);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(5120);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream(5120);
            ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream(5120);

            byte[] buffer1 = new byte[5120];
            byte[] buffer2 = new byte[5120];
            byte[] buffer3 = new byte[5120];
            byte[] buffer4 = new byte[5120];

            int bytesRead1;
            int bytesRead2;
            int bytesRead3;
            int bytesRead4;

            InputStream inputStream1 = socket1.getInputStream();
            InputStream inputStream2 = socket2.getInputStream();
            InputStream inputStream3 = socket3.getInputStream();
            InputStream inputStream4 = socket4.getInputStream();

            DecimalFormat enteros1 = new DecimalFormat("000");
            DecimalFormat enteros2 = new DecimalFormat("000");
            DecimalFormat enteros3 = new DecimalFormat("000");
            DecimalFormat enteros4 = new DecimalFormat("000");

            if (funciones.Nombres1[0]==null) {
                for (int i = 0; i <= 127; i++) {
                    String corr = enteros1.format(i+1);
                    funciones.Nombres1[i+1] = "Variable" + corr; //Integer.toString(i + 1);
                   // funciones.Val1[i+1]=0;
                }
                nombres1OK=false;
            }

            if (funciones.Nombres2[0]==null) {
                for (int i = 0; i <= 127; i++) {
                    String corr = enteros2.format(i+1);
                    funciones.Nombres2[i+1] = "Variable" + corr; //Integer.toString(i + 1);
                    //funciones.Val2[i+1]=0;
                }
                nombres2OK=false;
            }

            if (funciones.Nombres3[0]==null) {
                for (int i = 0; i <= 127; i++) {
                    String corr = enteros3.format(i+1);
                    funciones.Nombres3[i+1] = "Variable" + corr; //Integer.toString(i + 1);
                    //funciones.Val3[i+1]=0;
                }
                nombres3OK=false;
            }

            if (funciones.Nombres4[0]==null) {
                for (int i = 0; i <= 127; i++) {
                    String corr = enteros4.format(i+1);
                    funciones.Nombres4[i+1] = "Variable" + corr; //Integer.toString(i + 1);
                   // funciones.Val4[i+1]=0;
                }
                nombres4OK=false;
            }

            response1="";
            response2="";
            response3="";
            response4="";

            byte[] bufempty1 = new byte[5120];
            byte[] bufempty2 = new byte[5120];
            byte[] bufempty3 = new byte[5120];
            byte[] bufempty4 = new byte[5120];

            sendMessage1("Nombres");
            sendMessage2("Nombres");
            sendMessage3("Nombres");
            sendMessage4("Nombres");

            nombrar1=false;
            nombrar2=false;
            nombrar3=false;
            nombrar4=false;

            while  (funciones.MasterON){
                //((bytesRead = inputStream.read(buffer)) != -1) {

                bytesRead1 = inputStream1.read(buffer1);
             //   funciones.statusS1="Conectado";
             //   funciones.isOnlineS1=true;

                bytesRead2 = inputStream2.read(buffer2);
             //   funciones.statusS2="Conectado";
             //   funciones.isOnlineS2=true;

                bytesRead3 = inputStream3.read(buffer3);

                bytesRead4 = inputStream4.read(buffer4);

                if (nombrar1){
                    sendMessage1("Nombres");
                    nombrar1=false;
                }

                if (nombrar2){
                    sendMessage2("Nombres");
                    nombrar2=false;
                }

                if (nombrar3){
                    sendMessage3("Nombres");
                    nombrar3=false;
                }

                if (nombrar4){
                    sendMessage4("Nombres");
                    nombrar4=false;
                }

                canBytes1 = bytesRead1;
                canBytes2 = bytesRead2;
                canBytes3 = bytesRead3;
                canBytes4 = bytesRead4;

                byteArrayOutputStream1.reset();

                if (canBytes1!=-1){
                    byteArrayOutputStream1.write(buffer1, 0, bytesRead1);

                }else{
                   /* socket1.close();
                    socket1 = new Socket(dstAddress1, dsrPort1);
                    socket1.setReceiveBufferSize(5120);
                    socket1.setPerformancePreferences(2,-2,5);
                    socket1.setSoTimeout(0);
                    buffer1=bufempty1;
                    bytesRead1=0;
                    funciones.isOnlineS1=false;
                    nombres1OK=false;
                    funciones.statusS1="Desconectado";
                    socket1.close(); */
                }

                if (bytesRead1==4483 || bytesRead1==1121 || bytesRead1==1667 || bytesRead1==1706 || bytesRead1==1923){
                    response1 = byteArrayOutputStream1.toString("UTF-8");
                    rechazo1=0;
                    x1=1;

                    if (cierre1==1 && !nombres1OK){
                        cierre1=0;
                    }
                }else{
                    rechazo1=1;
                    response1 += byteArrayOutputStream1.toString("UTF-8");

                    buffer1 = bufempty1;
                }

                byteArrayOutputStream2.reset();
                if (canBytes2!=-1) {
                    byteArrayOutputStream2.write(buffer2, 0, bytesRead2);
                }

                if (bytesRead2==4483 || bytesRead2==1121 || bytesRead2==1667 || bytesRead2==1706 || bytesRead2==1923){
                    response2 = byteArrayOutputStream2.toString("UTF-8");
                    rechazo2=0;
                    x2=1;

                    if (cierre2==1 && !nombres2OK){
                        cierre2=0;
                    }
                }else{
                    rechazo2=1;
                    response2 += byteArrayOutputStream2.toString("UTF-8");

                    buffer2 = bufempty2;
                }

                byteArrayOutputStream3.reset();
                if (canBytes3!=-1) {
                    byteArrayOutputStream3.write(buffer3, 0, bytesRead3);
                }

                if (bytesRead3==4483 || bytesRead3==1121 || bytesRead3==1667 || bytesRead3==1706 || bytesRead3==1923){
                    response3 = byteArrayOutputStream3.toString("UTF-8");
                    rechazo3=0;
                    x3=1;

                    if (cierre3==1 && !nombres3OK){
                        cierre3=0;
                    }
                }else{
                    rechazo3=1;
                    response3 += byteArrayOutputStream3.toString("UTF-8");

                    buffer3 = bufempty3;
                }

                byteArrayOutputStream4.reset();
                if (canBytes4!=-1) {
                    byteArrayOutputStream4.write(buffer4, 0, bytesRead4);
                }

                if (bytesRead4==4483 || bytesRead4==1121 || bytesRead4==1667 || bytesRead4==1706 || bytesRead4==1923){
                    response4 = byteArrayOutputStream4.toString("UTF-8");
                    rechazo4=0;
                    x4=1;

                    if (cierre4==1 && !nombres4OK){
                        cierre4=0;
                    }
                }else{
                    rechazo4=1;
                    response4 += byteArrayOutputStream4.toString("UTF-8");

                    buffer4 = bufempty4;
                }

                publishProgress();
            }

            if (!funciones.MasterON){


                socket1.shutdownInput();
                socket2.shutdownInput();
                socket3.shutdownInput();
                socket4.shutdownInput();

                funciones.isOnlineS1=false;
                funciones.isOnlineS2=false;
                funciones.isOnlineS3=false;
                funciones.isOnlineS4=false;

                buffer1=bufempty1;
                buffer2=bufempty2;
                buffer3=bufempty3;
                buffer4=bufempty4;

                canBytes1=0;
                canBytes2=0;
                canBytes3=0;
                canBytes4=0;

                response1="";
                response2="";
                response3="";
                response4="";

                nombres1OK=false;
                nombres2OK=false;
                nombres3OK=false;
                nombres4OK=false;

                funciones.statusS1="Desconectado";
                funciones.statusS2="Desconectado";
                funciones.statusS3="Desconectado";
                funciones.statusS4="Desconectado";

                socket1.close();
                socket2.close();
                socket3.close();
                socket4.close();

            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response1 = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response1 = "IOException: " + e.toString();
        } finally {
            if (socket1 != null) {
                try {
                    socket1.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    void sendMessage1(String message) {
        try {
            if (null != socket1) {
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket1.getOutputStream())),
                        true);
                out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendMessage2(String message) {
        try {
            if (null != socket2) {
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket2.getOutputStream())),
                        true);
                out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendMessage3(String message) {
        try {
            if (null != socket3) {
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket3.getOutputStream())),
                        true);
                out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void sendMessage4(String message) {
        try {
            if (null != socket4) {
                PrintWriter out = new PrintWriter(new BufferedWriter(
                        new OutputStreamWriter(socket4.getOutputStream())),
                        true);
                out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        funciones.statusS1=(funciones.INIX1);
        funciones.statusS2=(funciones.INIX2);
        funciones.statusS3=(funciones.INIX3);
        funciones.statusS4=(funciones.INIX4);


            for (int i = 0; i <= 127; i++) {
                funciones.Val1[i+1]=0;
                funciones.Val2[i+1]=0;
                funciones.Val3[i+1]=0;
                funciones.Val4[i+1]=0;

                funciones.Color1[i+1]="#FFFFFFFF";
                funciones.Color2[i+1]="#FFFFFFFF";
                funciones.Color3[i+1]="#FFFFFFFF";
                funciones.Color4[i+1]="#FFFFFFFF";
            }




        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void result) {
        //textresponse1.setText(response1);
        super.onPostExecute(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        mx++;
        if(mx>3){
            mx=0;
        }
//    try{
        //S1---------------------------------------------------------------------------------------

        funciones.statusS1="Bytes Rx " +  Integer.toString(canBytes1)+" "+motor[mx] ;

        if (rechazo1==0){
            //funciones.statusS1="Conectado";
            funciones.isOnlineS1=true;
            funciones.largo1=canBytes1;
            mx++;
            if(mx>3){
                mx=0;
            }

            int x;
            int y;
            int offs;
            String sc="";

            if (response1.length()==4483) {
                x = 3;
                String n = "";
                for (int i = 0; i <= 127; i++) {
                    if (x <= response1.length() - 35) {
                        n = response1.substring(x, x + 35).trim();
                        //n=n.substring(0,35);
                        funciones.Nombres1[i+1] = n;
                        x = x + 35;
                    }
                }

                nombres1OK=true;
                response1="";
            }else{
                if (response1.length()==1121) {
                    x = 1;
                    y=0;
                    offs=0;
                    String n = "";
                    sc=response1.substring(0,1);
                    funciones.largo1=canBytes1;

                    switch (sc){
                        case "*":
                            x=1;
                            y=31;
                            offs=0;
                            break;
                        case "+":
                            x=1;
                            y=31;
                            offs=32;
                            break;
                        case "-":
                            x=1;
                            y=31;
                            offs=64;
                            break;
                        case "/":
                            x=1;
                            y=31;
                            offs=96;
                            break;
                        default:
                            offs=0;
                            break;
                    }
                    //offs=32;
                    for (int i = 0; i <= 31; i++) {
                        if (x <= response1.length() - 35) {
                            n = response1.substring(x, x + 35).trim();
                            //n=n.substring(0,35);
                            funciones.Nombres1[i+offs+1] = n;
                            x = x + 35;
                        }
                    }
                }else{
                    cierre1=1;
                }
            }
            x=1;
            String s;
            String sn,cl,clv;

            //if (((response1.length()==1667) || (response1.length()==1706)) && response1.substring(0,1)!="*"){
            String terx1;
            if (response1.length()>3){
                terx1=response1.substring(response1.length()-3);
            }else{
                terx1="-----";
            };

            if (((response1.length()==1667) || (response1.length()==1706)) && terx1.equals("fin")){
                funciones.isDatoOkS1=true;
                for(int i = 0;i<=127;i++){
                    s = response1.substring(x-1,x+12);
                    sn = s.substring(0,12);
                    cl=s.substring(12,13);
                    funciones.Val1[i+1]=  Double.parseDouble(sn);    //Float.parseFloat(sn);
                    switch (cl){
                        case "Y":
                            clv="#FFE8D65B";
                            break;
                        case "G":
                            clv="#FF99CC00";
                            break;
                        case "R":
                            clv="#FFCD0B0B";
                            break;
                        default:
                            clv="#FFE8D65B";
                            break;
                    }
                    funciones.Color1[i+1]=clv;
                    x+=13;
                }
                response1="";
                funciones.isDatoOkS1=false;
            }

            //falta poner colores para este largo que solo es del daqenergia
            if ((response1.length()==1923)){
                for(int i = 0;i<=127;i++){
                    s = response1.substring(x-1,x+14);
                    sn = s.substring(0,14);
                    funciones.Val1[i+1]=  Double.parseDouble(sn);    //Float.parseFloat(sn);
                    x+=15;
                }
                response1="";
            }

            String cadena="";
            DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
            DecimalFormat enteros = new DecimalFormat("000");

            for(int i =0;i<=127;i++){
                String Valor = formatter.format(funciones.Val1[i+1]);
                String corr = enteros.format(i+1);
                cadena+=corr + ". "+funciones.Nombres1[i+1] + "=\t"+ Valor+ "\r\n";
            }


        }else{
            //textresponse1.setText(response1);
            if (response1.length()>0) {
                funciones.largo1=canBytes1;
            }
        }
        //finS1---------------------------------------------------------------------------------------


        //S2---------------------------------------------------------------------------------------
        if (rechazo2==0){
            funciones.statusS2="Conectado";
            funciones.isOnlineS2=true;
            funciones.largo2=canBytes2;

            int x2;
            int y2;
            int offs2;
            String sc2="";

            funciones.statusS2="Bytes Rx " + Integer.toString(canBytes2)+" "+motor[mx] ;

            if (response2.length()==4483) {
                x2 = 3;
                String n2 = "";
                for (int i = 0; i <= 127; i++) {
                    if (x2 <= response2.length() - 35) {
                        n2 = response2.substring(x2, x2 + 35).trim();
                        //n=n.substring(0,35);
                        funciones.Nombres2[i+1] = n2;
                        x2 = x2 + 35;
                    }
                }
                nombres2OK=true;
                response2="";
            }else{
                if (response2.length()==1121) {
                    x2 = 1;
                    y2=0;
                    offs2=0;
                    String n2 = "";
                    sc2=response2.substring(0,1);
                    funciones.largo2=canBytes2;

                    switch (sc2){
                        case "*":
                            x2=1;
                            y2=31;
                            offs2=0;
                            break;
                        case "+":
                            x2=1;
                            y2=31;
                            offs2=32;
                            break;
                        case "-":
                            x2=1;
                            y2=31;
                            offs2=64;
                            break;
                        case "/":
                            x2=1;
                            y2=31;
                            offs2=96;
                            break;
                        default:
                            offs2=0;
                            break;
                    }
                    //offs=32;
                    for (int i = 0; i <= 31; i++) {
                        if (x2 <= response2.length() - 35) {
                            n2 = response2.substring(x2, x2 + 35).trim();
                            //n=n.substring(0,35);
                            funciones.Nombres2[i+offs2+1] = n2;
                            x2 = x2 + 35;
                        }
                    }
                }else{
                    cierre2=1;
                }
            }

            x2=1;
            String s2;
            String sn2,cl2,clv2;

            //if (((response2.length()==1667) || (response2.length()==1706)) && response2.substring(0,1)!="*"){
            String terx2;
            if (response2.length()>3){
                terx2=response2.substring(response2.length()-3);
            }else{
                terx2="-----";
            };

            if (((response2.length()==1667) || (response2.length()==1706)) && terx2.equals("fin")){
                funciones.isDatoOkS2=true;
                for(int i = 0;i<=127;i++){
                    s2 = response2.substring(x2-1,x2+12);
                    sn2 = s2.substring(0,12);
                    cl2=s2.substring(12,13);
                    funciones.Val2[i+1]=  Double.parseDouble(sn2);    //Float.parseFloat(sn);
                    switch (cl2){
                        case "Y":
                            clv2="#FFE8D65B";
                            break;
                        case "G":
                            clv2="#FF99CC00";
                            break;
                        case "R":
                            clv2="#FFCD0B0B";
                            break;
                        default:
                            clv2="#FFE8D65B";
                            break;
                    }
                    funciones.Color2[i+1]=clv2;
                    x2+=13;
                }
                response2="";
                funciones.isDatoOkS2=false;
            }

            String cadena2="";
            DecimalFormat formatter2 = new DecimalFormat("###,###,##0.00");
            DecimalFormat enteros2 = new DecimalFormat("000");

            for(int i =0;i<=127;i++){
                String Valor2 = formatter2.format(funciones.Val2[i+1]);
                String corr2 = enteros2.format(i+1);
                cadena2+=corr2 + ". "+funciones.Nombres2[i+1] + "=\t"+ Valor2+ "\r\n";
            }

        }else{
            if (response2.length()>0) {
                funciones.largo2=canBytes2;
            }
        }
        //finS2---------------------------------------------------------------------------------------


        //S3---------------------------------------------------------------------------------------
        if (rechazo3==0){
            funciones.statusS3="Conectado";
            funciones.isOnlineS3=true;
            funciones.largo3=canBytes3;

            int x3;
            int y3;
            int offs3;
            String sc3="";

            funciones.statusS3="Bytes Rx " + Integer.toString(canBytes3)+" "+motor[mx] ;

            if (response3.length()==4483) {
                x3 = 3;
                String n3 = "";
                for (int i = 0; i <= 127; i++) {
                    if (x3 <= response3.length() - 35) {
                        n3 = response3.substring(x3, x3 + 35).trim();
                        //n=n.substring(0,35);
                        funciones.Nombres3[i+1] = n3;
                        x3 = x3 + 35;
                    }
                }
                nombres3OK=true;
                response3="";
            }else{
                if (response3.length()==1121) {
                    x3 = 1;
                    y3=0;
                    offs3=0;
                    String n3 = "";
                    sc3=response3.substring(0,1);
                    funciones.largo3=canBytes3;

                    switch (sc3){
                        case "*":
                            x3=1;
                            y3=31;
                            offs3=0;
                            break;
                        case "+":
                            x3=1;
                            y3=31;
                            offs3=32;
                            break;
                        case "-":
                            x3=1;
                            y3=31;
                            offs3=64;
                            break;
                        case "/":
                            x3=1;
                            y3=31;
                            offs3=96;
                            break;
                        default:
                            offs3=0;
                            break;
                    }
                    //offs=32;
                    for (int i = 0; i <= 31; i++) {
                        if (x3 <= response3.length() - 35) {
                            n3 = response3.substring(x3, x3 + 35).trim();
                            //n=n.substring(0,35);
                            funciones.Nombres3[i+offs3+1] = n3;
                            x3 = x3 + 35;
                        }
                    }
                }else{
                    cierre3=1;
                }
            }

            x3=1;
            String s3;
            String sn3,cl3,clv3;

            //if (((response3.length()==1667) || (response3.length()==1706)) && response3.substring(0,1)!="*"){
            String terx3;
            if (response3.length()>3){
                terx3=response3.substring(response3.length()-3);
            }else{
                terx3="-----";
            };

            if (((response3.length()==1667) || (response3.length()==1706)) && terx3.equals("fin")){
                funciones.isDatoOkS3=true;
                for(int i = 0;i<=127;i++){
                    s3 = response3.substring(x3-1,x3+12);
                    sn3 = s3.substring(0,11);
                    cl3=s3.substring(12,13);
                    funciones.Val3[i+1]=  Double.parseDouble(sn3);    //Float.parseFloat(sn);
                    switch (cl3){
                        case "Y":
                            clv3="#FFE8D65B";
                            break;
                        case "G":
                            clv3="#FF99CC00";
                            break;
                        case "R":
                            clv3="#FFCD0B0B";
                            break;
                        default:
                            clv3="#FFE8D65B";
                            break;
                    }
                    funciones.Color3[i+1]=clv3;
                    x3+=13;
                }
                response3="";
                funciones.isDatoOkS3=false;
            }


            String cadena3="";
            DecimalFormat formatter3 = new DecimalFormat("###,###,##0.00");
            DecimalFormat enteros3= new DecimalFormat("000");

            for(int i =0;i<=127;i++){
                String Valor3 = formatter3.format(funciones.Val3[i+1]);
                String corr3 = enteros3.format(i+1);
                cadena3+=corr3 + ". "+funciones.Nombres3[i+1] + "=\t"+ Valor3+ "\r\n";
            }

        }else{
            if (response3.length()>0) {
                funciones.largo3=canBytes3;
            }
        }
        //finS3---------------------------------------------------------------------------------------


        //S4---------------------------------------------------------------------------------------
        if (rechazo4==0){
            funciones.statusS4="Conectado";
            funciones.isOnlineS4=true;
            funciones.largo2=canBytes4;

            int x4;
            int y4;
            int offs4;
            String sc4="";

            funciones.statusS4="Bytes Rx " + Integer.toString(canBytes4)+" "+motor[mx] ;

            if (response4.length()==4483) {
                x4 = 3;
                String n4 = "";
                for (int i = 0; i <= 127; i++) {
                    if (x4 <= response4.length() - 35) {
                        n4 = response4.substring(x4, x4 + 35).trim();
                        //n=n.substring(0,35);
                        funciones.Nombres4[i+1] = n4;
                        x4 = x4 + 35;
                    }
                }
                nombres4OK=true;
                response4="";
            }else{
                if (response4.length()==1121) {
                    x4 = 1;
                    y4=0;
                    offs4=0;
                    String n4 = "";
                    sc4=response4.substring(0,1);
                    funciones.largo4=canBytes4;

                    switch (sc4){
                        case "*":
                            x4=1;
                            y4=31;
                            offs4=0;
                            break;
                        case "+":
                            x4=1;
                            y4=31;
                            offs4=32;
                            break;
                        case "-":
                            x4=1;
                            y4=31;
                            offs4=64;
                            break;
                        case "/":
                            x4=1;
                            y4=31;
                            offs4=96;
                            break;
                        default:
                            offs4=0;
                            break;
                    }
                    //offs=32;
                    for (int i = 0; i <= 31; i++) {
                        if (x4 <= response4.length() - 35) {
                            n4 = response4.substring(x4, x4 + 35).trim();
                            //n=n.substring(0,35);
                            funciones.Nombres4[i+offs4+1] = n4;
                            x4 = x4 + 35;
                        }
                    }
                }else{
                    cierre4=1;
                }
            }

            x4=1;
            String s4;
            String sn4,cl4,clv4;

            //if (((response4.length()==1667) || (response4.length()==1706)) && response4.substring(0,1)!="*"){
            String terx4;
            if (response4.length()>3){
                terx4=response4.substring(response4.length()-3);
            }else{
                terx4="-----";
            };

            if (((response4.length()==1667) || (response4.length()==1706)) && terx4.equals("fin")){
                funciones.isDatoOkS4=true;
                for(int i = 0;i<=127;i++){
                    s4 = response4.substring(x4-1,x4+12);
                    sn4 = s4.substring(0,11);
                    cl4=s4.substring(12,13);
                    funciones.Val4[i+1]=  Double.parseDouble(sn4);    //Float.parseFloat(sn);
                    switch (cl4){
                        case "Y":
                            clv4="#FFE8D65B";
                            break;
                        case "G":
                            clv4="#FF99CC00";
                            break;
                        case "R":
                            clv4="#FFCD0B0B";
                            break;
                        default:
                            clv4="#FFE8D65B";
                            break;
                    }
                    funciones.Color4[i+1]=clv4;
                    x4+=13;
                }
                response4="";
                funciones.isDatoOkS4=false;
            }

            String cadena4="";
            DecimalFormat formatter4 = new DecimalFormat("###,###,##0.00");
            DecimalFormat enteros4 = new DecimalFormat("000");

            for(int i =0;i<=127;i++){
                String Valor4 = formatter4.format(funciones.Val4[i+1]);
                String corr4 = enteros4.format(i+1);
                cadena4+=corr4 + ". "+funciones.Nombres4[i+1] + "=\t"+ Valor4+ "\r\n";
            }

        }else{
            if (response4.length()>0) {
                funciones.largo4=canBytes4;
            }
        }
        //finS4---------------------------------------------------------------------------------------

//        super.onProgressUpdate(values);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
    }
}
