package reflection.p06_mirror_image.models.interfaces;

public interface Wizard extends Identifiable,Namable,Listener,Observer {

    int getMagicalPower();

    void castSpell(Spell spell);

}
