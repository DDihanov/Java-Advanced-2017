package iterators_and_comparators.p08_pet_clinics.models;

import iterators_and_comparators.p08_pet_clinics.interfaces.ClinicManager;

public class CommandInterpreter {
    private ClinicManager clinicManager;

    public CommandInterpreter() {
        this.clinicManager = new ClinicManagerImpl();
    }

    public void execCommands(String... args) {
        switch (args[0]) {
            case "Create":
                if (args[1].equals("Pet")) {
                    this.clinicManager.createPet(args[2], Integer.parseInt(args[3]), args[4]);
                    return;
                }
                try {
                    this.clinicManager.createClinic(args[2], Integer.parseInt(args[3]));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "Add":
                System.out.println(this.clinicManager.addPetToClinic(args[1], args[2]));
                break;
            case "Release":
                System.out.println(this.clinicManager.releasePet(args[1]));
                break;
            case "HasEmptyRooms":
                System.out.println(this.clinicManager.hasEmptyRooms(args[1]));
                break;
            case "Print":
                if (args.length == 3) {
                    this.clinicManager.printRoom(args[1], Integer.parseInt(args[2]) - 1);
                    return;
                }
                this.clinicManager.printClinic(args[1]);
                break;
        }
    }
}
