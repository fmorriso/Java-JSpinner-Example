import java.text.SimpleDateFormat;
import java.util.logging.LogRecord;
import java.util.Date;
import java.util.logging.Formatter;

public class CustomLoggingFormatter extends Formatter {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        String dateTime = dateFormat.format(new Date(record.getMillis()));
        return String.format("[%s] [%s] %s%n", dateTime, record.getLevel(), record.getMessage());
    }
}
