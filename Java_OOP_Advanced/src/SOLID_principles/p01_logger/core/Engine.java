package SOLID_principles.p01_logger.core;

import SOLID_principles.p01_logger.core.interfaces.Controller;
import SOLID_principles.p01_logger.core.interfaces.Runnable;
import SOLID_principles.p01_logger.factories.AppenderFactory;
import SOLID_principles.p01_logger.io.interfaces.Reader;
import SOLID_principles.p01_logger.io.interfaces.Writer;
import SOLID_principles.p01_logger.models.appenders.Appender;
import SOLID_principles.p01_logger.models.loggers.Logger;
import SOLID_principles.p01_logger.models.loggers.MessageLogger;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Engine implements Runnable{
    private Reader reader;
    private Writer writer;
    private List<Appender> appenderList;
    private Controller controller;
    private AppenderFactory appenderFactory;

    public Engine(Reader reader, Writer writer, AppenderFactory appenderFactory) {
        this.reader = reader;
        this.writer = writer;
        this.appenderFactory = appenderFactory;
        this.appenderList = new ArrayList<>();
    }

    @Override
    public void run() throws IOException, InvocationTargetException, IllegalAccessException {
        String input;
        int count = Integer.parseInt(reader.readLine());
        this.initAppenders(count);
        this.injectAppenders();

        while(!"END".equals(input = reader.readLine())) {
            String[] args = input.split("\\|");
            this.controller.log(args);
        }

        this.printLogger();
    }

    private void printLogger(){
        this.writer.writeLine(this.controller.getLoggerInfo());
    }

    protected void initAppenders(int count) {
        for (int i = 0; i < count; i++) {
            try {
                this.appenderList.add(this.appenderFactory.createAppender(reader.readLine().split("\\s+")));
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void injectAppenders(){
        Logger logger = new MessageLogger(this.appenderList);
        Controller controller = new ControllerImpl(logger);
        this.controller = controller;
    }
}
