package com.devkito.log4a;

import android.util.Log;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kito on 23/6/16.
 */
public class Sys {

    public enum LEVEL {
        None,
        Error
    }

    private static LEVEL _lv = LEVEL.Error;
    private final static int STACK_IDX = 4;

    public final static void mode(LEVEL lv) {
        Sys._lv = lv;
    }

    public final static void log(String msg) {
        switch (Sys._lv) {
            case Error:
                Log.e(Sys.tag(), msg);
                break;

            default:
                break;
        }
    }

    private final static String tag() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        String tag = stack[Sys.STACK_IDX].toString();
        String[] split = tag.split("\\.");
        return "[" + split[split.length - 3] + "." + split[split.length - 2] + "." + split[split.length - 1] + "]";
    }
}
