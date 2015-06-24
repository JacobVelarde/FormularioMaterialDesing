package com.example.usuario.lillipop;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Usuario on 24/06/2015.
 */
public class Resultados extends Activity {

    TextView tvNombre,tvEdad,tvSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultados_layout);

        tvNombre=(TextView)findViewById(R.id.textView5);
        tvEdad=(TextView)findViewById(R.id.textView7);
        tvSexo=(TextView)findViewById(R.id.textView9);

        Bundle bundle = getIntent().getExtras();

        tvNombre.setText(bundle.getString("nombre"));
        tvEdad.setText(bundle.getString("edad"));
        tvSexo.setText(bundle.getString("sexo"));
    }
}
