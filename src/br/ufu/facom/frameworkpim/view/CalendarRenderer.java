package br.ufu.facom.frameworkpim.view;

import br.ufu.facom.frameworkpim.control.EventoControl;
import br.ufu.facom.frameworkpim.model.Evento;
import com.javaswingcomponents.calendar.JSCCalendar;
import com.javaswingcomponents.calendar.cellrenderers.CalendarCellRenderer;
import com.javaswingcomponents.calendar.cellrenderers.CellRendererComponentParameter;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/*
 * Alteracoes sobre o formato e cor do calendario sao controladas por esta classe
 */
public class CalendarRenderer extends JLabel implements CalendarCellRenderer {

    private ArrayList<Evento>[] eventoMes;   //Array de listas (mais de um evento por dia)
    private int mesCorrente;
    private JTextArea textArea;
    private int lengthEventosTotal;
    private EventoControl eventoControl;

    public CalendarRenderer(JTextArea text,EventoControl ec) {
        this.mesCorrente = 0;
        this.textArea = text;
        this.eventoControl = ec;
        this.lengthEventosTotal = eventoControl.getEventos().size();
    }

    @Override
    public JComponent getCellRendererComponent(CellRendererComponentParameter parameterObject) {
        boolean isToday = parameterObject.isToday;
        boolean isSelected = parameterObject.isSelected;
        boolean isSelectable = parameterObject.isAllowSelection();
        boolean hasKeyboardFocus = parameterObject.isHasFocus();
        boolean isCurrentMonth = parameterObject.isCurrentMonth;

        String text = parameterObject.getText();
        Date date = parameterObject.getDate();
        String[] datestr = (new Timestamp(date.getTime())).toString().split("[^0-9]");
        int mes = Integer.parseInt(datestr[1]);
        int dia = Integer.parseInt(datestr[2]);
        //JSCCalendar calendar = parameterObject.getCalendar();

        if (isCurrentMonth) {
            if ((mes != this.mesCorrente)
                    || (this.lengthEventosTotal
                    != eventoControl.getEventos().size())) {
                this.lengthEventosTotal = eventoControl.getEventos().size();
                this.mesCorrente = mes;

            }
        }
        updateEventosDoMes();
        setHorizontalAlignment(JLabel.CENTER);
        setText(text);
        setOpaque(false);

        if (isSelectable) {
            setForeground(Color.BLACK);
        } else {
            setText(text);
            setForeground(Color.LIGHT_GRAY);
        }

        if (!isCurrentMonth) {
            setText("");
        }

        if (isSelected) {
            setBorder(BorderFactory.createDashedBorder(Color.BLACK, 3, 2));
            if ((!this.eventoMes[dia - 1].isEmpty()) && isCurrentMonth) {
                textArea.setText(this.getTextFromEventsOfDay(dia));
            } else {
                textArea.setText("");
            }
        } else {
            setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        }

        if (isToday && isCurrentMonth) {
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        }

        if ((!this.eventoMes[dia - 1].isEmpty()) && isCurrentMonth) {
            setBackground(Color.red);
            setOpaque(true);
        }

        if (hasKeyboardFocus) {
            setBorder(BorderFactory.createDashedBorder(Color.BLACK, 6, 2));
            setBackground(new Color(255, 248, 220));
            setOpaque(true);
        }
        return this;

    }

    @Override
    public JComponent getHeadingCellRendererComponent(JSCCalendar calendar, String text) {
        setHorizontalAlignment(JLabel.CENTER);
        setText(text);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setForeground(Color.BLACK);
        return this;
    }

    private void updateEventosDoMes() {

        this.eventoMes = (ArrayList<Evento>[]) new ArrayList[31];

        for (int i = 0; i < 31; i++) {
            this.eventoMes[i] = new ArrayList<>();
        }
        List<Evento> eventos = eventoControl.getEventos();
        for (Iterator<Evento> it = eventos.iterator(); it.hasNext();) {
            Evento evento = it.next();
            String[] time = evento.getDataHora().toString().split("[^0-9]");

            int mes = Integer.parseInt(time[1]);
            if (mes == this.mesCorrente) {
                int day = Integer.parseInt(time[2]);
                this.eventoMes[day - 1].add(evento);
            }
        }
    }

    private String getTextFromEventsOfDay(int day) {
        String str = "";
        int i = 0;
        for (Iterator it = this.eventoMes[day - 1].iterator(); it.hasNext();) {
            i++;
            Evento evento = (Evento) it.next();
            str += "--------------EVENTO " + i + "--------------\n";
            str += evento.toString() + "\n\n";
        }
        return str;
    }

}
