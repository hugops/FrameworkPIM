package br.ufu.facom.frameworkpim.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.JTextComponent;

/*
 * Listener para adicionar ao campos que precisam ser delimitados
 */
public class LimitDigitsListener implements KeyListener{

    private int maximumDigits;
    private JTextComponent textComponent;
     
    public LimitDigitsListener(int maximumDigits, JTextComponent textComponent){
        this.maximumDigits = maximumDigits;
        this.textComponent = textComponent;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {        
        if (textComponent.getText().length() > maximumDigits){
            String text = textComponent.getText();
            textComponent.setText(text.substring(0,maximumDigits));   
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public int getMaximumDigits() {
        return maximumDigits;
    }

    public void setMaximumDigits(int maximumDigits) {
        this.maximumDigits = maximumDigits;
    }
    
    
}
