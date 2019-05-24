package i.dostudy.log;

/**
 * @author Abdullah Wahab
 * @email dostudy@outlook.com
 */
public interface Logger {
    /**
     * 格式化输出字符串。日志级别:{@link LOG#VERBOSE}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    void v(String message, Object... args);

    /**
     * 格式化输出字符串。日志级别:{@link LOG#DEBUG}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    void d(String message, Object... args);

    /**
     * 输出对象，支持直接输出集合。日志级别:{@link LOG#DEBUG}
     * 所支持输出的集合包括：{@link java.util.Map}、{@link java.util.Set}、{@link java.util.List} 和数组
     *
     * @param object 要输出的对象
     */
    void d(Object object);

    /**
     * 格式化输出字符串。日志级别:{@link LOG#INFO}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    void i(String message, Object... args);

    /**
     * 格式化输出字符串。日志级别:{@link LOG#WARN}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    void w(String message, Object... args);

    /**
     * 格式化输出字符串。日志级别:{@link LOG#ERROR}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    void e(String message, Object... args);

    /**
     * 输出{@link Throwable}详细信息和格式化的字符串。日志级别:{@link LOG#ERROR}
     *
     * @param throwable 要输出的{@link Throwable}
     * @param message   要输出的字符串
     * @param args      字符串格式化参数
     */
    void e(Throwable throwable, String message, Object... args);

    /**
     * 格式化输出字符串。日志级别:{@link LOG#ASSERT}
     * Tip: Use this for exceptional situations to log
     * ie: Unexpected errors etc
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    void wtf(String message, Object... args);

    /**
     * 格式化输出JSON字符串。日志级别:{@link LOG#DEBUG}
     * Formats the given json content and print it
     *
     * @param json 要格式化输出的JSON字符串
     */
    void json(String json);

    /**
     * 格式化输出XML字符串。日志级别:{@link LOG#DEBUG}
     * Formats the given xml content and print it
     *
     * @param xml 要格式化输出的XML字符串
     */
    void xml(String xml);

    /**
     * 自定义格式化输出。日志级别:{@link LOG#DEBUG}
     * Formats the given string content and print it
     *
     * @param custom 要格式化输出的XML字符串
     */
    void custom(String custom);
}
