package iterators_and_comparators.p08_pet_clinics.models;

import iterators_and_comparators.p08_pet_clinics.interfaces.ClinicManager;
import iterators_and_comparators.p08_pet_clinics.interfaces.Pet;
import iterators_and_comparators.p08_pet_clinics.interfaces.PetClinic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ClinicManagerImpl implements ClinicManager {
    private Map<String, PetClinic> clinics;
    private Map<String, Pet> pets;

    public ClinicManagerImpl() {
        this.clinics = new HashMap<>();
        this.pets = new HashMap<>();
    }

    @Override
    public Map<String, PetClinic> getClinics() {
        return Collections.unmodifiableMap(clinics);
    }

    @Override
    public void createClinic(String name, int rooms) {
        this.clinics.put(name, new PetClinicImpl(name, rooms));
    }

    @Override
    public void createPet(String name, int age, String kind) {
        this.pets.put(name, new PetImpl(age, name, kind));
    }

    @Override
    public boolean addPetToClinic(String petName, String clinicName) {
        Pet pet = this.pets.get(petName);
        this.pets.remove(petName);
        return this.clinics.get(clinicName).addPet(pet);
    }

    @Override
    public boolean releasePet(String clinicName) {
        return this.clinics.get(clinicName).releasePet();
    }

    @Override
    public boolean hasEmptyRooms(String clinicName) {
        return this.clinics.get(clinicName).hasEmptyRooms();
    }

    @Override
    public void printClinic(String clinicName) {
        this.clinics.get(clinicName).getRoomsInfo();
    }

    @Override
    public void printRoom(String clinicName, int index) {
        this.clinics.get(clinicName).getSingleRoomInfo(index);
    }
}
