package br.com.unifip.aplicationspringboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.unifip.aplicationspringboot.models.Aluno;
import br.com.unifip.aplicationspringboot.services.ICadastroService;

@RestController
@RequestMapping(path = "/aluno")
public class CadastroController {

  @Autowired
  private ICadastroService service;

  // Criar
  @RequestMapping(path = "/criar", method = RequestMethod.POST)
  public void save(@RequestBody Aluno conta) {
    service.save(conta);
  }

  // Listar Todos
  @RequestMapping(path = "/listartodos", method = RequestMethod.GET)
  public List<Aluno> listarTodos() {
    return service.listarTodos();
  }

  // Atualizar
  @RequestMapping(path = "/atualizar/{id}", method = RequestMethod.PUT)
  public void atualizarDados(@PathVariable Long id, @RequestBody Aluno aluno) {
    service.atualizarDados(aluno, id);
  }

  // Deletar
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  @RequestMapping(path = "/deletar/{id}", method = RequestMethod.DELETE)
  public void deletar(@PathVariable Long id) {
    service.deletar(id);
  }

  // Pesquisar por nome
  @RequestMapping(path = "/pesquisarnome", method = RequestMethod.GET)
  public List<Aluno> pesquisaPorNome(@RequestParam String nome) {
    return service.pesquisaPorNome(nome);
  }

  // Pesquiasr por nota
  @RequestMapping(path = "/pesquisarnota", method = RequestMethod.GET)
  public List<Aluno> pesquisaPorNota() {
    return service.pesquisaPorNota();
  }
}
