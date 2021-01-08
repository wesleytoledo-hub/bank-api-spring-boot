package br.com.banco.api.apibanco.repositorios.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.api.apibanco.entidades.Pessoa;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
}
