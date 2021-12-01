package br.com.unifip.aplicationspringboot.services;

import java.util.List;

import br.com.unifip.aplicationspringboot.models.Aluno;

public interface ICadastroService {

  void save(Aluno conta);

  List<Aluno> pesquisaPorNome(String nome);

  List<Aluno> listarTodos();

  void deletar(Long id);

  void atualizarDados(Aluno aluno, Long id);

  List<Aluno> pesquisaPorNota();

}
