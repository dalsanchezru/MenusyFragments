package com.example.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    //Declaro mi lista
    ArrayList<Contacto> contactos;
    Activity activity;

    //Finalmente asociaremos el siguiente adaptadora a nuestro view en el activity_main

    //Declaro mi metodo constructor, el cual construye nuestra lista de contactos, este codigo lo puso al final
    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    //Inflar el layout y lo pasará al viewholder para que el obtenga los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //va a inflar o darle vida a nuestro Layout Card View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v); //ese v es el contacto viewholder al final, aqui mismo.
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
/*Aqui es donde vamos a empezar a setear los valores que traigo de mi lista de contactos
        //este elemento se va invocando uno a uno cada vez que traigo mi lista de elementos
        con la position de cada elemento*/
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());//poniendo el objeto de la foto en la iteración que lleve
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Diste like a " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista de contactos
        return contactos.size();
    }

    /*Este contacto Adaptador va a tener una clase estatica, la cual sera como un
    elemento view holder, para asociar nuestros objetos view y darles vida, aquí se hace la magia
    del reclaje*/

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        /*Aquí declararé todos mis view, la foto, el nombre, el tel, etc*/
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto         = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV    = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
