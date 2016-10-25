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

import com.bakeryfactory.vendas.java.VendaRomaneioEntregaVO;
import com.bakeryfactory.pcp.java.PcpServicoColaboradorVO;
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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "COLABORADOR")
public class ColaboradorVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MATRICULA")
    private String matricula;
    @Column(name = "DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "DATA_ADMISSAO")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    @Column(name = "VENCIMENTO_FERIAS")
    @Temporal(TemporalType.DATE)
    private Date vencimentoFerias;
    @Column(name = "FOTO_3X4")
    private String foto3x4;
    @Column(name = "DATA_TRANSFERENCIA")
    @Temporal(TemporalType.DATE)
    private Date dataTransferencia;
    @Column(name = "FGTS_OPTANTE")
    private Character fgtsOptante;
    @Column(name = "FGTS_DATA_OPCAO")
    @Temporal(TemporalType.DATE)
    private Date fgtsDataOpcao;
    @Column(name = "FGTS_CONTA")
    private Integer fgtsConta;
    @Column(name = "PAGAMENTO_FORMA")
    private Character pagamentoForma;
    @Column(name = "PAGAMENTO_BANCO")
    private String pagamentoBanco;
    @Column(name = "PAGAMENTO_AGENCIA")
    private String pagamentoAgencia;
    @Column(name = "PAGAMENTO_AGENCIA_DIGITO")
    private Character pagamentoAgenciaDigito;
    @Column(name = "PAGAMENTO_CONTA")
    private String pagamentoConta;
    @Column(name = "PAGAMENTO_CONTA_DIGITO")
    private Character pagamentoContaDigito;
    @Column(name = "EXAME_MEDICO_ULTIMO")
    @Temporal(TemporalType.DATE)
    private Date exameMedicoUltimo;
    @Column(name = "EXAME_MEDICO_VENCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date exameMedicoVencimento;
    @Column(name = "PIS_DATA_CADASTRO")
    @Temporal(TemporalType.DATE)
    private Date pisDataCadastro;
    @Column(name = "PIS_NUMERO")
    private String pisNumero;
    @Column(name = "PIS_BANCO")
    private String pisBanco;
    @Column(name = "PIS_AGENCIA")
    private String pisAgencia;
    @Column(name = "PIS_AGENCIA_DIGITO")
    private Character pisAgenciaDigito;
    @Column(name = "CTPS_NUMERO")
    private String ctpsNumero;
    @Column(name = "CTPS_SERIE")
    private String ctpsSerie;
    @Column(name = "CTPS_DATA_EXPEDICAO")
    @Temporal(TemporalType.DATE)
    private Date ctpsDataExpedicao;
    @Column(name = "CTPS_UF")
    private String ctpsUf;
    @Column(name = "DESCONTO_PLANO_SAUDE")
    private Character descontoPlanoSaude;
    @Column(name = "SAI_NA_RAIS")
    private Character saiNaRais;
    @Column(name = "CATEGORIA_SEFIP")
    private String categoriaSefip;
    @Column(name = "OBSERVACAO")
    private String observacao;
    @Column(name = "OCORRENCIA_SEFIP")
    private Integer ocorrenciaSefip;
    @Column(name = "CODIGO_ADMISSAO_CAGED")
    private Integer codigoAdmissaoCaged;
    @Column(name = "CODIGO_DEMISSAO_CAGED")
    private Integer codigoDemissaoCaged;
    @Column(name = "CODIGO_DEMISSAO_SEFIP")
    private Integer codigoDemissaoSefip;
    @Column(name = "CAGED_APRENDIZ")
    private Character cagedAprendiz;
    @Column(name = "CAGED_DEFICIENCIA")
    private Character cagedDeficiencia;
    @Column(name = "CLASSIFICACAO_CONTABIL_CONTA")
    private String classificacaoContabilConta;
    @Column(name = "CODIGO_TURMA_PONTO")
    private String codigoTurmaPonto;
    @Column(name = "ATA_DEMISSAO")
    @Temporal(TemporalType.DATE)
    private Date ataDemissao;

    @JoinColumn(name = "ID_CARGO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CargoVO cargo;

    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private PessoaVO pessoa;

    @JoinColumn(name = "ID_SETOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SetorVO setor;

    @JoinColumn(name = "ID_TIPO_COLABORADOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TipoColaboradorVO tipoColaborador;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "colaborador")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendaRomaneioEntregaVO> listaVendaRomaneioEntrega;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "colaborador")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UsuarioVO> ListaUsuario;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "colaborador")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraRequisicaoInternaDetalheVO> listaRequisicaoInternaDetalhe;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "colaborador")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CompraRequisicaoVO> listaCompraRequisicao;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "colaborador")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<VendedorVO> listaVendedor;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "colaborador")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PcpServicoColaboradorVO> ListaPcpServicoColaborador;

    public ColaboradorVO() {
    }

    public ColaboradorVO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getVencimentoFerias() {
        return vencimentoFerias;
    }

    public void setVencimentoFerias(Date vencimentoFerias) {
        this.vencimentoFerias = vencimentoFerias;
    }

    public String getFoto3x4() {
        return foto3x4;
    }

    public void setFoto3x4(String foto3x4) {
        this.foto3x4 = foto3x4;
    }

    public Date getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(Date dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Character getFgtsOptante() {
        return fgtsOptante;
    }

    public void setFgtsOptante(Character fgtsOptante) {
        this.fgtsOptante = fgtsOptante;
    }

    public Date getFgtsDataOpcao() {
        return fgtsDataOpcao;
    }

    public void setFgtsDataOpcao(Date fgtsDataOpcao) {
        this.fgtsDataOpcao = fgtsDataOpcao;
    }

    public Integer getFgtsConta() {
        return fgtsConta;
    }

    public void setFgtsConta(Integer fgtsConta) {
        this.fgtsConta = fgtsConta;
    }

    public Character getPagamentoForma() {
        return pagamentoForma;
    }

    public void setPagamentoForma(Character pagamentoForma) {
        this.pagamentoForma = pagamentoForma;
    }

    public String getPagamentoBanco() {
        return pagamentoBanco;
    }

    public void setPagamentoBanco(String pagamentoBanco) {
        this.pagamentoBanco = pagamentoBanco;
    }

    public String getPagamentoAgencia() {
        return pagamentoAgencia;
    }

    public void setPagamentoAgencia(String pagamentoAgencia) {
        this.pagamentoAgencia = pagamentoAgencia;
    }

    public Character getPagamentoAgenciaDigito() {
        return pagamentoAgenciaDigito;
    }

    public void setPagamentoAgenciaDigito(Character pagamentoAgenciaDigito) {
        this.pagamentoAgenciaDigito = pagamentoAgenciaDigito;
    }

    public String getPagamentoConta() {
        return pagamentoConta;
    }

    public void setPagamentoConta(String pagamentoConta) {
        this.pagamentoConta = pagamentoConta;
    }

    public Character getPagamentoContaDigito() {
        return pagamentoContaDigito;
    }

    public void setPagamentoContaDigito(Character pagamentoContaDigito) {
        this.pagamentoContaDigito = pagamentoContaDigito;
    }

    public Date getExameMedicoUltimo() {
        return exameMedicoUltimo;
    }

    public void setExameMedicoUltimo(Date exameMedicoUltimo) {
        this.exameMedicoUltimo = exameMedicoUltimo;
    }

    public Date getExameMedicoVencimento() {
        return exameMedicoVencimento;
    }

    public void setExameMedicoVencimento(Date exameMedicoVencimento) {
        this.exameMedicoVencimento = exameMedicoVencimento;
    }

    public Date getPisDataCadastro() {
        return pisDataCadastro;
    }

    public void setPisDataCadastro(Date pisDataCadastro) {
        this.pisDataCadastro = pisDataCadastro;
    }

    public String getPisNumero() {
        return pisNumero;
    }

    public void setPisNumero(String pisNumero) {
        this.pisNumero = pisNumero;
    }

    public String getPisBanco() {
        return pisBanco;
    }

    public void setPisBanco(String pisBanco) {
        this.pisBanco = pisBanco;
    }

    public String getPisAgencia() {
        return pisAgencia;
    }

    public void setPisAgencia(String pisAgencia) {
        this.pisAgencia = pisAgencia;
    }

    public Character getPisAgenciaDigito() {
        return pisAgenciaDigito;
    }

    public void setPisAgenciaDigito(Character pisAgenciaDigito) {
        this.pisAgenciaDigito = pisAgenciaDigito;
    }

    public String getCtpsNumero() {
        return ctpsNumero;
    }

    public void setCtpsNumero(String ctpsNumero) {
        this.ctpsNumero = ctpsNumero;
    }

    public String getCtpsSerie() {
        return ctpsSerie;
    }

    public void setCtpsSerie(String ctpsSerie) {
        this.ctpsSerie = ctpsSerie;
    }

    public Date getCtpsDataExpedicao() {
        return ctpsDataExpedicao;
    }

    public void setCtpsDataExpedicao(Date ctpsDataExpedicao) {
        this.ctpsDataExpedicao = ctpsDataExpedicao;
    }

    public String getCtpsUf() {
        return ctpsUf;
    }

    public void setCtpsUf(String ctpsUf) {
        this.ctpsUf = ctpsUf;
    }

    public Character getDescontoPlanoSaude() {
        return descontoPlanoSaude;
    }

    public void setDescontoPlanoSaude(Character descontoPlanoSaude) {
        this.descontoPlanoSaude = descontoPlanoSaude;
    }

    public Character getSaiNaRais() {
        return saiNaRais;
    }

    public void setSaiNaRais(Character saiNaRais) {
        this.saiNaRais = saiNaRais;
    }

    public String getCategoriaSefip() {
        return categoriaSefip;
    }

    public void setCategoriaSefip(String categoriaSefip) {
        this.categoriaSefip = categoriaSefip;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getOcorrenciaSefip() {
        return ocorrenciaSefip;
    }

    public void setOcorrenciaSefip(Integer ocorrenciaSefip) {
        this.ocorrenciaSefip = ocorrenciaSefip;
    }

    public Integer getCodigoAdmissaoCaged() {
        return codigoAdmissaoCaged;
    }

    public void setCodigoAdmissaoCaged(Integer codigoAdmissaoCaged) {
        this.codigoAdmissaoCaged = codigoAdmissaoCaged;
    }

    public Integer getCodigoDemissaoCaged() {
        return codigoDemissaoCaged;
    }

    public void setCodigoDemissaoCaged(Integer codigoDemissaoCaged) {
        this.codigoDemissaoCaged = codigoDemissaoCaged;
    }

    public Integer getCodigoDemissaoSefip() {
        return codigoDemissaoSefip;
    }

    public void setCodigoDemissaoSefip(Integer codigoDemissaoSefip) {
        this.codigoDemissaoSefip = codigoDemissaoSefip;
    }

    public Character getCagedAprendiz() {
        return cagedAprendiz;
    }

    public void setCagedAprendiz(Character cagedAprendiz) {
        this.cagedAprendiz = cagedAprendiz;
    }

    public Character getCagedDeficiencia() {
        return cagedDeficiencia;
    }

    public void setCagedDeficiencia(Character cagedDeficiencia) {
        this.cagedDeficiencia = cagedDeficiencia;
    }

    public String getClassificacaoContabilConta() {
        return classificacaoContabilConta;
    }

    public void setClassificacaoContabilConta(String classificacaoContabilConta) {
        this.classificacaoContabilConta = classificacaoContabilConta;
    }

    public String getCodigoTurmaPonto() {
        return codigoTurmaPonto;
    }

    public void setCodigoTurmaPonto(String codigoTurmaPonto) {
        this.codigoTurmaPonto = codigoTurmaPonto;
    }

    public Date getAtaDemissao() {
        return ataDemissao;
    }

    public void setAtaDemissao(Date ataDemissao) {
        this.ataDemissao = ataDemissao;
    }

    public List<VendaRomaneioEntregaVO> getListaVendaRomaneioEntrega() {
        return listaVendaRomaneioEntrega;
    }

    public void setListaVendaRomaneioEntrega(List<VendaRomaneioEntregaVO> listaVendaRomaneioEntrega) {
        this.listaVendaRomaneioEntrega = listaVendaRomaneioEntrega;
    }

    public List<UsuarioVO> getListaUsuario() {
        return ListaUsuario;
    }

    public void setListaUsuario(List<UsuarioVO> ListaUsuario) {
        this.ListaUsuario = ListaUsuario;
    }

    public List<CompraRequisicaoInternaDetalheVO> getListaRequisicaoInternaDetalhe() {
        return listaRequisicaoInternaDetalhe;
    }

    public void setListaRequisicaoInternaDetalhe(List<CompraRequisicaoInternaDetalheVO> listaRequisicaoInternaDetalhe) {
        this.listaRequisicaoInternaDetalhe = listaRequisicaoInternaDetalhe;
    }

    public List<CompraRequisicaoVO> getListaCompraRequisicao() {
        return listaCompraRequisicao;
    }

    public void setListaCompraRequisicao(List<CompraRequisicaoVO> listaCompraRequisicao) {
        this.listaCompraRequisicao = listaCompraRequisicao;
    }

    public List<VendedorVO> getListaVendedor() {
        return listaVendedor;
    }

    public void setListaVendedor(List<VendedorVO> listaVendedor) {
        this.listaVendedor = listaVendedor;
    }

    public CargoVO getCargo() {
        return cargo;
    }

    public void setCargo(CargoVO cargo) {
        this.cargo = cargo;
    }

    public PessoaVO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }

    public SetorVO getSetor() {
        return setor;
    }

    public void setSetor(SetorVO setor) {
        this.setor = setor;
    }

    public TipoColaboradorVO getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(TipoColaboradorVO tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public List<PcpServicoColaboradorVO> getListaPcpServicoColaborador() {
        return ListaPcpServicoColaborador;
    }

    public void setListaPcpServicoColaborador(List<PcpServicoColaboradorVO> ListaPcpServicoColaborador) {
        this.ListaPcpServicoColaborador = ListaPcpServicoColaborador;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ColaboradorVO[ id=" + id + " ]";
    }

}
