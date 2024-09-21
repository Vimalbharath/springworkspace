package maven.loggersdemo;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;  
   
public class HelloWorld {  
   
  private static final Logger logger = LogManager.getLogger(HelloWorld.class);  
 public static void main(String[] args) {  
  // basic log4j configurator  
  //BasicConfigurator.configure(); 
//	 Properties props = new Properties();
//     props.load(new FileInputStream("src/log4j2.properties"));
     //PropertyConfigurator.configure("D:\\files\\log4j2.properties");
  logger.info("Hello world");  
  logger.info("we are in logger info mode");  
   
 }  
   
}  