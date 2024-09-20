package br.unitins.tp2.faixas.service;

import java.util.List;

import br.unitins.tp2.faixas.dto.CidadeDTO;
import br.unitins.tp2.faixas.dto.CidadeResponseDTO;
import br.unitins.tp2.faixas.model.Cidade;
import br.unitins.tp2.faixas.repository.CidadeRepository;
import br.unitins.tp2.faixas.repository.EstadoRepository;
import br.unitins.tp2.faixas.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {

    @Inject
    public CidadeRepository cidadeRepository;

    @Inject
    public EstadoRepository estadoRepository;
    
    @Override
    @Transactional
    public CidadeResponseDTO create(@Valid CidadeDTO dto) {
        validarNomeCidade(dto.nome());

        Cidade cidade = new Cidade();
        cidade.setNome(dto.nome());
        cidade.setEstado(estadoRepository.findById(dto.idEstado()));

        cidadeRepository.persist(cidade);
        return CidadeResponseDTO.valueOf(cidade);
    }

    public void validarNomeCidade(String nome) {
        Cidade cidade = cidadeRepository.findByNomeCompleto(nome);
        if (cidade != null)
            throw  new ValidationException("nome", "O nome "+nome+" já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, CidadeDTO dto) {
        Cidade cidadeBanco =  cidadeRepository.findById(id);
        cidadeBanco.setNome(dto.nome());
        cidadeBanco.setEstado(estadoRepository.findById(dto.idEstado()));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        cidadeRepository.deleteById(id);
    }

    @Override
    public CidadeResponseDTO findById(Long id) {
        Cidade cidade = cidadeRepository.findById(id);
        if (cidade != null)
            return CidadeResponseDTO.valueOf(cidade);
        return null;
    }

    @Override
    public List<CidadeResponseDTO> findAll() {
        return cidadeRepository
        .listAll()
        .stream()
        .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) {
        return cidadeRepository.findByNome(nome).stream()
        .map(e -> CidadeResponseDTO.valueOf(e)).toList();
    }
}
