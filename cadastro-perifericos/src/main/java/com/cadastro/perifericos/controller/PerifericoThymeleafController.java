package com.cadastro.perifericos.controller;

import com.cadastro.perifericos.entites.Periferico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class PerifericoThymeleafController {

    private final String apiUrl = "http://localhost:8080/api/perifericos/";

   //metodo exibir lista de perifericos
    @GetMapping("/perifericos")
    public String listarPerifericos(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Periferico[] perifericos = restTemplate.getForObject(apiUrl, Periferico[].class);
        List<Periferico> perifericoList = Arrays.asList(perifericos);
        model.addAttribute("perifericos", perifericoList);
        return "perifericos"; // Nome do template Thymeleaf
    }
}
