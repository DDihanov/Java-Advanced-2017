package SOLID_principles.p01_logger.models.appenders;

import SOLID_principles.p01_logger.enums.ReportLevel;
import SOLID_principles.p01_logger.models.layouts.Layout;

public interface Appender {
    void append(String dateTime, String message, ReportLevel reportLevel);

    void setReportLevel(ReportLevel error);

    ReportLevel getReportLevel();

    String getType();

    int getMessageCount();

    Layout getLayout();
}
