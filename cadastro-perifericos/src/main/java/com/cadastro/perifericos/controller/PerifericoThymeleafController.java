package com.cadastro.perifericos.controller;

import com.cadastro.perifericos.entites.Periferico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PerifericoThymeleafController {

    private final String apiUrl = "http://localhost:8080/api/perifericos/";

    @GetMapping("/perifericos")
    public String listarPerifericos(Model model) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Periferico[] perifericos = restTemplate.getForObject(apiUrl, Periferico[].class);

            List<Periferico> perifericoList = (perifericos != null) ?
                    Arrays.asList(perifericos) : new ArrayList<>();

            model.addAttribute("perifericos", perifericoList);
            return "perifericos";
        } catch (Exception e) {
            model.addAttribute("erro", "Erro ao carregar periféricos: " + e.getMessage());
            model.addAttribute("perifericos", new ArrayList<>());
            return "perifericos";
        }
    }

    @PostMapping("/perifericos/")
    public String adicionarPeriferico(@ModelAttribute Periferico periferico, Model model) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(apiUrl, periferico, Periferico.class);
            return "redirect:/perifericos/";
        } catch (Exception e) {
            model.addAttribute("erro", "Erro ao salvar periférico: " + e.getMessage());
            return "redirect:/perifericos?erro=true";
        }
    }
}