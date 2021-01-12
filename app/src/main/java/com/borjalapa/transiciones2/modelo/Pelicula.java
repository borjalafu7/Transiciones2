package com.borjalapa.transiciones2.modelo;

public class Pelicula {
    String id;
    String titulo;
    String autor;
    String url_portada;

    public Pelicula(String id, String titulo, String autor, String url_portada) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.url_portada = url_portada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getUrl_portada() {
        return url_portada;
    }

    public void setUrl_portada(String url_portada) {
        this.url_portada = url_portada;
    }

}
