package fr.eulbobo.template;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IOUtils {

    /** logger for class */
    private static final Logger LOGGER = LoggerFactory.getLogger(IOUtils.class);

    /**
     * Fail safe closable
     *
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException ioe) {
            LOGGER.warn("Exception while closing quietly", ioe);
        }
    }

    /**
     * Fail safe scanner close
     * @param scanner
     */
    public static void closeQuietly(final Scanner scanner) {
        if (scanner != null) {
            scanner.close();
        }
    }
}
