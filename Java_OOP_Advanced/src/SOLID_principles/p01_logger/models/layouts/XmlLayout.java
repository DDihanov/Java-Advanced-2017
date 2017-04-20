package SOLID_principles.p01_logger.models.layouts;

import SOLID_principles.p01_logger.enums.ReportLevel;

public class XmlLayout implements Layout{
    public XmlLayout() {
    }

    @Override
    public String format(String dateTime, String message, ReportLevel reportLevel) {
        return String.format("<log>\n" +
                        "<date>%s</date>\n" +
                        "   <level>%s</level>\n" +
                        "   <message>%s</message>\n" +
                        "</log>\n",
                dateTime,
                reportLevel,
                message);
    }
}
