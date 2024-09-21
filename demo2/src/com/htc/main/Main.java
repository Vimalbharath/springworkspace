package com.htc.main;  
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htc.beans.Company;
import com.htc.beans.Job;
import com.htc.config.BeanConfig;
 
  
public class Main {  
    public static void main(String[] args) {  
    	ApplicationContext context=new AnnotationConfigApplicationContext(BeanConfig.class);
          
    
//    	ApplicationContext context =   
//    		    new ClassPathXmlApplicationContext("beans.xml");  
    	Job e=(Job)context.getBean("job");  
        e.display(); 
        Job j=(Job)context.getBean("job2");  
        j.display(); 
    	
 
          
        
    }  
}