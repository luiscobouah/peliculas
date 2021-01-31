package es.uah.peliculas.dao;

import es.uah.peliculas.model.Actor;
import es.uah.peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IActoresJPA extends JpaRepository<Actor, Integer> {

    List<Actor> findByNombreContainingIgnoreCase(String nombre);

}
