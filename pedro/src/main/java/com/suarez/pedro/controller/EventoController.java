package com.suarez.pedro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suarez.pedro.model.Evento;
import com.suarez.pedro.service.EventoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/v1/eventos")
public class EventoController {
    @Autowired
    private EventoService EventoService;
    @GetMapping
    public ResponseEntity<?> getEventos(){
        List<Evento>listaEventos = EventoService.readAll();
        if(listaEventos.isEmpty()){
            return ResponseEntity
            .status(404)
            .body("No hay eventos ingresados");
        }
        return ResponseEntity.ok(listaEventos);
    }
    @PostMapping
    public ResponseEntity <?>postEventos(@Valid @RequestBody Evento evento){
        Evento e=EventoService.createEvento(evento);
        if(e!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Evento creado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se ha creado el evento");
    }
    @DeleteMapping("{evento}")
        public String deleteEvento(@PathVariable String nombre){
            return EventoService.deleteEvento(nombre);
    }
    
    
    
    
    
    
}
