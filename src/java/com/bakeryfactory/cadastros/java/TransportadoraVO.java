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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "transportadora")
public class TransportadoraVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "classificacao_contabil_conta")
    private String classificacaoContabilConta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadoraId")
    private List<TransportadoraMunicipioVO> transportadoraMunicipioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadoraId")
    private List<VendaCabecalhoVO> vendaCabecalhoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadoraId")
    private List<VendaOrcamentoCabecalhoVO> vendaOrcamentoCabecalhoList;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaVO pessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportadoraId")
    private List<VendaFreteVO> vendaFreteList;

    public TransportadoraVO() {
    }

    public TransportadoraVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getClassificacaoContabilConta() {
        return classificacaoContabilConta;
    }

    public void setClassificacaoContabilConta(String classificacaoContabilConta) {
        this.classificacaoContabilConta = classificacaoContabilConta;
    }

    public List<TransportadoraMunicipioVO> getTransportadoraMunicipioList() {
        return transportadoraMunicipioList;
    }

    public void setTransportadoraMunicipioList(List<TransportadoraMunicipioVO> transportadoraMunicipioList) {
        this.transportadoraMunicipioList = transportadoraMunicipioList;
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

    public PessoaVO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }

    public List<VendaFreteVO> getVendaFreteList() {
        return vendaFreteList;
    }

    public void setVendaFreteList(List<VendaFreteVO> vendaFreteList) {
        this.vendaFreteList = vendaFreteList;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.TransportadoraVO[ id=" + id + " ]";
    }
    
}
