package com.company;

import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicBoolean;

public class V8 {

    static {
        String property = System.getProperty("java.library.path");
        StringTokenizer parser = new StringTokenizer(property, ";");
        while (parser.hasMoreTokens()) {
            System.err.println(parser.nextToken());
        }
        String libv8HelloWorld = System.mapLibraryName("v8HelloWorld");
        System.err.println(libv8HelloWorld);

        System.loadLibrary("v8HelloWorld"); // Load native library at runtime
    }

    private static AtomicBoolean isInitialized = new AtomicBoolean(false);

    public static synchronized void initialize(String path) {
        if (!isInitialized.get()) {
            initialize0(path);
            isInitialized.set(true);
        }
    }

    private static native void initialize0(String path);
}
