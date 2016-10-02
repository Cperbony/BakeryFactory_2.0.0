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
package com.bakeryfactory.cadastros.cliente;

import com.bakeryfactory.cadastros.java.PessoaVO;
import com.bakeryfactory.padrao.java.Constantes;
import org.openswing.swing.form.client.Form;
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.ValueObject;
import org.openswing.swing.util.client.ClientUtils;
import org.openswing.swing.util.java.Consts;

/**
 *
 * @author Claudinei Aparecido Perboni • contact: cperbony@gmail.com
 */
public class PessoaDetalheController extends FormController {

    private PessoaDetalhe pessoaDetalhe = null;
    private String pk = null;
    private PessoaGrid pessoaGrid = null;
    private String acaoServidor;

    public PessoaDetalheController(PessoaGrid pessoaGrid, String pk) {
        this.pessoaGrid = new PessoaGrid();
        this.pk = pk;
        this.acaoServidor = "pessoaDetalheAction";
        pessoaDetalhe.setParentFrame(this.pessoaGrid);
        this.pessoaGrid.pushFrame(pessoaDetalhe);
        MDIFrame.add(pessoaDetalhe);
        try {
            pessoaDetalhe.setMaximum(true);
        } catch (Exception e) {
        }

        if (pk != null) {
            pessoaDetalhe.getForm1().setMode(Consts.READONLY);
            pessoaDetalhe.getForm1().reload();
        } else {
            pessoaDetalhe.getForm1().setMode(Consts.INSERT);
            pessoaDetalhe.getFormPessoaFisica().setMode(Consts.INSERT);
            pessoaDetalhe.getFormPessoaJuridica().setMode(Consts.INSERT);
            pessoaDetalhe.getGridControlContatos().reloadData();
            pessoaDetalhe.getGridControlEndereco().reloadData();
            pessoaDetalhe.getGridControlTelefone().reloadData();
        }
    }

    @Override
    public Response loadData(Class valueObjectClass) {
        return ClientUtils.getData(acaoServidor, new Object[]{Constantes.LOAD, pk});
    }

    public void loadDataCompleted(boolean error) {
        PessoaVO pessoa = (PessoaVO) pessoaDetalhe.getForm1().getVOModel().getValueObject();
        if (pessoa.getTipo().equals("F")) {
            pessoaDetalhe.getFormPessoaFisica().setVisible(true);
            pessoaDetalhe.getFormPessoaJuridica().setVisible(false);
        } else {
            pessoaDetalhe.getFormPessoaFisica().setVisible(false);
            pessoaDetalhe.getFormPessoaJuridica().setVisible(true);
        }

        pessoaDetalhe.getPessoaFisicaController().setPessoa(pessoa);
        pessoaDetalhe.getFormPessoaFisica().reload();

        pessoaDetalhe.getPessoaJuridicaController().setPessoa(pessoa);
        pessoaDetalhe.getFormPessoaJuridica().reload();

        pessoaDetalhe.getContatoController().setPk(pessoa.getId().toString());
        pessoaDetalhe.getGridControlContatos().reloadData();

        pessoaDetalhe.getEnderecoController().setPessoa(pessoa);
        pessoaDetalhe.getGridControlEndereco().reloadData();

        pessoaDetalhe.getTelefoneController().setPessoa(pessoa);
        pessoaDetalhe.getGridControlTelefone().reloadData();
    }
    
    /**
   * Method called by the Form panel to insert new data.
   * @param newValueObject value object to save
   * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
   */
  public Response insertRecord(ValueObject newPersistentObject) throws Exception {
    throw new java.lang.UnsupportedOperationException("Method insertRecord() not yet implemented.");
  }

    /**
   * Callback method called after saving SUCCESSFULLY data in INSERT mode.
   */
  public void afterInsertData() {
  }
  
  /**
   * Callback method invoked on pressing EDIT button to check if edit mode is allowed.
   * @return <code>true</code> allows to go to EDIT mode, <code>false</code> the mode change is interrupted
   */
  public boolean beforeEditData(Form form) {
    return true;
  }
  
   /**
   * Method called by the Form panel to update existing data.
   * @param oldPersistentObject original value object, previous to the changes
   * @param persistentObject value object to save
   * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
   */
  public Response updateRecord(ValueObject oldPersistentObject,ValueObject persistentObject) throws Exception {
    throw new java.lang.UnsupportedOperationException("Method updateRecord() not yet implemented.");
  }
  
   /**
   * Callback method called after saving SUCCESSFULLY data in EDIT mode.
   */
  public void afterEditData() {
      pessoaGrid.
  }
  
    /**
   * Callback method invoked each time an input control is edited: this method define if the new value if valid.
   * Default behaviour: input control value is valid.
   * @param attributeName attribute name related to the input control currently edited
   * @param oldValue old input control value (before editing)
   * @param newValue new input control value (just edited)
   * @return <code>true</code> if input control value is valid, <code>false</code> otherwise
   */
  public boolean validateControl(String attributeName,Object oldValue,Object newValue) {
    if(attributeName.equals("tipo")) {
        if(newValue.toString().equals("F")){
            pessoaDetalhe.getFormPessoaFisica().setVisible(true);
            pessoaDetalhe.getFormPessoaJuridica().setVisible(false);
        }else{
            pessoaDetalhe.getFormPessoaFisica().setVisible(false);
            pessoaDetalhe.getFormPessoaJuridica().setVisible(true);
        }
    }
      
      return super.validateControl(attributeName, oldValue, newValue);
  }
  
    
}
