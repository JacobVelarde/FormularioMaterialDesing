package com.example.usuario.lillipop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends Activity implements View.OnClickListener {
    private EditText tvNombre;
    private RadioGroup grupoGenero;
    private Button btnEnviar;
    private String gen;
    private CalendarView cal;
    private int dia,mes,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNombre=(EditText)findViewById(R.id.editText);
        grupoGenero=(RadioGroup)findViewById(R.id.rdgGrupo);

        btnEnviar=(Button)findViewById(R.id.button);
        btnEnviar.setOnClickListener(this);

        cal = (CalendarView) findViewById(R.id.calendarView);

        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                dia=dayOfMonth;
                mes=month;
                ano=year;
            }
        });

        grupoGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton){
                    gen="Masculino";
                }else if (checkedId == R.id.radioButton2){
                    gen="Femenino";
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(btnEnviar.getId()==v.getId()){

            if(!tvNombre.getText().toString().equals("")) {

                Intent i = new Intent(this, Resultados.class);
                i.putExtra("nombre", tvNombre.getText().toString());
                i.putExtra("edad", dia+"/"+mes+"/"+ano);
                i.putExtra("sexo", gen);
                startActivity(i);
            }else{
                Toast.makeText(this,"Faltan datos",Toast.LENGTH_LONG).show();
            }
        }
    }
}
