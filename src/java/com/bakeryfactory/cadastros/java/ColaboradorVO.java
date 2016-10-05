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
@Table(name = "colaborador")
public class ColaboradorVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "data_admissao")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;
    @Column(name = "vencimento_ferias")
    @Temporal(TemporalType.DATE)
    private Date vencimentoFerias;
    @Column(name = "foto_3x4")
    private String foto3x4;
    @Column(name = "data_transferencia")
    @Temporal(TemporalType.DATE)
    private Date dataTransferencia;
    @Column(name = "fgts_optante")
    private Character fgtsOptante;
    @Column(name = "fgts_data_opcao")
    @Temporal(TemporalType.DATE)
    private Date fgtsDataOpcao;
    @Column(name = "fgts_conta")
    private Integer fgtsConta;
    @Column(name = "pagamento_forma")
    private Character pagamentoForma;
    @Column(name = "pagamento_banco")
    private String pagamentoBanco;
    @Column(name = "pagamento_agencia")
    private String pagamentoAgencia;
    @Column(name = "pagamento_agencia_digito")
    private Character pagamentoAgenciaDigito;
    @Column(name = "pagamento_conta")
    private String pagamentoConta;
    @Column(name = "pagamento_conta_digito")
    private Character pagamentoContaDigito;
    @Column(name = "exame_medico_ultimo")
    @Temporal(TemporalType.DATE)
    private Date exameMedicoUltimo;
    @Column(name = "exame_medico_vencimento")
    @Temporal(TemporalType.DATE)
    private Date exameMedicoVencimento;
    @Column(name = "pis_data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date pisDataCadastro;
    @Column(name = "pis_numero")
    private String pisNumero;
    @Column(name = "pis_banco")
    private String pisBanco;
    @Column(name = "pis_agencia")
    private String pisAgencia;
    @Column(name = "pis_agencia_digito")
    private Character pisAgenciaDigito;
    @Column(name = "ctps_numero")
    private String ctpsNumero;
    @Column(name = "ctps_serie")
    private String ctpsSerie;
    @Column(name = "ctps_data_expedicao")
    @Temporal(TemporalType.DATE)
    private Date ctpsDataExpedicao;
    @Column(name = "ctps_uf")
    private String ctpsUf;
    @Column(name = "desconto_plano_saude")
    private Character descontoPlanoSaude;
    @Column(name = "sai_na_rais")
    private Character saiNaRais;
    @Column(name = "categoria_sefip")
    private String categoriaSefip;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "ocorrencia_sefip")
    private Integer ocorrenciaSefip;
    @Column(name = "codigo_admissao_caged")
    private Integer codigoAdmissaoCaged;
    @Column(name = "codigo_demissao_caged")
    private Integer codigoDemissaoCaged;
    @Column(name = "codigo_demissao_sefip")
    private Integer codigoDemissaoSefip;
    @Column(name = "caged_aprendiz")
    private Character cagedAprendiz;
    @Column(name = "caged_deficiencia")
    private Character cagedDeficiencia;
    @Column(name = "classificacao_contabil_conta")
    private String classificacaoContabilConta;
    @Column(name = "codigo_turma_ponto")
    private String codigoTurmaPonto;
    @Column(name = "ata_demissao")
    @Temporal(TemporalType.DATE)
    private Date ataDemissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private List<VendaRomaneioEntregaVO> vendaRomaneioEntregaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private List<UsuarioVO> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private List<RequisicaoInternaDetalheVO> requisicaoInternaDetalheList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private List<CompraRequisicaoVO> compraRequisicaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private List<VendedorVO> vendedorList;
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CargoVO cargo;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PessoaVO pessoa;
    @JoinColumn(name = "setor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SetorVO setor;
    @JoinColumn(name = "tipo_colaborador_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoColaboradorVO tipoColaborador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradorId")
    private List<PcpServicoColaboradorVO> pcpServicoColaboradorList;

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

    public List<VendaRomaneioEntregaVO> getVendaRomaneioEntregaList() {
        return vendaRomaneioEntregaList;
    }

    public void setVendaRomaneioEntregaList(List<VendaRomaneioEntregaVO> vendaRomaneioEntregaList) {
        this.vendaRomaneioEntregaList = vendaRomaneioEntregaList;
    }

    public List<UsuarioVO> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<UsuarioVO> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<RequisicaoInternaDetalheVO> getRequisicaoInternaDetalheList() {
        return requisicaoInternaDetalheList;
    }

    public void setRequisicaoInternaDetalheList(List<RequisicaoInternaDetalheVO> requisicaoInternaDetalheList) {
        this.requisicaoInternaDetalheList = requisicaoInternaDetalheList;
    }

    public List<CompraRequisicaoVO> getCompraRequisicaoList() {
        return compraRequisicaoList;
    }

    public void setCompraRequisicaoList(List<CompraRequisicaoVO> compraRequisicaoList) {
        this.compraRequisicaoList = compraRequisicaoList;
    }

    public List<VendedorVO> getVendedorList() {
        return vendedorList;
    }

    public void setVendedorList(List<VendedorVO> vendedorList) {
        this.vendedorList = vendedorList;
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

    public List<PcpServicoColaboradorVO> getPcpServicoColaboradorList() {
        return pcpServicoColaboradorList;
    }

    public void setPcpServicoColaboradorList(List<PcpServicoColaboradorVO> pcpServicoColaboradorList) {
        this.pcpServicoColaboradorList = pcpServicoColaboradorList;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ColaboradorVO[ id=" + id + " ]";
    }
    
}
