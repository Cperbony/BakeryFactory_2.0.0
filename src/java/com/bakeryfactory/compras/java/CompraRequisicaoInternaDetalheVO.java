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
package com.bakeryfactory.compras.java;

import com.bakeryfactory.cadastros.java.ColaboradorVO;
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
@Table(name = "COMPRA_REQUISICAO_INTERNA_DETALHE")
public class CompraRequisicaoInternaDetalheVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "QUANTIDADE")
    private BigDecimal quantidade;
    
    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ColaboradorVO colaborador;
    
    @JoinColumn(name = "ID_COMPRA_REQUISICAO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CompraRequisicaoVO compraRequisicao;
    
    @JoinColumn(name = "ID_COMPRA_REQUISICAO_INTERNA_CABECALHO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CompraRequisicaoInternaCabecalhoVO compraRequisicaoInternaCabecalho;

    public CompraRequisicaoInternaDetalheVO() {
    }

    public CompraRequisicaoInternaDetalheVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public ColaboradorVO getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorVO colaborador) {
        this.colaborador = colaborador;
    }

    public CompraRequisicaoVO getCompraRequisicao() {
        return compraRequisicao;
    }

    public void setCompraRequisicao(CompraRequisicaoVO compraRequisicao) {
        this.compraRequisicao = compraRequisicao;
    }

    public CompraRequisicaoInternaCabecalhoVO getCompraRequisicaoInternaCabecalho() {
        return compraRequisicaoInternaCabecalho;
    }

    public void setCompraRequisicaoInternaCabecalho(CompraRequisicaoInternaCabecalhoVO compraRequisicaoInternaCabecalho) {
        this.compraRequisicaoInternaCabecalho = compraRequisicaoInternaCabecalho;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.RequisicaoInternaDetalheVO[ id=" + id + " ]";
    }
    
}
