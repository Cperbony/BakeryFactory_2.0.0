/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.contabilidade.java;

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
 * @date   06/11/2016
 */
@Entity
@Table(name = "CONTABIL_CONTA")
public class ContabilContaVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CLASSIFICACAO")
    private String classificacao;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_INCLUSAO")
    private Date dataInclusao;
    @Column(name = "SITUACAO")
    private String situacao;
    @Column(name = "NATUREZA")
    private String natureza;
    @Column(name = "PATRIMONIO_RESULTADO")
    private String patrimonioResultado;
    @Column(name = "LIVRO_CAIXA")
    private String livroCaixa;
    @Column(name = "DFC")
    private String dfc;
    @Column(name = "ORDEM")
    private String ordem;
    @Column(name = "CODIGO_REDUZIDO")
    private String codigoReduzido;
    @Column(name = "CODIGO_EFD")
    private String codigoEfd;
    @JoinColumn(name = "ID_PLANO_CONTA_REF_SPED", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PlanoContaRefSpedVO planoContaRefSped;
    @JoinColumn(name = "ID_CONTABIL_CONTA", referencedColumnName = "ID")
    @ManyToOne
    private ContabilContaVO contabilConta;
    @JoinColumn(name = "ID_PLANO_CONTA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PlanoContaVO planoConta;

    public ContabilContaVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public String getPatrimonioResultado() {
        return patrimonioResultado;
    }

    public void setPatrimonioResultado(String patrimonioResultado) {
        this.patrimonioResultado = patrimonioResultado;
    }

    public String getLivroCaixa() {
        return livroCaixa;
    }

    public void setLivroCaixa(String livroCaixa) {
        this.livroCaixa = livroCaixa;
    }

    public String getDfc() {
        return dfc;
    }

    public void setDfc(String dfc) {
        this.dfc = dfc;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getCodigoReduzido() {
        return codigoReduzido;
    }

    public void setCodigoReduzido(String codigoReduzido) {
        this.codigoReduzido = codigoReduzido;
    }

    public String getCodigoEfd() {
        return codigoEfd;
    }

    public void setCodigoEfd(String codigoEfd) {
        this.codigoEfd = codigoEfd;
    }

    public PlanoContaRefSpedVO getPlanoContaRefSped() {
        return planoContaRefSped;
    }

    public void setPlanoContaRefSped(PlanoContaRefSpedVO planoContaRefSped) {
        this.planoContaRefSped = planoContaRefSped;
    }

    public ContabilContaVO getContabilConta() {
        return contabilConta;
    }

    public void setContabilConta(ContabilContaVO contabilConta) {
        this.contabilConta = contabilConta;
    }

    public PlanoContaVO getPlanoConta() {
        return planoConta;
    }

    public void setPlanoConta(PlanoContaVO planoConta) {
        this.planoConta = planoConta;
    }

    @Override
    public String toString() {
        return "ContabilContaVO{" + "id=" + id + ", classificacao=" + classificacao + ", tipo=" + tipo + ", descricao=" + descricao + ", dataInclusao=" + dataInclusao + ", situacao=" + situacao + ", natureza=" + natureza + ", patrimonioResultado=" + patrimonioResultado + ", livroCaixa=" + livroCaixa + ", dfc=" + dfc + ", ordem=" + ordem + ", codigoReduzido=" + codigoReduzido + ", codigoEfd=" + codigoEfd + ", planoContaRefSped=" + planoContaRefSped + ", contabilConta=" + contabilConta + ", planoConta=" + planoConta + '}';
    }
    
    
}
