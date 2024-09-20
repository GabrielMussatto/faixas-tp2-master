package br.unitins.tp2.faixas.service;

import java.util.List;

import br.unitins.tp2.faixas.dto.CidadeDTO;
import br.unitins.tp2.faixas.dto.CidadeResponseDTO;
import jakarta.validation.Valid;

public interface CidadeService {

    public CidadeResponseDTO create(@Valid CidadeDTO dto);
    public void update(Long id, CidadeDTO dto);
    public void delete(Long id);
    public CidadeResponseDTO findById(Long id);
    public List<CidadeResponseDTO> findAll();
    public List<CidadeResponseDTO> findByNome(String nome);
    
}
