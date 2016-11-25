/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.cadastros.cliente;

import java.util.ArrayList;
import java.util.Map;
import org.openswing.swing.message.receive.java.Response;
import org.openswing.swing.table.client.GridController;
import org.openswing.swing.table.java.GridDataLocator;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   23/11/2016
 */
public class IngredienteGridController extends GridController implements GridDataLocator{

    public IngredienteGridController() {
    }

    @Override
    public Response loadData(int action, int startIndex, Map filteredColumns, ArrayList currentSortedColumns, ArrayList currentSortedVersusColumns, Class valueObjectType, Map otherGridParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
