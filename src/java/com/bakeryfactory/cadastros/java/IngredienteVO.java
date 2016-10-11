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
@Table(name = "INGREDIENTE")
public class IngredienteVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME_INGRED")
    private String nomeIngred;
    @Column(name = "UNIDADE_MEDIDA")
    private String unidadeMedida;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PESO")
    private BigDecimal peso;
    @Column(name = "VALOR_UNITARIO")
    private BigDecimal valorUnitario;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;

    @JoinColumn(name = "ID_RECEITUARIO_CONTROLE_CUSTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ReceituarioControleCustoVO receituarioControleCusto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredienteId")
    private List<IngredientesReceitasVO> listaIngredientesReceitas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredienteId")
    private List<MarcaVO> listaMarca;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredienteId")
    private List<CompraCotacaoDetalheVO> listaCompraCotacaoDetalhe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingredienteId")
    private List<CompraPedidoDetalheVO> listaCompraPedidoDetalhe;

    public IngredienteVO() {
    }

    public IngredienteVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeIngred() {
        return nomeIngred;
    }

    public void setNomeIngred(String nomeIngred) {
        this.nomeIngred = nomeIngred;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<IngredientesReceitasVO> getListaIngredientesReceitas() {
        return listaIngredientesReceitas;
    }

    public void setListaIngredientesReceitas(List<IngredientesReceitasVO> listaIngredientesReceitas) {
        this.listaIngredientesReceitas = listaIngredientesReceitas;
    }

    public List<MarcaVO> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<MarcaVO> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public List<CompraCotacaoDetalheVO> getListaCompraCotacaoDetalhe() {
        return listaCompraCotacaoDetalhe;
    }

    public void setListaCompraCotacaoDetalhe(List<CompraCotacaoDetalheVO> listaCompraCotacaoDetalhe) {
        this.listaCompraCotacaoDetalhe = listaCompraCotacaoDetalhe;
    }

    public ReceituarioControleCustoVO getReceituarioControleCusto() {
        return receituarioControleCusto;
    }

    public void setReceituarioControleCusto(ReceituarioControleCustoVO receituarioControleCusto) {
        this.receituarioControleCusto = receituarioControleCusto;
    }

    public List<CompraPedidoDetalheVO> getListaCompraPedidoDetalhe() {
        return listaCompraPedidoDetalhe;
    }

    public void setListaCompraPedidoDetalhe(List<CompraPedidoDetalheVO> listaCompraPedidoDetalhe) {
        this.listaCompraPedidoDetalhe = listaCompraPedidoDetalhe;
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
        if (!(object instanceof IngredienteVO)) {
            return false;
        }
        IngredienteVO other = (IngredienteVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.IngredienteVO[ id=" + id + " ]";
    }

}
