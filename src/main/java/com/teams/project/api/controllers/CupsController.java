package com.teams.project.api.controllers;

import com.teams.project.business.CupService;
import com.teams.project.entities.Cup;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cups")
@AllArgsConstructor
public class CupsController {

    private final CupService cupService;
    @PostMapping("/add")
    public void add(@RequestBody Cup cup) {
        cupService.add(cup);
    }

    @GetMapping("/getAll")
    public List<Cup> getAll() {
        return cupService.getAll();
    }


}
