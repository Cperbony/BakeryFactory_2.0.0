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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "municipio")
@NamedQueries({
    @NamedQuery(name = "MunicipioVO.findAll", query = "SELECT m FROM MunicipioVO m")})
public class MunicipioVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "codigo_ibge")
    private Integer codigoIbge;
    @Column(name = "codigo_receita_federal")
    private Integer codigoReceitaFederal;
    @Column(name = "codigo_estadual")
    private Integer codigoEstadual;
    @Column(name = "uf_sigla")
    private String ufSigla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioId")
    private List<TransportadoraMunicipioVO> transportadoraMunicipioVOList;
    @JoinColumn(name = "uf_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UfVO ufId;

    public MunicipioVO() {
    }

    public MunicipioVO(Integer id) {
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

    public Integer getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public Integer getCodigoReceitaFederal() {
        return codigoReceitaFederal;
    }

    public void setCodigoReceitaFederal(Integer codigoReceitaFederal) {
        this.codigoReceitaFederal = codigoReceitaFederal;
    }

    public Integer getCodigoEstadual() {
        return codigoEstadual;
    }

    public void setCodigoEstadual(Integer codigoEstadual) {
        this.codigoEstadual = codigoEstadual;
    }

    public String getUfSigla() {
        return ufSigla;
    }

    public void setUfSigla(String ufSigla) {
        this.ufSigla = ufSigla;
    }

    public List<TransportadoraMunicipioVO> getTransportadoraMunicipioVOList() {
        return transportadoraMunicipioVOList;
    }

    public void setTransportadoraMunicipioVOList(List<TransportadoraMunicipioVO> transportadoraMunicipioVOList) {
        this.transportadoraMunicipioVOList = transportadoraMunicipioVOList;
    }

    public UfVO getUfId() {
        return ufId;
    }

    public void setUfId(UfVO ufId) {
        this.ufId = ufId;
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
        if (!(object instanceof MunicipioVO)) {
            return false;
        }
        MunicipioVO other = (MunicipioVO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.MunicipioVO[ id=" + id + " ]";
    }
    
}
