package co.edu.unipiloto.googlemapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {

    private Spinner spn_pacientes;
    private Button btn_recorrido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn_pacientes = findViewById(R.id.spn_pacientes);
        btn_recorrido = findViewById(R.id.btn_recorrido);

        btn_recorrido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSendMaps();
            }
        });
    }

    public void onSendMaps(){

        //Latitud: 4.632339710
        //Longitud: -74.065350

        String paciente = String.valueOf(spn_pacientes.getSelectedItem());

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api", "1")
                .appendQueryParameter("destination",  Direccion.getLatitud(paciente) + "," + Direccion.getLongitud(paciente));
        String url = builder.build().toString();
        Log.d("Directions", url);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}