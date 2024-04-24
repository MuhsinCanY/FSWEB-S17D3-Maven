package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    Map<Integer, Kangaroo> kangaroos = new HashMap<>();

    @GetMapping("")
    public List<Kangaroo> getAll() {
        return new ArrayList<>(kangaroos.values());
    }

    @GetMapping("/{id}")
    public Kangaroo getOne(@PathVariable int id) {
        if (!kangaroos.containsKey(id)){
            throw new ZooException("Id not found", HttpStatus.NOT_FOUND);
        }
        return kangaroos.get(id);
    }

    @PostMapping("")
    public Kangaroo save(@RequestBody Kangaroo kangaroo) {

        if (kangaroo.getId() <= 0 || kangaroo.getName() == null || kangaroo.getName().isEmpty()) {
            throw new IllegalArgumentException();
        }

        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable int id, @RequestBody Kangaroo kangaroo) {
        kangaroos.replace(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable int id) {
        Kangaroo kangaroo = kangaroos.get(id);
        kangaroos.remove(id, kangaroo);
        return kangaroo;
    }

}
