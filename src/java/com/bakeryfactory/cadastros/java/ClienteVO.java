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
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "ClienteVO.findAll", query = "SELECT c FROM ClienteVO c")})
public class ClienteVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "desde")
    @Temporal(TemporalType.DATE)
    private Date desde;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "gera_financeiro")
    private Character geraFinanceiro;
    @Column(name = "conta_tomador")
    private String contaTomador;
    @Column(name = "indicador_preco")
    private Character indicadorPreco;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcento_desconto")
    private BigDecimal porcentoDesconto;
    @Column(name = "forma_desconto")
    private Character formaDesconto;
    @Column(name = "limite_credito")
    private BigDecimal limiteCredito;
    @Column(name = "tipo_frete")
    private Character tipoFrete;
    @Column(name = "classificacao_contabil_conta")
    private String classificacaoContabilConta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private List<VendaCabecalhoVO> vendaCabecalhoVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteId")
    private List<VendaOrcamentoCabecalhoVO> vendaOrcamentoCabecalhoVOList;
    @JoinColumn(name = "atividade_for_cli_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AtividadeForCliVO atividadeForCliId;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaVO pessoaId;
    @JoinColumn(name = "situacao_for_cli_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SituacaoForCliVO situacaoForCliId;

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

    public Character getIndicadorPreco() {
        return indicadorPreco;
    }

    public void setIndicadorPreco(Character indicadorPreco) {
        this.indicadorPreco = indicadorPreco;
    }

    public BigDecimal getPorcentoDesconto() {
        return porcentoDesconto;
    }

    public void setPorcentoDesconto(BigDecimal porcentoDesconto) {
        this.porcentoDesconto = porcentoDesconto;
    }

    public Character getFormaDesconto() {
        return formaDesconto;
    }

    public void setFormaDesconto(Character formaDesconto) {
        this.formaDesconto = formaDesconto;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Character getTipoFrete() {
        return tipoFrete;
    }

    public void setTipoFrete(Character tipoFrete) {
        this.tipoFrete = tipoFrete;
    }

    public String getClassificacaoContabilConta() {
        return classificacaoContabilConta;
    }

    public void setClassificacaoContabilConta(String classificacaoContabilConta) {
        this.classificacaoContabilConta = classificacaoContabilConta;
    }

    public List<VendaCabecalhoVO> getVendaCabecalhoVOList() {
        return vendaCabecalhoVOList;
    }

    public void setVendaCabecalhoVOList(List<VendaCabecalhoVO> vendaCabecalhoVOList) {
        this.vendaCabecalhoVOList = vendaCabecalhoVOList;
    }

    public List<VendaOrcamentoCabecalhoVO> getVendaOrcamentoCabecalhoVOList() {
        return vendaOrcamentoCabecalhoVOList;
    }

    public void setVendaOrcamentoCabecalhoVOList(List<VendaOrcamentoCabecalhoVO> vendaOrcamentoCabecalhoVOList) {
        this.vendaOrcamentoCabecalhoVOList = vendaOrcamentoCabecalhoVOList;
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
        if (!(object instanceof ClienteVO)) {
            return false;
        }
        ClienteVO other = (ClienteVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ClienteVO[ id=" + id + " ]";
    }
    
}
