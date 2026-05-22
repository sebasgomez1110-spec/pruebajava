package com.crudbasico.app.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clubes")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ciudad;
    private int anioFundacion;

    @OneToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    @OneToMany
    @JoinColumn(name = "id_club")
    private List<Jugador> jugadores = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "asociacion_id")
    private Asociacion asociacion;

    @ManyToMany
    @JoinTable(
            name = "clubes_competiciones",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "competicion_id")
    )
    private List<Competicion> competiciones = new ArrayList<>();

    public Club() {
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Asociacion getAsociacion() {
        return asociacion;
    }

    public List<Competicion> getCompeticiones() {
        return competiciones;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setAsociacion(Asociacion asociacion) {
        this.asociacion = asociacion;
    }

    public void setCompeticiones(List<Competicion> competiciones) {
        this.competiciones = competiciones;
    }
}