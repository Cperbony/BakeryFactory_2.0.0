/*
 * The MIT License
 *
 * Copyright 2016 Claudinei Aparecido Perboni • contact: cperbony@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.bakeryfactory.cadastros.java;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "venda_condicoes_pagamento")
public class VendaCondicoesPagamentoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "faturamento_minimo")
    private BigDecimal faturamentoMinimo;
    @Column(name = "faturamento_maximo")
    private BigDecimal faturamentoMaximo;
    @Column(name = "indice_correcao")
    private BigDecimal indiceCorrecao;
    @Column(name = "dias_tolerancia")
    private Integer diasTolerancia;
    @Column(name = "valor_tolerancia")
    private BigDecimal valorTolerancia;
    @Column(name = "prazo_medio")
    private Integer prazoMedio;
    @Column(name = "vista_prazo")
    private Character vistaPrazo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaCondicoesPagamentoId")
    private List<VendaCondicoesParcelaVO> vendaCondicoesParcelaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaCondicoesPagamentoId")
    private List<VendaCabecalhoVO> vendaCabecalhoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaCondicoesPagamentoId")
    private List<VendaOrcamentoCabecalhoVO> vendaOrcamentoCabecalhoList;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EmpresaVO empresa;

    public VendaCondicoesPagamentoVO() {
    }

    public VendaCondicoesPagamentoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getFaturamentoMinimo() {
        return faturamentoMinimo;
    }

    public void setFaturamentoMinimo(BigDecimal faturamentoMinimo) {
        this.faturamentoMinimo = faturamentoMinimo;
    }

    public BigDecimal getFaturamentoMaximo() {
        return faturamentoMaximo;
    }

    public void setFaturamentoMaximo(BigDecimal faturamentoMaximo) {
        this.faturamentoMaximo = faturamentoMaximo;
    }

    public BigDecimal getIndiceCorrecao() {
        return indiceCorrecao;
    }

    public void setIndiceCorrecao(BigDecimal indiceCorrecao) {
        this.indiceCorrecao = indiceCorrecao;
    }

    public Integer getDiasTolerancia() {
        return diasTolerancia;
    }

    public void setDiasTolerancia(Integer diasTolerancia) {
        this.diasTolerancia = diasTolerancia;
    }

    public BigDecimal getValorTolerancia() {
        return valorTolerancia;
    }

    public void setValorTolerancia(BigDecimal valorTolerancia) {
        this.valorTolerancia = valorTolerancia;
    }

    public Integer getPrazoMedio() {
        return prazoMedio;
    }

    public void setPrazoMedio(Integer prazoMedio) {
        this.prazoMedio = prazoMedio;
    }

    public Character getVistaPrazo() {
        return vistaPrazo;
    }

    public void setVistaPrazo(Character vistaPrazo) {
        this.vistaPrazo = vistaPrazo;
    }

    public List<VendaCondicoesParcelaVO> getVendaCondicoesParcelaList() {
        return vendaCondicoesParcelaList;
    }

    public void setVendaCondicoesParcelaList(List<VendaCondicoesParcelaVO> vendaCondicoesParcelaList) {
        this.vendaCondicoesParcelaList = vendaCondicoesParcelaList;
    }

    public List<VendaCabecalhoVO> getVendaCabecalhoList() {
        return vendaCabecalhoList;
    }

    public void setVendaCabecalhoList(List<VendaCabecalhoVO> vendaCabecalhoList) {
        this.vendaCabecalhoList = vendaCabecalhoList;
    }

    public List<VendaOrcamentoCabecalhoVO> getVendaOrcamentoCabecalhoList() {
        return vendaOrcamentoCabecalhoList;
    }

    public void setVendaOrcamentoCabecalhoList(List<VendaOrcamentoCabecalhoVO> vendaOrcamentoCabecalhoList) {
        this.vendaOrcamentoCabecalhoList = vendaOrcamentoCabecalhoList;
    }

    public EmpresaVO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaVO empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.VendaCondicoesPagamentoVO[ id=" + id + " ]";
    }
    
}
