package reflection.p06_mirror_image.models.spells;

import reflection.p06_mirror_image.core.WizardDataImpl;
import reflection.p06_mirror_image.core.interfaces.WizardData;
import reflection.p06_mirror_image.enums.SpellType;
import reflection.p06_mirror_image.factories.WizardFactory;
import reflection.p06_mirror_image.models.interfaces.Wizard;

public class Reflection extends AbstractSpell {

    private static final int REFLECTION_COUNT = 2;

    public Reflection(SpellType spellType, Wizard wizard) {
        super(spellType, wizard);
    }

    @Override
    public void cast() {
        Wizard wizard = this.getWizard();
        int magicalPower = this.getWizard().getMagicalPower();

        if (wizard.getListenersCount() < REFLECTION_COUNT) {
            createReflections(wizard, magicalPower);
        }
        String wizardName = this.getWizard().getName();
        int wizardId = this.getWizard().getId();

        String spellResult = String.format("%s %d casts Reflection", wizardName,wizardId);

        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addSpellResult(spellResult);
    }

    private void createReflections(Wizard wizard, int magicalPower) {
        for (int i = 0; i < 2; i++) {
            Wizard newWizard = WizardFactory.createWizard(wizard.getName(), magicalPower / REFLECTION_COUNT);

            addMageToData(newWizard);
            wizard.addListener(newWizard);
        }
    }

    private void addMageToData(Wizard wizard) {
        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addWizard(wizard);
    }
}
