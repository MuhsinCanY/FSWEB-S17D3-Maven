package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    Map<Integer, Kangaroo> koalas = new HashMap<>();

    @GetMapping("")
    public List<Kangaroo> getAll() {
        return new ArrayList<>(koalas.values());
    }

    @GetMapping("/{id}")
    public Kangaroo getOne(@PathVariable int id) {
        return koalas.get(id);
    }

    @PostMapping("")
    public Kangaroo save(@RequestBody Kangaroo kangaroo) {
        koalas.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable int id, @RequestBody Kangaroo kangaroo) {
        koalas.replace(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable int id) {
        Kangaroo kangaroo = koalas.get(id);
        koalas.remove(id, kangaroo);
        return kangaroo;
    }
}
