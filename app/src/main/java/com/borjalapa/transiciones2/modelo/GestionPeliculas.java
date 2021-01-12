package com.borjalapa.transiciones2.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestionPeliculas {

    static final String URL = "https://webcarlos.com/fotosmarvel";

    public final static List<Pelicula> PELICULAS = new ArrayList<Pelicula>();


    //metodo para recoger las peliculas por id
    public static Pelicula getPeliculaById(String id){
        Pelicula pelicula = null;
        for(Pelicula p:PELICULAS){
            if(p.getId().toLowerCase().compareTo(id.toLowerCase())==0){
                pelicula = p;
                break;
            }
        }
        return pelicula;
    }

    public static void crearPeliculas(){
        PELICULAS.clear();
        PELICULAS.add(new Pelicula("0","Avengers: End Game","Marvel",URL + "endgame.jpg"));
        PELICULAS.add(new Pelicula("1","Pantera Negra","Marvel",URL + "panteranegra.jpg"));
        PELICULAS.add(new Pelicula("2","Capitana Marvel","Marvel",URL + "capitanamarvel.jpg"));
        PELICULAS.add(new Pelicula("3","Avengers: Infinity War","Marvel",URL + "infinitywar.jpg"));
        PELICULAS.add(new Pelicula("4","Guardianes de la Galaxia Vol. 2","Marvel",URL + "guardianes2.jpg"));
        PELICULAS.add(new Pelicula("5","Spider-Man: Lejos de casa","Marvel",URL + "spidermanlejoscasa.jpg"));
        PELICULAS.add(new Pelicula("6","Avengers: Age of Ultron","Marvel",URL + "eradeultron.jpg"));
        PELICULAS.add(new Pelicula("7","Hombre Hormiga","Marvel",URL + "antman.jpg"));
        PELICULAS.add(new Pelicula("8","Spider-man: Homecoming","Marvel",URL + "homcoming.jpg"));
        PELICULAS.add(new Pelicula("9","Thor: The Dark World","Marvel",URL + "darkworld.jpg"));
        PELICULAS.add(new Pelicula("10","Captain America: The Winter Soldier","Marvel",URL + "winersoldier.jpg"));
        PELICULAS.add(new Pelicula("11","Guardianes de la Galaxia","Marvel",URL + "guardianes1.jpg"));
        PELICULAS.add(new Pelicula("12","Iron Man 3","Marvel",URL + "ironman3.jpg"));
        PELICULAS.add(new Pelicula("13","Ant-Man and the Wasp","Marvel",URL + "antmanwasp.jpg"));
        PELICULAS.add(new Pelicula("14","Thor: Ragnarok","Marvel",URL + "ragnarok.jpg"));
        PELICULAS.add(new Pelicula("15","The Avengers","Marvel",URL + "avengers.jpg"));
    }
}
