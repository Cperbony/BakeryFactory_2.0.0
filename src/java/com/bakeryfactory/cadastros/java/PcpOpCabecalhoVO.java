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
@Table(name = "pcp_op_cabecalho")
public class PcpOpCabecalhoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Column(name = "previsao_entrega")
    @Temporal(TemporalType.DATE)
    private Date previsaoEntrega;
    @Column(name = "termino")
    @Temporal(TemporalType.DATE)
    private Date termino;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_total_previsto")
    private BigDecimal custoTotalPrevisto;
    @Column(name = "custo_total_realizado")
    private BigDecimal custoTotalRealizado;
    @Column(name = "porcento_venda")
    private BigDecimal porcentoVenda;
    @Column(name = "porcento_estoque")
    private BigDecimal porcentoEstoque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pcpOpCabecalhoId")
    private List<PcpInstrucaoOpVO> pcpInstrucaoOpList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pcpOpCabecalhoId")
    private List<PcpOpDetalheVO> pcpOpDetalheList;

    public PcpOpCabecalhoVO() {
    }

    public PcpOpCabecalhoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Date previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public BigDecimal getCustoTotalPrevisto() {
        return custoTotalPrevisto;
    }

    public void setCustoTotalPrevisto(BigDecimal custoTotalPrevisto) {
        this.custoTotalPrevisto = custoTotalPrevisto;
    }

    public BigDecimal getCustoTotalRealizado() {
        return custoTotalRealizado;
    }

    public void setCustoTotalRealizado(BigDecimal custoTotalRealizado) {
        this.custoTotalRealizado = custoTotalRealizado;
    }

    public BigDecimal getPorcentoVenda() {
        return porcentoVenda;
    }

    public void setPorcentoVenda(BigDecimal porcentoVenda) {
        this.porcentoVenda = porcentoVenda;
    }

    public BigDecimal getPorcentoEstoque() {
        return porcentoEstoque;
    }

    public void setPorcentoEstoque(BigDecimal porcentoEstoque) {
        this.porcentoEstoque = porcentoEstoque;
    }

    public List<PcpInstrucaoOpVO> getPcpInstrucaoOpList() {
        return pcpInstrucaoOpList;
    }

    public void setPcpInstrucaoOpList(List<PcpInstrucaoOpVO> pcpInstrucaoOpList) {
        this.pcpInstrucaoOpList = pcpInstrucaoOpList;
    }

    public List<PcpOpDetalheVO> getPcpOpDetalheList() {
        return pcpOpDetalheList;
    }

    public void setPcpOpDetalheList(List<PcpOpDetalheVO> pcpOpDetalheList) {
        this.pcpOpDetalheList = pcpOpDetalheList;
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
        if (!(object instanceof PcpOpCabecalhoVO)) {
            return false;
        }
        PcpOpCabecalhoVO other = (PcpOpCabecalhoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.PcpOpCabecalhoVO[ id=" + id + " ]";
    }
    
}
