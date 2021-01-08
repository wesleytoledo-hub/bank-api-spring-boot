package br.com.banco.api.apibanco.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.banco.api.apibanco.entidades.Pessoa;
import br.com.banco.api.apibanco.error.ResourceNotFoundException;
import br.com.banco.api.apibanco.repositorios.pessoa.PessoaRepositorio;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

  @Autowired
  PessoaRepositorio pessoaRepo;

  @PostMapping(consumes = "application/json")
  public <cpf, email> ResponseEntity<Pessoa> adicionaPessoa(@RequestBody @Valid Pessoa pessoa) {

    try {
      pessoaRepo.save(pessoa);

      return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @GetMapping
  public ResponseEntity<List<Pessoa>> listaPessoas() {
    return ResponseEntity.ok().body(pessoaRepo.findAll());

  }

  @GetMapping("/{id}")
  public ResponseEntity<Pessoa> pessoaPorId(@PathVariable Long id) {

    Pessoa pessoa = pessoaRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Nao existe uma pessoa com o id = " + id));

    return new ResponseEntity<>(pessoa, HttpStatus.OK);

    // return ResponseEntity.ok().body(pessoaRepo.findById(id).get());
  }

}
