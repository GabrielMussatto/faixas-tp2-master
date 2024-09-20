package br.unitins.tp2.faixas.dto;

import br.unitins.tp2.faixas.model.Cidade;

public record CidadeResponseDTO(
    Long id,
    String nome,
    EstadoResponseDTO estado
) {
    public static CidadeResponseDTO valueOf(Cidade cidade) {
        return new CidadeResponseDTO(
            cidade.getId(), 
            cidade.getNome(), 
            EstadoResponseDTO.valueOf(cidade.getEstado()));
    }
    
}