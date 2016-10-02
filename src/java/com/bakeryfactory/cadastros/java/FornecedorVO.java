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
@Table(name = "fornecedor")
@NamedQueries({
    @NamedQuery(name = "FornecedorVO.findAll", query = "SELECT f FROM FornecedorVO f")})
public class FornecedorVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "optante_simples_nacional")
    private Character optanteSimplesNacional;
    @Column(name = "localizacao")
    private Character localizacao;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "sofre_retencao")
    private Character sofreRetencao;
    @Column(name = "cheque_nominal_a")
    private String chequeNominalA;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "conta_remetente")
    private String contaRemetente;
    @Column(name = "prazo_medio_entrega")
    private Integer prazoMedioEntrega;
    @Column(name = "gera_faturamento")
    private Character geraFaturamento;
    @Column(name = "numero_dias_primeiro_venc")
    private Integer numeroDiasPrimeiroVenc;
    @Column(name = "numero_dias_intervalo")
    private Integer numeroDiasIntervalo;
    @Column(name = "quantidade_parcelas")
    private Integer quantidadeParcelas;
    @Column(name = "classificacao_contabil_conta")
    private String classificacaoContabilConta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedorId")
    private List<CompraCotacaoDetalheVO> compraCotacaoDetalheVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fornecedorId")
    private List<CompraFornecedorCotacaoVO> compraFornecedorCotacaoVOList;
    @JoinColumn(name = "atividade_for_cli_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AtividadeForCliVO atividadeForCliId;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaVO pessoaId;
    @JoinColumn(name = "situacao_for_cli_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SituacaoForCliVO situacaoForCliId;

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

    public List<CompraCotacaoDetalheVO> getCompraCotacaoDetalheVOList() {
        return compraCotacaoDetalheVOList;
    }

    public void setCompraCotacaoDetalheVOList(List<CompraCotacaoDetalheVO> compraCotacaoDetalheVOList) {
        this.compraCotacaoDetalheVOList = compraCotacaoDetalheVOList;
    }

    public List<CompraFornecedorCotacaoVO> getCompraFornecedorCotacaoVOList() {
        return compraFornecedorCotacaoVOList;
    }

    public void setCompraFornecedorCotacaoVOList(List<CompraFornecedorCotacaoVO> compraFornecedorCotacaoVOList) {
        this.compraFornecedorCotacaoVOList = compraFornecedorCotacaoVOList;
    }

    public AtividadeForCliVO getAtividadeForCliId() {
        return atividadeForCliId;
    }

    public void setAtividadeForCliId(AtividadeForCliVO atividadeForCliId) {
        this.atividadeForCliId = atividadeForCliId;
    }

    public PessoaVO getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(PessoaVO pessoaId) {
        this.pessoaId = pessoaId;
    }

    public SituacaoForCliVO getSituacaoForCliId() {
        return situacaoForCliId;
    }

    public void setSituacaoForCliId(SituacaoForCliVO situacaoForCliId) {
        this.situacaoForCliId = situacaoForCliId;
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
