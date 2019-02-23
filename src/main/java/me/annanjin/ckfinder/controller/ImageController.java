package me.annanjin.ckfinder.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {

    @GetMapping(value = "/public/images/{imgName}")
    public void loadImage(@PathVariable("imgName") String imgName, HttpServletResponse response) throws IOException {
        String filePath = "C:/upload/images/" + imgName;
        File file = new File(filePath);
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        System.out.println(file.getAbsolutePath());
        if (file.isFile()){
            Files.copy(file.toPath(), response.getOutputStream());
        }
    }
}