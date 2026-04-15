package com.suarez.pedro.model;


import java.util.concurrent.atomic.AtomicInteger;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Evento {
    private static final AtomicInteger contador = new AtomicInteger(1);
    
    private int id;
    @NotBlank(message = "el nombre del evento no puede estar vacio")
    @Size(min = 3, max = 20, message = "el nombre debe tener entre 3 y 20 caracteres")
    private String nombre;
    @NotBlank(message = "el tipo de evento no puede estar vacio")
    @Size(min = 4, max = 20, message = "el tipo de evento debe tener entre 4 y 20 caracteres")
    private String tipo;
    @NotBlank(message = "la fecha no puede estar vacia")
    @Size(min = 4, max = 20, message = "la fecha debe tener entre 4 y 20 caracteres")
    private String fecha;
    @NotBlank(message = "la ubicacion no puede estar vacia")
    @Size(min = 4, max = 20, message = "la ubicacion debe tener entre 4 y 20 caracteres")
    private String ubicacion;
    @Min(value = 1, message = "la capacidad debe ser mayor a 1")
    @Max(value = 10000, message = "la capacidad no puede ser mayor a 1000")
    private int capacidad;
    public Evento(String nombre, String tipo, String fecha, String ubicacion, int capacidad){
        this.id=contador.getAndIncrement();
        this.nombre=nombre;
        this.tipo=tipo;
        this.fecha=fecha;
        this.ubicacion=ubicacion;
        this.capacidad=capacidad;

    }
}

