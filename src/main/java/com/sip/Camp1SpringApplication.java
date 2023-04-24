package com.sip;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.sip.controllers.ArticleController;


@SpringBootApplication
public class Camp1SpringApplication   {

	public static void main(String[] args)throws IOException  {
		SpringApplication.run(Camp1SpringApplication.class, args);
		//new File(ArticleController.uploadDirectory).mkdir();
        Path path = Paths.get(ArticleController.uploadDirectory);
        Files.createDirectory(path);
		//System.out.println("Couche data");
     System.out.println("camp devops started");
     System.out. println("instruction 1 dev");
     System.out. println("instruction  2 dev");
     System.out. println("instruction  3 dev");
     
     
 
    
      
       
       
	}

}
