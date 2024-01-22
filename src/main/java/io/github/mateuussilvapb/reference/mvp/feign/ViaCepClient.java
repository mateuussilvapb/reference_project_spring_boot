package io.github.mateuussilvapb.reference.mvp.feign;

import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viaCep", url = "${viaCepUrl}", path = "/ws")
public interface ViaCepClient {
  @GetMapping(value = "/{cep}/json")
  Optional<Cep> findByCep(@PathVariable String cep);
}
