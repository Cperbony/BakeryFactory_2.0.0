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
@Table(name = "pcp_servico")
public class PcpServicoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "inicio_realizado")
    @Temporal(TemporalType.DATE)
    private Date inicioRealizado;
    @Column(name = "termino_realizado")
    @Temporal(TemporalType.DATE)
    private Date terminoRealizado;
    @Column(name = "horas_realizado")
    private Integer horasRealizado;
    @Column(name = "minutos_realizado")
    private Integer minutosRealizado;
    @Column(name = "segundos_realizado")
    private Integer segundosRealizado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "custo_realizado")
    private BigDecimal custoRealizado;
    @Column(name = "inicio_previsto")
    @Temporal(TemporalType.DATE)
    private Date inicioPrevisto;
    @Column(name = "termino_previsto")
    @Temporal(TemporalType.DATE)
    private Date terminoPrevisto;
    @Column(name = "horas_previsto")
    private Integer horasPrevisto;
    @Column(name = "minutos_previsto")
    private Integer minutosPrevisto;
    @Column(name = "segundos_previsto")
    private Integer segundosPrevisto;
    @Column(name = "custo_previsto")
    private BigDecimal custoPrevisto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pcpServicoId")
    private List<PcpServicoEquipamentoVO> pcpServicoEquipamentoList;
    @JoinColumn(name = "pcp_op_detalhe_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PcpOpDetalheVO pcpOpDetalhe;
    @JoinColumn(name = "produto_calculo_preco_medidas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProdutoCalculoPrecoMedidasVO produtoCalculoPrecoMedidas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pcpServicoId")
    private List<PcpServicoColaboradorVO> pcpServicoColaboradorList;

    public PcpServicoVO() {
    }

    public PcpServicoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicioRealizado() {
        return inicioRealizado;
    }

    public void setInicioRealizado(Date inicioRealizado) {
        this.inicioRealizado = inicioRealizado;
    }

    public Date getTerminoRealizado() {
        return terminoRealizado;
    }

    public void setTerminoRealizado(Date terminoRealizado) {
        this.terminoRealizado = terminoRealizado;
    }

    public Integer getHorasRealizado() {
        return horasRealizado;
    }

    public void setHorasRealizado(Integer horasRealizado) {
        this.horasRealizado = horasRealizado;
    }

    public Integer getMinutosRealizado() {
        return minutosRealizado;
    }

    public void setMinutosRealizado(Integer minutosRealizado) {
        this.minutosRealizado = minutosRealizado;
    }

    public Integer getSegundosRealizado() {
        return segundosRealizado;
    }

    public void setSegundosRealizado(Integer segundosRealizado) {
        this.segundosRealizado = segundosRealizado;
    }

    public BigDecimal getCustoRealizado() {
        return custoRealizado;
    }

    public void setCustoRealizado(BigDecimal custoRealizado) {
        this.custoRealizado = custoRealizado;
    }

    public Date getInicioPrevisto() {
        return inicioPrevisto;
    }

    public void setInicioPrevisto(Date inicioPrevisto) {
        this.inicioPrevisto = inicioPrevisto;
    }

    public Date getTerminoPrevisto() {
        return terminoPrevisto;
    }

    public void setTerminoPrevisto(Date terminoPrevisto) {
        this.terminoPrevisto = terminoPrevisto;
    }

    public Integer getHorasPrevisto() {
        return horasPrevisto;
    }

    public void setHorasPrevisto(Integer horasPrevisto) {
        this.horasPrevisto = horasPrevisto;
    }

    public Integer getMinutosPrevisto() {
        return minutosPrevisto;
    }

    public void setMinutosPrevisto(Integer minutosPrevisto) {
        this.minutosPrevisto = minutosPrevisto;
    }

    public Integer getSegundosPrevisto() {
        return segundosPrevisto;
    }

    public void setSegundosPrevisto(Integer segundosPrevisto) {
        this.segundosPrevisto = segundosPrevisto;
    }

    public BigDecimal getCustoPrevisto() {
        return custoPrevisto;
    }

    public void setCustoPrevisto(BigDecimal custoPrevisto) {
        this.custoPrevisto = custoPrevisto;
    }

    public List<PcpServicoEquipamentoVO> getPcpServicoEquipamentoList() {
        return pcpServicoEquipamentoList;
    }

    public void setPcpServicoEquipamentoList(List<PcpServicoEquipamentoVO> pcpServicoEquipamentoList) {
        this.pcpServicoEquipamentoList = pcpServicoEquipamentoList;
    }

    public PcpOpDetalheVO getPcpOpDetalhe() {
        return pcpOpDetalhe;
    }

    public void setPcpOpDetalhe(PcpOpDetalheVO pcpOpDetalhe) {
        this.pcpOpDetalhe = pcpOpDetalhe;
    }

    public ProdutoCalculoPrecoMedidasVO getProdutoCalculoPrecoMedidas() {
        return produtoCalculoPrecoMedidas;
    }

    public void setProdutoCalculoPrecoMedidas(ProdutoCalculoPrecoMedidasVO produtoCalculoPrecoMedidas) {
        this.produtoCalculoPrecoMedidas = produtoCalculoPrecoMedidas;
    }

    public List<PcpServicoColaboradorVO> getPcpServicoColaboradorList() {
        return pcpServicoColaboradorList;
    }

    public void setPcpServicoColaboradorList(List<PcpServicoColaboradorVO> pcpServicoColaboradorList) {
        this.pcpServicoColaboradorList = pcpServicoColaboradorList;
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
        if (!(object instanceof PcpServicoVO)) {
            return false;
        }
        PcpServicoVO other = (PcpServicoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.PcpServicoVO[ id=" + id + " ]";
    }
    
}
