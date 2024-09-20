package br.unitins.tp2.faixas.service;

import java.util.List;

import br.unitins.tp2.faixas.dto.EstadoDTO;
import br.unitins.tp2.faixas.dto.EstadoResponseDTO;
import jakarta.validation.Valid;

public interface EstadoService {

    public EstadoResponseDTO create(@Valid EstadoDTO dto);
    public void update(Long id, EstadoDTO dto);
    public void delete(Long id);
    public EstadoResponseDTO findById(Long id);
    public List<EstadoResponseDTO> findAll();
    public List<EstadoResponseDTO> findByNome(String nome);
    public List<EstadoResponseDTO> findBySigla(String sigla);
    
}
