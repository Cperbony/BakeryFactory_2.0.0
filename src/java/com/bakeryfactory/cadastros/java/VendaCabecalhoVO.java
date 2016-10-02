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
@Table(name = "venda_cabecalho")
@NamedQueries({
    @NamedQuery(name = "VendaCabecalhoVO.findAll", query = "SELECT v FROM VendaCabecalhoVO v")})
public class VendaCabecalhoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "data_venda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Column(name = "data_saida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Column(name = "hora_saida")
    private String horaSaida;
    @Column(name = "numero_fatura")
    private Integer numeroFatura;
    @Column(name = "local_entrega")
    private String localEntrega;
    @Column(name = "local_cobranca")
    private String localCobranca;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_subtotal")
    private BigDecimal valorSubtotal;
    @Column(name = "taxa_comissao")
    private BigDecimal taxaComissao;
    @Column(name = "taxa_desconto")
    private BigDecimal taxaDesconto;
    @Column(name = "valor_desconto")
    private BigDecimal valorDesconto;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "tipo_frete")
    private Character tipoFrete;
    @Column(name = "forma_pagamento")
    private Character formaPagamento;
    @Column(name = "valor_frete")
    private BigDecimal valorFrete;
    @Column(name = "valor_seguro")
    private BigDecimal valorSeguro;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "situacao")
    private Character situacao;
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClienteVO clienteId;
    @JoinColumn(name = "nota_fiscal_tipo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NotaFiscalTipoVO notaFiscalTipoId;
    @JoinColumn(name = "transportadora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransportadoraVO transportadoraId;
    @JoinColumn(name = "venda_condicoes_pagamento_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VendaCondicoesPagamentoVO vendaCondicoesPagamentoId;
    @JoinColumn(name = "venda_romaneio_entrega_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VendaRomaneioEntregaVO vendaRomaneioEntregaId;
    @JoinColumn(name = "vendedor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VendedorVO vendedorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaCabecalhoId")
    private List<VendaComissaoVO> vendaComissaoVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaCabecalhoId")
    private List<VendaFreteVO> vendaFreteVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendaCabecalhoId")
    private List<VendaDetalheVO> vendaDetalheVOList;

    public VendaCabecalhoVO() {
    }

    public VendaCabecalhoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Integer getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(Integer numeroFatura) {
        this.numeroFatura = numeroFatura;
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

    public BigDecimal getValorSubtotal() {
        return valorSubtotal;
    }

    public void setValorSubtotal(BigDecimal valorSubtotal) {
        this.valorSubtotal = valorSubtotal;
    }

    public BigDecimal getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(BigDecimal taxaComissao) {
        this.taxaComissao = taxaComissao;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public ClienteVO getClienteId() {
        return clienteId;
    }

    public void setClienteId(ClienteVO clienteId) {
        this.clienteId = clienteId;
    }

    public NotaFiscalTipoVO getNotaFiscalTipoId() {
        return notaFiscalTipoId;
    }

    public void setNotaFiscalTipoId(NotaFiscalTipoVO notaFiscalTipoId) {
        this.notaFiscalTipoId = notaFiscalTipoId;
    }

    public TransportadoraVO getTransportadoraId() {
        return transportadoraId;
    }

    public void setTransportadoraId(TransportadoraVO transportadoraId) {
        this.transportadoraId = transportadoraId;
    }

    public VendaCondicoesPagamentoVO getVendaCondicoesPagamentoId() {
        return vendaCondicoesPagamentoId;
    }

    public void setVendaCondicoesPagamentoId(VendaCondicoesPagamentoVO vendaCondicoesPagamentoId) {
        this.vendaCondicoesPagamentoId = vendaCondicoesPagamentoId;
    }

    public VendaRomaneioEntregaVO getVendaRomaneioEntregaId() {
        return vendaRomaneioEntregaId;
    }

    public void setVendaRomaneioEntregaId(VendaRomaneioEntregaVO vendaRomaneioEntregaId) {
        this.vendaRomaneioEntregaId = vendaRomaneioEntregaId;
    }

    public VendedorVO getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(VendedorVO vendedorId) {
        this.vendedorId = vendedorId;
    }

    public List<VendaComissaoVO> getVendaComissaoVOList() {
        return vendaComissaoVOList;
    }

    public void setVendaComissaoVOList(List<VendaComissaoVO> vendaComissaoVOList) {
        this.vendaComissaoVOList = vendaComissaoVOList;
    }

    public List<VendaFreteVO> getVendaFreteVOList() {
        return vendaFreteVOList;
    }

    public void setVendaFreteVOList(List<VendaFreteVO> vendaFreteVOList) {
        this.vendaFreteVOList = vendaFreteVOList;
    }

    public List<VendaDetalheVO> getVendaDetalheVOList() {
        return vendaDetalheVOList;
    }

    public void setVendaDetalheVOList(List<VendaDetalheVO> vendaDetalheVOList) {
        this.vendaDetalheVOList = vendaDetalheVOList;
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
        if (!(object instanceof VendaCabecalhoVO)) {
            return false;
        }
        VendaCabecalhoVO other = (VendaCabecalhoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.VendaCabecalhoVO[ id=" + id + " ]";
    }
    
}
