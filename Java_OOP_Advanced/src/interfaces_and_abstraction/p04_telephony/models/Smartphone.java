package interfaces_and_abstraction.p04_telephony.models;

import interfaces_and_abstraction.p04_telephony.interfaces.Browsable;
import interfaces_and_abstraction.p04_telephony.interfaces.Callable;

public class Smartphone implements Callable, Browsable {
    public Smartphone() {
    }

    @Override
    public String callPhone(String number) {
        char[] chars = number.toCharArray();
        for (int i = 0; i < number.length(); i++) {
            if(!Character.isDigit(chars[i])){
                throw new IllegalArgumentException("Invalid number!");
            }
        }

        return "Calling... " + number;
    }

    @Override
    public String browseSite(String site) {
        char[] chars = site.toCharArray();
        for (int i = 0; i < site.length(); i++) {
            if(Character.isDigit(chars[i])){
                throw new IllegalArgumentException("Invalid URL!");
            }
        }

        return "Browsing: " + site + "!";
    }
}
