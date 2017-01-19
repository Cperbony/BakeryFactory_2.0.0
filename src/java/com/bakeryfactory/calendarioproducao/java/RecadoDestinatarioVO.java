/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.calendarioproducao.java;

import com.bakeryfactory.cadastros.java.ColaboradorVO;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   15/01/2017
 */

@Entity
@Table(name = "RECADO_DESTINATARIO")
public class RecadoDestinatarioVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    
    @JoinColumn(name = "ID_RECADO_REMETENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RecadoRemetenteVO recadoRemetente;
    
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ColaboradorVO colaborador;

    public RecadoDestinatarioVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RecadoRemetenteVO getRecadoRemetente() {
        return recadoRemetente;
    }

    public void setRecadoRemetente(RecadoRemetenteVO recadoRemetente) {
        this.recadoRemetente = recadoRemetente;
    }

    public ColaboradorVO getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorVO colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return "RecadoDestinatarioVO{" + "id=" + id + '}';
    }
}
