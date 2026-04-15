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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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
    @DeleteMapping("eliminar/{id}")
        public String deleteEvento(@PathVariable int id){
            return EventoService.deleteEvento(id);
    }
    @PutMapping("modificar/{id}")
        public Evento putEvento(@PathVariable int id, @RequestBody Evento evento){
            return EventoService.modifEvento(id, evento);
    }
    
    @GetMapping("buscar/{id}")
    public Evento getById(@PathVariable int id){
        return EventoService.searchById(id);
    }
    
}
