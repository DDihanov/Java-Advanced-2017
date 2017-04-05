package reflection.p06_mirror_image.models.interfaces;

import reflection.p06_mirror_image.enums.SpellType;

public interface Spell {

    void   cast();

    SpellType getSpellType();

    Wizard getWizard();
}
