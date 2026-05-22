package com.crudbasico.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int numero;
    private String posicion;

    public Jugador() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getNumero() {
        return numero;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}