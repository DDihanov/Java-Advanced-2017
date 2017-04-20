package SOLID_principles.p01_logger.models.layouts;

import SOLID_principles.p01_logger.enums.ReportLevel;

public class SimpleLayout implements Layout {
    @Override
    public String format(String dateTime, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s\n",
                dateTime,
                reportLevel,
                message);
    }
}
