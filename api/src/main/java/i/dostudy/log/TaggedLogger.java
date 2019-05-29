package i.dostudy.log;

/**
 * @author Abdullah Wahab
 * @email dostudy@outlook.com
 */
final class TaggedLogger implements Logger {

    private final String tag;
    private final Printer printer;

    TaggedLogger(Printer printer, String tag) {
        this.printer = printer;
        this.tag = tag;
    }

    /**
     * 格式化输出字符串，有TAG。日志级别:{@link LOG#VERBOSE}
     *
     * @param message 输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void v(String message, Object... args) {
        printer.log(LOG.VERBOSE, tag, null, printer.format(message, args));
    }

    /**
     * 格式化输出字符串，有TAG。日志级别:{@link LOG#DEBUG}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void d(String message, Object... args) {
        printer.log(LOG.DEBUG, tag, null, printer.format(message, args));
    }

    /**
     * 输出对象，支持直接输出集合，有TAG。日志级别:{@link LOG#DEBUG}
     * * 所支持输出的集合包括：{@link java.util.Map}、{@link java.util.Set}、{@link java.util.List} 和数组
     *
     * @param object 要输出的对象
     */
    @Override
    public void d(Object object) {
        printer.log(LOG.DEBUG, tag, null, printer.toString(object));
    }

    /**
     * 格式化输出字符串，有TAG。日志级别:{@link LOG#INFO}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void i(String message, Object... args) {
        printer.log(LOG.INFO, tag, null, printer.format(message, args));
    }

    /**
     * 格式化输出字符串，有TAG。日志级别:{@link LOG#WARN}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void w(String message, Object... args) {
        printer.log(LOG.WARN, tag, null, printer.format(message, args));
    }

    /**
     * 格式化输出字符串，有TAG。日志级别:{@link LOG#ERROR}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void e(String message, Object... args) {
        printer.log(LOG.ERROR, tag, null, printer.format(message, args));
    }

    /**
     * 输出{@link Throwable}详细信息和格式化的字符串，有TAG。日志级别:{@link LOG#ERROR}
     *
     * @param throwable 要输出的{@link Throwable}
     * @param message   要输出的字符串
     * @param args      字符串格式化参数
     */
    @Override
    public void e(Throwable throwable, String message, Object... args) {
        printer.log(LOG.ERROR, tag, throwable, printer.format(message, args));
    }

    /**
     * 格式化输出字符串，有TAG。日志级别:{@link LOG#ASSERT}
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    @Override
    public void wtf(String message, Object... args) {
        printer.log(LOG.ASSERT, tag, null, printer.format(message, args));
    }

    /**
     * 格式化输出JSON字符串，有TAG。日志级别:{@link LOG#DEBUG}
     *
     * @param json 要格式化输出的JSON字符串
     */
    @Override
    public void json(String json) {
        printer.log(LOG.JSON, tag, null, json);
    }

    /**
     * 格式化输出XML字符串，有TAG。日志级别:{@link LOG#DEBUG}
     *
     * @param xml 要格式化输出的XML字符串
     */
    @Override
    public void xml(String xml) {
        printer.log(LOG.XML, tag, null, xml);
    }

    /**
     * 自定义格式化输出，有TAG。日志级别:{@link LOG#DEBUG}
     *
     * @param custom 要格式化输出的XML字符串
     */
    @Override
    public void custom(String custom) {
        printer.log(LOG.CUSTOM, tag, null, custom);
    }
}
