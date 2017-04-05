package reflection.p06_mirror_image.factories;

import reflection.p06_mirror_image.models.WizardImpl;
import reflection.p06_mirror_image.models.interfaces.Wizard;

public class WizardFactory {

    private static int id = 0;

    public static Wizard createWizard(String name, int power) {
        return new WizardImpl(id++, name, power);
    }
}
