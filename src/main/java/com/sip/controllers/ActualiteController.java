package com.sip.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sip.entities.Article;
import com.sip.entities.Provider;
import com.sip.repositories.ArticleRepository;
import com.sip.repositories.ProviderRepository;
@Controller
@RequestMapping("/actualite/")

public class ActualiteController {
	   public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";
     @Autowired
	 private final ArticleRepository articleRepository;
     private final ProviderRepository providerRepository;
     public ActualiteController(ArticleRepository articleRepository, ProviderRepository providerRepository) {
        this.articleRepository = articleRepository;
        this.providerRepository = providerRepository;
    }
    
    
    @GetMapping("list")
   // @ResponseBody
    
    public String getAll(Model model) {
    	List<Article>la = (List<Article>) articleRepository.findAll();
    	if(la.size()==0) {
    		la = null;
    	}
        model.addAttribute("article",articleRepository.findAll());
        return "list";
      }
    
    
    @GetMapping("add")
    //@ResponseBody
    public String showAddArticleForm(Article article, Model model) {
    	model.addAttribute("providers", providerRepository.findAll());
     
    	model.addAttribute("article", new Article());
        return "article/addActualite";
    }
    
    @PostMapping("add")
    public String addArticle(@Valid Article article, BindingResult result, @RequestParam(name = "providerId", required = true)
    
    
    Long p,@RequestParam("files") MultipartFile[] files) {
    	
    	Provider provider = providerRepository.findById(p)
                .orElseThrow(()-> new IllegalArgumentException("Invalid provider Id:" + p));
    	article.setProvider(provider);
	
    	//stockage du name de fichier dans la base
    	StringBuilder fileName = new StringBuilder();
    	MultipartFile file = files[0];
    	Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
    	
    	fileName.append(file.getOriginalFilename());
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		    } catch (IOException e) {
			e.printStackTrace();
		   }
		  
		 article.setPicture(fileName.toString());
		 
		 System.out.println(article);
		 
    	 articleRepository.save(article);
    	 return "redirect:list";
    	//return article.getLabel() + " " +article.getPrice() + " " + p.toString();
    }

	@GetMapping("delete/{id}")
    public String deleteProvider(@PathVariable("id") long id, Model model) {
        Article artice = articleRepository.findById(id)
        .orElseThrow(()-> new IllegalArgumentException("Invalid provider Id:" + id));
       StringBuilder fileName =new StringBuilder();
        articleRepository.delete(artice);
        model.addAttribute("articles", articleRepository.findAll());
        return "article/listActualites";
    }

}
