package com.devkito.log4a;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kito on 23/6/16.
 */
public class Sys {

    public enum LEVEL {
        None,
        Verbose,
        Debug,
        Info,
        Warn,
        Error
    }

    public enum MODE {
        Simple,
        Detail
    }

    private static LEVEL _lv = LEVEL.Error;
    private static MODE _mode = MODE.Simple;
    private final static StringWriter _sw = new StringWriter();
    private final static PrintWriter _pw = new PrintWriter(_sw);
    private final static int STACK_IDX = 4;

    public final static void mode(LEVEL lv) {
        Sys._lv = lv;
    }

    public final static void mode(LEVEL lv, MODE mode) {
        Sys._lv = lv;
        Sys._mode = mode;
    }

    public final static int log(Object obj) {
        String msg;

        if (obj instanceof JSONObject) {
            try {
                msg = ((JSONObject) obj).toString(2);
            } catch (JSONException e) {
                msg = obj.toString();
            }
        } else if (obj instanceof JSONArray) {
            try {
                msg = ((JSONArray) obj).toString(2);
            } catch (JSONException e) {
                msg = obj.toString();
            }
        } else if (obj instanceof Exception) {
            ((Exception) obj).printStackTrace(_pw);
            msg = _sw.toString();
        } else {
            msg = obj.toString();
        }

        switch (Sys._lv) {
            case Verbose:
                return Log.v(Sys.tag(), msg);

            case Debug:
                return Log.d(Sys.tag(), msg);

            case Info:
                return Log.i(Sys.tag(), msg);

            case Warn:
                return Log.w(Sys.tag(), msg);

            case Error:
                return Log.e(Sys.tag(), msg);

            default:
                return 0;
        }
    }

    private final static String tag() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        String tag = stack[Sys.STACK_IDX].toString();
        if (Sys._mode == MODE.Detail) {
            String[] split = tag.split("\\.");
            return "[" + split[split.length - 3] + "." + split[split.length - 2] + "." + split[split.length - 1] + "]";
        } else {
            tag = tag.substring(tag.indexOf("("), tag.lastIndexOf(")") + 1);
            return "[" + tag + "]";
        }
    }

    public final static int logV(String msg) {
        if (Sys._lv != LEVEL.None) {
            return Log.v(Sys.tag(), msg);
        } else {
            return 0;
        }
    }

    public final static int logV(String msg, Throwable tr) {
        if (Sys._lv != LEVEL.None) {
            return Log.v(Sys.tag(), msg, tr);
        } else {
            return 0;
        }
    }

    public final static int logD(String msg) {
        if (Sys._lv != LEVEL.None) {
            return Log.d(Sys.tag(), msg);
        } else {
            return 0;
        }
    }

    public final static int logD(String msg, Throwable tr) {
        if (Sys._lv != LEVEL.None) {
            return Log.d(Sys.tag(), msg, tr);
        } else {
            return 0;
        }
    }

    public final static int logI(String msg) {
        if (Sys._lv != LEVEL.None) {
            return Log.i(Sys.tag(), msg);
        } else {
            return 0;
        }
    }

    public final static int logI(String msg, Throwable tr) {
        if (Sys._lv != LEVEL.None) {
            return Log.i(Sys.tag(), msg, tr);
        } else {
            return 0;
        }
    }

    public final static int logW(String msg) {
        if (Sys._lv != LEVEL.None) {
            return Log.w(Sys.tag(), msg);
        } else {
            return 0;
        }
    }

    public final static int logW(String msg, Throwable tr) {
        if (Sys._lv != LEVEL.None) {
            return Log.w(Sys.tag(), msg, tr);
        } else {
            return 0;
        }
    }

    public final static int logE(String msg) {
        if (Sys._lv != LEVEL.None) {
            return Log.e(Sys.tag(), msg);
        } else {
            return 0;
        }
    }

    public final static int logE(String msg, Throwable tr) {
        if (Sys._lv != LEVEL.None) {
            return Log.e(Sys.tag(), msg, tr);
        } else {
            return 0;
        }
    }
}
