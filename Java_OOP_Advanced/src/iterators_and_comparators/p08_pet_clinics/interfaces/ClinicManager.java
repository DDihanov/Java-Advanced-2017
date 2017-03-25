package iterators_and_comparators.p08_pet_clinics.interfaces;

import java.util.Map;

public interface ClinicManager {
    Map<String, PetClinic> getClinics();

    void createClinic(String name, int rooms);

    void createPet(String name, int age, String kind);

    boolean addPetToClinic(String petName, String clinicName);

    boolean releasePet(String clinicName);

    boolean hasEmptyRooms(String clinicName);

    void printClinic(String clinicName);

    void printRoom(String clinicName, int index);
}
