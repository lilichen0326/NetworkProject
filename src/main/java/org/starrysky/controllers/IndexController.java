package org.starrysky.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String doSearch(HttpServletRequest request,
                           HttpServletResponse response, ModelMap model, @RequestParam String videoName) {
        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/files/");
        String fileName = videoName + ".mp4";
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) {
            model.addAttribute("videoPath", "./files/" + videoName + ".mp4");
        }
        else {
            model.addAttribute("errorMessage", "This video does not exist!");
        }
        return "index";
    }
}