package SOLID_principles.p01_logger.models.appenders;

import SOLID_principles.p01_logger.enums.ReportLevel;
import SOLID_principles.p01_logger.models.layouts.Layout;

public class ConsoleAppender extends AppenderImpl {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, String message, ReportLevel reportLevel) {
        if(super.isLevelValid(reportLevel)){
            this.incrementMessages();
            System.out.print(super.getLayout().format(dateTime, message, reportLevel));
        }
    }
}
