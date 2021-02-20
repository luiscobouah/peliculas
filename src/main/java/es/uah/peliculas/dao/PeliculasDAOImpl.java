package es.uah.peliculas.dao;

import es.uah.peliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PeliculasDAOImpl implements IPeliculasDAO{

    @Autowired
    IPeliculasJPA peliculasJPA;

    @Autowired
    IActoresJPA actoresJPA;

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculasJPA.findAll();
    }

    @Override
    public Pelicula buscarPeliculaPorId(Integer idPelicula) {
        Optional<Pelicula> optional = peliculasJPA.findById(idPelicula);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Pelicula> buscarPeliculasPorTitulo(String titulo) {
        return peliculasJPA.findByTituloContainingIgnoreCase(titulo);
    }

    @Override
    public List<Pelicula> buscarPeliculasPorGenero(String genero) {
        return peliculasJPA.findByGeneroContainingIgnoreCase(genero);
    }

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        pelicula = peliculasJPA.saveAndFlush(pelicula);
        return pelicula;
    }

    @Override
    public void eliminarPelicula(Integer idPelicula) {
        peliculasJPA.deleteById(idPelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) {
        pelicula = peliculasJPA.save(pelicula);
        return pelicula;
    }

}
