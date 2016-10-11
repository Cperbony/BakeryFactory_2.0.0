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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "RECEITA")
public class ReceitaVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME_PROD")
    private String nomeProd;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORCENTAGEM_RECEITA")
    private BigDecimal porcentagemReceita;
    @Column(name = "TIPO_RECEITA")
    private String tipoReceita;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "INGREDIENTE_MASSA")
    private String ingredienteMassa;

    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoVO produto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "receita")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<IngredientesReceitasVO> listaIngredientesReceitas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "receitaVO")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ModoPreparoVO> listaModoPreparo;

    public ReceitaVO() {
    }

    public ReceitaVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public BigDecimal getPorcentagemReceita() {
        return porcentagemReceita;
    }

    public void setPorcentagemReceita(BigDecimal porcentagemReceita) {
        this.porcentagemReceita = porcentagemReceita;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIngredienteMassa() {
        return ingredienteMassa;
    }

    public void setIngredienteMassa(String ingredienteMassa) {
        this.ingredienteMassa = ingredienteMassa;
    }

    public List<IngredientesReceitasVO> getListaIngredientesReceitas() {
        return listaIngredientesReceitas;
    }

    public void setListaIngredientesReceitas(List<IngredientesReceitasVO> listaIngredientesReceitas) {
        this.listaIngredientesReceitas = listaIngredientesReceitas;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    public List<ModoPreparoVO> getListaModoPreparo() {
        return listaModoPreparo;
    }

    public void setListaModoPreparo(List<ModoPreparoVO> listaModoPreparo) {
        this.listaModoPreparo = listaModoPreparo;
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
        if (!(object instanceof ReceitaVO)) {
            return false;
        }
        ReceitaVO other = (ReceitaVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ReceitaVO[ id=" + id + " ]";
    }

}
