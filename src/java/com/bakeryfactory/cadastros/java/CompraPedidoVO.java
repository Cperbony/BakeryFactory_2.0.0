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
@Table(name = "compra_pedido")
@NamedQueries({
    @NamedQuery(name = "CompraPedidoVO.findAll", query = "SELECT c FROM CompraPedidoVO c")})
public class CompraPedidoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_pedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Column(name = "data_prevista_entrega")
    @Temporal(TemporalType.DATE)
    private Date dataPrevistaEntrega;
    @Column(name = "data_previsao_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPrevisaoPagamento;
    @Column(name = "local_entrega")
    private String localEntrega;
    @Column(name = "local_cobranca")
    private String localCobranca;
    @Column(name = "contato")
    private String contato;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_subtotal")
    private BigDecimal valorSubtotal;
    @Column(name = "taxa_desconto")
    private BigDecimal taxaDesconto;
    @Column(name = "valor_desconto")
    private BigDecimal valorDesconto;
    @Column(name = "valor_total_pedido")
    private BigDecimal valorTotalPedido;
    @Column(name = "tipo_frete")
    private Character tipoFrete;
    @Column(name = "forma_pagamento")
    private Character formaPagamento;
    @Column(name = "base_calculo_icms")
    private BigDecimal baseCalculoIcms;
    @Column(name = "valor_icms")
    private BigDecimal valorIcms;
    @Column(name = "base_calculo_icms_st")
    private BigDecimal baseCalculoIcmsSt;
    @Column(name = "valor_icms_st")
    private BigDecimal valorIcmsSt;
    @Column(name = "valor_total_produtos")
    private BigDecimal valorTotalProdutos;
    @Column(name = "valor_frete")
    private BigDecimal valorFrete;
    @Column(name = "valor_seguro")
    private BigDecimal valorSeguro;
    @Column(name = "valor_outras_despesas")
    private BigDecimal valorOutrasDespesas;
    @Column(name = "valor_ipi")
    private BigDecimal valorIpi;
    @Column(name = "valor_total_nf")
    private BigDecimal valorTotalNf;
    @Column(name = "quantidade_parcelas")
    private Integer quantidadeParcelas;
    @Column(name = "dias_primeiro_vencimento")
    private Integer diasPrimeiroVencimento;
    @Column(name = "dias_intervalo")
    private Integer diasIntervalo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraPedidoId")
    private List<CompraCotacaoPedidoDetalheVO> compraCotacaoPedidoDetalheVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compraPedidoId")
    private List<CompraPedidoDetalheVO> compraPedidoDetalheVOList;
    @JoinColumn(name = "compra_tipo_pedido_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CompraTipoPedidoVO compraTipoPedidoId;

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

    public List<CompraCotacaoPedidoDetalheVO> getCompraCotacaoPedidoDetalheVOList() {
        return compraCotacaoPedidoDetalheVOList;
    }

    public void setCompraCotacaoPedidoDetalheVOList(List<CompraCotacaoPedidoDetalheVO> compraCotacaoPedidoDetalheVOList) {
        this.compraCotacaoPedidoDetalheVOList = compraCotacaoPedidoDetalheVOList;
    }

    public List<CompraPedidoDetalheVO> getCompraPedidoDetalheVOList() {
        return compraPedidoDetalheVOList;
    }

    public void setCompraPedidoDetalheVOList(List<CompraPedidoDetalheVO> compraPedidoDetalheVOList) {
        this.compraPedidoDetalheVOList = compraPedidoDetalheVOList;
    }

    public CompraTipoPedidoVO getCompraTipoPedidoId() {
        return compraTipoPedidoId;
    }

    public void setCompraTipoPedidoId(CompraTipoPedidoVO compraTipoPedidoId) {
        this.compraTipoPedidoId = compraTipoPedidoId;
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
