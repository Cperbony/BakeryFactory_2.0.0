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
import java.math.BigDecimal;
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
@Table(name = "COMPRA_PEDIDO")
public class CompraPedidoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATA_PEDIDO")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Column(name = "DATA_PREVISTA_ENTREGA")
    @Temporal(TemporalType.DATE)
    private Date dataPrevistaEntrega;
    @Column(name = "DATA_PREVISAO_PAGAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataPrevisaoPagamento;
    @Column(name = "LOCAL_ENTREGA")
    private String localEntrega;
    @Column(name = "LOCAL_COBRANCA")
    private String localCobranca;
    @Column(name = "CONTATO")
    private String contato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALOR_SUBTOTAL")
    private BigDecimal valorSubtotal;
    @Column(name = "TAXA_DESCONTO")
    private BigDecimal taxaDesconto;
    @Column(name = "VALOR_DESCONTO")
    private BigDecimal valorDesconto;
    @Column(name = "VALOR_TOTAL_PEDIDO")
    private BigDecimal valorTotalPedido;
    @Column(name = "TIPO_FRETE")
    private Character tipoFrete;
    @Column(name = "FORMA_PAGAMENTO")
    private Character formaPagamento;
    @Column(name = "BASE_CALCULO_ICMS")
    private BigDecimal baseCalculoIcms;
    @Column(name = "VALOR_ICMS")
    private BigDecimal valorIcms;
    @Column(name = "BASE_CALCULO_ICMS_ST")
    private BigDecimal baseCalculoIcmsSt;
    @Column(name = "VALOR_ICMS_ST")
    private BigDecimal valorIcmsSt;
    @Column(name = "VALOR_TOTAL_PRODUTOS")
    private BigDecimal valorTotalProdutos;
    @Column(name = "VALOR_FRETE")
    private BigDecimal valorFrete;
    @Column(name = "VALOR_SEGURO")
    private BigDecimal valorSeguro;
    @Column(name = "VALOR_OUTRAS_DESPESAS")
    private BigDecimal valorOutrasDespesas;
    @Column(name = "VALOR_IPI")
    private BigDecimal valorIpi;
    @Column(name = "VALOR_TOTAL_NF")
    private BigDecimal valorTotalNf;
    @Column(name = "QUANTIDADE_PARCELAS")
    private Integer quantidadeParcelas;
    @Column(name = "DIAS_PRIMEIRO_VENCIMENTO")
    private Integer diasPrimeiroVencimento;
    @Column(name = "DIAS_INTERVALO")
    private Integer diasIntervalo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compraPedido")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraCotacaoPedidoDetalheVO> listaCompraCotacaoPedidoDetalhe;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compraPedido")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraPedidoDetalheVO> listaCompraPedidoDetalhe;

    @JoinColumn(name = "ID_COMPRA_TIPO_PEDIDO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CompraTipoPedidoVO compraTipoPedido;

    public CompraPedidoVO() {
    }

    public CompraPedidoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public Date getDataPrevisaoPagamento() {
        return dataPrevisaoPagamento;
    }

    public void setDataPrevisaoPagamento(Date dataPrevisaoPagamento) {
        this.dataPrevisaoPagamento = dataPrevisaoPagamento;
    }

    public String getLocalEntrega() {
        return localEntrega;
    }

    public void setLocalEntrega(String localEntrega) {
        this.localEntrega = localEntrega;
    }

    public String getLocalCobranca() {
        return localCobranca;
    }

    public void setLocalCobranca(String localCobranca) {
        this.localCobranca = localCobranca;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
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

    public BigDecimal getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(BigDecimal valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public Character getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(Character tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    public Character getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Character formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getBaseCalculoIcms() {
        return baseCalculoIcms;
    }

    public void setBaseCalculoIcms(BigDecimal baseCalculoIcms) {
        this.baseCalculoIcms = baseCalculoIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getBaseCalculoIcmsSt() {
        return baseCalculoIcmsSt;
    }

    public void setBaseCalculoIcmsSt(BigDecimal baseCalculoIcmsSt) {
        this.baseCalculoIcmsSt = baseCalculoIcmsSt;
    }

    public BigDecimal getValorIcmsSt() {
        return valorIcmsSt;
    }

    public void setValorIcmsSt(BigDecimal valorIcmsSt) {
        this.valorIcmsSt = valorIcmsSt;
    }

    public BigDecimal getValorTotalProdutos() {
        return valorTotalProdutos;
    }

    public void setValorTotalProdutos(BigDecimal valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    public BigDecimal getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(BigDecimal valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public BigDecimal getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(BigDecimal valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public BigDecimal getValorIpi() {
        return valorIpi;
    }

    public void setValorIpi(BigDecimal valorIpi) {
        this.valorIpi = valorIpi;
    }

    public BigDecimal getValorTotalNf() {
        return valorTotalNf;
    }

    public void setValorTotalNf(BigDecimal valorTotalNf) {
        this.valorTotalNf = valorTotalNf;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public Integer getDiasPrimeiroVencimento() {
        return diasPrimeiroVencimento;
    }

    public void setDiasPrimeiroVencimento(Integer diasPrimeiroVencimento) {
        this.diasPrimeiroVencimento = diasPrimeiroVencimento;
    }

    public Integer getDiasIntervalo() {
        return diasIntervalo;
    }

    public void setDiasIntervalo(Integer diasIntervalo) {
        this.diasIntervalo = diasIntervalo;
    }

    public List<CompraCotacaoPedidoDetalheVO> getListaCompraCotacaoPedidoDetalhe() {
        return listaCompraCotacaoPedidoDetalhe;
    }

    public void setListaCompraCotacaoPedidoDetalhe(List<CompraCotacaoPedidoDetalheVO> listaCompraCotacaoPedidoDetalhe) {
        this.listaCompraCotacaoPedidoDetalhe = listaCompraCotacaoPedidoDetalhe;
    }

    public List<CompraPedidoDetalheVO> getListaCompraPedidoDetalhe() {
        return listaCompraPedidoDetalhe;
    }

    public void setListaCompraPedidoDetalhe(List<CompraPedidoDetalheVO> listaCompraPedidoDetalhe) {
        this.listaCompraPedidoDetalhe = listaCompraPedidoDetalhe;
    }

    public CompraTipoPedidoVO getCompraTipoPedido() {
        return compraTipoPedido;
    }

    public void setCompraTipoPedido(CompraTipoPedidoVO compraTipoPedido) {
        this.compraTipoPedido = compraTipoPedido;
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
        if (!(object instanceof CompraPedidoVO)) {
            return false;
        }
        CompraPedidoVO other = (CompraPedidoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.CompraPedidoVO[ id=" + id + " ]";
    }

}
