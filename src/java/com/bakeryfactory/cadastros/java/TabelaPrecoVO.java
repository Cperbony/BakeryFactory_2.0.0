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
@Table(name = "tabela_preco")
@NamedQueries({
    @NamedQuery(name = "TabelaPrecoVO.findAll", query = "SELECT t FROM TabelaPrecoVO t")})
public class TabelaPrecoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coeficiente")
    private BigDecimal coeficiente;
    @Column(name = "principal")
    private Character principal;
    @Column(name = "base_custo")
    private Character baseCusto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tabelaPrecoId")
    private List<TabelaPrecoVO> tabelaPrecoList;
    @JoinColumn(name = "tabela_preco_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TabelaPrecoVO tabelaPreco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tabelaPrecoId")
    private List<ProdutoTabelaPrecoVO> produtoTabelaPrecoList;

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

    public List<TabelaPrecoVO> getTabelaPrecoList() {
        return tabelaPrecoList;
    }

    public void setTabelaPrecoList(List<TabelaPrecoVO> tabelaPrecoList) {
        this.tabelaPrecoList = tabelaPrecoList;
    }

    public TabelaPrecoVO getTabelaPreco() {
        return tabelaPreco;
    }

    public void setTabelaPreco(TabelaPrecoVO tabelaPreco) {
        this.tabelaPreco = tabelaPreco;
    }

    public List<ProdutoTabelaPrecoVO> getProdutoTabelaPrecoList() {
        return produtoTabelaPrecoList;
    }

    public void setProdutoTabelaPrecoList(List<ProdutoTabelaPrecoVO> produtoTabelaPrecoList) {
        this.produtoTabelaPrecoList = produtoTabelaPrecoList;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.TabelaPrecoVO[ id=" + id + " ]";
    }
    
}
