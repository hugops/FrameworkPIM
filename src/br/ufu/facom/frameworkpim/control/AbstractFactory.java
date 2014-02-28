/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.frameworkpim.control;

/**
 *
 * @author Silas
 */
public interface AbstractFactory {

    public EventoControl createEventoControl();

    public StickyNotesControl createCtickyNotesControl();

}
