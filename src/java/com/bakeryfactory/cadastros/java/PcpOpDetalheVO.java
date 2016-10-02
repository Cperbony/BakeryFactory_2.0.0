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
@Table(name = "pcp_op_detalhe")
@NamedQueries({
    @NamedQuery(name = "PcpOpDetalheVO.findAll", query = "SELECT p FROM PcpOpDetalheVO p")})
public class PcpOpDetalheVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade_produzir")
    private BigDecimal quantidadeProduzir;
    @Column(name = "quantidade_produzida")
    private BigDecimal quantidadeProduzida;
    @Column(name = "quantidade_entregue")
    private BigDecimal quantidadeEntregue;
    @Column(name = "custo_previsto")
    private BigDecimal custoPrevisto;
    @Column(name = "custo_realizado")
    private BigDecimal custoRealizado;
    @JoinColumn(name = "pcp_op_cabecalho_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PcpOpCabecalhoVO pcpOpCabecalhoId;
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProdutoVO produtoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pcpOpDetalheId")
    private List<PcpServicoVO> pcpServicoVOList;

    public PcpOpDetalheVO() {
    }

    public PcpOpDetalheVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantidadeProduzir() {
        return quantidadeProduzir;
    }

    public void setQuantidadeProduzir(BigDecimal quantidadeProduzir) {
        this.quantidadeProduzir = quantidadeProduzir;
    }

    public BigDecimal getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(BigDecimal quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public BigDecimal getQuantidadeEntregue() {
        return quantidadeEntregue;
    }

    public void setQuantidadeEntregue(BigDecimal quantidadeEntregue) {
        this.quantidadeEntregue = quantidadeEntregue;
    }

    public BigDecimal getCustoPrevisto() {
        return custoPrevisto;
    }

    public void setCustoPrevisto(BigDecimal custoPrevisto) {
        this.custoPrevisto = custoPrevisto;
    }

    public BigDecimal getCustoRealizado() {
        return custoRealizado;
    }

    public void setCustoRealizado(BigDecimal custoRealizado) {
        this.custoRealizado = custoRealizado;
    }

    public PcpOpCabecalhoVO getPcpOpCabecalhoId() {
        return pcpOpCabecalhoId;
    }

    public void setPcpOpCabecalhoId(PcpOpCabecalhoVO pcpOpCabecalhoId) {
        this.pcpOpCabecalhoId = pcpOpCabecalhoId;
    }

    public ProdutoVO getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(ProdutoVO produtoId) {
        this.produtoId = produtoId;
    }

    public List<PcpServicoVO> getPcpServicoVOList() {
        return pcpServicoVOList;
    }

    public void setPcpServicoVOList(List<PcpServicoVO> pcpServicoVOList) {
        this.pcpServicoVOList = pcpServicoVOList;
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
        if (!(object instanceof PcpOpDetalheVO)) {
            return false;
        }
        PcpOpDetalheVO other = (PcpOpDetalheVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.PcpOpDetalheVO[ id=" + id + " ]";
    }
    
}
