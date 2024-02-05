package io.github.mateuussilvapb.reference.controller;

import io.github.mateuussilvapb.reference.mvp.feign.Cep;
import io.github.mateuussilvapb.reference.mvp.feign.ViaCepRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

  private final ViaCepRepository viaCepRepository;

  public CepController(ViaCepRepository viaCepRepository) {
    this.viaCepRepository = viaCepRepository;
  }

  @GetMapping
  public String get() {
    return "Hello World!";
  }

  @GetMapping("/{cep}")
  public ResponseEntity<Cep> get(@PathVariable String cep) {
    return viaCepRepository.findAddressByCep(cep)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}
