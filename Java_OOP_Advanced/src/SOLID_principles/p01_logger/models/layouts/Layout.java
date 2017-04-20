package SOLID_principles.p01_logger.models.layouts;

import SOLID_principles.p01_logger.enums.ReportLevel;

public interface Layout {
    String format(String dateTime , String message, ReportLevel reportLevel);
}
