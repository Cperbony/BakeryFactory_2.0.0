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

import com.bakeryfactory.contabilidade.java.ContabilContaVO;
import com.bakeryfactory.tributacao.java.TributOperacaoFiscalVO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "CLIENTE")
public class ClienteVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DESDE")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "GERA_FINANCEIRO")
    private Character geraFinanceiro;
    @Column(name = "CONTA_TOMADOR")
    private String contaTomador;
    @Column(name = "INDICADOR_PRECO")
    private String indicadorPreco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PORCENTO_DESCONTO")
    private BigDecimal porcentoDesconto;
    @Column(name = "FORMA_DESCONTO")
    private String formaDesconto;
    @Column(name = "LIMITE_CREDITO")
    private BigDecimal limiteCredito;
    @Column(name = "TIPO_FRETE")
    private String tipoFrete;

    @JoinColumn(name = "ID_ATIVIDADE_FOR_CLI", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AtividadeForCliVO atividadeForCli;

    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PessoaVO pessoa;

    @JoinColumn(name = "ID_SITUACAO_FOR_CLI", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SituacaoForCliVO situacaoForCli;
    
    @JoinColumn(name = "ID_OPERACAO_FISCAL", referencedColumnName = "ID")
    @ManyToOne
    private TributOperacaoFiscalVO tributOperacaoFiscal;
    
    @JoinColumn(name = "ID_CONTABIL_CONTA", referencedColumnName = "ID")
    @ManyToOne
    private ContabilContaVO contabilConta;


    public ClienteVO() {
    }

    public ClienteVO(Integer id) {
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Character getGeraFinanceiro() {
        return geraFinanceiro;
    }

    public void setGeraFinanceiro(Character geraFinanceiro) {
        this.geraFinanceiro = geraFinanceiro;
    }

    public String getContaTomador() {
        return contaTomador;
    }

    public void setContaTomador(String contaTomador) {
        this.contaTomador = contaTomador;
    }

    public String getIndicadorPreco() {
        return indicadorPreco;
    }

    public void setIndicadorPreco(String indicadorPreco) {
        this.indicadorPreco = indicadorPreco;
    }

    public BigDecimal getPorcentoDesconto() {
        return porcentoDesconto;
    }

    public void setPorcentoDesconto(BigDecimal porcentoDesconto) {
        this.porcentoDesconto = porcentoDesconto;
    }

    public String getFormaDesconto() {
        return formaDesconto;
    }

    public void setFormaDesconto(String formaDesconto) {
        this.formaDesconto = formaDesconto;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public String getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(String tipoFrete) {
        this.tipoFrete = tipoFrete;
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

    public TributOperacaoFiscalVO getTributOperacaoFiscal() {
        return tributOperacaoFiscal;
    }

    public void setTributOperacaoFiscal(TributOperacaoFiscalVO tributOperacaoFiscal) {
        this.tributOperacaoFiscal = tributOperacaoFiscal;
    }

    public ContabilContaVO getContabilConta() {
        return contabilConta;
    }

    public void setContabilConta(ContabilContaVO contabilConta) {
        this.contabilConta = contabilConta;
    }
    
    

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ClienteVO[ id=" + id + " ]";
    }

}
