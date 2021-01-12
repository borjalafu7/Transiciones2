package com.borjalapa.transiciones2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjalapa.transiciones2.modelo.GestionPeliculas;
import com.borjalapa.transiciones2.modelo.Pelicula;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView gridView;

    //implementar el piccaso en el archivo build.gradle
    //implementation 'com.squareup.picasso:picasso:2.71828'
    //tambien tienes que dar permisos de internet en el manifest.xml para poder cargar las imagenes desde la web
    //<uses-permission android:name="android.permission.INTERNET"/>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = (GridView) findViewById(R.id.gridView);

        //cargamos las peliculas
        GestionPeliculas.crearPeliculas();

        MyAdapter myAdapter = new MyAdapter(this,R.id.gridView, GestionPeliculas.PELICULAS);
        gridView.setAdapter(myAdapter);

        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(this,DetailActivity.class);
        Pelicula p = (Pelicula) view.getTag();

        //Le añadimos un extra que contendrá el ID de la película.
        intent.putExtra(constantes.ID_PELICULA, p.getId());

        //Creamos Opciones de la actividad, en este caso crear una escena de transición
        //Le pasamos la actividad actual, y elementos de ti par, que contendrá la vista a hacer la animación y una etiqueta que la identifique en la otra Actividad
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair<View, String>(view.findViewById(R.id.ivPortada),constantes.SHARED_PELICULA),
                new Pair<View, String>(view.findViewById(R.id.autor),constantes.SHARED_AUTOR),
                new Pair<View, String>(view.findViewById(R.id.titulo),constantes.SHARED_TITULO)
        );


        ActivityCompat.startActivity(this,intent,options.toBundle());
        //startActivity(intent);
    }


    private class MyAdapter extends ArrayAdapter {
        Context c;
        List<Pelicula> peliculas;

        //Constructor de nuestro Adaptador
        //Le pasamos el contexto y un ArrayList
        public MyAdapter(@NonNull Context context, int resource, @NonNull List<Pelicula> peliculas) {
            super(context, resource, peliculas);

            this.c = context;
            this.peliculas = peliculas;
        }

        //devuelve el numero de peliculas que hay
        @Override
        public int getCount() {
            //return this.peliculas.size();
            return super.getCount();
        }


        //metodo para vincular los elemento de esta lista con el grid
        @NonNull
        @Override
        public View getView(int i, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v;

            //hemos inflado el item_grid_view para cada uno de los elemenos del gridView
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_grid_view, null);

            ImageView ivPortada = (ImageView) v.findViewById(R.id.ivPortada);
            TextView tvTitulo = (TextView) v.findViewById(R.id.titulo);
            TextView tvAutor = (TextView) v.findViewById(R.id.autor);

            tvTitulo.setText(peliculas.get(i).getTitulo());
            tvAutor.setText(peliculas.get(i).getAutor());

            //Usamos Picasso para añadir una imagen de internet a un imageView
            Picasso.get()
                    .load(this.peliculas.get(i).getUrl_portada())
                    //.placeholder(R.drawable.user_placeholder)
                    .noPlaceholder()
                    //.resize(50,50)
                    //.centerCrop()
                    //.error(R.drawable.user_placeholder_error)
                    .into(ivPortada);

            //a la vista le pasamos un objeto
            v.setTag(this.peliculas.get(i));

            return v;
        }

    }

}