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

import com.bakeryfactory.cadastros.java.ColaboradorVO;
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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "COMPRA_REQUISICAO")
public class CompraRequisicaoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATA_REQUISICAO")
    @Temporal(TemporalType.DATE)
    private Date dataRequisicao;
    @Column(name = "OBSERVACAO")
    private String observacao;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compraRequisicaoId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraRequisicaoDetalheVO> listaCompraRequisicaoDetalhe;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compraRequisicao")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraRequisicaoInternaDetalheVO> listaRequisicaoInternaDetalhe;
    
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ColaboradorVO colaborador;
    
    @JoinColumn(name = "ID_COMPRA_TIPO_REQUISICAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CompraTipoRequisicaoVO compraTipoRequisicao;

    public CompraRequisicaoVO() {
    }

    public CompraRequisicaoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(Date dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<CompraRequisicaoDetalheVO> getListaCompraRequisicaoDetalhe() {
        return listaCompraRequisicaoDetalhe;
    }

    public void setListaCompraRequisicaoDetalhe(List<CompraRequisicaoDetalheVO> listaCompraRequisicaoDetalhe) {
        this.listaCompraRequisicaoDetalhe = listaCompraRequisicaoDetalhe;
    }

    public List<CompraRequisicaoInternaDetalheVO> getListaRequisicaoInternaDetalhe() {
        return listaRequisicaoInternaDetalhe;
    }

    public void setListaRequisicaoInternaDetalhe(List<CompraRequisicaoInternaDetalheVO> listaRequisicaoInternaDetalhe) {
        this.listaRequisicaoInternaDetalhe = listaRequisicaoInternaDetalhe;
    }

    public ColaboradorVO getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorVO colaborador) {
        this.colaborador = colaborador;
    }

    public CompraTipoRequisicaoVO getCompraTipoRequisicao() {
        return compraTipoRequisicao;
    }

    public void setCompraTipoRequisicao(CompraTipoRequisicaoVO compraTipoRequisicao) {
        this.compraTipoRequisicao = compraTipoRequisicao;
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
        if (!(object instanceof CompraRequisicaoVO)) {
            return false;
        }
        CompraRequisicaoVO other = (CompraRequisicaoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.CompraRequisicaoVO[ id=" + id + " ]";
    }
    
}
