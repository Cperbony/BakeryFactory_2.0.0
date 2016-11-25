/*
 * The MIT License
 *
 * Copyright 2016 Claudinei Aparecido Perboni - contact:cperbony@gmail.com.
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
package com.bakeryfactory.cadastros.cliente;

import com.bakeryfactory.padrao.java.Constantes;
import javax.swing.JOptionPane;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 15/10/2016
 */
public class NivelFormacaoDetalheController extends FormController {

    private NivelFormacaoDetalhe nivelFormacaoDetalhe = null;
    private String pk = null;
    private NivelFormacaoGrid nivelFormacaoGrid = null;
    private final String acaoServidor;

    public NivelFormacaoDetalheController(NivelFormacaoGrid tempGrid, String pk) {
        this.nivelFormacaoGrid = tempGrid;
        this.pk = pk;
        this.acaoServidor = "nivelFormacaoDetalheAction";
        nivelFormacaoDetalhe = new NivelFormacaoDetalhe(this);
        nivelFormacaoDetalhe.setParentFrame(this.nivelFormacaoGrid);
        this.nivelFormacaoGrid.pushFrame(nivelFormacaoDetalhe);
        MDIFrame.add(nivelFormacaoDetalhe);
        
        if (pk != null) {
            nivelFormacaoDetalhe.getForm1().setMode(Consts.READONLY);
            nivelFormacaoDetalhe.getForm1().reload();
        } else {
            nivelFormacaoDetalhe.getForm1().setMode(Consts.INSERT);
        }
    }

/**
 * This method must be overridden by the subclass to retrieve data and return the valorized value object. If the method is not overridden, the current version will return a "demo" value object.
 *
 * @param valueObjectClass value object class
 * @return a VOResponse object if data loading is successfully completed, or an ErrorResponse object if an error occours
 */
@Override
        public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    /**
     * Method called by the Form panel to insert new data.
     *
     * @param newPersistentObject
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     * @throws java.lang.Exception
     */
    @Override
        public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.INSERT, newPersistentObject});
    }

    /**
     * Callback method called after saving SUCCESSFULLY data in INSERT mode.
     */
    @Override
        public void afterInsertData() {
        nivelFormacaoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(nivelFormacaoDetalhe, "Dados Salvos com Sucesso!", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Method called by the Form panel to update existing data.
     *
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     * @throws java.lang.Exception
     */
    @Override
        public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.UPDATE, oldPersistentObject, persistentObject});
    }

    /**
     * Callback method called after saving SUCCESSFULLY data in EDIT mode.
     */
    @Override
        public void afterEditData() {
        nivelFormacaoGrid.getGrid1().reloadData();
        JOptionPane.showMessageDialog(nivelFormacaoDetalhe, "Dados Alterados Com Sucesso", "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    } 
    
     /**
   * Callback method invoked each time an input control is edited: this method define if the new value if valid.
   * Default behaviour: input control value is valid.
   * @param attributeName attribute name related to the input control currently edited
   * @param oldValue old input control value (before editing)
   * @param newValue new input control value (just edited)
   * @return <code>true</code> if input control value is valid, <code>false</code> otherwise
   */
    @Override
  public boolean validateControl(String attributeName,Object oldValue,Object newValue) {
    return true;
  }

}
