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
package com.bakeryfactory.padrao.cliente;

import com.bakeryfactory.cadastros.java.EmpresaEnderecoVO;
import com.bakeryfactory.cadastros.java.UsuarioVO;
import java.util.Hashtable;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 11/09/2016
 */
public class Container {

    //Objeto Utilizado para armazenar os dados da aplicação do lado Cliente
    private static Hashtable container = new Hashtable();

    public static Hashtable getContainer() {
        return container;
    }

    public static void setContainer(UsuarioVO usuarioVo) {
        container.put("usuario", usuarioVo);
        container.put("empresa", usuarioVo.getColaborador().getPessoa().getListaEmpresa().get(0));
        EmpresaEnderecoVO enderecoPrincipalEmpresa = new EmpresaEnderecoVO();
        for (EmpresaEnderecoVO endereco : usuarioVo.getColaborador().getPessoa().getListaEmpresa().get(0).getListaEndereco()) {
            if (endereco.getPrincipal().equals("S")) {
                enderecoPrincipalEmpresa = endereco;
            }
        }
        container.put("enderecoPrincipalEmpresa", enderecoPrincipalEmpresa);
    }
}
