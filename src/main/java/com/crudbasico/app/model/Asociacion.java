package com.crudbasico.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asociaciones")
public class Asociacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pais;
    private String presidente;

    public Asociacion() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }
}