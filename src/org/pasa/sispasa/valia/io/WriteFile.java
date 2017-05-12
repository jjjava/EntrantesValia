package org.pasa.sispasa.valia.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import org.apache.log4j.Logger;
import org.pasa.sispasa.valia.util.EntrantesValiaCommon;

/**
 *
 * @author Hudson Schumaker
 * @version 1.0.0
 */
public class WriteFile {

    private static final Logger LOGGER = Logger.getLogger(WriteFile.class);

    public WriteFile() {
    }

    public static void createFile(String content) {
        createFile(EntrantesValiaCommon.P_PATH_OUT, content);
    }

    public static void createFile(String path, String content) {
        createFile(new File(path), content);
    }

    public static void createFile(File f, String content) {
        try {
            f.createNewFile();
            FileWriter fileWriter = new FileWriter(f);
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(content);
            buffer.flush();
            buffer.close();
        } catch (IOException ex) {
            System.err.println(ex);
            LOGGER.error(ex);
        }
    }
}
