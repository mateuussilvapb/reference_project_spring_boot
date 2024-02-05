package io.github.mateuussilvapb.reference.mvp.feign;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ViaCepRepositoryTest {
  @Autowired
  private ViaCepRepository cepRepository;
  @Test
  void testeCepValido() {
    Optional<Cep> addressByCep = cepRepository.findAddressByCep("58710000");
    Assertions.assertThat(addressByCep).isPresent();
    Cep cep = addressByCep.get();
    Assertions.assertThat(cep.ibge()).isEqualTo("2505501");
    Assertions.assertThat(cep.localidade() ).isEqualTo("Vista Serrana");
    Assertions.assertThat(cep.uf()).isEqualTo("PB");
    Assertions.assertThat(cep.ddd()).isEqualTo("83");
  }
}
