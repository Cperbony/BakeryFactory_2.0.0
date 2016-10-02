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
@Table(name = "compra_requisicao_detalhe")
@NamedQueries({
    @NamedQuery(name = "CompraRequisicaoDetalheVO.findAll", query = "SELECT c FROM CompraRequisicaoDetalheVO c")})
public class CompraRequisicaoDetalheVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private BigDecimal quantidade;
    @Column(name = "quantidade_cotada")
    private BigDecimal quantidadeCotada;
    @Column(name = "item_cotado")
    private Character itemCotado;
    @JoinColumn(name = "compra_requisicao_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CompraRequisicaoVO compraRequisicaoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraRequisicaoDetalheId")
    private List<CompraReqCotacaoDetalheVO> compraReqCotacaoDetalheVOList;

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

    public CompraRequisicaoVO getCompraRequisicaoId() {
        return compraRequisicaoId;
    }

    public void setCompraRequisicaoId(CompraRequisicaoVO compraRequisicaoId) {
        this.compraRequisicaoId = compraRequisicaoId;
    }

    public List<CompraReqCotacaoDetalheVO> getCompraReqCotacaoDetalheVOList() {
        return compraReqCotacaoDetalheVOList;
    }

    public void setCompraReqCotacaoDetalheVOList(List<CompraReqCotacaoDetalheVO> compraReqCotacaoDetalheVOList) {
        this.compraReqCotacaoDetalheVOList = compraReqCotacaoDetalheVOList;
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
