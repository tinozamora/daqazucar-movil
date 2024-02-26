package com.example.constantinozamora.daqazucar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.*;

public class activity_test extends AppCompatActivity {

    TextView response;
    TextView largo;
    ToggleButton togOn;
    CheckBox chkErr;
    EditText editTextAddress, editTextPort;
    Button buttonConnect, buttonClear,buttonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //editTextAddress = (EditText) findViewById(R.id.addressEditText);
        //editTextPort = (EditText) findViewById(R.id.portEditText);
        buttonConnect = (Button) findViewById(R.id.connectButton);
        buttonClear = (Button) findViewById(R.id.clearButton);
        buttonSalir=(Button)findViewById(R.id.buttonSalir);
        response = (TextView) findViewById(R.id.responseTextView);
        largo=(TextView) findViewById(R.id.textLargo) ;
        togOn=(ToggleButton)findViewById(R.id.toggleOn);
        chkErr=(CheckBox)findViewById(R.id.checkErr);

        final String[] nSer = getResources().getStringArray(R.array.puertos);


        final Spinner spinnerIP = (Spinner) findViewById(R.id.spinnerIP);
        ArrayAdapter<CharSequence> adapterIP = ArrayAdapter.createFromResource(
                this, R.array.servers, android.R.layout.simple_spinner_item);
        adapterIP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIP.setAdapter(adapterIP);

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerPort);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.daqservers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setSelection(3);

        togOn.setChecked(true);
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) new MyOnItemSelectedListener());

/*		Button myButton =(Button)findViewById(R.id.button);
		myButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {

				Spinner sp =	(Spinner)findViewById(R.id.spinner);
				String spinnerString = null;
				spinnerString = sp.getSelectedItem().toString();
				int nPos = sp.getSelectedItemPosition();


				Toast.makeText(getApplicationContext(), "getSelectedItem=" + spinnerString,
						Toast.LENGTH_LONG).show();
				Toast.makeText(getApplicationContext(), "getSelectedItemPosition=" + nPos,
						Toast.LENGTH_LONG).show();
			}
		});
*/


//		response = (TextView) findViewById(R.id.TextData);

        buttonConnect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                response.setText("Conectando...");

                //              Client myClient = new Client(editTextAddress.getText()
                //                     .toString(), Integer.parseInt(editTextPort
                //                   .getText().toString()), response,largo);

                Spinner spIP =	(Spinner)findViewById(R.id.spinnerIP);
                String spinnerStringIP = null;
                spinnerStringIP = spIP.getSelectedItem().toString();

                Spinner sp =	(Spinner)findViewById(R.id.spinnerPort);
                String spinnerString = null;
                spinnerString = sp.getSelectedItem().toString();
                Integer spinnerPos = sp.getSelectedItemPosition();

                // int nPos = sp.getSelectedItemPosition();

//                Client myClient = new Client(spinnerStringIP, Integer.parseInt(spinnerString), response,largo,togOn);
                Client myClient = new Client(spinnerStringIP, Integer.parseInt(nSer[spinnerPos]), response,largo,togOn,chkErr);

                myClient.execute();
            }
        });

        buttonClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                response.setText("");
                response.setText("Puerto seleccionado: " + nSer[spinner.getSelectedItemPosition()]);


         //       Intent PantallaMolienda = new Intent(activity_test.this, molienda.class);
         //       startActivity(PantallaMolienda);

                //myClient.cancel(true);
            }
        });

        buttonSalir.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                //System.exit(0);
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
   //     System.exit(0);
    }

}

