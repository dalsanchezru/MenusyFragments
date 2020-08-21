package com.example.miscontactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        //Aquí elijo de que manera quiero mostrar mi recycler view voy a dejar varias maneras de ver

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager glm = new GridLayoutManager(this, 2);*/


        //AQUI le decimos que el recycler view se comporte como un linear Layout.
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializaAdaptador();

        // AQUI ME LLEVE UNAS LINEAS DE CODIGO PARA DARLE ORDEN EN LAS ÚLTIMAS LINEAS

        /*para que en la linea de lstContactos se muestren los nombres tenemos que hacer un arreglo PERO POR EL
        MOMENTO NO SE USARA:
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        Voy a comentar este ListView por lo que ahora estamos haciendo el metodo de Recycler_view
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        //para llenar una lista de contactos tenemos que poner un adaptador, como el siguiente:
        //El adaptador lo que recibe es un arreglo
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        //para pasar de una vista a otra vamos a crear un int explicito para unir las actividades:
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                //Para tomar los datos de cada uno, hago lo siguiente

                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();
             }
        });
*/
    }



    //Este va a estar trabajando la distanciación entre contacto adaptador
   /* public void inicializaAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);*/

        public ContactoAdaptador adaptador;
        private void inicializaAdaptador(){
            adaptador = new ContactoAdaptador(contactos, this);
            listaContactos.setAdapter(adaptador);
        }


      /* analizar  public ContactoAdaptador adaptador;
        private void inicializaAdaptador(){
            adaptador = new ContactoAdaptador(contactos, this);
            rvContactos.setAdapter(adaptador);
        }

    }*/

    //LAS SIGUIENTES LÍNEAS LAS PASE DE ARRIBA PARA ORGANIZARLAS MEJOR
    public void inicializarListaContactos(){

        contactos = new  ArrayList<Contacto>();

        //la siguiente lista, mas adelante la puedes conseguir del un web servis o por internet
        //por por el momento la dejaremos así

        contactos.add(new Contacto(R.drawable.a, "Rata", "1", "Animal roedor, algo más grandes que sus parientes cercanos los ratones, pudiendo alcanzar los 500 gramos de peso. Existen unas 56 especies, de las cuales algunas son domésticas, y otras, muy agresivas, colonizan de manera oportunista el hábitat humano."));
        contactos.add(new Contacto(R.drawable.b,"Perro", "2","El perro es un animal mamífero y cuadrúpedo que fue domesticado hace unos 10.000 años y que, actualmente, convive con el hombre como una mascota."));
        contactos.add(new Contacto(R.drawable.c,"Pájaro", "3","entro de los animales pertenecientes al grupo de los vertebrados (dotados de un esqueleto interno articulado que soporta a todo el organismo, permitiendo además su movimiento) existen una gran cantidad de animales que pertenecen a la clasificación de aves y que cuentan con una serie de características semejantes entre sí. Dentro del reino de las aves existe un subgrupo conocido como el de los paseriformes, también denominados pájaros."));
        contactos.add(new Contacto(R.drawable.d,"Oso Panda", "4", "El oso panda, también conocido como panda gigante, es un mamífero omnívoro caracterizado por su coloración en blanco y negro y su afición al bambú."));
        contactos.add(new Contacto(R.drawable.e,"Pez", "5", "Los peces (del latín pisces) son animales vertebrados primariamente acuáticos, generalmente ectotérmicos (regulan su temperatura a partir del medio ambiente) y con respiración por branquias."));
        contactos.add(new Contacto(R.drawable.f,"Loro", "6", "La noción de loro procede del vocablo caribe roro. El término hace referencia a un ave que pertenece al orden de las psitaciformes, un grupo que incluye a aquellas especies de colores llamativos y pico encorvado que son prensoras: disponen de un par de dedos orientados hacia atrás en las patas y de fuertes mandíbulas."));
        contactos.add(new Contacto(R.drawable.g,"Mapache", "7", "Procyon es un género de mamíferos carnívoros de la familia Procyonidae1\u200B conocidos comúnmente como mapaches u osos lavadores."));
        contactos.add(new Contacto(R.drawable.h,"León", "8", "El león (Panthera leo) es un mamífero carnívoro de la familia de los félidos y una de las cinco especies del género Panthera."));
        contactos.add(new Contacto(R.drawable.i,"Cerdo", "9", "El cerdo es un animal mamífero que puede encontrarse en estado salvaje o doméstico. El nombre científico de la especie en estado natural es Sus scrofa y coloquialmente se lo conoce como jabalí o cerdo silvestre; mientras que aquéllos ejemplares que han sido domesticados reciben el nombre de Sus scrofa domestica."));
    }

    // la siguiente opción tomara nuestro menu y lo mostrará:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    //Las siguientes líneas son para controlar las opciones del menu:
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;

            case R.id.mSettings:
                Intent i = new Intent(this, ActivitySettings.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}