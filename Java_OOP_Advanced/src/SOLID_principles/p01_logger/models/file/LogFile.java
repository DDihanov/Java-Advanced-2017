package SOLID_principles.p01_logger.models.file;

public class LogFile implements File {
    StringBuilder data;
    int size;

    public LogFile() {
        this.data = new StringBuilder();
        this.size = 0;
    }

    @Override
    public void write(String message) {
        this.data.append(message);
        this.size = this.data.toString().replaceAll("[^a-zA-Z]", "").chars().sum();
    }

    @Override
    public int getSize() {
        return this.size;
    }
}

