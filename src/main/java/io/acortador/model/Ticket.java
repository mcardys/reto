package io.acortador.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name= "urls")
public class Ticket {
    /*id	fechaInicio	fechaFin	status*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private int status;

    public Long getId() {
        return id;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public int getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
