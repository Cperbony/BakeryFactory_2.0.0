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
package com.bakeryfactory.compras.java;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "COMPRA_COTACAO")
public class CompraCotacaoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATA_COTACAO")
    @Temporal(TemporalType.DATE)
    private Date dataCotacao;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "SITUACAO")
    private Character situacao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compraCotacao")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraReqCotacaoDetalheVO> listaCompraReqCotacaoDetalhe;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compraCotacao")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraFornecedorCotacaoVO> listaCompraFornecedorCotacao;

    public CompraCotacaoVO() {
    }

    public CompraCotacaoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCotacao() {
        return dataCotacao;
    }

    public void setDataCotacao(Date dataCotacao) {
        this.dataCotacao = dataCotacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public List<CompraReqCotacaoDetalheVO> getListaCompraReqCotacaoDetalhe() {
        return listaCompraReqCotacaoDetalhe;
    }

    public void setListaCompraReqCotacaoDetalhe(List<CompraReqCotacaoDetalheVO> listaCompraReqCotacaoDetalhe) {
        this.listaCompraReqCotacaoDetalhe = listaCompraReqCotacaoDetalhe;
    }

    public List<CompraFornecedorCotacaoVO> getListaCompraFornecedorCotacao() {
        return listaCompraFornecedorCotacao;
    }

    public void setListaCompraFornecedorCotacao(List<CompraFornecedorCotacaoVO> listaCompraFornecedorCotacao) {
        this.listaCompraFornecedorCotacao = listaCompraFornecedorCotacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraCotacaoVO)) {
            return false;
        }
        CompraCotacaoVO other = (CompraCotacaoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.CompraCotacaoVO[ id=" + id + " ]";
    }

}
