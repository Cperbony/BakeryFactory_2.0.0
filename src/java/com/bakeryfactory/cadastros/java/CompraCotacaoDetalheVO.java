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
import javax.persistence.Transient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "COMPRA_COTACAO_DETALHE")
public class CompraCotacaoDetalheVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    @Column(name = "QUANTIDADE_PEDIDA")
    private BigDecimal quantidadePedida;
    @Column(name = "VALOR_UNITARIO")
    private BigDecimal valorUnitario;
    @Column(name = "VALOR_SUBTOTAL")
    private BigDecimal valorSubtotal;
    @Column(name = "TAXA_DESCONTO")
    private BigDecimal taxaDesconto;
    @Column(name = "VALOR_DESCONTO")
    private BigDecimal valorDesconto;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compraCotacaoDetalhe")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraCotacaoPedidoDetalheVO> listaCompraCotacaoPedidoDetalhe;
    
    @JoinColumn(name = "ID_COMPRA_FORNECEDOR_COTACAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CompraFornecedorCotacaoVO compraFornecedorCotacao;
    
    @JoinColumn(name = "ID_FORNECEDOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FornecedorVO fornecedor;
    
    @JoinColumn(name = "ID_INGREDIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private IngredienteVO ingrediente;
    
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoVO produto;
    
    @Transient
    private CompraRequisicaoDetalheVO compraRequisicaoDetalhe;
    

    public CompraCotacaoDetalheVO() {
    }

    public CompraCotacaoDetalheVO(Integer id) {
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

    public BigDecimal getQuantidadePedida() {
        return quantidadePedida;
    }

    public void setQuantidadePedida(BigDecimal quantidadePedida) {
        this.quantidadePedida = quantidadePedida;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorSubtotal() {
        return valorSubtotal;
    }

    public void setValorSubtotal(BigDecimal valorSubtotal) {
        this.valorSubtotal = valorSubtotal;
    }

    public BigDecimal getTaxaDesconto() {
        return taxaDesconto;
    }

    public void setTaxaDesconto(BigDecimal taxaDesconto) {
        this.taxaDesconto = taxaDesconto;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<CompraCotacaoPedidoDetalheVO> getListaCompraCotacaoPedidoDetalhe() {
        return listaCompraCotacaoPedidoDetalhe;
    }

    public void setListaCompraCotacaoPedidoDetalhe(List<CompraCotacaoPedidoDetalheVO> listaCompraCotacaoPedidoDetalhe) {
        this.listaCompraCotacaoPedidoDetalhe = listaCompraCotacaoPedidoDetalhe;
    }

    public CompraFornecedorCotacaoVO getCompraFornecedorCotacao() {
        return compraFornecedorCotacao;
    }

    public void setCompraFornecedorCotacao(CompraFornecedorCotacaoVO compraFornecedorCotacao) {
        this.compraFornecedorCotacao = compraFornecedorCotacao;
    }

    public FornecedorVO getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorVO fornecedor) {
        this.fornecedor = fornecedor;
    }

    public IngredienteVO getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(IngredienteVO ingrediente) {
        this.ingrediente = ingrediente;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    public CompraRequisicaoDetalheVO getCompraRequisicaoDetalhe() {
        return compraRequisicaoDetalhe;
    }

    public void setCompraRequisicaoDetalhe(CompraRequisicaoDetalheVO compraRequisicaoDetalhe) {
        this.compraRequisicaoDetalhe = compraRequisicaoDetalhe;
    }
    


    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.CompraCotacaoDetalheVO[ id=" + id + " ]";
    }
    
}
