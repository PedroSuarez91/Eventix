package com.suarez.pedro.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suarez.pedro.model.Evento;
import com.suarez.pedro.repository.EventoRepository;

@Service
public class EventoService {
    @Autowired
    private EventoRepository EventoRepository;

    public Evento createEvento(Evento evento){
        return EventoRepository.agregarEvento(evento);
    }

    public List<Evento>readAll(){
        return EventoRepository.listaEventos();
    }

    public String deleteEvento(int id){
        if(EventoRepository.eliminarEventos(id)){
            return "Evento eliminado";
        }
        return "No se puede eliminar el evento";
    }

    public Evento modifEvento(int id, Evento evento){
        return EventoRepository.modificarEvento(id, evento);
    }

    public Evento searchById(int id){
        return EventoRepository.buscarPorId(id);
    }
}

