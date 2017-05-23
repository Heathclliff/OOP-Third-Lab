package Serialize;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Валерий on 16.05.2017.
 */
public interface SerializePlugin {
    InputStream getInputStream(InputStream stream);
    OutputStream getOutputStream(OutputStream stream);
}
