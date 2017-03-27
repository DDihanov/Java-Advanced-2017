package iterators_and_comparators.p08_pet_clinics.models;

import iterators_and_comparators.p08_pet_clinics.interfaces.Pet;
import iterators_and_comparators.p08_pet_clinics.interfaces.PetClinic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PetClinicImpl implements PetClinic {
    private int startingRoom;
    private Map<Integer, Pet> rooms;
    private String name;

    public PetClinicImpl(String name, int count) {
        this.setName(name);
        this.setRooms(count);
        for (int i = 0; i < count; i++) {
            this.rooms.put(i, null);
        }
        this.startingRoom = (this.rooms.size() - 1) / 2;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void setRooms(int count) {
        if (count % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = new HashMap<>();
    }

    @Override
    public Map<Integer, Pet> getRooms() {
        return Collections.unmodifiableMap(this.rooms);
    }

    @Override
    public boolean addPet(Pet pet) {
        boolean canGoRight = false;
        boolean canGoLeft = true;
        int leftIndex = this.startingRoom;
        int rightIndex = this.startingRoom;

        if(!this.hasEmptyRooms()){
            return false;
        }
        while(rightIndex < this.rooms.size() || leftIndex > 0){
            if(canGoLeft){
                if(this.rooms.get(leftIndex) == null){
                    this.rooms.put(leftIndex, pet);
                    return true;
                }
                leftIndex--;
                canGoLeft = false;
                canGoRight = true;
            }
            if(canGoRight){
                if(this.rooms.get(rightIndex) == null){
                    this.rooms.put(rightIndex, pet);
                    return true;
                }
                rightIndex++;
                canGoRight = false;
                canGoLeft = true;
            }
        }

        return false;
    }


    @Override
    public boolean releasePet() {
        for (int i = this.startingRoom; i < this.rooms.size(); i++) {
            if (!(this.rooms.get(i) == null)) {
                this.rooms.put(i, null);
                return true;
            }
        }

        for (int i = 0; i < this.startingRoom; i++) {
            if (!(this.rooms.get(i) == null)) {
                this.rooms.put(i, null);
                return true;
            }
        }

        return false;
    }

    @Override
    public void getRoomsInfo() {
        this.rooms.values().forEach(pet -> {
            if (pet != null) {
                System.out.println(pet);
            } else {
                System.out.println("Room empty");
            }
        });
    }

    @Override
    public boolean hasEmptyRooms() {
        return this.rooms.containsValue(null);
    }

    @Override
    public void getSingleRoomInfo(int index) {
        if(this.rooms.get(index) == null){
            System.out.println("Room empty");
            return;
        }
        System.out.println(this.rooms.get(index).toString());
    }


}
