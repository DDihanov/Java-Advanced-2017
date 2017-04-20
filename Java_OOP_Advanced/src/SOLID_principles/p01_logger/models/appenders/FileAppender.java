package SOLID_principles.p01_logger.models.appenders;

import SOLID_principles.p01_logger.enums.ReportLevel;
import SOLID_principles.p01_logger.models.file.File;
import SOLID_principles.p01_logger.models.layouts.Layout;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String dateTime, String message, ReportLevel reportLevel) {
        if(super.isLevelValid(reportLevel)) {
            this.incrementMessages();
            this.file.write(super.getLayout().format(dateTime, message, reportLevel));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(", File size: ").append(this.file.getSize());

        return sb.toString();
    }
}
