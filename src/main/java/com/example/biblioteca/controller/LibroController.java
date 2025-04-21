package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;//Model
import com.example.biblioteca.service.LibroService;//Service

import org.springframework.web.bind.annotation.RequestMapping;//@RequestMapping
import org.springframework.web.bind.annotation.RestController;//@RestController

import org.springframework.beans.factory.annotation.Autowired;//Inyeccion de dependencia

import org.springframework.web.bind.annotation.GetMapping;//Get
import org.springframework.web.bind.annotation.PostMapping;//Post
import org.springframework.web.bind.annotation.PathVariable;//Path
import org.springframework.web.bind.annotation.PutMapping;//Put
import org.springframework.web.bind.annotation.DeleteMapping;//Delete

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getLibros(){
        return libroService.getLibros();
    }

    @GetMapping("{id}")//BuscarLibro por Id
    public Libro buscarLibroPorId(@PathVariable int id){
        return libroService.getLibroPorId(id);
    }

    @GetMapping("/isbn/{isbn}")//Por ejemplo, si la solicitud es /isbn/12345, el valor de isbn dentro de la función sería 12345
    public Libro buscarLibroPorIsbn(@PathVariable String isbn){
        return libroService.getLibroPorIsbn(isbn);
    }

    @GetMapping("/autor/{autor}")
    public Libro buscarLibroPorTitulo(@PathVariable String autor){
        return libroService.getLibroPorAutor(autor);
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro){
        return libroService.guardarLibro(libro);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        return libroService.actuaLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.eliminarLibro(id);
    }

}
