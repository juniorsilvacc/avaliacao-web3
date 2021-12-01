package br.com.unifip.aplicationspringboot.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.unifip.aplicationspringboot.models.Aluno;

public interface CadastroRepository extends CrudRepository<Aluno, Long> {

  List<Aluno> findByNomeStartingWith(String nome);

  List<Aluno> findAll();

  void deleteById(Long id);

  List<Aluno> findByNotaGreaterThan(Double nota);

}
