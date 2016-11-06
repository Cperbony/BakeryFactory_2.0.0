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

import com.bakeryfactory.compras.java.CompraCotacaoDetalheVO;
import com.bakeryfactory.compras.java.CompraFornecedorCotacaoVO;
import java.io.Serializable;
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
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "FORNECEDOR")
public class FornecedorVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESDE")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "OPTANTE_SIMPLES_NACIONAL")
    private Character optanteSimplesNacional;
    @Column(name = "LOCALIZACAO")
    private Character localizacao;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "SOFRE_RETENCAO")
    private Character sofreRetencao;
    @Column(name = "CHEQUE_NOMINAL_A")
    private String chequeNominalA;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "CONTA_REMETENTE")
    private String contaRemetente;
    @Column(name = "PRAZO_MEDIO_ENTREGA")
    private Integer prazoMedioEntrega;
    @Column(name = "GERA_FATURAMENTO")
    private Character geraFaturamento;
    @Column(name = "NUM_DIAS_PRIMEIRO_VENCIMENTO")
    private Integer numeroDiasPrimeiroVenc;
    @Column(name = "NUM_DIAS_INTERVALO")
    private Integer numeroDiasIntervalo;
    @Column(name = "QUANTIDADE_PARCELAS")
    private Integer quantidadeParcelas;
    @Column(name = "CLASSIFICACAO_CONTABIL_CONTA")
    private String classificacaoContabilConta;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
    private List<CompraCotacaoDetalheVO> listaCompraCotacaoDetalhe;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedor")
    private List<CompraFornecedorCotacaoVO> listaCompraFornecedorCotacao;
    
    @JoinColumn(name = "ID_ATIVIDADE_FOR_CLI", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AtividadeForCliVO atividadeForCli;
    
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PessoaVO pessoa;
    
    @JoinColumn(name = "ID_SITUACAO_FOR_CLI", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SituacaoForCliVO situacaoForCli;

    public FornecedorVO() {
    }

    public FornecedorVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Character getOptanteSimplesNacional() {
        return optanteSimplesNacional;
    }

    public void setOptanteSimplesNacional(Character optanteSimplesNacional) {
        this.optanteSimplesNacional = optanteSimplesNacional;
    }

    public Character getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Character localizacao) {
        this.localizacao = localizacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Character getSofreRetencao() {
        return sofreRetencao;
    }

    public void setSofreRetencao(Character sofreRetencao) {
        this.sofreRetencao = sofreRetencao;
    }

    public String getChequeNominalA() {
        return chequeNominalA;
    }

    public void setChequeNominalA(String chequeNominalA) {
        this.chequeNominalA = chequeNominalA;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getContaRemetente() {
        return contaRemetente;
    }

    public void setContaRemetente(String contaRemetente) {
        this.contaRemetente = contaRemetente;
    }

    public Integer getPrazoMedioEntrega() {
        return prazoMedioEntrega;
    }

    public void setPrazoMedioEntrega(Integer prazoMedioEntrega) {
        this.prazoMedioEntrega = prazoMedioEntrega;
    }

    public Character getGeraFaturamento() {
        return geraFaturamento;
    }

    public void setGeraFaturamento(Character geraFaturamento) {
        this.geraFaturamento = geraFaturamento;
    }

    public Integer getNumeroDiasPrimeiroVenc() {
        return numeroDiasPrimeiroVenc;
    }

    public void setNumeroDiasPrimeiroVenc(Integer numeroDiasPrimeiroVenc) {
        this.numeroDiasPrimeiroVenc = numeroDiasPrimeiroVenc;
    }

    public Integer getNumeroDiasIntervalo() {
        return numeroDiasIntervalo;
    }

    public void setNumeroDiasIntervalo(Integer numeroDiasIntervalo) {
        this.numeroDiasIntervalo = numeroDiasIntervalo;
    }

    public Integer getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(Integer quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public String getClassificacaoContabilConta() {
        return classificacaoContabilConta;
    }

    public void setClassificacaoContabilConta(String classificacaoContabilConta) {
        this.classificacaoContabilConta = classificacaoContabilConta;
    }

    public List<CompraCotacaoDetalheVO> getListaCompraCotacaoDetalhe() {
        return listaCompraCotacaoDetalhe;
    }

    public void setListaCompraCotacaoDetalhe(List<CompraCotacaoDetalheVO> listaCompraCotacaoDetalhe) {
        this.listaCompraCotacaoDetalhe = listaCompraCotacaoDetalhe;
    }

    public List<CompraFornecedorCotacaoVO> getListaCompraFornecedorCotacao() {
        return listaCompraFornecedorCotacao;
    }

    public void setListaCompraFornecedorCotacao(List<CompraFornecedorCotacaoVO> listaCompraFornecedorCotacao) {
        this.listaCompraFornecedorCotacao = listaCompraFornecedorCotacao;
    }

    public AtividadeForCliVO getAtividadeForCli() {
        return atividadeForCli;
    }

    public void setAtividadeForCli(AtividadeForCliVO atividadeForCli) {
        this.atividadeForCli = atividadeForCli;
    }

    public PessoaVO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }

    public SituacaoForCliVO getSituacaoForCli() {
        return situacaoForCli;
    }

    public void setSituacaoForCli(SituacaoForCliVO situacaoForCli) {
        this.situacaoForCli = situacaoForCli;
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
        if (!(object instanceof FornecedorVO)) {
            return false;
        }
        FornecedorVO other = (FornecedorVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.FornecedorVO[ id=" + id + " ]";
    }
    
}
