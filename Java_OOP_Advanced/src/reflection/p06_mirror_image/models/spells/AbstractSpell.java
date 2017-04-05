package reflection.p06_mirror_image.models.spells;

import reflection.p06_mirror_image.enums.SpellType;
import reflection.p06_mirror_image.models.interfaces.Spell;
import reflection.p06_mirror_image.models.interfaces.Wizard;

public abstract class AbstractSpell implements Spell {

    private SpellType spellType;
    private Wizard wizard;

    protected AbstractSpell(SpellType spellType, Wizard wizard) {
        this.spellType = spellType;
        this.wizard = wizard;
    }

    public Wizard getWizard() {
        return this.wizard;
    }

    @Override
    public SpellType getSpellType() {
        return this.spellType;
    }

    @Override
    public abstract void cast();

}
