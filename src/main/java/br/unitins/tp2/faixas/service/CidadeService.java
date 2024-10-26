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
    public List<CidadeResponseDTO> findAll(int page, int pageSize);
    public List<CidadeResponseDTO> findByNome(String nome);
    public List<CidadeResponseDTO> findByNome(int page, int pageSize, String nome);
    public long count();
    
}
