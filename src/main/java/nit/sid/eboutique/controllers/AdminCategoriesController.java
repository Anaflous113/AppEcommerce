package nit.sid.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import nit.sid.eboutique.entities.Categorie;
import nit.sid.eboutique.metier.IAdminCategoriesMetier;

@Controller
@RequestMapping(value="/adminCat")
public class AdminCategoriesController {
 @Autowired	
 private  IAdminCategoriesMetier metier;
 
 @RequestMapping(value="/index")
 public String index(Model model) {
	 model.addAttribute("categorie",new Categorie());
	 model.addAttribute("categories", metier.listCategories());
	 return "categories";
	}
 
 @RequestMapping(value="/SaveCat")
 public String saveCat(@Valid Categorie c,BindingResult bindingResult,Model model,MultipartFile file) throws IOException{
 	if(bindingResult.hasErrors()){
 		model.addAttribute("categories", metier.listCategories());
 	    return("categories");
 	}
 	if(!file.isEmpty()){
 		BufferedImage bi = ImageIO.read(file.getInputStream()); 
 		c.setPhoto(file.getBytes());
 		c.setNomPhoto(file.getOriginalFilename());
 	}
 	metier.ajouterCategorie(c);
 	model.addAttribute("categorie", new Categorie()); 
 	model.addAttribute("categories", metier.listCategories());
 	return "categories";
}}
