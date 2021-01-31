package es.uah.peliculas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "peliculas", schema = "peliculasdb")
public class Pelicula {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPelicula;
    private String titulo;
    private String annio;
    private String duracion;
    private String pais;
    private String direccion;
    private String genero;
    private String sinopsis;
    private String imagen;

    @ManyToMany(mappedBy = "peliculas")
    @JsonIgnoreProperties("peliculas")
    private List<Actor> actores;

    public Pelicula() {
    }


    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPeliculas) {
        this.idPelicula = idPeliculas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula that = (Pelicula) o;
        return Objects.equals(idPelicula, that.idPelicula) && Objects.equals(titulo, that.titulo) && Objects.equals(annio, that.annio) && Objects.equals(duracion, that.duracion) && Objects.equals(pais, that.pais) && Objects.equals(direccion, that.direccion) && Objects.equals(genero, that.genero) && Objects.equals(sinopsis, that.sinopsis) && Objects.equals(imagen, that.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, titulo, annio, duracion, pais, direccion, genero, sinopsis, imagen);
    }

    public void addActor(Actor actor) {
        if (actor != null) {
            getActores().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActores().remove(actor);
        }
    }

    public void removeAllActor(List<Actor> actores) {
            getActores().removeAll(actores);
    }
}
