package reflection.p06_mirror_image.models.spells;

import reflection.p06_mirror_image.core.WizardDataImpl;
import reflection.p06_mirror_image.core.interfaces.WizardData;
import reflection.p06_mirror_image.enums.SpellType;
import reflection.p06_mirror_image.models.interfaces.Wizard;

public class Fireball extends AbstractSpell {

    public Fireball(SpellType spellType, Wizard wizard) {
        super(spellType, wizard);
    }

    @Override
    public void cast() {
        String wizardName = this.getWizard().getName();
        int wizardId = this.getWizard().getId();
        int damageDone = this.getWizard().getMagicalPower();

       String spellResult = String.format("%s %d casts Fireball for %d damage",
                wizardName,
                wizardId,
                damageDone);
        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addSpellResult(spellResult);
    }
}
