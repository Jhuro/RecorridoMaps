package co.edu.unipiloto.googlemapsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {

    private EditText et_latitud, et_longitud;
    private Button btn_recorrido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_latitud = findViewById(R.id.et_latitud);
        et_longitud = findViewById(R.id.et_longitud);
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

        double latitud = Double.parseDouble(et_latitud.getText().toString());
        double longitud = Double.parseDouble(et_longitud.getText().toString());

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api", "1")
                .appendQueryParameter("destination",  latitud + "," + longitud);
        String url = builder.build().toString();
        Log.d("Directions", url);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}