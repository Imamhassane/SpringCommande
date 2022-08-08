package com.commandespringboot.controllers;

import com.commandespringboot.services.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/demo")
public class UploadController implements ServletContextAware {

    private ServletContext servletContext;


    @RequestMapping(value = "upload" , method = RequestMethod.POST)
    public ResponseEntity<Void> upload(@RequestParam("files") MultipartFile[] files){
        try{
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/produit/save" , method= RequestMethod.POST)
    public String saving(MultipartFile files){

        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyyHHmss");
            String fileName = simpleDateFormat.format(new Date() + files.getOriginalFilename());
            byte [] bytes = files.getBytes();
            Path path = Paths.get(this.servletContext.getRealPath("uploads/images/" + fileName));
            Files.write(path , bytes);
            return fileName;
        }catch (Exception e){
            return  null ;
        }
    }


    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
