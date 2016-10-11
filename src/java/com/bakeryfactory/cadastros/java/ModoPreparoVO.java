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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openswing.swing.message.receive.java.ValueObjectImpl;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
@Entity
@Table(name = "MODO_PREPARO")
public class ModoPreparoVO extends ValueObjectImpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModoPreparoVOPK modoPreparoVOPK;
    @Column(name = "DESCRICAO_PREPARO")
    private String descricaoPreparo;
    @Column(name = "TEMPO_PREPARO")
    private String tempoPreparo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RENDIMENTO")
    private BigDecimal rendimento;
    @Column(name = "DATA_REVISAO")
    @Temporal(TemporalType.DATE)
    private Date dataRevisao;
    
    @JoinColumn(name = "ID_RECEITA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ReceitaVO receita;

    public ModoPreparoVO() {
    }

    public ModoPreparoVO(ModoPreparoVOPK modoPreparoVOPK) {
        this.modoPreparoVOPK = modoPreparoVOPK;
    }

    public ModoPreparoVO(int id, int receitaId) {
        this.modoPreparoVOPK = new ModoPreparoVOPK(id, receitaId);
    }

    public ModoPreparoVOPK getModoPreparoVOPK() {
        return modoPreparoVOPK;
    }

    public void setModoPreparoVOPK(ModoPreparoVOPK modoPreparoVOPK) {
        this.modoPreparoVOPK = modoPreparoVOPK;
    }

    public String getDescricaoPreparo() {
        return descricaoPreparo;
    }

    public void setDescricaoPreparo(String descricaoPreparo) {
        this.descricaoPreparo = descricaoPreparo;
    }

    public String getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(String tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    public Date getDataRevisao() {
        return dataRevisao;
    }

    public void setDataRevisao(Date dataRevisao) {
        this.dataRevisao = dataRevisao;
    }

    public ReceitaVO getReceita() {
        return receita;
    }

    public void setReceita(ReceitaVO receita) {
        this.receita = receita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modoPreparoVOPK != null ? modoPreparoVOPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModoPreparoVO)) {
            return false;
        }
        ModoPreparoVO other = (ModoPreparoVO) object;
        if ((this.modoPreparoVOPK == null && other.modoPreparoVOPK != null) || (this.modoPreparoVOPK != null && !this.modoPreparoVOPK.equals(other.modoPreparoVOPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bakeryfactory.cadastros.java.ModoPreparoVO[ modoPreparoVOPK=" + modoPreparoVOPK + " ]";
    }
    
}
