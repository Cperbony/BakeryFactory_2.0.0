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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "venda_frete")
@NamedQueries({
    @NamedQuery(name = "VendaFreteVO.findAll", query = "SELECT v FROM VendaFreteVO v")})
public class VendaFreteVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "conhecimento")
    private Integer conhecimento;
    @Column(name = "responsavel")
    private Character responsavel;
    @Column(name = "placa")
    private String placa;
    @Column(name = "uf_placa")
    private String ufPlaca;
    @Column(name = "selo_fiscal")
    private Integer seloFiscal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade_volume")
    private BigDecimal quantidadeVolume;
    @Column(name = "marca_volume")
    private String marcaVolume;
    @Column(name = "especie_volume")
    private String especieVolume;
    @Column(name = "peso_bruto")
    private BigDecimal pesoBruto;
    @Column(name = "peso_liquido")
    private BigDecimal pesoLiquido;
    @JoinColumn(name = "transportadora_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TransportadoraVO transportadoraId;
    @JoinColumn(name = "venda_cabecalho_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private VendaCabecalhoVO vendaCabecalhoId;

    public VendaFreteVO() {
    }

    public VendaFreteVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConhecimento() {
        return conhecimento;
    }

    public void setConhecimento(Integer conhecimento) {
        this.conhecimento = conhecimento;
    }

    public Character getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Character responsavel) {
        this.responsavel = responsavel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getUfPlaca() {
        return ufPlaca;
    }

    public void setUfPlaca(String ufPlaca) {
        this.ufPlaca = ufPlaca;
    }

    public Integer getSeloFiscal() {
        return seloFiscal;
    }

    public void setSeloFiscal(Integer seloFiscal) {
        this.seloFiscal = seloFiscal;
    }

    public BigDecimal getQuantidadeVolume() {
        return quantidadeVolume;
    }

    public void setQuantidadeVolume(BigDecimal quantidadeVolume) {
        this.quantidadeVolume = quantidadeVolume;
    }

    public String getMarcaVolume() {
        return marcaVolume;
    }

    public void setMarcaVolume(String marcaVolume) {
        this.marcaVolume = marcaVolume;
    }

    public String getEspecieVolume() {
        return especieVolume;
    }

    public void setEspecieVolume(String especieVolume) {
        this.especieVolume = especieVolume;
    }

    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public BigDecimal getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(BigDecimal pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public TransportadoraVO getTransportadoraId() {
        return transportadoraId;
    }

    public void setTransportadoraId(TransportadoraVO transportadoraId) {
        this.transportadoraId = transportadoraId;
    }

    public VendaCabecalhoVO getVendaCabecalhoId() {
        return vendaCabecalhoId;
    }

    public void setVendaCabecalhoId(VendaCabecalhoVO vendaCabecalhoId) {
        this.vendaCabecalhoId = vendaCabecalhoId;
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
        if (!(object instanceof VendaFreteVO)) {
            return false;
        }
        VendaFreteVO other = (VendaFreteVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.VendaFreteVO[ id=" + id + " ]";
    }
    
}
