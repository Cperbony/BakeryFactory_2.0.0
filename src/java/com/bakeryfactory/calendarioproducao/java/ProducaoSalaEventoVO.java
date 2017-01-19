/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.calendarioproducao.java;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   15/01/2017
 */

@Entity
@Table(name = "PRODUCAO_SALA_EVENTO")
public class ProducaoSalaEventoVO extends ValueObjectImpl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_RESERVA")
    private Date dataReserva;
    
    @JoinColumn(name = "ID_PRODUCAO_SALA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProducaoSalaVO producaoSala;
    
    @JoinColumn(name = "ID_AGENDA_COMPROMISSO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AgendaCompromissoVO agendaCompromisso;

    public ProducaoSalaEventoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public ProducaoSalaVO getProducaoSala() {
        return producaoSala;
    }

    public void setProducaoSala(ProducaoSalaVO producaoSala) {
        this.producaoSala = producaoSala;
    }

    public AgendaCompromissoVO getAgendaCompromisso() {
        return agendaCompromisso;
    }

    public void setAgendaCompromisso(AgendaCompromissoVO agendaCompromisso) {
        this.agendaCompromisso = agendaCompromisso;
    }

    @Override
    public String toString() {
        return "ProducaoSalaEventoVO{" + "id=" + id + '}';
    }

}
