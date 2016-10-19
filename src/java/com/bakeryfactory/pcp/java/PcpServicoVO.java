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
package com.bakeryfactory.pcp.java;

import com.bakeryfactory.cadastros.java.ProdutoCalculoPrecoMedidasVO;
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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "PCP_SERVICO")
public class PcpServicoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "INICIO_REALIZADO")
    @Temporal(TemporalType.DATE)
    private Date inicioRealizado;
    @Column(name = "TERMINO_REALIZADO")
    @Temporal(TemporalType.DATE)
    private Date terminoRealizado;
    @Column(name = "HORAS_REALIZADO")
    private Integer horasRealizado;
    @Column(name = "MINUTOS_REALIZADO")
    private Integer minutosRealizado;
    @Column(name = "SEGUNDOS_REALIZADO")
    private Integer segundosRealizado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CUSTO_REALIZADO")
    private BigDecimal custoRealizado;
    @Column(name = "INICIO_PREVISTO")
    @Temporal(TemporalType.DATE)
    private Date inicioPrevisto;
    @Column(name = "TERMINO_PREVISTO")
    @Temporal(TemporalType.DATE)
    private Date terminoPrevisto;
    @Column(name = "HORAS_PREVISTO")
    private Integer horasPrevisto;
    @Column(name = "MINUTOS_PREVISTO")
    private Integer minutosPrevisto;
    @Column(name = "SEGUNDOS_PREVISTO")
    private Integer segundosPrevisto;
    @Column(name = "CUSTO_PREVISTO")
    private BigDecimal custoPrevisto;
    
    @JoinColumn(name = "ID_PCP_OP_DETALHE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PcpOpDetalheVO pcpOpDetalhe;
    
    @JoinColumn(name = "ID_PRODUTO_CALCULO_PRECO_MEDIDAS", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProdutoCalculoPrecoMedidasVO produtoCalculoPrecoMedidas;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pcpServicoId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PcpServicoColaboradorVO> listaPcpServicoColaborador;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "pcpServicoId")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PcpServicoEquipamentoVO> listaPcpServicoEquipamento;

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

    public List<PcpServicoEquipamentoVO> getListaPcpServicoEquipamento() {
        return listaPcpServicoEquipamento;
    }

    public void setListaPcpServicoEquipamento(List<PcpServicoEquipamentoVO> listaPcpServicoEquipamento) {
        this.listaPcpServicoEquipamento = listaPcpServicoEquipamento;
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

    public List<PcpServicoColaboradorVO> getListaPcpServicoColaborador() {
        return listaPcpServicoColaborador;
    }

    public void setListaPcpServicoColaborador(List<PcpServicoColaboradorVO> listaPcpServicoColaborador) {
        this.listaPcpServicoColaborador = listaPcpServicoColaborador;
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
