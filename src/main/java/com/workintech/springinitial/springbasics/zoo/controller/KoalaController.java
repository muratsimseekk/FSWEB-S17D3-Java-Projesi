package com.workintech.springinitial.springbasics.zoo.controller;

import com.workintech.springinitial.springbasics.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("workintech")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init(){
        koalas=new HashMap<>();
    }
    @GetMapping("/koalas")
    public List<Koala> getKoalas(){
        return koalas.values().stream().toList();
    }
    @GetMapping("/koalas/{id}")
    public Koala getKoalaByID(@PathVariable Integer id){
        return koalas.get(id);
    }
    @PostMapping("/koalas")
    public Koala addKoala(@RequestBody Koala koala){
        koalas.put(koala.getId(), koala);
        return koala;
    }
    @PutMapping("/koalas/{id}")
    public Koala updateKoalaByID(@PathVariable Integer id , @RequestBody Koala koala){
        koalas.put(id,koala);
        return koalas.get(id);
    }

    @DeleteMapping("/koalas/{id}")
    public void deleteKoala(@PathVariable Integer id){
        koalas.remove(id);
    }
}
