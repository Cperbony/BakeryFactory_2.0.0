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
package com.bakeryfactory.padrao.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JFormattedTextField;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date 11/09/2016
 */
public class Biblioteca {

    private static Iterable<Field> fields;

    public JFormattedTextField.AbstractFormatter formatoCpf() {
        return new JFormattedTextField.AbstractFormatter() {
            @Override
            public Object stringToValue(String text) throws ParseException {
                String str = text.replace(".", "");
                str = str.replace("-", "");
                return str;
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                String str = (String) value;
                validaCPF(str);
                if (str.length() < 11) {
                    return null;
                }
                str = str.replace(".", "");
                str = str.replace("-", "");
                String strFormatado = str.substring(0, 3) + "."
                        + str.substring(3, 6) + "."
                        + str.substring(6, 9) + "-"
                        + str.substring(9, 1);
                return strFormatado;
            }
        };

    }

    @SuppressWarnings("empty-statement")
    public static boolean validaCPF(String strCpf) {
        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
            digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount));
            d1 = d1 + (11 - nCount) * digitoCPF;
            d2 = d2 + (12 - nCount) * digitoCPF;
        };

        resto = (d1 % 11);

        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        d2 += 2 * digito1;
        resto = (d2 % 11);

        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        return nDigVerific.equals(nDigResult);
    }

    public JFormattedTextField.AbstractFormatter formatoCnpj() {
        return new JFormattedTextField.AbstractFormatter() {

            @Override
            public Object stringToValue(String text) throws ParseException {
                String str = text.replace(".", "");
                str = str.replace("-", "");
                str = str.replace("/", "");
                return str;
            }

            @Override
            public String valueToString(Object value) throws ParseException {
                String str = (String) value;
                cnpjValido(str);
                if (str.length() < 14) {
                    return null;
                }
                str = str.replace(".", "");
                str = str.replace("-", "");
                str = str.replace("/", "");
                String strFormatado = str.substring(0, 2) + "."
                        + str.substring(2, 5) + "."
                        + str.substring(5, 8) + "/"
                        + str.substring(8, 12) + "-"
                        + str.substring(12, 14); //Exemplo: 10.793.118/0001-78
                return strFormatado;
            }
        };

    }

    public static boolean cnpjValido(String CNPJ) {

// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

// Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static void copiaArquivo(String origem, String destino) throws Exception {
        FileInputStream in = new FileInputStream(origem);
        try (FileOutputStream out = new FileOutputStream(destino)) {
            byte[] bb = new byte[in.available()];
            in.read(bb);
            out.write(bb);
        }
    }

    public static String MD5Arquivo(String nomeArquivo) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
        }
        File f = new File(nomeArquivo);
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
        }
        byte[] buffer = new byte[8192];
        int read = 0;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            return output;
        } catch (IOException e) {
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
        return null;
    }

    public static String MD5String(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static byte[] geraAssinaturaArquivo(byte[] arquivoAssinar, File arquivoCertificado, char[] senha) throws KeyStoreException {
        try {
            //carrega o Keystore
            KeyStore ks = KeyStore.getInstance("PKC12");
            InputStream isCertificado = new FileInputStream(arquivoCertificado);
            ks.load(isCertificado, senha);

            //pega a chave Privada
            Key key = ks.getKey(ks.aliases().nextElement(), senha);
            PrivateKey privateKey = (PrivateKey) key;

            //cria o objeto Signature informando o algoritimo de assinatura
            //http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html
            Signature sign = Signature.getInstance("SHA1withRSA");
            sign.initSign(privateKey);

            sign.update(arquivoAssinar);

            //gera a Assinatura
            byte[] assinatura = sign.sign();

            return assinatura;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Verifica se a data informada e valida
     *
     * @param dia, mes e ano
     * @return true se a data for valida, caso contrario false
     */
    public static boolean validaData(int dia, int mes, int ano) {
        try {
            Calendar dataValidar = Calendar.getInstance();
            dataValidar.setLenient(false);
            dataValidar.set(Calendar.DAY_OF_MONTH, dia);
            dataValidar.set(Calendar.MONTH, mes);
            dataValidar.set(Calendar.YEAR, ano);
            dataValidar.getTime();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    /**
     * Verifica se a hora informada e valida
     *
     * @param hora, minuto e segundo
     * @return true se a hora for valida, caso contrario false
     */
    public static boolean validaHora(int hora, int minuto, int segundo) {
        try {
            Calendar dataValidar = Calendar.getInstance();
            dataValidar.setLenient(false);
            dataValidar.set(Calendar.HOUR_OF_DAY, hora);
            dataValidar.set(Calendar.MINUTE, minuto);
            dataValidar.set(Calendar.SECOND, segundo);
            dataValidar.getTime();
            return true;
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return false;
    }

    /**
     * Oobtem a hora do dia em segundos
     *
     * @param dataMarcacao
     * @return int - hora do dia em segundos
     */
    public static int getHoraSeg(Calendar dataMarcacao) {
        int segundos = dataMarcacao.get(Calendar.SECOND);
        segundos += dataMarcacao.get(Calendar.MINUTE) * 60;
        segundos += dataMarcacao.get(Calendar.HOUR_OF_DAY) * 3600;
        return segundos;
    }

    /**
     * Converte segundos para horas:minutos:segundos
     *
     * @param segundos
     * @return String no formato HH:mm:ss
     */
    public static String getHoraMinutoSegundo(int segundos) {
        Calendar dataC = Calendar.getInstance();
        dataC.set(Calendar.HOUR_OF_DAY, 0);
        dataC.set(Calendar.MINUTE, 0);
        dataC.set(Calendar.SECOND, 0);

        dataC.add(Calendar.SECOND, segundos);

        String resultado = dataC.get(Calendar.HOUR_OF_DAY) < 10
                ? "0" + dataC.get(Calendar.HOUR_OF_DAY)
                : "" + dataC.get(Calendar.HOUR_OF_DAY);
        resultado += ":";

        resultado += dataC.get(Calendar.MINUTE) < 10
                ? "0" + dataC.get(Calendar.MINUTE)
                : "" + dataC.get(Calendar.MINUTE);
        resultado += ":";

        resultado += dataC.get(Calendar.SECOND) < 10
                ? "0" + dataC.get(Calendar.SECOND)
                : "" + dataC.get(Calendar.SECOND);

        return resultado;
    }

    /**
     * Converte a hora de String para Calendar
     *
     * @param horas no formato HH:mm:ss
     * @return Calendar
     */
    public static Calendar horaStrToCalendar(String horas) {
        Calendar dataC = Calendar.getInstance();
        dataC.set(Calendar.HOUR_OF_DAY, Integer.valueOf(horas.substring(0, 2)));
        dataC.set(Calendar.MINUTE, Integer.valueOf(horas.substring(3, 5)));
        dataC.set(Calendar.SECOND, Integer.valueOf(horas.substring(6, 8)));
        return dataC;
    }

    /**
     * Retorna o mes e ano no formato MM/AAAA
     *
     * @param dataA data
     * @return String
     */
    public static String mesAno(Calendar dataA) throws Exception {
        return new SimpleDateFormat("MM/yyyy").format(dataA.getTime());
    }

    public static String primeiraMaiuscula(String texto) {
        return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
    }

    /**
     * Busca os bytes de um determinado arquivo
     *
     * @param file Arquivo
     * @return byte[]
     */
    public static byte[] getBytesFromFile(File file) throws Exception {
        //Converte o arquivo em array de bytes 
        InputStream is = new FileInputStream(file);
        //Pega o tamanho do arquivo
        long length = file.length();
        //Cria o array de byte para armazenar a data
        byte[] documento = new byte[(int) length];
        //Ler nos bytes
        int offset = 0;
        int numRead = 0;
        while (offset < documento.length
                && (numRead = is.read(documento, offset, documento.length - offset)) >= 0) {
            offset += numRead;
        }
        //Certificar que todos os bytes foram lidos
        if (offset < documento.length) {
            throw new IOException("Não pode completar the ler o arquivo " + file.getName());
        }
        //Fecha o InputStream e retorna os bytes
        is.close();
        return documento;
    }

    /**
     * Salva um array de byte em um arquivo
     *
     * @param caminhoArquivo Nome do arquivo a ser salvo
     * @param file Array de byte que sera salvo
     *
     */
    public static void salvaArquivo(String caminhoArquivo, byte[] file) throws Exception {
        FileOutputStream out = new FileOutputStream(caminhoArquivo);
        out.write(file);
        out.close();
    }

    public static BigDecimal multiplica(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.multiply(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(Constantes.DECIMAIS_VALOR, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal divide(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.divide(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(Constantes.DECIMAIS_VALOR, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal subtrai(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.subtract(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(Constantes.DECIMAIS_VALOR, RoundingMode.DOWN);
        return resultado;
    }

    public static BigDecimal soma(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.add(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(Constantes.DECIMAIS_VALOR, RoundingMode.DOWN);
        return resultado;
    }
    
    /**
     * Verifica se o cpf informado e valido
     *
     * @param cpf CPF a validar
     * @return  boolean
     *
     */
    public static boolean cpfValido(String CPF) {
        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static Object nullToEmpty(Object objeto) {
        Object atributo;
        try {
            Field field[] = objeto.getClass().getDeclaredFields();
            for (Field f : fields) {

                if (!f.getName().equals("serialVersionUID")) {
                    if (f.getType() == String.class
                            || f.getType() == Integer.class
                            || f.getType() == BigDecimal.class
                            || f.getType() == Double.class
                            || f.getType() == Date.class
                            || f.getType() == Long.class) {

                        Method metodo = objeto.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
                        atributo = metodo.invoke(objeto);
                        if (atributo == null) {
                            if (f.getType() == String.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), String.class);
                                metodo.invoke(objeto, "");
                            }
                            if (f.getType() == Integer.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), Integer.class);
                                metodo.invoke(objeto, 0);
                            }
                            if (f.getType() == BigDecimal.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), BigDecimal.class);
                                metodo.invoke(objeto, BigDecimal.ZERO);
                            }
                            if (f.getType() == Double.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), Double.class);
                                metodo.invoke(objeto, 0.0);
                            }
                            if (f.getType() == Date.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), Date.class);
                                metodo.invoke(objeto, new Date(0l));
                            }
                            if (f.getType() == Long.class) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), Long.class);
                                metodo.invoke(objeto, 0l);
                            }
                        }
                    } else {
                        System.out.println(f.getName());
                        if (!objeto.getClass().getName().equals(f.getType().getName())) {
                            Method metodo = objeto.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
                            atributo = metodo.invoke(objeto);
                            if (atributo != null) {
                                if (atributo.getClass() == ArrayList.class) {
                                    for (Object o : (ArrayList) atributo) {
                                        //nullToEmpty(o);
                                    }
                                } else {
                                    nullToEmpty(atributo);
                                }
                            } else if (f.getType() != ArrayList.class || !(f.getType().isArray())) {
                                metodo = objeto.getClass().getDeclaredMethod("set" + primeiraMaiuscula(f.getName()), f.getType());
                                metodo.invoke(objeto, Class.forName(f.getType().getName()).newInstance());

                                metodo = objeto.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
                                atributo = metodo.invoke(objeto);

                                nullToEmpty(atributo);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return objeto;
    }

}
