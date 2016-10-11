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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "RECEITUARIO_PADRAO")
public class ReceituarioPadraoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReceituarioPadraoVOPK receituarioPadraoVOPK;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORCENTAGEM_INGREDIENTE")
    private BigDecimal porcentagemIngredientes;
    @Column(name = "INGREDIENTE_MASSA")
    private String ingredienteMassa;
    @Column(name = "PADRAO_COMPOSICAO")
    private BigDecimal padraoComposicao;
    @Column(name = "TOTAL_GRAMA")
    private BigDecimal totalGrama;
    @Column(name = "TOTAL_UNIDADES")
    private BigDecimal totalUnidades;
    @Column(name = "RENDIMENTO")
    private BigDecimal rendimento;
    @Column(name = "PERDA")
    private BigDecimal perda;
    @Column(name = "PESO_BOLA")
    private BigDecimal pesoBola;
    @Column(name = "NUMERO_DIVISAO")
    private Integer numeroDivisao;
    @Column(name = "BASE_CALC_PERDAS")
    private Integer baseCalcPerdas;
    @Column(name = "PERDA_COMUM")
    private Integer perdaComum;
    
    @JoinColumn(name = "ID_RECEITUARIO_CONTROLE_CUSTO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ReceituarioControleCustoVO receituarioControleCusto;

    public ReceituarioPadraoVO() {
    }

    public ReceituarioPadraoVO(ReceituarioPadraoVOPK receituarioPadraoVOPK) {
        this.receituarioPadraoVOPK = receituarioPadraoVOPK;
    }

    public ReceituarioPadraoVO(int id, int receituarioControleCustoId) {
        this.receituarioPadraoVOPK = new ReceituarioPadraoVOPK(id, receituarioControleCustoId);
    }

    public ReceituarioPadraoVOPK getReceituarioPadraoVOPK() {
        return receituarioPadraoVOPK;
    }

    public void setReceituarioPadraoVOPK(ReceituarioPadraoVOPK receituarioPadraoVOPK) {
        this.receituarioPadraoVOPK = receituarioPadraoVOPK;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPorcentagemIngredientes() {
        return porcentagemIngredientes;
    }

    public void setPorcentagemIngredientes(BigDecimal porcentagemIngredientes) {
        this.porcentagemIngredientes = porcentagemIngredientes;
    }

    public String getIngredienteMassa() {
        return ingredienteMassa;
    }

    public void setIngredienteMassa(String ingredienteMassa) {
        this.ingredienteMassa = ingredienteMassa;
    }

    public BigDecimal getPadraoComposicao() {
        return padraoComposicao;
    }

    public void setPadraoComposicao(BigDecimal padraoComposicao) {
        this.padraoComposicao = padraoComposicao;
    }

    public BigDecimal getTotalGrama() {
        return totalGrama;
    }

    public void setTotalGrama(BigDecimal totalGrama) {
        this.totalGrama = totalGrama;
    }

    public BigDecimal getTotalUnidades() {
        return totalUnidades;
    }

    public void setTotalUnidades(BigDecimal totalUnidades) {
        this.totalUnidades = totalUnidades;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    public BigDecimal getPerda() {
        return perda;
    }

    public void setPerda(BigDecimal perda) {
        this.perda = perda;
    }

    public BigDecimal getPesoBola() {
        return pesoBola;
    }

    public void setPesoBola(BigDecimal pesoBola) {
        this.pesoBola = pesoBola;
    }

    public Integer getNumeroDivisao() {
        return numeroDivisao;
    }

    public void setNumeroDivisao(Integer numeroDivisao) {
        this.numeroDivisao = numeroDivisao;
    }

    public Integer getBaseCalcPerdas() {
        return baseCalcPerdas;
    }

    public void setBaseCalcPerdas(Integer baseCalcPerdas) {
        this.baseCalcPerdas = baseCalcPerdas;
    }

    public Integer getPerdaComum() {
        return perdaComum;
    }

    public void setPerdaComum(Integer perdaComum) {
        this.perdaComum = perdaComum;
    }

    public ReceituarioControleCustoVO getReceituarioControleCusto() {
        return receituarioControleCusto;
    }

    public void setReceituarioControleCusto(ReceituarioControleCustoVO receituarioControleCusto) {
        this.receituarioControleCusto = receituarioControleCusto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receituarioPadraoVOPK != null ? receituarioPadraoVOPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceituarioPadraoVO)) {
            return false;
        }
        ReceituarioPadraoVO other = (ReceituarioPadraoVO) object;
        if ((this.receituarioPadraoVOPK == null && other.receituarioPadraoVOPK != null) || (this.receituarioPadraoVOPK != null && !this.receituarioPadraoVOPK.equals(other.receituarioPadraoVOPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ReceituarioPadraoVO[ receituarioPadraoVOPK=" + receituarioPadraoVOPK + " ]";
    }
    
}
