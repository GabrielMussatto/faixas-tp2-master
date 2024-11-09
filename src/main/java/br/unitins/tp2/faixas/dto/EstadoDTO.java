package br.unitins.tp2.faixas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstadoDTO (
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(min = 4, max = 60, message = "O tamanho do nome deve ser entre 4 e 60 caracteres.")
    String nome,
    @NotBlank(message = "A sigla não pode ser nula ou vazia")
    @Size(min = 2, max = 2, message = "A sigla deve possuir 2 caracteres")
    String sigla
) { }
