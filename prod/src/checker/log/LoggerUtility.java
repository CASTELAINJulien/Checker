package checker.log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Utility class used to generate Log4j logger.
 */
public class LoggerUtility {

	private static final String HTML_LOG_CONFIG = "src/checker/log/log4j-html.properties";

	public static Logger getLogger(Class<?> logClass) {
		PropertyConfigurator.configure(HTML_LOG_CONFIG);
		String className = logClass.getName();
		return Logger.getLogger(className);
	}
}