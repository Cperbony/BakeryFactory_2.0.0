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
@Table(name = "TABELA_PRECO")
public class TabelaPrecoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COEFICIENTE")
    private BigDecimal coeficiente;
    @Column(name = "PRINCIPAL")
    private Character principal;
    @Column(name = "BASE_CUSTO")
    private Character baseCusto;
    
    @JoinColumn(name = "ID_TABELA_PRECO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TabelaPrecoVO tabelaPreco;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tabelaPreco")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TabelaPrecoVO> listaTabelaPreco;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "tabelaPreco")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProdutoTabelaPrecoVO> listaProdutoTabelaPreco;

    public TabelaPrecoVO() {
    }

    public TabelaPrecoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(BigDecimal coeficiente) {
        this.coeficiente = coeficiente;
    }

    public Character getPrincipal() {
        return principal;
    }

    public void setPrincipal(Character principal) {
        this.principal = principal;
    }

    public Character getBaseCusto() {
        return baseCusto;
    }

    public void setBaseCusto(Character baseCusto) {
        this.baseCusto = baseCusto;
    }

    public List<TabelaPrecoVO> getListaTabelaPreco() {
        return listaTabelaPreco;
    }

    public void setListaTabelaPreco(List<TabelaPrecoVO> listaTabelaPreco) {
        this.listaTabelaPreco = listaTabelaPreco;
    }

    public TabelaPrecoVO getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(TabelaPrecoVO tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }

    public List<ProdutoTabelaPrecoVO> getListaProdutoTabelaPreco() {
        return listaProdutoTabelaPreco;
    }

    public void setListaProdutoTabelaPreco(List<ProdutoTabelaPrecoVO> listaProdutoTabelaPreco) {
        this.listaProdutoTabelaPreco = listaProdutoTabelaPreco;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.TabelaPrecoVO[ id=" + id + " ]";
    }
    
}
