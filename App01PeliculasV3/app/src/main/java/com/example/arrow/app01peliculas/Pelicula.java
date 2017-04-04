package com.example.arrow.app01peliculas;

/**
 * Created by ARROW on 16/03/2017.
 */

public class Pelicula {
    private long id;
    private String titulo;
    private String anio;
    private String pais;
    private int duraccion;
    private String director;
    private String sipnosis;
    private String guinista;
    private int caratulaMini;
    private int caratula;

    public Pelicula() {

    }

    public Pelicula(long id, String titulo, String anio, String pais, int duraccion, String director, String sipnosis, String guinista, int caratulaMini, int caratula) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.pais = pais;
        this.duraccion = duraccion;
        this.director = director;
        this.sipnosis = sipnosis;
        this.guinista = guinista;
        this.caratulaMini = caratulaMini;
        this.caratula = caratula;
    }

    public Pelicula(long id,String titulo, String anio, String pais, int duraccion, int caratulaMini) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.pais = pais;
        this.duraccion = duraccion;
        this.caratulaMini = caratulaMini;
    }

    public Pelicula(String titulo, String anio, String pais, int duraccion, String director,
                    String sipnosis, String guinista, int caratulaMini, int caratula) {
        this.titulo = titulo;
        this.anio = anio;
        this.pais = pais;
        this.duraccion = duraccion;
        this.director = director;
        this.sipnosis = sipnosis;
        this.guinista = guinista;
        this.caratulaMini = caratulaMini;
        this.caratula = caratula;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getDuraccion() {
        return duraccion;
    }

    public void setDuraccion(int duraccion) {
        this.duraccion = duraccion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public String getGuinista() {
        return guinista;
    }

    public void setGuinista(String guinista) {
        this.guinista = guinista;
    }

    public int getCaratulaMini() {
        return caratulaMini;
    }

    public void setCaratulaMini(int caratulaMini) {
        this.caratulaMini = caratulaMini;
    }

    public int getCaratula() {
        return caratula;
    }

    public void setCaratula(int caratula) {
        this.caratula = caratula;
    }
}
