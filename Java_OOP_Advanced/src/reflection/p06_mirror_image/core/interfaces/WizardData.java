package reflection.p06_mirror_image.core.interfaces;

import reflection.p06_mirror_image.models.interfaces.Wizard;

public interface WizardData {

    void addWizard(Wizard wizard);

    Wizard getWizard(int id);

    void addSpellResult(String spellResult);

    String getSpellResults();
}
