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
@Table(name = "produto_calculo_preco_medidas")
public class ProdutoCalculoPrecoMedidasVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tipo_medida")
    private String tipoMedida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mark_up_minimo")
    private BigDecimal markUpMinimo;
    @Column(name = "custo_produto")
    private BigDecimal custoProduto;
    @Column(name = "preco_sugestao")
    private BigDecimal precoSugestao;
    @Column(name = "preco_venda")
    private BigDecimal precoVenda;
    @Column(name = "mark_up_aplicado")
    private BigDecimal markUpAplicado;
    @JoinColumn(name = "receituario_controle_custo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ReceituarioControleCustoVO receituarioControleCusto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoCalculoPrecoMedidasId")
    private List<PcpServicoVO> pcpServicoList;

    public ProdutoCalculoPrecoMedidasVO() {
    }

    public ProdutoCalculoPrecoMedidasVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(String tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    public BigDecimal getMarkUpMinimo() {
        return markUpMinimo;
    }

    public void setMarkUpMinimo(BigDecimal markUpMinimo) {
        this.markUpMinimo = markUpMinimo;
    }

    public BigDecimal getCustoProduto() {
        return custoProduto;
    }

    public void setCustoProduto(BigDecimal custoProduto) {
        this.custoProduto = custoProduto;
    }

    public BigDecimal getPrecoSugestao() {
        return precoSugestao;
    }

    public void setPrecoSugestao(BigDecimal precoSugestao) {
        this.precoSugestao = precoSugestao;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public BigDecimal getMarkUpAplicado() {
        return markUpAplicado;
    }

    public void setMarkUpAplicado(BigDecimal markUpAplicado) {
        this.markUpAplicado = markUpAplicado;
    }

    public ReceituarioControleCustoVO getReceituarioControleCusto() {
        return receituarioControleCusto;
    }

    public void setReceituarioControleCusto(ReceituarioControleCustoVO receituarioControleCusto) {
        this.receituarioControleCusto = receituarioControleCusto;
    }

    public List<PcpServicoVO> getPcpServicoList() {
        return pcpServicoList;
    }

    public void setPcpServicoList(List<PcpServicoVO> pcpServicoList) {
        this.pcpServicoList = pcpServicoList;
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
        if (!(object instanceof ProdutoCalculoPrecoMedidasVO)) {
            return false;
        }
        ProdutoCalculoPrecoMedidasVO other = (ProdutoCalculoPrecoMedidasVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ProdutoCalculoPrecoMedidasVO[ id=" + id + " ]";
    }
    
}
