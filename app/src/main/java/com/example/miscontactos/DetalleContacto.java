package com.example.miscontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        /*Si ya la actividad me envía los parametros, pues tengo que recibirlos
        aquí con un bundle, como se muestra a continuación.Nota: En Adroid los parametros
        se llaman extras*/

        Bundle parametros = getIntent().getExtras();
        String nombre     = parametros.getString(getResources().getString(R.string.pnombre));//equivale a mi texto nombre declarado
        String telefono   = parametros.getString(getResources().getString(R.string.ptelefono));//equivale a mi texto telefono declarado
        String email      = parametros.getString(getResources().getString(R.string.pemail));//equivale a mi texto email declarado

        //Antes estaba TextView LOCAL pero lo volví GLOBAL y se nombró en el private de arriba, dejo el primero de ejemplo:
        //para ver como estaba antes como LOCAL
        /*TextView*/ tvNombre   = (TextView) findViewById(R.id.tvNombre);
                     tvEmail    = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvEmail.setText(email);
    }

    /* este es el metodo para darle vida a los al telefono y el email; es decir, haremos
    un procedimiento explicito*/


    public void enviarMail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        //esto es para poner que se abra en diferentes app de msn
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email"));

    }
}
