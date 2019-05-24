package br.com.xyinc.gps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class Boot
{
   private static final Logger logger = LogManager.getLogger(Boot.class);

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }

}
