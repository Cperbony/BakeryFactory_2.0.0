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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "pessoa")
public class PessoaVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "email")
    private String email;
    @Column(name = "site")
    private String site;
    @Column(name = "cliente")
    private Character cliente;
    @Column(name = "fornecedor")
    private Character fornecedor;
    @Column(name = "colaborador")
    private Character colaborador;
    @Column(name = "transportadora")
    private Character transportadora;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="empresa_pessoa", joinColumns={@JoinColumn(name="pessoa_id")}, inverseJoinColumns={@JoinColumn(name="empresa_id")})
    private List<EmpresaVO> listaEmpresa;
    @OneToOne(fetch=FetchType.EAGER, mappedBy="pessoa", cascade = CascadeType.ALL)
    private PessoaFisicaVO pessoaFisica;
    @OneToOne(fetch=FetchType.EAGER, mappedBy="pessoa", cascade = CascadeType.ALL)
    private PessoaJuridicaVO pessoaJuridica;
    @OneToMany(mappedBy="pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PessoaEnderecoVO> listaEndereco;
    @OneToMany(mappedBy="pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PessoaContatoVO> listaContato;
    @OneToMany(mappedBy="pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PessoaTelefoneVO> listaTelefone;
    

    public PessoaVO() {
    }

    public PessoaVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Character getCliente() {
        return cliente;
    }

    public void setCliente(Character cliente) {
        this.cliente = cliente;
    }

    public Character getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Character fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Character getColaborador() {
        return colaborador;
    }

    public void setColaborador(Character colaborador) {
        this.colaborador = colaborador;
    }

    public Character getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Character transportadora) {
        this.transportadora = transportadora;
    }

    public List<EmpresaVO> getListaEmpresa() {
        return listaEmpresa;
    }

    public void setListaEmpresa(List<EmpresaVO> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    public PessoaFisicaVO getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisicaVO pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridicaVO getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridicaVO pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public List<PessoaEnderecoVO> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<PessoaEnderecoVO> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public List<PessoaContatoVO> getListaContato() {
        return listaContato;
    }

    public void setListaContato(List<PessoaContatoVO> listaContato) {
        this.listaContato = listaContato;
    }

    public List<PessoaTelefoneVO> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<PessoaTelefoneVO> listaTelefone) {
        this.listaTelefone = listaTelefone;
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
        if (!(object instanceof PessoaVO)) {
            return false;
        }
        PessoaVO other = (PessoaVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.PessoaVO[ id=" + id + " ]";
    }
    
}
