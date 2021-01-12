package com.borjalapa.transiciones2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.borjalapa.transiciones2.modelo.GestionPeliculas;
import com.borjalapa.transiciones2.modelo.Pelicula;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    ImageView ivPortada;
    TextView tvAutor, tvTitulo;
    Pelicula p = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Referenciamos las vistas
        tvAutor = (TextView)findViewById(R.id.tvAutorPeli);
        tvTitulo = (TextView)findViewById(R.id.tvTituloPeli);
        ivPortada = (ImageView)findViewById(R.id.ivPortada);

        //Comprabamos que tenemos un extra y obtentemos el valor
        if(getIntent().hasExtra(constantes.ID_PELICULA)){
            String id = getIntent().getStringExtra(constantes.ID_PELICULA);

            //Con el ID del parámetro obtenemos la película
            p = GestionPeliculas.getPeliculaById(id);

            if (p!=null){
                //Establecemos las transiciones, asociando la vistas de las dos actividades gracias a las constantes
                ViewCompat.setTransitionName(ivPortada,constantes.SHARED_PELICULA);
                ViewCompat.setTransitionName(tvAutor,constantes.SHARED_AUTOR);
                ViewCompat.setTransitionName(tvTitulo,constantes.SHARED_TITULO);

                //Cargamos el contenido de las vistas.
                cargarvistas();
            }
        }
    }

    private void cargarvistas() {
        tvTitulo.setText(p.getTitulo());
        tvAutor.setText(p.getAutor());

        Picasso.get().load(p.getUrl_portada()).into(ivPortada);
    }
}