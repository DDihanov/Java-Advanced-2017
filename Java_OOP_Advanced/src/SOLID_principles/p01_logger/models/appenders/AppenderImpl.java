package SOLID_principles.p01_logger.models.appenders;

import SOLID_principles.p01_logger.enums.ReportLevel;
import SOLID_principles.p01_logger.models.layouts.Layout;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private String type;
    private int messageCount;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.type = this.getClass().getSimpleName();
        this.messageCount = 0;
        this.setReportLevel(ReportLevel.INFO);
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public Layout getLayout(){
        return this.layout;
    }

    protected void incrementMessages(){
        this.messageCount++;
    }

    protected boolean isLevelValid(ReportLevel reportLevel){
        return reportLevel.compareTo(this.reportLevel) >= 0;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getMessageCount() {
        return this.messageCount;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %s",
                this.getType(),
                this.getLayout().getClass().getSimpleName(),
                this.getReportLevel().name(),
                this.getMessageCount());
    }
}
