package constants;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GlobalConstants {
    public static final String PROJECT_PATH = System.getProperty("user.dir");

    public static final String SLASH = File.separator;
    public static final long LONG_TIMEOUT = 30L;
    public static final long SHORT_TIMEOUT = 15;
    public static final String TAKE_VIDEO_PATH = PROJECT_PATH + SLASH + "src" + SLASH + "test" + SLASH + "java" + SLASH + "videos" + SLASH;
    public static final String TAKE_SCREENSHOTS_PATH = PROJECT_PATH + SLASH + "src" + SLASH + "test" + SLASH + "java" + SLASH + "screenshots" + SLASH;
    public static final String CURRENT_DATE_TIME = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss").format(Calendar.getInstance().getTime());




}
