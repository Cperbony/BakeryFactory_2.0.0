/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.calendarioproducao.java;

import com.bakeryfactory.cadastros.java.ColaboradorVO;
import com.bakeryfactory.pcp.java.PcpOpDetalheVO;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   15/01/2017
 */

@Entity
@Table(name = "AGENDA_COMPROMISSO")
public class AgendaCompromissoVO extends ValueObjectImpl implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_COMPROMISSO")
    private Date dataCompromisso;
    @Column(name = "HORA")
    private String hora;
    @Column(name = "DURACAO")
    private Integer duracao;
    @Column(name = "ONDE")
    private String onde;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "TIPO")
    private Integer tipo;
    @Column(name = "RECORRENTE")
    private Integer recorrente;
    @Column(name = "QUANTIDADE_OCORRENCIA")
    private Integer quantidadeOcorrencia;
        
    @JoinColumn(name = "ID_AGENDA_CATEGORIA_COMPROMISSO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AgendaCategoriaCompromissoVO agendaCategoriaCompromisso;
    
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ColaboradorVO colaborador;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "agendaCompromisso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgendaCompromissoConvidadoVO> listaAgendaCompromissoConvidado;
    
    @JoinColumn(name = "ID_PCP_OP_DETALHE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PcpOpDetalheVO pcpOpDetalhe;
    
//    @Transient
//    private Integer recorrente;
//    
//    @Transient
//    private Integer quantidadeOcorrencia;

    public AgendaCompromissoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCompromisso() {
        return dataCompromisso;
    }

    public void setDataCompromisso(Date dataCompromisso) {
        this.dataCompromisso = dataCompromisso;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getOnde() {
        return onde;
    }

    public void setOnde(String onde) {
        this.onde = onde;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public AgendaCategoriaCompromissoVO getAgendaCategoriaCompromisso() {
        return agendaCategoriaCompromisso;
    }

    public void setAgendaCategoriaCompromisso(AgendaCategoriaCompromissoVO agendaCategoriaCompromisso) {
        this.agendaCategoriaCompromisso = agendaCategoriaCompromisso;
    }

    public ColaboradorVO getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorVO colaborador) {
        this.colaborador = colaborador;
    }

    public List<AgendaCompromissoConvidadoVO> getListaAgendaCompromissoConvidado() {
        return listaAgendaCompromissoConvidado;
    }

    public void setListaAgendaCompromissoConvidado(List<AgendaCompromissoConvidadoVO> listaAgendaCompromissoConvidado) {
        this.listaAgendaCompromissoConvidado = listaAgendaCompromissoConvidado;
    }

    public Integer getRecorrente() {
        return recorrente;
    }

    public void setRecorrente(Integer recorrente) {
        this.recorrente = recorrente;
    }

    public Integer getQuantidadeOcorrencia() {
        return quantidadeOcorrencia;
    }

    public void setQuantidadeOcorrencia(Integer quantidadeOcorrencia) {
        this.quantidadeOcorrencia = quantidadeOcorrencia;
    }

    public PcpOpDetalheVO getPcpOpDetalhe() {
        return pcpOpDetalhe;
    }

    public void setPcpOpDetalhe(PcpOpDetalheVO pcpOpDetalhe) {
        this.pcpOpDetalhe = pcpOpDetalhe;
    }

    @Override
    public String toString() {
        return "AgendaCompromissoVO{" + "id=" + id + '}';
    }
    
}
