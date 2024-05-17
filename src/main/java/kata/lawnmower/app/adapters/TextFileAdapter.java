package kata.lawnmower.app.adapters;

import java.io.InputStream;

public interface TextFileAdapter {
    String moveMowers(InputStream input) throws Exception;
}
