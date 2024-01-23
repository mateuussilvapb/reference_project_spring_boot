package io.github.mateuussilvapb.reference.mvp.feign;


import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ViaCepRepository {
  private final ViaCepClient viaCepClient;

  public ViaCepRepository(ViaCepClient viaCepClient) {
    this.viaCepClient = viaCepClient;
  }

  public Optional<Cep> findAddressByCep(String cep) {
    return viaCepClient.findByCep(cep);
  }
}
