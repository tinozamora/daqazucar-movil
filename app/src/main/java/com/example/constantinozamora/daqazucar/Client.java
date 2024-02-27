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

public class Client extends AsyncTask<Void, Void, Void> {

//	public double[] Val =new double[128];
//	public String[] Nombres = new String[128];
	public boolean nombresOK=false;
	public String[] motor={"--","\\","|","/"};
	public int mx=0;

	String dstAddress;
	int dstPort;
	int canBytes=0;
	public String response = "";
	public int rechazo=0;
	public int cierre=0;
	public boolean nombrar=false;

	TextView textResponse;
	TextView textLargo;
	ToggleButton TogOn;
	CheckBox chkErr;

	public	Socket socket = null;

	Client(String addr, int port,TextView textResponse, TextView textLargo,ToggleButton ToggleOn,CheckBox checkErr) {
		dstAddress = addr;
		dstPort = port;
		this.textResponse=textResponse;
		this.textLargo=textLargo;
		this.TogOn=ToggleOn;
		this.chkErr=checkErr;

/*		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}



	@Override
	protected Void doInBackground(Void... arg0) {

		//	Socket socket = null;
		int x=1;

		try {
			Date currentTime = Calendar.getInstance().getTime();

			textResponse.setText("Conectando a Server. "+ currentTime.toString()) ;

			socket = new Socket(dstAddress, dstPort);

			socket.setReceiveBufferSize(5120);
			//socket.setSendBufferSize(5000);
			//socket.setTcpNoDelay(true);
			socket.setPerformancePreferences(2,-2,5);
			//socket.setKeepAlive(true);
			socket.setSoTimeout(0);
//socket.setKeepAlive(true);
//socket.setTcpNoDelay(true);
//socket.setOOBInline(true);
//socket.setReuseAddress(true);

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5120);
			byte[] buffer = new byte[5120];
			int bytesRead;

			InputStream inputStream = socket.getInputStream();

			/*
			 * notice: inputStream.read() will block if no data return
			 */
			DecimalFormat enteros = new DecimalFormat("000");

			if (funciones.Nombres[0]==null) {
				for (int i = 0; i <= 127; i++) {
					String corr = enteros.format(i+1);
					funciones.Nombres[i] = "Variable" + corr; //Integer.toString(i + 1);
				}
				nombresOK=false;
			}

			response="";
			byte[] bufempty = new byte[5120];


			sendMessage("Nombres");
			nombrar=false;
			while ((bytesRead = inputStream.read(buffer)) != -1) {

			//	funciones.statusS1="Conectado";
			//	funciones.isOnlineS1=true;



				if (nombrar){
					sendMessage("Nombres");
					nombrar=false;
				}

				canBytes = bytesRead;
//				response="";

				byteArrayOutputStream.reset();
				byteArrayOutputStream.write(buffer, 0, bytesRead);

//				response += byteArrayOutputStream.toString("UTF-8");


				//			response = byteArrayOutputStream.toString("UTF-8");
				//			response.trim();

				//if (response.length()==4483 || response.length()==1667 || response.length()==1706){
				if (bytesRead==4483 || bytesRead==1121 || bytesRead==1667 || bytesRead==1706 || bytesRead==1923){
					response = byteArrayOutputStream.toString("UTF-8");
					//response.trim();
					rechazo=0;
					x=1;
					if (!TogOn.isChecked()){
						byteArrayOutputStream.reset();
						buffer=bufempty;
						socket.close();
						nombrar=true;
					}
					if (cierre==1 && !nombresOK){
						cierre=0;
					}
				}else{
					rechazo=1;
					response += byteArrayOutputStream.toString("UTF-8");
					if (!TogOn.isChecked()){
						socket.close();
						nombrar=true;
					}
					buffer = bufempty;
				}
				publishProgress();
				//byteArrayOutputStream.reset()
			}



		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "UnknownHostException: " + e.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "IOException: " + e.toString();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					response = "IOException " + e.toString();
				}
			}
		}
		return null;
	}

	void sendMessage(String message) {
		try {
			if (null != socket) {
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())),
						true);
				out.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

//	@Override
//	protected void onPreExecute(Void result){
//		textLargo.setText("Ini");
//		super.onPreExecute(result);
//	}


	@Override
	protected void onPreExecute() {
		textLargo.setText(funciones.INIX);

		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(Void result) {
		textResponse.setText(response);
		super.onPostExecute(result);
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		//	textResponse.setText(Integer.toString(response.length()));
		try	{
			if (rechazo==0){

//if (response.length()>1800) {
				textLargo.setTextColor(Color.GREEN);
				textLargo.setBackgroundColor(Color.BLACK);
				textLargo.setText("Largo: " + Integer.toString(canBytes)+" "+motor[mx]);
				mx++;
				if(mx>3){
					mx=0;
				}

//			}

//		Nombres[0]=response.substring(1,35);

				int x;
				int y;
				int offs;
				String sc="";

				if (response.length()==4483) {

					//if (response.substring(1, 1) == "*"){
					//response = response.substring(1, 1121);
					x = 3;
					String n = "";
//		if (response.length()>3 & response.substring(1,3)=="***"){
					//for (int i = 0; i <= 31; i++) {

					for (int i = 0; i <= 127; i++) {
						if (x <= response.length() - 35) {
							n = response.substring(x, x + 35).trim();
							//n=n.substring(0,35);
							funciones.Nombres[i] = n;
							x = x + 35;
						}

					}

					//}
					nombresOK=true;
					response="";
				}else{
					if (response.length()==1121) {
						x = 1;
						y=0;
						offs=0;
						String n = "";
						sc=response.substring(0,1);
						textLargo.setText("Largo: " + Integer.toString(canBytes)+ " " +sc);

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
							if (x <= response.length() - 35) {
								n = response.substring(x, x + 35).trim();
								//n=n.substring(0,35);
								funciones.Nombres[i+offs] = n;
								x = x + 35;
							}
						}
					}else{
						cierre=1;
					}
				}
				x=1;
				String s;
				String sn;

				if ((response.length()==1667) || (response.length()==1706)){
					for(int i = 0;i<=127;i++){
						s = response.substring(x-1,x+12);
						sn = s.substring(0,12);
						funciones.Val[i]=  Double.parseDouble(sn);    //Float.parseFloat(sn);
						x+=13;
					}
					response="";
				}

				if ((response.length()==1923)){
					for(int i = 0;i<=127;i++){
						s = response.substring(x-1,x+14);
						sn = s.substring(0,14);
						funciones.Val[i]=  Double.parseDouble(sn);    //Float.parseFloat(sn);
						x+=15;
					}
					response="";
				}

				String cadena="";
				DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
				DecimalFormat enteros = new DecimalFormat("000");

				for(int i =0;i<=127;i++){
					String Valor = formatter.format(funciones.Val[i]);
					String corr = enteros.format(i+1);
					cadena+=corr + ". "+funciones.Nombres[i] + "=\t"+ Valor+ "\r\n";
				}

				textResponse.setTextColor(Color.parseColor("#ff99cc00"));
				textResponse.setText(cadena);

				//	textResponse.setText(response);
				//response="";

			}else{
				//textResponse.setText(response);
				if (response.length()>0) {
					textLargo.setBackgroundColor(Color.BLACK);
					textLargo.setTextColor(Color.RED);
					textLargo.setText("Rechazo: " + Integer.toString(canBytes));
					if (chkErr.isChecked()){
						textResponse.setTextColor(Color.RED);
						textResponse.setText(response);
					}
					//textResponse.setTextColor(Color.RED);
					//textResponse.setText(response);

					//response = "";
				}
			}
			super.onProgressUpdate(values);

		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
