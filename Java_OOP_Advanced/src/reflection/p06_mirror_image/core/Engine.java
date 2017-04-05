package reflection.p06_mirror_image.core;

import reflection.p06_mirror_image.core.interfaces.Executable;
import reflection.p06_mirror_image.core.interfaces.Runnable;
import reflection.p06_mirror_image.core.interfaces.WizardData;
import reflection.p06_mirror_image.factories.WizardFactory;
import reflection.p06_mirror_image.io.interfaces.Reader;
import reflection.p06_mirror_image.io.interfaces.Writer;
import reflection.p06_mirror_image.models.interfaces.Wizard;

import java.io.IOException;

public class Engine implements Runnable {

    private Reader reader;
    private Executable executable;
    private Writer writer;

    public Engine(Reader reader, Writer writer, Executable executable) {
        this.reader = reader;
        this.writer = writer;
        this.executable = executable;
    }

    @Override
    public void run() throws IOException {
        String[] input = this.reader.readLine().split("\\s+");
        this.createFirstWizard(input);

        while (true) {
            input = this.reader.readLine().split("\\s+");
            if (input[0].toLowerCase().equals("end")) {
                break;
            }
            this.executable.execute(input);
        }
        this.printResults();
    }

    private void printResults() {
        String allSpellsCasted = WizardDataImpl.getInstance().getSpellResults();
        this.writer.writeLine(allSpellsCasted);
    }

    private void createFirstWizard(String... data) {
        String name = data[0];
        int initialDamage = Integer.valueOf(data[1]);
        Wizard wizard = WizardFactory.createWizard(name, initialDamage);

        WizardData wizardData = WizardDataImpl.getInstance();
        wizardData.addWizard(wizard);
    }
}
