package iterators_and_comparators.p08_pet_clinics.interfaces;

import java.util.Map;

public interface PetClinic {
    Map<Integer, Pet> getRooms();
    boolean addPet(Pet pet);
    boolean releasePet();
    boolean hasEmptyRooms();
    void getRoomsInfo();
    void getSingleRoomInfo(int index);
}
