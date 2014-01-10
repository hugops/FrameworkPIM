package br.ufu.facom.frameworkpim.control;

import br.ufu.facom.frameworkpim.model.Evento;
import java.util.List;

//Singleton
public interface EventoControl {

    public Evento save(Evento evento);

    public List<Evento> getEventos();

}
