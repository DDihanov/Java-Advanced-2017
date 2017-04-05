package reflection.p06_mirror_image.factories;

import reflection.p06_mirror_image.enums.SpellType;
import reflection.p06_mirror_image.models.interfaces.Spell;
import reflection.p06_mirror_image.models.interfaces.Wizard;
import reflection.p06_mirror_image.models.spells.Fireball;
import reflection.p06_mirror_image.models.spells.Reflection;

public class SpellFactory {

    public static Spell createSpell(SpellType spellType, Wizard wizard) {

        switch (spellType) {
            case REFLECTION:
                return new Reflection(spellType, wizard);
            case FIREBALL:
                return new Fireball(spellType, wizard);
            default:
                throw new IllegalArgumentException("No such spell");
        }
    }
}
