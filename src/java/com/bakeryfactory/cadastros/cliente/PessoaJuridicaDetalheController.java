/*
 * The MIT License
 *
 * Copyright 2016 Claudinei Aparecido Perboni <cperbony@gmail.com>.
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
import org.openswing.swing.form.client.FormController;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.message.receive.java.VOResponse;
import org.openswing.swing.message.receive.java.ValueObject;

/**
 *
 * @author Claudinei Aparecido Perboni <cperbony@gmail.com>
 */
class PessoaJuridicaDetalheController extends FormController {

    private PessoaVO pessoa;

    public PessoaJuridicaDetalheController() {
    }

    /**
     * This method must be overridden by the subclass to retrieve data and return the valorized value object. If the method is not overridden, the current version will return a "demo" value object.
     *
     * @param valueObjectClass value object class
     * @return a VOResponse object if data loading is successfully completed, or an ErrorResponse object if an error occours
     */
    @Override
    public Response loadData(Class valueObjectClass) {
        return new VOResponse(pessoa.getPessoaJuridica());
    }

    /**
     * Method called by the Form panel to insert new data.
     *
     * @param newValueObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    @Override
    public Response insertRecord(ValueObject newPersistentObject) throws Exception {
        return new VOResponse(newPersistentObject);
    }

    /**
     * Method called by the Form panel to update existing data.
     *
     * @param oldPersistentObject original value object, previous to the changes
     * @param persistentObject value object to save
     * @return an ErrorResponse value object in case of errors, VOResponse if the operation is successfully completed
     */
    @Override
    public Response updateRecord(ValueObject oldPersistentObject, ValueObject persistentObject) throws Exception {
        return new VOResponse(persistentObject);
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }
}
