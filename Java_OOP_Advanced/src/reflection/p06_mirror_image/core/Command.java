package reflection.p06_mirror_image.core;

import reflection.p06_mirror_image.core.interfaces.Executable;
import reflection.p06_mirror_image.enums.SpellType;
import reflection.p06_mirror_image.factories.SpellFactory;
import reflection.p06_mirror_image.models.interfaces.Spell;
import reflection.p06_mirror_image.models.interfaces.Wizard;

public class Command implements Executable {


    @Override
    public void execute(String[] args) {
        int mageId = Integer.valueOf(args[0]);
        SpellType spellType = SpellType.valueOf(args[1]);

        Wizard wizard = WizardDataImpl.getInstance().getWizard(mageId);
        Spell spell = SpellFactory.createSpell(spellType, wizard);

        wizard.castSpell(spell);
    }
}
