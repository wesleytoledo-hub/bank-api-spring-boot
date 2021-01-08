package br.com.banco.api.apibanco.entidades;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false, unique = true)
  private Long id;

  @NotNull(message = "{nome.not.null}")
  @NotEmpty(message = "{nome.not.empty}")
  private String nome;

  @Email
  @NotNull(message = "{email.not.null}")
  @NotEmpty(message = "{email.not.empty}")
  private String email;

  @NotNull(message = "{cpf.not.null}")
  @NotEmpty(message = "{cpf.not.empty}")
  private String cpf;

  @NotNull(message = "{data_nascimento.not.null}")
  // @NotEmpty(message = "O campo data de nascimento nao pode ser vazio")
  private Date data_nascimento;

  public Pessoa() {
  }
}
