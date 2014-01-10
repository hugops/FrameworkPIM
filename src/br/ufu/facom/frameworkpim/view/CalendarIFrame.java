package br.ufu.facom.frameworkpim.view;

import br.ufu.facom.frameworkpim.control.EventoControl;
import com.javaswingcomponents.calendar.JSCCalendar;
import com.javaswingcomponents.calendar.plaf.darksteel.DarkSteelCalendarUI;
import com.javaswingcomponents.calendar.plaf.darksteel.DarkSteelCellPanel;
import com.javaswingcomponents.calendar.plaf.darksteel.DarkSteelCellPanelBackgroundPainter;
import com.javaswingcomponents.calendar.plaf.darksteel.DarkSteelMonthAndYearPanel;
import java.awt.Color;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 *  IFrame do calendario sobre o desktop
 */

public class CalendarIFrame extends JInternalFrame{
    
    private EventoControl eventoControl;
    
    public CalendarIFrame (EventoControl ec) {
        this.eventoControl = ec;
        this.setIFrameConfigurations();
        this.createEventoDisplay();
        this.createCalendar();
    }
    
    private void setIFrameConfigurations() {
        this.setTitle("Calendário");
        this.setIconifiable(true);
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(0, 0, 400, 430);
        this.setVisible(true);
    }
    
    private void createEventoDisplay() {
        this.textArea = new JTextArea();
        this.scrollText = new JScrollPane(this.textArea);
        this.scrollText.setBounds(5,253,380,135);
        this.textArea.setWrapStyleWord(true);
        this.textArea.setBackground(new Color(255, 255, 183));
        //this.scrollText.add(this.textArea);
        this.textArea.setBounds(0,0, 380, 135);
        this.textArea.setEditable(false);
        this.getContentPane().add(this.scrollText);
    }
    
    private void createCalendar() {
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale = Locale.getDefault();
        
        this.calendar = new JSCCalendar(timeZone, locale);
        this.calendar.setUI(new DarkSteelCalendarUI());
        this.calendar.setBounds(0, 0, 400, 250);
        
        DarkSteelCalendarUI calendarUI = (DarkSteelCalendarUI) this.calendar.getUI();
        DarkSteelMonthAndYearPanel monthAndYearPanel = (DarkSteelMonthAndYearPanel) calendarUI.getMonthAndYearPanel();
        DarkSteelCellPanel cellPanel = (DarkSteelCellPanel) calendarUI.getCellPanel();
        DarkSteelCellPanelBackgroundPainter cellPanelBackgroundPainter =
                (DarkSteelCellPanelBackgroundPainter) cellPanel.getBackgroundPainter();
        cellPanelBackgroundPainter.setHeadingBackgroundStartGradientColor(new Color(0xB0, 0xE0, 0xE6));
        cellPanelBackgroundPainter.setHeadingBackgroundEndGradientColor(new Color(0x46, 0x82, 0xB4));
        
        this.calendar.setCalendarCellRenderer(new CalendarRenderer(this.textArea,eventoControl));
        this.getContentPane().add(this.calendar);
    }
    
    private JSCCalendar calendar;
    private JTextArea textArea;
    private JScrollPane scrollText;
}
