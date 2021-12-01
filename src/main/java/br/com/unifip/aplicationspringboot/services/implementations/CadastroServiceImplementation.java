package br.com.unifip.aplicationspringboot.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifip.aplicationspringboot.models.Aluno;
import br.com.unifip.aplicationspringboot.repositories.CadastroRepository;
import br.com.unifip.aplicationspringboot.services.ICadastroService;

@Service
public class CadastroServiceImplementation implements ICadastroService {

  @Autowired
  private CadastroRepository repository;

  public void save(Aluno conta) {
    repository.save(conta);
  }

  public List<Aluno> pesquisaPorNome(String nome) {
    return repository.findByNomeStartingWith(nome);
  }

  public List<Aluno> listarTodos() {
    return repository.findAll();
  }

  public void deletar(Long id) {
    repository.deleteById(id);
  }

  public void atualizarDados(Aluno aluno, Long id) {
    Optional<Aluno> alunoSalvo = repository.findById(id);
    if (alunoSalvo.isPresent()) {
      aluno.setId(id);
      repository.save(aluno);
    } else {
      throw new IllegalArgumentException("Id não encontrado");
    }
  }

  public List<Aluno> pesquisaPorNota() {
    return repository.findByNotaGreaterThan(Double.valueOf(7));
  }

}
