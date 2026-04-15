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

    public boolean eliminarEventos(int id){
        return listaEventos.removeIf(b -> b.getId()==(id));
    }

    public Evento modificarEvento(int id,Evento evento){
        Evento e = buscarPorId(id);
        if(e!=null){
        e.setNombre(evento.getNombre());
        e.setTipo(evento.getTipo());
        e.setFecha(evento.getFecha());
        e.setUbicacion(evento.getUbicacion());
        e.setCapacidad(evento.getCapacidad());
        return e;
        }
        return null;
    }



    public Evento buscarPorId(int id){
        for(Evento evento: listaEventos){
            if(evento.getId()==id){
                return evento;
            }
        }
        return null;
    }
        
    
}
