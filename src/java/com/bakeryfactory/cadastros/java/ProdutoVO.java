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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "ProdutoVO.findAll", query = "SELECT p FROM ProdutoVO p")})
public class ProdutoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "gtin")
    private String gtin;
    @Column(name = "codigo_interno")
    private String codigoInterno;
    @Column(name = "ncm")
    private String ncm;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "descricao_pdv")
    private String descricaoPdv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "estoque_minimo")
    private BigDecimal estoqueMinimo;
    @Column(name = "estoque_maximo")
    private BigDecimal estoqueMaximo;
    @Column(name = "estoque_ideal")
    private BigDecimal estoqueIdeal;
    @Column(name = "excluido")
    private Character excluido;
    @Column(name = "inativo")
    private Character inativo;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "data_alteracao")
    @Temporal(TemporalType.DATE)
    private Date dataAlteracao;
    @Column(name = "classe_abc")
    private Character classeAbc;
    @Column(name = "peso")
    private BigDecimal peso;
    @Column(name = "imagem")
    private String imagem;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<FichaTecnicaVO> fichaTecnicaVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<ReceitaVO> receitaVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<PcpOpDetalheVO> pcpOpDetalheVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<VendaOrcamentoDetalheVO> vendaOrcamentoDetalheVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<VendaDetalheVO> vendaDetalheVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<ProdutoTabelaPrecoVO> produtoTabelaPrecoVOList;
    @JoinColumn(name = "produto_subgrupo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProdutoSubgrupoVO produtoSubgrupoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<ReceituarioControleCustoVO> receituarioControleCustoVOList;

    public ProdutoVO() {
    }

    public ProdutoVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGtin() {
        return gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoPdv() {
        return descricaoPdv;
    }

    public void setDescricaoPdv(String descricaoPdv) {
        this.descricaoPdv = descricaoPdv;
    }

    public BigDecimal getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public BigDecimal getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public BigDecimal getEstoqueIdeal() {
        return estoqueIdeal;
    }

    public void setEstoqueIdeal(BigDecimal estoqueIdeal) {
        this.estoqueIdeal = estoqueIdeal;
    }

    public Character getExcluido() {
        return excluido;
    }

    public void setExcluido(Character excluido) {
        this.excluido = excluido;
    }

    public Character getInativo() {
        return inativo;
    }

    public void setInativo(Character inativo) {
        this.inativo = inativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Character getClasseAbc() {
        return classeAbc;
    }

    public void setClasseAbc(Character classeAbc) {
        this.classeAbc = classeAbc;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<FichaTecnicaVO> getFichaTecnicaVOList() {
        return fichaTecnicaVOList;
    }

    public void setFichaTecnicaVOList(List<FichaTecnicaVO> fichaTecnicaVOList) {
        this.fichaTecnicaVOList = fichaTecnicaVOList;
    }

    public List<ReceitaVO> getReceitaVOList() {
        return receitaVOList;
    }

    public void setReceitaVOList(List<ReceitaVO> receitaVOList) {
        this.receitaVOList = receitaVOList;
    }

    public List<PcpOpDetalheVO> getPcpOpDetalheVOList() {
        return pcpOpDetalheVOList;
    }

    public void setPcpOpDetalheVOList(List<PcpOpDetalheVO> pcpOpDetalheVOList) {
        this.pcpOpDetalheVOList = pcpOpDetalheVOList;
    }

    public List<VendaOrcamentoDetalheVO> getVendaOrcamentoDetalheVOList() {
        return vendaOrcamentoDetalheVOList;
    }

    public void setVendaOrcamentoDetalheVOList(List<VendaOrcamentoDetalheVO> vendaOrcamentoDetalheVOList) {
        this.vendaOrcamentoDetalheVOList = vendaOrcamentoDetalheVOList;
    }

    public List<VendaDetalheVO> getVendaDetalheVOList() {
        return vendaDetalheVOList;
    }

    public void setVendaDetalheVOList(List<VendaDetalheVO> vendaDetalheVOList) {
        this.vendaDetalheVOList = vendaDetalheVOList;
    }

    public List<ProdutoTabelaPrecoVO> getProdutoTabelaPrecoVOList() {
        return produtoTabelaPrecoVOList;
    }

    public void setProdutoTabelaPrecoVOList(List<ProdutoTabelaPrecoVO> produtoTabelaPrecoVOList) {
        this.produtoTabelaPrecoVOList = produtoTabelaPrecoVOList;
    }

    public ProdutoSubgrupoVO getProdutoSubgrupoId() {
        return produtoSubgrupoId;
    }

    public void setProdutoSubgrupoId(ProdutoSubgrupoVO produtoSubgrupoId) {
        this.produtoSubgrupoId = produtoSubgrupoId;
    }

    public List<ReceituarioControleCustoVO> getReceituarioControleCustoVOList() {
        return receituarioControleCustoVOList;
    }

    public void setReceituarioControleCustoVOList(List<ReceituarioControleCustoVO> receituarioControleCustoVOList) {
        this.receituarioControleCustoVOList = receituarioControleCustoVOList;
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
        if (!(object instanceof ProdutoVO)) {
            return false;
        }
        ProdutoVO other = (ProdutoVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ProdutoVO[ id=" + id + " ]";
    }
    
}
