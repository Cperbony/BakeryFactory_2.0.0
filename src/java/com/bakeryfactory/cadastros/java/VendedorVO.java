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

import com.bakeryfactory.vendas.java.VendaCabecalhoVO;
import com.bakeryfactory.vendas.java.VendaComissaoVO;
import com.bakeryfactory.vendas.java.VendaOrcamentoCabecalhoVO;
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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "VENDEDOR")
public class VendedorVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISSAO")
    private BigDecimal comissao;
    @Column(name = "META_VENDAS")
    private BigDecimal metaVendas;
    @Column(name = "GERENTE")
    private Character gerente;
    @Column(name = "TAXA_GERENTE")
    private BigDecimal taxaGerente;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,  mappedBy = "vendedor")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaCabecalhoVO> listaVendaCabecalho;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "vendedor")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaOrcamentoCabecalhoVO> listaVendaOrcamentoCabecalho;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "vendedor")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaComissaoVO> listaVendaComissao;
    
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ColaboradorVO colaborador;

    public VendedorVO() {
    }

    public VendedorVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public BigDecimal getMetaVendas() {
        return metaVendas;
    }

    public void setMetaVendas(BigDecimal metaVendas) {
        this.metaVendas = metaVendas;
    }

    public Character getGerente() {
        return gerente;
    }

    public void setGerente(Character gerente) {
        this.gerente = gerente;
    }

    public BigDecimal getTaxaGerente() {
        return taxaGerente;
    }

    public void setTaxaGerente(BigDecimal taxaGerente) {
        this.taxaGerente = taxaGerente;
    }

    public List<VendaCabecalhoVO> getListaVendaCabecalho() {
        return listaVendaCabecalho;
    }

    public void setListaVendaCabecalho(List<VendaCabecalhoVO> listaVendaCabecalho) {
        this.listaVendaCabecalho = listaVendaCabecalho;
    }

    public List<VendaOrcamentoCabecalhoVO> getListaVendaOrcamentoCabecalho() {
        return listaVendaOrcamentoCabecalho;
    }

    public void setListaVendaOrcamentoCabecalho(List<VendaOrcamentoCabecalhoVO> listaVendaOrcamentoCabecalho) {
        this.listaVendaOrcamentoCabecalho = listaVendaOrcamentoCabecalho;
    }

    public List<VendaComissaoVO> getListaVendaComissao() {
        return listaVendaComissao;
    }

    public void setListaVendaComissao(List<VendaComissaoVO> listaVendaComissao) {
        this.listaVendaComissao = listaVendaComissao;
    }

    public ColaboradorVO getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorVO colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.VendedorVO[ id=" + id + " ]";
    }
    
}
