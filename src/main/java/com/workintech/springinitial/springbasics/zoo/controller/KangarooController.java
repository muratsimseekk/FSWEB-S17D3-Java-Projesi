package com.workintech.springinitial.springbasics.zoo.controller;

import com.workintech.springinitial.springbasics.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class KangarooController {
    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init(){
        kangaroos=new HashMap<>();
    }
    @GetMapping("/kangaroos")
    public List<Kangaroo> getKangaroos(){
        return kangaroos.values().stream().toList();
    }
    @GetMapping("/kangaroos/{id}")
    public Kangaroo getKangarooByID(@PathVariable Integer id){
        return kangaroos.get(id);
    }

    @PostMapping("/kangaroos")
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo){
        kangaroos.put(kangaroo.getId(),kangaroo);
        return kangaroo;
    }
    @PutMapping("/kangaroos/{id}")
    public Kangaroo updateKangaroo(@RequestBody Kangaroo kangaroo,@PathVariable Integer id){
        Kangaroo matchedKangaroo = kangaroos.get(id);
         kangaroos.put(kangaroo.getId(),kangaroo);
         return kangaroos.get(id);
    }

    @DeleteMapping("/kangaroos/{id}")
    public void deleteKangaroo(@PathVariable Integer id){
         kangaroos.remove(id);

    }
}
