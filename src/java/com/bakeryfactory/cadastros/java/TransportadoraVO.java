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
import java.io.Serializable;
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
@Table(name = "TRANSPORTADORA")
public class TransportadoraVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "CLASSIFICACAO_CONTABIL_CONTA")
    private String classificacaoContabilConta;
    
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaVO pessoa;
    
    @JoinColumn(name = "ID_CONTABIL_CONTA", referencedColumnName = "ID")
    @ManyToOne
    private ContabilContaVO contabilConta;
    
    /*
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transportadora")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TransportadoraMunicipioVO> listaTransportadoraMunicipio;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transportadora")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaCabecalhoVO> listaVendaCabecalho;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transportadora")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaOrcamentoCabecalhoVO> listaVendaOrcamentoCabecalho;
   
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "transportadora")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaFreteVO> listaVendaFrete;

*/
    
    
    public TransportadoraVO() {
    }

    public TransportadoraVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getClassificacaoContabilConta() {
        return classificacaoContabilConta;
    }

    public void setClassificacaoContabilConta(String classificacaoContabilConta) {
        this.classificacaoContabilConta = classificacaoContabilConta;
    }

    public PessoaVO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }

    public ContabilContaVO getContabilConta() {
        return contabilConta;
    }

    public void setContabilConta(ContabilContaVO contabilConta) {
        this.contabilConta = contabilConta;
    }
    
    

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.TransportadoraVO[ id=" + id + " ]";
    }
    
}
