package i.dostudy.log;

/**
 * @author Abdullah Wahab
 * @email dostudy@outlook.com
 */
public final class LOG {
    /**
     * 默认TAG
     */
    public static final String DEFAULT_TAG = "MyLOG";

    /**
     * 日志级别：2
     * 日志分为6个级别，范围[2,7]。级别越高，日志数据越重要。
     */
    public static final int VERBOSE = 2;
    /**
     * 日志级别：3
     * 日志分为6个级别，范围[2,7]。级别越高，日志数据越重要。
     */
    public static final int DEBUG = 3;
    /**
     * 日志级别：4
     * 日志分为6个级别，范围[2,7]。级别越高，日志数据越重要。
     */
    public static final int INFO = 4;
    /**
     * 日志级别：5
     * 日志分为6个级别，范围[2,7]。级别越高，日志数据越重要。
     */
    public static final int WARN = 5;
    /**
     * 日志级别：6
     * 日志分为6个级别，范围[2,7]。级别越高，日志数据越重要。
     */
    public static final int ERROR = 6;
    /**
     * 日志级别：7
     * 日志分为6个级别，范围[2,7]。级别越高，日志数据越重要。
     */
    public static final int ASSERT = 7;

    /**
     * 标记日志为JSON数据
     * 日志级别：{@link LOG#DEBUG}
     */
    public static final int JSON = 8;
    /**
     * 标记日志为XML数据
     * 日志级别：{@link LOG#DEBUG}
     */
    public static final int XML = 9;
    /**
     * 标记日志为自定义格式化数据
     * 日志级别：{@link LOG#DEBUG}
     */
    public static final int CUSTOM = 10;

    private static final Printer EMPTY_PRINTER = new Printer() {
        @Override
        public void log(int priority, String tag, Throwable throwable, String message, Object... args) {

        }
    };

    private static Printer printer = EMPTY_PRINTER;

    private LOG() {
        throw new UnsupportedOperationException();//no instance.
    }

    /**
     * 设置{@link Printer},初始化{@link LOG}
     *
     * @param printer
     */
    public static void printer(Printer printer) {
        LOG.printer = printer == null ? EMPTY_PRINTER : printer;
    }

    /**
     * 返回Printer的class
     * @return
     */
    public static Class<? extends Printer> getPrinterClass() {
        return LOG.printer.getClass();
    }

    /**
     * 获取有TAG的可输出对象
     *
     * @param tag 本次日志输出有效
     * @return Printable
     */
    public static Logger t(String tag) {
        return printer.t(tag);
    }

    /**
     * 通用方法,接受所有参数
     * General log function that accepts all configurations as parameter
     *
     * @param priority  日志级别
     * @param tag
     * @param message
     * @param throwable
     * @param args      字符串格式化参数
     */
    public static void log(int priority, String tag, Throwable throwable, String message, Object... args) {
        printer.log(priority, tag, throwable, message, args);
    }

    /**
     * 日志级别：{@link LOG#VERBOSE}
     *
     * @param message
     * @param args
     */
    public static void v(String message, Object... args) {
        printer.v(message, args);
    }

    /**
     * 日志级别：{@link LOG#DEBUG}
     *
     * @param message
     * @param args
     */
    public static void d(String message, Object... args) {
        printer.d(message, args);
    }

    /**
     * 日志级别：{@link LOG#DEBUG}
     *
     * @param object
     */
    public static void d(Object object) {
        printer.d(object);
    }

    /**
     * 日志级别：{@link LOG#INFO}
     *
     * @param message
     * @param args
     */
    public static void i(String message, Object... args) {
        printer.i(message, args);
    }

    /**
     * 日志级别：{@link LOG#WARN}
     *
     * @param message
     * @param args
     */
    public static void w(String message, Object... args) {
        printer.w(message, args);
    }

    /**
     * 日志级别：{@link LOG#ERROR}
     *
     * @param message
     * @param args
     */
    public static void e(String message, Object... args) {
        printer.e(null, message, args);
    }

    /**
     * 日志级别：{@link LOG#ERROR}
     *
     * @param throwable
     * @param message
     * @param args
     */
    public static void e(Throwable throwable, String message, Object... args) {
        printer.e(throwable, message, args);
    }

    /**
     * 格式化输出字符串，日志级别：{@link LOG#ASSERT}
     * Tip: Use this for exceptional situations to log
     * ie: Unexpected errors etc
     *
     * @param message 要输出的字符串
     * @param args    字符串格式化参数
     */
    public static void wtf(String message, Object... args) {
        printer.wtf(message, args);
    }

    /**
     * 格式化json并输出。日志级别：{@link LOG#DEBUG}
     * Formats the given json content and print it
     *
     * @param json 要格式化输出的JSON字符串
     */
    public static void json(String json) {
        printer.json(json);
    }

    /**
     * 格式化xml并输出。日志级别：{@link LOG#DEBUG}
     * Formats the given xml content and print it
     *
     * @param xml 要格式化输出的XML字符串
     */
    public static void xml(String xml) {
        printer.xml(xml);
    }

    /**
     * 格式化并输出。日志级别：{@link LOG#DEBUG}
     * Formats the given string content and print it
     *
     * @param custom 要格式化输出的XML字符串
     */
    public static void custom(String custom) {
        printer.custom(custom);
    }
}
