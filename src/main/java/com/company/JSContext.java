package com.company;

public class JSContext {

    //这个值表示JSContext在CPP中的实例指针。
    private long jv8ContextPointer;

    public native void initialize();

    public native String executeScript(String script);

    public native void close();
}
