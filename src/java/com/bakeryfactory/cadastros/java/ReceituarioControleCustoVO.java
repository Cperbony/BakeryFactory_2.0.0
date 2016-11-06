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

import com.bakeryfactory.pcp.java.ProdutoCalculoPrecoMedidasVO;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "RECEITUARIO_CONTROLE_CUSTO")
public class ReceituarioControleCustoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORCENTAGEM_INGREDIENTE")
    private BigDecimal porcentagemIngrediente;
    @Column(name = "INGREDIENTE_MASSA")
    private String ingredienteMassa;
    @Column(name = "PADRAO_GRAMA")
    private Integer padraoGrama;
    @Column(name = "PESO_MASSA")
    private BigDecimal pesoMassa;
    @Column(name = "RENDIMENTO_UNIDADE")
    private Integer rendimentoUnidade;
    @Column(name = "RENDIMENTO_KG")
    private BigDecimal rendimentoKg;
    @Column(name = "CUSTO_UNIDADE")
    private BigDecimal custoUnidade;
    @Column(name = "CUSTO_KG")
    private BigDecimal custoKg;
    @Column(name = "VALOR_UNIDADE")
    private BigDecimal valorUnidade;
    @Column(name = "VALOR_KG")
    private BigDecimal valorKg;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @Column(name = "VALOR_DE_VENDA")
    private BigDecimal valorDeVenda;
    @Column(name = "TOTAL_SOMA_CUSTO")
    private BigDecimal totalSomaCusto;
    @Column(name = "MARK_UP_MINIMO")
    private Integer markUpMinimo;
    @Column(name = "MARK_UP_PROMOCIONAL")
    private Integer markUpPromocional;
    
    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true, mappedBy = "receituarioControleCusto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProdutoCalculoPrecoMedidasVO> listaProdutoCalculoPrecoMedidas;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "receituarioControleCusto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ReceituarioPadraoVO> listaReceituarioPadrao;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "receituarioControleCusto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<IngredienteVO> listaIngrediente;
    
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoVO produto;

    public ReceituarioControleCustoVO() {
    }

    public ReceituarioControleCustoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPorcentagemIngrediente() {
        return porcentagemIngrediente;
    }

    public void setPorcentagemIngrediente(BigDecimal porcentagemIngrediente) {
        this.porcentagemIngrediente = porcentagemIngrediente;
    }

    public String getIngredienteMassa() {
        return ingredienteMassa;
    }

    public void setIngredienteMassa(String ingredienteMassa) {
        this.ingredienteMassa = ingredienteMassa;
    }

    public Integer getPadraoGrama() {
        return padraoGrama;
    }

    public void setPadraoGrama(Integer padraoGrama) {
        this.padraoGrama = padraoGrama;
    }

    public BigDecimal getPesoMassa() {
        return pesoMassa;
    }

    public void setPesoMassa(BigDecimal pesoMassa) {
        this.pesoMassa = pesoMassa;
    }

    public Integer getRendimentoUnidade() {
        return rendimentoUnidade;
    }

    public void setRendimentoUnidade(Integer rendimentoUnidade) {
        this.rendimentoUnidade = rendimentoUnidade;
    }

    public BigDecimal getRendimentoKg() {
        return rendimentoKg;
    }

    public void setRendimentoKg(BigDecimal rendimentoKg) {
        this.rendimentoKg = rendimentoKg;
    }

    public BigDecimal getCustoUnidade() {
        return custoUnidade;
    }

    public void setCustoUnidade(BigDecimal custoUnidade) {
        this.custoUnidade = custoUnidade;
    }

    public BigDecimal getCustoKg() {
        return custoKg;
    }

    public void setCustoKg(BigDecimal custoKg) {
        this.custoKg = custoKg;
    }

    public BigDecimal getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(BigDecimal valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public BigDecimal getValorKg() {
        return valorKg;
    }

    public void setValorKg(BigDecimal valorKg) {
        this.valorKg = valorKg;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(BigDecimal valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }

    public BigDecimal getTotalSomaCusto() {
        return totalSomaCusto;
    }

    public void setTotalSomaCusto(BigDecimal totalSomaCusto) {
        this.totalSomaCusto = totalSomaCusto;
    }

    public Integer getMarkUpMinimo() {
        return markUpMinimo;
    }

    public void setMarkUpMinimo(Integer markUpMinimo) {
        this.markUpMinimo = markUpMinimo;
    }

    public Integer getMarkUpPromocional() {
        return markUpPromocional;
    }

    public void setMarkUpPromocional(Integer markUpPromocional) {
        this.markUpPromocional = markUpPromocional;
    }

    public List<ProdutoCalculoPrecoMedidasVO> getListaProdutoCalculoPrecoMedidas() {
        return listaProdutoCalculoPrecoMedidas;
    }

    public void setListaProdutoCalculoPrecoMedidas(List<ProdutoCalculoPrecoMedidasVO> listaProdutoCalculoPrecoMedidas) {
        this.listaProdutoCalculoPrecoMedidas = listaProdutoCalculoPrecoMedidas;
    }

    public List<ReceituarioPadraoVO> getListaReceituarioPadrao() {
        return listaReceituarioPadrao;
    }

    public void setListaReceituarioPadrao(List<ReceituarioPadraoVO> listaReceituarioPadrao) {
        this.listaReceituarioPadrao = listaReceituarioPadrao;
    }

    public List<IngredienteVO> getListaIngrediente() {
        return listaIngrediente;
    }

    public void setListaIngrediente(List<IngredienteVO> listaIngrediente) {
        this.listaIngrediente = listaIngrediente;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
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
        if (!(object instanceof ReceituarioControleCustoVO)) {
            return false;
        }
        ReceituarioControleCustoVO other = (ReceituarioControleCustoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ReceituarioControleCustoVO[ id=" + id + " ]";
    }
    
}
