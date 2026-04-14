package com.suarez.pedro.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.suarez.pedro.model.Evento;

@Repository
public class EventoRepository {
    private List<Evento>listaEventos = new ArrayList<>();

    public Evento agregarEvento(Evento evento){
        listaEventos.add(evento);
        return evento;
    }

    public List <Evento> listaEventos(){
        return listaEventos;
    }

    public boolean eliminarEventos(String nombre){
        return listaEventos.removeIf(b -> b.getNombre().equals(nombre));
    }
}
