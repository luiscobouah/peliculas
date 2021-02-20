package es.uah.peliculas.dao;

import es.uah.peliculas.model.Pelicula;
import java.util.List;

public interface IPeliculasDAO {

    List<Pelicula> buscarTodas();

    Pelicula buscarPeliculaPorId(Integer idPelicula);

    List<Pelicula> buscarPeliculasPorTitulo(String titulo);

    List<Pelicula> buscarPeliculasPorGenero(String genero);


    Pelicula guardarPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer idPelicula);

    Pelicula actualizarPelicula(Pelicula pelicula);

}
