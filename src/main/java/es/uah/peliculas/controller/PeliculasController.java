package es.uah.peliculas.controller;

import es.uah.peliculas.model.Actor;
import es.uah.peliculas.model.Pelicula;
import es.uah.peliculas.service.IActoresService;
import es.uah.peliculas.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculasController {

    @Autowired
    IPeliculasService peliculasService;

    @Autowired
    IActoresService actoresService;

    @GetMapping("/peliculas")
    public List<Pelicula> buscarTodos() {
        return peliculasService.buscarTodas();
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula buscarCursoPorId(@PathVariable("id") Integer id) {
        return peliculasService.buscarPeliculaPorId(id);
    }

    @GetMapping("/peliculas/titulo/{titulo}")
    public List<Pelicula> buscarCursosPorNombre(@PathVariable("titulo") String titulo) {
        return peliculasService.buscarPeliculasPorTitulo(titulo);
    }

    @GetMapping("/peliculas/genero/{genero}")
    public List<Pelicula> buscarCursosPorCategoria(@PathVariable("genero") String genero) {
        return peliculasService.buscarPeliculasPorGenero(genero);
    }

    @PostMapping("/peliculas")
    public void guardarPelicula(@RequestBody Pelicula pelicula) {
        List<Actor> actores = pelicula.getActores();
         pelicula = peliculasService.guardarPelicula(pelicula);
         for (Actor actor : actores) {
            actoresService.inscribirActor(actor.getIdActor(),pelicula.getIdPelicula());
        }
    }

    @PutMapping("/peliculas")
    public void actualizarPelicula(@RequestBody Pelicula pelicula) {
        List<Actor> actores = pelicula.getActores();
        pelicula = peliculasService.actualizarPelicula(pelicula);
        for (Actor actor : actores) {
            if (actor != null) {
                actor.removePelicula(pelicula);
                actoresService.guardarActor(actor);
                actoresService.inscribirActor(actor.getIdActor(),pelicula.getIdPelicula());
            }
        }
    }

    @DeleteMapping("/peliculas/{id}")
    public void eliminarPelicula(@PathVariable("id") Integer id) {
        peliculasService.eliminarPelicula(id);
    }

}
