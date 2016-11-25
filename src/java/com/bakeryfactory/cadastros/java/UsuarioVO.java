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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "USUARIO")
public class UsuarioVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "ADMINISTRADOR")
    private Character administrador;

    @JoinColumn(name = "ID_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ColaboradorVO colaborador;

    @JoinColumn(name = "ID_PAPEL", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PapelVO papel;

    //@JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
   // @ManyToOne(optional = false)
    //private PessoaVO pessoa;

    @JoinColumn(name = "ID_EMPRESA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private EmpresaVO empresa;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "usuario")
   // @LazyCollection(LazyCollectionOption.FALSE)
    //private List<AuditoriaVO> listaAuditoria;

    public UsuarioVO() {
    }

    public UsuarioVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Character getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Character administrador) {
        this.administrador = administrador;
    }
/*
    
    
    public List<AuditoriaVO> getListaAuditoria() {
        return listaAuditoria;
    }

    public void setListaAuditoria(List<AuditoriaVO> listaAuditoria) {
        this.listaAuditoria = listaAuditoria;
    }
    */

    public ColaboradorVO getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorVO colaborador) {
        this.colaborador = colaborador;
    }

    public EmpresaVO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaVO empresa) {
        this.empresa = empresa;
    }

    public PapelVO getPapel() {
        return papel;
    }

    public void setPapel(PapelVO papel) {
        this.papel = papel;
    }
/**
 * 
 * @return 

    public PessoaVO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }
    *  */

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.UsuarioVO[ id=" + id + " ]";
    }

}
