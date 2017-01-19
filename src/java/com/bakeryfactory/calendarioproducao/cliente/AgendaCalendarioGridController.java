/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bakeryfactory.calendarioproducao.cliente;

import com.bakeryfactory.cadastros.java.ColaboradorVO;
import com.bakeryfactory.calendarioproducao.java.AgendaCompromissoVO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.openswing.swing.mdi.client.MDIFrame;
import org.openswing.swing.util.client.ClientUtils;

/**
 * @author Claudinei Aparecido Perboni - contact:cperbony@gmail.com
 * @date   15/01/2017
 */
public class AgendaCalendarioGridController implements CalendarioListener {

    private AgendaCalendarioGrid grid;

public AgendaCalendarioGridController(Calendar dataCompromisso, List<AgendaCompromissoVO> listaCompromisso) {
        grid = new AgendaCalendarioGrid(this);

        Map<Calendar, List<CalendarioEvento>> listaCalendarioEvento = new HashMap<>();
        Date dataAnterior = new Date(0l);
        Calendar calendar = Calendar.getInstance();
        List<CalendarioEvento> listaEvento = new ArrayList<>();
        for (int i = 0; i < listaCompromisso.size(); i++) {
            AgendaCompromissoVO c = listaCompromisso.get(i);
            if (i == 0 || c.getDataCompromisso().compareTo(dataAnterior) != 0) {
                if (i != 0) {
                    listaCalendarioEvento.put(calendar, listaEvento);
                }

                listaEvento = new ArrayList<>();

                calendar = Calendar.getInstance();
                calendar.setTime(c.getDataCompromisso());

                dataAnterior = c.getDataCompromisso();
            }
            CalendarioEvento evento = new CalendarioEvento();
            evento.setTexto(c.getHora() + " - " + c.getDescricao());
            defineCor(evento, c.getAgendaCategoriaCompromisso().getCor());

            listaEvento.add(evento);
        }
        if (!listaEvento.isEmpty()) {
            listaCalendarioEvento.put(calendar, listaEvento);
        }

        new Calendario(grid.getPanel(), this, dataCompromisso, listaCalendarioEvento);

        MDIFrame.add(grid, true);
    }

    public AgendaCalendarioGridController(List<ColaboradorVO> listaAniversariante) {
        grid = new AgendaCalendarioGrid(this);

        Map<Calendar, List<CalendarioEvento>> listaCalendarioEvento = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -2);
        List<CalendarioEvento> listaEvento = new ArrayList<>();

        for (int i = 0; i < 120; i++) {
            for (ColaboradorVO c : listaAniversariante) {
                if (c.getPessoa().getPessoaFisica() != null) {
                    Calendar dataAniversario = Calendar.getInstance();
                    dataAniversario.setTime(c.getPessoa().getPessoaFisica().getDataNascimento());
                    if ((dataAniversario.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH))
                            && (dataAniversario.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))) {
                        CalendarioEvento evento = new CalendarioEvento();
                        evento.setIcon(new ImageIcon(ClientUtils.getImage("cake.png")));
                        evento.setTexto(c.getPessoa().getNome());
                        defineCor(evento, "Verde");

                        listaEvento.add(evento);
                    }
                }
            }
            if (!listaEvento.isEmpty()) {
                listaCalendarioEvento.put((Calendar) calendar.clone(), listaEvento);
                listaEvento = new ArrayList<>();
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        new Calendario(grid.getPanel(), this, Calendar.getInstance(), listaCalendarioEvento);

        MDIFrame.add(grid, true);
    }

    private void defineCor(CalendarioEvento evento, String cor) {
        switch (cor) {
            case "Amarelo": {
                evento.setBackground(Color.YELLOW);
                break;
            }
            case "Azul": {
                evento.setBackground(Color.BLUE);
                evento.setForeground(Color.WHITE);
                break;
            }
            case "Branco": {
                evento.setBackground(Color.WHITE);
                break;
            }
            case "Verde": {
                evento.setBackground(Color.GREEN);
                break;
            }
            case "Vermelho": {
                evento.setBackground(Color.RED);
                break;
            }
            default: {
                evento.setBackground(Color.BLACK);
                evento.setForeground(Color.WHITE);
                break;
            }
        }
    }

    @Override
    public CalendarioEvento adicionaCompromisso(Calendar dataCompromisso) {
        String descricao = JOptionPane.showInputDialog("Descrição do evento");
        if (descricao != null && !descricao.isEmpty()) {
            CalendarioEvento evento = new CalendarioEvento();
            evento.setTexto(descricao);
            defineCor(evento, "Azul");

            return evento;
        }
        return null;
    } 
}
