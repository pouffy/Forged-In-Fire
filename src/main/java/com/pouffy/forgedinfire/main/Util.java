package com.pouffy.forgedinfire.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class Util {
    public static final Marker FORGEDINFIRE = MarkerManager.getMarker("FORGEDINFIRE");

    public Util() {
    }

    public static Logger getLogger(String type) {
        return LogManager.getLogger("forgedinfire-" + type);
    }
}
