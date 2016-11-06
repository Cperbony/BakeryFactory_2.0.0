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
package com.bakeryfactory.vendas.java;

import com.bakeryfactory.cadastros.java.TransportadoraVO;
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
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "VENDA_FRETE")
public class VendaFreteVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CONHECIMENTO")
    private Integer conhecimento;
    @Column(name = "RESPONSAVEL")
    private Character responsavel;
    @Column(name = "PLACA")
    private String placa;
    @Column(name = "UF_PLACA")
    private String ufPlaca;
    @Column(name = "SELO_FISCAL")
    private Integer seloFiscal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE_VOLUME")
    private BigDecimal quantidadeVolume;
    @Column(name = "MARCA_VOLUME")
    private String marcaVolume;
    @Column(name = "ESPECIE_VOLUME")
    private String especieVolume;
    @Column(name = "PESO_BRUTO")
    private BigDecimal pesoBruto;
    @Column(name = "PESO_LIQUIDO")
    private BigDecimal pesoLiquido;
    
    @JoinColumn(name = "ID_TRANSPORTADORA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TransportadoraVO transportadora;
    
    @JoinColumn(name = "ID_VENDA_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private VendaCabecalhoVO vendaCabecalho;

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

    public TransportadoraVO getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(TransportadoraVO transportadora) {
        this.transportadora = transportadora;
    }

    public VendaCabecalhoVO getVendaCabecalho() {
        return vendaCabecalho;
    }

    public void setVendaCabecalho(VendaCabecalhoVO vendaCabecalho) {
        this.vendaCabecalho = vendaCabecalho;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.VendaFreteVO[ id=" + id + " ]";
    }
    
}
