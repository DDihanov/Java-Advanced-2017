package SOLID_principles.p01_logger.factories;

import SOLID_principles.p01_logger.enums.ReportLevel;
import SOLID_principles.p01_logger.models.appenders.Appender;
import SOLID_principles.p01_logger.models.appenders.FileAppender;
import SOLID_principles.p01_logger.models.file.File;
import SOLID_principles.p01_logger.models.file.LogFile;
import SOLID_principles.p01_logger.models.layouts.Layout;

public class AppenderFactoryImpl implements AppenderFactory {
    private static final String APPENDERS_PATH = "SOLID_principles.p01_logger.models.appenders.";
    private static final String LAYOUTS_PATH = "SOLID_principles.p01_logger.models.layouts.";

    @Override
    @SuppressWarnings("unchecked")
    public Appender createAppender(String... args) throws ReflectiveOperationException{
        String appenderName = args[0];
        String layoutName = args[1];
        Class<Appender> appenderClass = (Class<Appender>) Class.forName(APPENDERS_PATH + appenderName);
        Class<Layout> layoutClass = (Class<Layout>) Class.forName(LAYOUTS_PATH + layoutName);
        Layout layout = layoutClass.getDeclaredConstructor().newInstance();
        Appender appender = appenderClass.getDeclaredConstructor(Layout.class).newInstance(layout);
        if(appender instanceof FileAppender){
            File file = new LogFile();
            ((FileAppender) appender).setFile(file);
        }
        if (args.length > 2) {
            ReportLevel reportLevel = ReportLevel.valueOf(args[2]);
            appender.setReportLevel(reportLevel);
        }
        return appender;
    }
}
