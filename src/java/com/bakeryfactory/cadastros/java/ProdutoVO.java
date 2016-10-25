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

import com.bakeryfactory.vendas.java.VendaOrcamentoDetalheVO;
import com.bakeryfactory.vendas.java.VendaDetalheVO;
import com.bakeryfactory.pcp.java.PcpOpDetalheVO;
import com.bakeryfactory.tributacao.java.TributGrupoTributarioVO;
import com.bakeryfactory.tributacao.java.TributIcmsCustomCabVO;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "PRODUTO")
public class ProdutoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "GTIN")
    private String gtin;
    @Column(name = "CODIGO_INTERNO")
    private String codigoInterno;
    @Column(name = "NCM")
    private String ncm;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "DESCRICAO_PDV")
    private String descricaoPdv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ESTOQUE_MINIMO")
    private BigDecimal estoqueMinimo;
    @Column(name = "ESTOQUE_MAXIMO")
    private BigDecimal estoqueMaximo;
    @Column(name = "ESTOQUE_IDEAL")
    private BigDecimal estoqueIdeal;
    @Column(name = "EXCLUIDO")
    private Character excluido;
    @Column(name = "INATIVO")
    private Character inativo;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "FOTO_PRODUTO")
    private String fotoProduto;
    @Column(name = "DATA_ALTERACAO")
    @Temporal(TemporalType.DATE)
    private Date dataAlteracao;
    @Column(name = "CLASSE_ABC")
    private Character classeAbc;
    @Column(name = "peso")
    private BigDecimal peso;
    @Transient
    private byte[] imagem;

    @JoinColumn(name = "ID_PRODUTO_SUBGRUPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoSubgrupoVO produtoSubgrupo;

    @JoinColumn(name = "ID_UNIDADE_PRODUTO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UnidadeProdutoVO unidadeProduto;
    
    @JoinColumn(name = "ID_SUB_GRUPO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ProdutoSubgrupoVO produtoSubGrupo;
    
    @JoinColumn(name = "ID_MARCA_PRODUTO", referencedColumnName = "ID")
    @ManyToOne
    private ProdutoMarcaVO produtoMarca;
    
    @JoinColumn(name = "ID_GRUPO_TRIBUTARIO", referencedColumnName = "ID")
    @ManyToOne
    private TributGrupoTributarioVO tributGrupoTributario;
    
    @JoinColumn(name = "ID_ALMOXARIFADO", referencedColumnName = "ID")
    @ManyToOne
    private AlmoxarifadoVO almoxarifado;
    
    @JoinColumn(name = "ID_TRIBUT_ICMS_CUSTOM_CAB", referencedColumnName = "ID")
    @ManyToOne
    private TributIcmsCustomCabVO tributIcmsCustomCab;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "produto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<FichaTecnicaVO> listaFichaTecnica;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "produto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ReceitaVO> listaReceita;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "produto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PcpOpDetalheVO> listaPcpOpDetalhe;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "produto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaOrcamentoDetalheVO> listaVendaOrcamentoDetalhe;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "produto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaDetalheVO> listaVendaDetalhe;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "produto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ProdutoTabelaPrecoVO> listaProdutoTabelaPreco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "produto")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ReceituarioControleCustoVO> listaReceituarioControleCusto;

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

    public String getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
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

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public UnidadeProdutoVO getUnidadeProduto() {
        return unidadeProduto;
    }

    public void setUnidadeProduto(UnidadeProdutoVO unidadeProduto) {
        this.unidadeProduto = unidadeProduto;
    }

    public ProdutoSubgrupoVO getProdutoSubGrupo() {
        return produtoSubGrupo;
    }

    public void setProdutoSubGrupo(ProdutoSubgrupoVO produtoSubGrupo) {
        this.produtoSubGrupo = produtoSubGrupo;
    }

    public ProdutoMarcaVO getProdutoMarca() {
        return produtoMarca;
    }

    public void setProdutoMarca(ProdutoMarcaVO produtoMarca) {
        this.produtoMarca = produtoMarca;
    }

    public TributGrupoTributarioVO getTributGrupoTributario() {
        return tributGrupoTributario;
    }

    public void setTributGrupoTributario(TributGrupoTributarioVO tributGrupoTributario) {
        this.tributGrupoTributario = tributGrupoTributario;
    }

    public AlmoxarifadoVO getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(AlmoxarifadoVO almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

    public TributIcmsCustomCabVO getTributIcmsCustomCab() {
        return tributIcmsCustomCab;
    }

    public void setTributIcmsCustomCab(TributIcmsCustomCabVO tributIcmsCustomCab) {
        this.tributIcmsCustomCab = tributIcmsCustomCab;
    }

    
    public List<FichaTecnicaVO> getListaFichaTecnica() {
        return listaFichaTecnica;
    }

    public void setListaFichaTecnica(List<FichaTecnicaVO> listaFichaTecnica) {
        this.listaFichaTecnica = listaFichaTecnica;
    }

    public List<ReceitaVO> getListaReceita() {
        return listaReceita;
    }

    public void setListaReceita(List<ReceitaVO> listaReceita) {
        this.listaReceita = listaReceita;
    }

    public List<PcpOpDetalheVO> getListaPcpOpDetalhe() {
        return listaPcpOpDetalhe;
    }

    public void setListaPcpOpDetalhe(List<PcpOpDetalheVO> listaPcpOpDetalhe) {
        this.listaPcpOpDetalhe = listaPcpOpDetalhe;
    }

    public List<VendaOrcamentoDetalheVO> getListaVendaOrcamentoDetalhe() {
        return listaVendaOrcamentoDetalhe;
    }

    public void setListaVendaOrcamentoDetalhe(List<VendaOrcamentoDetalheVO> listaVendaOrcamentoDetalhe) {
        this.listaVendaOrcamentoDetalhe = listaVendaOrcamentoDetalhe;
    }

    public List<VendaDetalheVO> getListaVendaDetalhe() {
        return listaVendaDetalhe;
    }

    public void setListaVendaDetalhe(List<VendaDetalheVO> listaVendaDetalhe) {
        this.listaVendaDetalhe = listaVendaDetalhe;
    }

    public List<ProdutoTabelaPrecoVO> getListaProdutoTabelaPreco() {
        return listaProdutoTabelaPreco;
    }

    public void setListaProdutoTabelaPreco(List<ProdutoTabelaPrecoVO> listaProdutoTabelaPreco) {
        this.listaProdutoTabelaPreco = listaProdutoTabelaPreco;
    }

    public ProdutoSubgrupoVO getProdutoSubgrupo() {
        return produtoSubgrupo;
    }

    public void setProdutoSubgrupo(ProdutoSubgrupoVO produtoSubgrupo) {
        this.produtoSubgrupo = produtoSubgrupo;
    }

    public List<ReceituarioControleCustoVO> getListaReceituarioControleCusto() {
        return listaReceituarioControleCusto;
    }

    public void setListaReceituarioControleCusto(List<ReceituarioControleCustoVO> listaReceituarioControleCusto) {
        this.listaReceituarioControleCusto = listaReceituarioControleCusto;
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
