package br.ufu.facom.frameworkpim.control;

import br.ufu.facom.frameworkpim.model.StickyNote;

public interface StickyNotesControl {

    public void save(StickyNote snote);

    public void delete(StickyNote snote);

    public void updateStickyNotePositionInfo(StickyNote snote);

}
