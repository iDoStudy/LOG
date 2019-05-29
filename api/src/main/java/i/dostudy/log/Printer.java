package i.dostudy.log;

import java.util.Arrays;

/**
 * @author Abdullah Wahab
 * @email dostudy@outlook.com
 */
public abstract class Printer implements Logger {
    /**
     * @param tag 一次性TAG，本次日志有效
     * @return Tagged Printable.not null
     */
    public Logger t(String tag) {
        return new TaggedLogger(this, tag);
    }

    /**
     * 打印机(输出)通用方法
     *
     * @param priority  日志级别
     * @param tag       tag
     * @param throwable 要输出详细信息的error对象
     * @param message   要输出的字符串
     */
    public abstract void log(int priority, String tag, Throwable throwable, String message);

    /**
     * 格式化输出字符串。日志级别:{@link LOG#VERBOSE}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void v(String message, Object... args) {
        log(LOG.VERBOSE, null, null, format(message, args));
    }

    /**
     * 格式化输出字符串。日志级别:{@link LOG#DEBUG}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void d(String message, Object... args) {
        log(LOG.DEBUG, null, null, format(message, args));
    }

    /**
     * 输出对象，支持直接输出集合。日志级别:{@link LOG#DEBUG}
     * 所支持输出的集合包括：{@link java.util.Map}、{@link java.util.Set}、{@link java.util.List} 和数组
     *
     * @param object 要输出的对象
     */
    @Override
    public void d(Object object) {
        log(LOG.DEBUG, null, null, toString(object));
    }

    /**
     * 格式化输出字符串。日志级别:{@link LOG#INFO}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void i(String message, Object... args) {
        log(LOG.INFO, null, null, format(message, args));
    }

    /**
     * 格式化输出字符串。日志级别:{@link LOG#WARN}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void w(String message, Object... args) {
        log(LOG.WARN, null, null, format(message, args));
    }

    /**
     * 格式化输出字符串。日志级别:{@link LOG#ERROR}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void e(String message, Object... args) {
        log(LOG.ERROR, null, null, format(message, args));
    }

    /**
     * 输出{@link Throwable}详细信息和格式化的字符串。日志级别:{@link LOG#ERROR}
     *
     * @param throwable 要输出的{@link Throwable}
     * @param message   要输出的字符串
     * @param args      字符串格式化参数
     */
    @Override
    public void e(Throwable throwable, String message, Object... args) {
        log(LOG.ERROR, null, throwable, format(message, args));
    }

    /**
     * 格式化输出字符串。日志级别:{@link LOG#ASSERT}
     * Tip: Use this for exceptional situations to log
     * ie: Unexpected errors etc
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void wtf(String message, Object... args) {
        log(LOG.ASSERT, null, null, format(message, args));
    }

    /**
     * 格式化输出JSON字符串。日志级别:{@link LOG#DEBUG}
     * Formats the given json content and print it
     *
     * @param json 要格式化输出的JSON字符串
     */
    @Override
    public void json(String json) {
        log(LOG.JSON, null, null, json);
    }

    /**
     * 格式化输出XML字符串。日志级别:{@link LOG#DEBUG}
     * Formats the given xml content and print it
     *
     * @param xml 要格式化输出的XML字符串
     */
    @Override
    public void xml(String xml) {
        log(LOG.XML, null, null, xml);
    }

    /**
     * 自定义格式化输出。日志级别:{@link LOG#DEBUG}
     * Formats the given string content and print it
     *
     * @param custom 要格式化输出的XML字符串
     */
    @Override
    public void custom(String custom) {
        log(LOG.CUSTOM, null, null, custom);
    }

    /**
     * object to string
     *
     * @param object
     * @return
     */
    protected String toString(Object object) {
        if (object == null) {
            return "null";
        }
        if (!object.getClass().isArray()) {
            return object.toString();
        }
        if (object instanceof boolean[]) {
            return Arrays.toString((boolean[]) object);
        }
        if (object instanceof byte[]) {
            return Arrays.toString((byte[]) object);
        }
        if (object instanceof char[]) {
            return Arrays.toString((char[]) object);
        }
        if (object instanceof short[]) {
            return Arrays.toString((short[]) object);
        }
        if (object instanceof int[]) {
            return Arrays.toString((int[]) object);
        }
        if (object instanceof long[]) {
            return Arrays.toString((long[]) object);
        }
        if (object instanceof float[]) {
            return Arrays.toString((float[]) object);
        }
        if (object instanceof double[]) {
            return Arrays.toString((double[]) object);
        }
        if (object instanceof Object[]) {
            return Arrays.deepToString((Object[]) object);
        }
        return String.valueOf(object);
    }

    /**
     * create formatted message
     *
     * @param message
     * @param args
     * @return
     */
    protected String format(String message, Object... args) {
        return args == null || args.length == 0 ? message : String.format(message, args);
    }
}
