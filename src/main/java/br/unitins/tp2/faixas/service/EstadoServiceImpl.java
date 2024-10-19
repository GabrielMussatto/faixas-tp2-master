package br.unitins.tp2.faixas.service;

import java.util.List;

import br.unitins.tp2.faixas.dto.EstadoDTO;
import br.unitins.tp2.faixas.dto.EstadoResponseDTO;
import br.unitins.tp2.faixas.model.Estado;
import br.unitins.tp2.faixas.repository.EstadoRepository;
import br.unitins.tp2.faixas.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    public EstadoRepository estadoRepository;

    @Override
    @Transactional
    public EstadoResponseDTO create(@Valid EstadoDTO dto) {
        validarNomeEstado(dto.nome());

        Estado estado = new Estado();
        estado.setNome(dto.nome());
        estado.setSigla(dto.sigla());

        estadoRepository.persist(estado);
        return EstadoResponseDTO.valueOf(estado);
    }

    public void validarNomeEstado(String nome) {
        Estado estado = estadoRepository.findByNomeCompleto(nome);
        if (estado != null)
            throw  new ValidationException("nome", "O nome '"+nome+"' já existe.");
    }

    @Override
    @Transactional
    public void update(Long id, EstadoDTO dto) {
        Estado estadoBanco =  estadoRepository.findById(id);

        estadoBanco.setNome(dto.nome());
        estadoBanco.setSigla(dto.sigla());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        estadoRepository.deleteById(id);
    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        Estado estado = estadoRepository.findById(id);
        if (estado != null)
            return EstadoResponseDTO.valueOf(estado);
        return null;
    }

    @Override
    public List<EstadoResponseDTO> findAll(int page, int pageSize) {
        List<Estado> listEstado = estadoRepository
                                    .findAll()
                                    .page(page, pageSize)
                                    .list();
        return listEstado
                    .stream()
                    .map(e -> EstadoResponseDTO.valueOf(e))
                    .toList();
    }

    @Override
    public List<EstadoResponseDTO> findByNome(int page, int pageSize, String nome) {
        List<Estado> listEstado = estadoRepository
                                    .findByNome(nome)
                                    .page(page, pageSize)
                                    .list();

        return listEstado
                    .stream()
                    .map(e -> EstadoResponseDTO.valueOf(e))
                    .toList();
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
        List<Estado> listEstado = estadoRepository
                                    .findByNome(nome)
                                    .list();

        return listEstado
                    .stream()
                    .map(e -> EstadoResponseDTO.valueOf(e))
                    .toList();
    }

    @Override
    public List<EstadoResponseDTO> findBySigla(int page, int pageSize, String sigla) {
        List<Estado> listEstado = estadoRepository
                                    .findBySigla(sigla)
                                    .page(page, pageSize)
                                    .list();

        return listEstado
                    .stream()
                    .map(e -> EstadoResponseDTO.valueOf(e))
                    .toList();
    }

    @Override
    public List<EstadoResponseDTO> findBySigla(String sigla) {
        List<Estado> listEstado = estadoRepository
                                    .findBySigla(sigla)
                                    .list();

        return listEstado
                    .stream()
                    .map(e -> EstadoResponseDTO.valueOf(e))
                    .toList();
    }

    @Override
    public long count(){
        return estadoRepository.count();
    }
}
