package es.uah.peliculas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actores", schema = "peliculasdb")
public class Actor {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idActor;
    private String nombre;
    private String paisNacimiento;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", locale = "es-ES", timezone = "Europe/Madrid")
    private Date fechaNacimiento;

    @JoinTable(name = "Peliculas_has_Actores", joinColumns = {
            @JoinColumn(name = "Actores_idActor", referencedColumnName = "idActor")}, inverseJoinColumns = {
            @JoinColumn(name = "Peliculas_idPelicula", referencedColumnName = "idPelicula")})
    @ManyToMany
    @JsonIgnoreProperties("actores")
    private List<Pelicula> peliculas;

    public Actor() {
        this.peliculas = new ArrayList<>();
    }

    public Integer getIdActor() {
        return idActor;
    }

    public void setIdActor(Integer idActores) {
        this.idActor = idActores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(String paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor that = (Actor) o;
        return Objects.equals(idActor, that.idActor) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(paisNacimiento, that.paisNacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActor, fechaNacimiento, paisNacimiento);
    }

    public void addPelicula(Pelicula pelicula) {
        if (pelicula != null) {
            getPeliculas().add(pelicula);
            pelicula.addActor(this);
        }
    }
    public void removePelicula(Pelicula pelicula) {
        if (pelicula != null) {
            getPeliculas().remove(pelicula);
        }
    }
}
