package br.com.buscarmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Buscar extends AppCompatActivity {

    private Button btnBuscar;
    static EditText lt, lg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);

        btnBuscar = findViewById(R.id.btnBuscar);
        lt = findViewById(R.id.Latitude);
        lg = findViewById(R.id.Longitude);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lt.getText().toString().isEmpty() || lg.getText().toString().isEmpty()) {
                    Toast.makeText(Buscar.this, "Campo Vazio!!!", Toast.LENGTH_LONG).show();
                } else if (Double.parseDouble(lt.getText().toString()) > 90 || Double.parseDouble(lt.getText().toString()) < -90) {
                    Toast.makeText(Buscar.this, "Insira uma Latitude Válida", Toast.LENGTH_SHORT).show();
                } else if (Double.parseDouble(lg.getText().toString()) > 180 || Double.parseDouble(lg.getText().toString()) < -180) {
                    Toast.makeText(Buscar.this, "Insira uma Longitude Válida", Toast.LENGTH_SHORT).show();
                } else {
                    Intent Buscar = new Intent(Buscar.this, MapsActivity.class);
                    startActivity(Buscar);
                }
            }
        });
    }
}