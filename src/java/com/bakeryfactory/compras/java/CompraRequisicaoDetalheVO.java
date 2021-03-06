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

import com.bakeryfactory.cadastros.java.ProdutoVO;
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
@Table(name = "COMPRA_REQUISICAO_DETALHE")
public class CompraRequisicaoDetalheVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "QUANTIDADE_COTADA")
    private BigDecimal quantidadeCotada;
    @Column(name = "ITEM_COTADO")
    private Character itemCotado;
    @JoinColumn(name = "ID_COMPRA_REQUISICAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CompraRequisicaoVO compraRequisicao;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compraRequisicaoDetalhe")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraReqCotacaoDetalheVO> listaCompraReqCotacaoDetalhe;
    
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoVO produto;
    

    public CompraRequisicaoDetalheVO() {
    }

    public CompraRequisicaoDetalheVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidadeCotada() {
        return quantidadeCotada;
    }

    public void setQuantidadeCotada(BigDecimal quantidadeCotada) {
        this.quantidadeCotada = quantidadeCotada;
    }

    public Character getItemCotado() {
        return itemCotado;
    }

    public void setItemCotado(Character itemCotado) {
        this.itemCotado = itemCotado;
    }

    public CompraRequisicaoVO getCompraRequisicao() {
        return compraRequisicao;
    }

    public void setCompraRequisicao(CompraRequisicaoVO compraRequisicao) {
        this.compraRequisicao = compraRequisicao;
    }

    public List<CompraReqCotacaoDetalheVO> getListaCompraReqCotacaoDetalhe() {
        return listaCompraReqCotacaoDetalhe;
    }

    public void setListaCompraReqCotacaoDetalhe(List<CompraReqCotacaoDetalheVO> listaCompraReqCotacaoDetalhe) {
        this.listaCompraReqCotacaoDetalhe = listaCompraReqCotacaoDetalhe;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
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
        if (!(object instanceof CompraRequisicaoDetalheVO)) {
            return false;
        }
        CompraRequisicaoDetalheVO other = (CompraRequisicaoDetalheVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.CompraRequisicaoDetalheVO[ id=" + id + " ]";
    }
    
}
