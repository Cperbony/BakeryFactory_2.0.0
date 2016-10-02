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
@Table(name = "empresa")
@NamedQueries({
    @NamedQuery(name = "EmpresaVO_1.findAll", query = "SELECT e FROM EmpresaVO_1 e")})
public class EmpresaVO  extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;
    @Column(name = "inscricao_estadual_st")
    private String inscricaoEstadualSt;
    @Column(name = "inscricao_municipal")
    private String inscricaoMunicipal;
    @Column(name = "inscricao_junta_comercial")
    private String inscricaoJuntaComercial;
    @Column(name = "data_insc_junta_comercial")
    @Temporal(TemporalType.DATE)
    private Date dataInscJuntaComercial;
    @Column(name = "tipo")
    private Character tipo;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "data_inicio_atividades")
    @Temporal(TemporalType.DATE)
    private Date dataInicioAtividades;
    @Column(name = "suframa")
    private String suframa;
    @Column(name = "email")
    private String email;
    @Column(name = "imagem_logotipo")
    private String imagemLogotipo;
    @Column(name = "crt")
    private Character crt;
    @Column(name = "tipo_regime")
    private Character tipoRegime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "aliquota_pis")
    private BigDecimal aliquotaPis;
    @Column(name = "contato")
    private String contato;
    @Column(name = "aliquota_cofins")
    private BigDecimal aliquotaCofins;
    @Column(name = "codigo_ibge_cidade")
    private Integer codigoIbgeCidade;
    @Column(name = "codigo_ibge_uf")
    private Integer codigoIbgeUf;
    @Column(name = "codigo_terceiros")
    private Integer codigoTerceiros;
    @Column(name = "codigo_gps")
    private Integer codigoGps;
    @Column(name = "aliquota_sat")
    private BigDecimal aliquotaSat;
    @Column(name = "cei")
    private String cei;
    @Column(name = "codigo_cnae_principal")
    private String codigoCnaePrincipal;
    @Column(name = "tipo_controle_estoque")
    private Character tipoControleEstoque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<EmpresaPessoaVO> empresaPessoaVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<EmpresaEnderecoVO> empresaEnderecoVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<EmpresaTelefoneVO> empresaTelefoneVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<EmpresaContatoVO> empresaContatoVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<NotaFiscalTipoVO> notaFiscalTipoVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<UsuarioVO> usuarioVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<VendaDetalheVO> vendaDetalheVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<CompraTipoRequisicaoVO> compraTipoRequisicaoVOList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresaId")
    private List<VendaCondicoesPagamentoVO> vendaCondicoesPagamentoVOList;

    public EmpresaVO() {
    }

    public EmpresaVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoEstadualSt() {
        return inscricaoEstadualSt;
    }

    public void setInscricaoEstadualSt(String inscricaoEstadualSt) {
        this.inscricaoEstadualSt = inscricaoEstadualSt;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getInscricaoJuntaComercial() {
        return inscricaoJuntaComercial;
    }

    public void setInscricaoJuntaComercial(String inscricaoJuntaComercial) {
        this.inscricaoJuntaComercial = inscricaoJuntaComercial;
    }

    public Date getDataInscJuntaComercial() {
        return dataInscJuntaComercial;
    }

    public void setDataInscJuntaComercial(Date dataInscJuntaComercial) {
        this.dataInscJuntaComercial = dataInscJuntaComercial;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataInicioAtividades() {
        return dataInicioAtividades;
    }

    public void setDataInicioAtividades(Date dataInicioAtividades) {
        this.dataInicioAtividades = dataInicioAtividades;
    }

    public String getSuframa() {
        return suframa;
    }

    public void setSuframa(String suframa) {
        this.suframa = suframa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagemLogotipo() {
        return imagemLogotipo;
    }

    public void setImagemLogotipo(String imagemLogotipo) {
        this.imagemLogotipo = imagemLogotipo;
    }

    public Character getCrt() {
        return crt;
    }

    public void setCrt(Character crt) {
        this.crt = crt;
    }

    public Character getTipoRegime() {
        return tipoRegime;
    }

    public void setTipoRegime(Character tipoRegime) {
        this.tipoRegime = tipoRegime;
    }

    public BigDecimal getAliquotaPis() {
        return aliquotaPis;
    }

    public void setAliquotaPis(BigDecimal aliquotaPis) {
        this.aliquotaPis = aliquotaPis;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public BigDecimal getAliquotaCofins() {
        return aliquotaCofins;
    }

    public void setAliquotaCofins(BigDecimal aliquotaCofins) {
        this.aliquotaCofins = aliquotaCofins;
    }

    public Integer getCodigoIbgeCidade() {
        return codigoIbgeCidade;
    }

    public void setCodigoIbgeCidade(Integer codigoIbgeCidade) {
        this.codigoIbgeCidade = codigoIbgeCidade;
    }

    public Integer getCodigoIbgeUf() {
        return codigoIbgeUf;
    }

    public void setCodigoIbgeUf(Integer codigoIbgeUf) {
        this.codigoIbgeUf = codigoIbgeUf;
    }

    public Integer getCodigoTerceiros() {
        return codigoTerceiros;
    }

    public void setCodigoTerceiros(Integer codigoTerceiros) {
        this.codigoTerceiros = codigoTerceiros;
    }

    public Integer getCodigoGps() {
        return codigoGps;
    }

    public void setCodigoGps(Integer codigoGps) {
        this.codigoGps = codigoGps;
    }

    public BigDecimal getAliquotaSat() {
        return aliquotaSat;
    }

    public void setAliquotaSat(BigDecimal aliquotaSat) {
        this.aliquotaSat = aliquotaSat;
    }

    public String getCei() {
        return cei;
    }

    public void setCei(String cei) {
        this.cei = cei;
    }

    public String getCodigoCnaePrincipal() {
        return codigoCnaePrincipal;
    }

    public void setCodigoCnaePrincipal(String codigoCnaePrincipal) {
        this.codigoCnaePrincipal = codigoCnaePrincipal;
    }

    public Character getTipoControleEstoque() {
        return tipoControleEstoque;
    }

    public void setTipoControleEstoque(Character tipoControleEstoque) {
        this.tipoControleEstoque = tipoControleEstoque;
    }

    public List<EmpresaPessoaVO> getEmpresaPessoaVOList() {
        return empresaPessoaVOList;
    }

    public void setEmpresaPessoaVOList(List<EmpresaPessoaVO> empresaPessoaVOList) {
        this.empresaPessoaVOList = empresaPessoaVOList;
    }

    public List<EmpresaEnderecoVO> getEmpresaEnderecoVOList() {
        return empresaEnderecoVOList;
    }

    public void setEmpresaEnderecoVOList(List<EmpresaEnderecoVO> empresaEnderecoVOList) {
        this.empresaEnderecoVOList = empresaEnderecoVOList;
    }

    public List<EmpresaTelefoneVO> getEmpresaTelefoneVOList() {
        return empresaTelefoneVOList;
    }

    public void setEmpresaTelefoneVOList(List<EmpresaTelefoneVO> empresaTelefoneVOList) {
        this.empresaTelefoneVOList = empresaTelefoneVOList;
    }

    public List<EmpresaContatoVO> getEmpresaContatoVOList() {
        return empresaContatoVOList;
    }

    public void setEmpresaContatoVOList(List<EmpresaContatoVO> empresaContatoVOList) {
        this.empresaContatoVOList = empresaContatoVOList;
    }

    public List<NotaFiscalTipoVO> getNotaFiscalTipoVOList() {
        return notaFiscalTipoVOList;
    }

    public void setNotaFiscalTipoVOList(List<NotaFiscalTipoVO> notaFiscalTipoVOList) {
        this.notaFiscalTipoVOList = notaFiscalTipoVOList;
    }

    public List<UsuarioVO> getUsuarioVOList() {
        return usuarioVOList;
    }

    public void setUsuarioVOList(List<UsuarioVO> usuarioVOList) {
        this.usuarioVOList = usuarioVOList;
    }

    public List<VendaDetalheVO> getVendaDetalheVOList() {
        return vendaDetalheVOList;
    }

    public void setVendaDetalheVOList(List<VendaDetalheVO> vendaDetalheVOList) {
        this.vendaDetalheVOList = vendaDetalheVOList;
    }

    public List<CompraTipoRequisicaoVO> getCompraTipoRequisicaoVOList() {
        return compraTipoRequisicaoVOList;
    }

    public void setCompraTipoRequisicaoVOList(List<CompraTipoRequisicaoVO> compraTipoRequisicaoVOList) {
        this.compraTipoRequisicaoVOList = compraTipoRequisicaoVOList;
    }

    public List<VendaCondicoesPagamentoVO> getVendaCondicoesPagamentoVOList() {
        return vendaCondicoesPagamentoVOList;
    }

    public void setVendaCondicoesPagamentoVOList(List<VendaCondicoesPagamentoVO> vendaCondicoesPagamentoVOList) {
        this.vendaCondicoesPagamentoVOList = vendaCondicoesPagamentoVOList;
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
        if (!(object instanceof EmpresaVO)) {
            return false;
        }
        EmpresaVO other = (EmpresaVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.EmpresaVO_1[ id=" + id + " ]";
    }
    
}
