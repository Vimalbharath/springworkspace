package maven.loggersdemo;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final Logger Logger=LogManager.getLogger(App.class);
    	//PropertyConfigurator.configure("D:\\files\\log4j2.properties");
    	Logger.info("HI");
        System.out.println( "Hello World!" );
    }
    
}
