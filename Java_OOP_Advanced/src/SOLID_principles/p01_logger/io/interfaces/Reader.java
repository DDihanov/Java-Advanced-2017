package SOLID_principles.p01_logger.io.interfaces;

import java.io.IOException;

public interface Reader {
    String readLine() throws IOException;
}
