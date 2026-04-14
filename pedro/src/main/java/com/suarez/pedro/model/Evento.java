package com.suarez.pedro.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    private String nombre;
    private String tipo;
    private Date fecha;
    private String ubicacion;
    private int capacidad;

}
