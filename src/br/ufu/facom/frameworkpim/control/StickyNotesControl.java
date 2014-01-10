package br.ufu.facom.frameworkpim.control;

import br.ufu.facom.frameworkpim.model.StickyNote;
import br.ufu.facom.frameworkpim.view.StickyNotesIFrame;
import java.util.List;

public interface StickyNotesControl {

    public void save(StickyNote snote);

    public void delete(StickyNote snote);

    public void updateStickyNotePositionInfo(StickyNote snote);
    
    public List<StickyNotesIFrame> buildStickyNotesIFrames();

}
