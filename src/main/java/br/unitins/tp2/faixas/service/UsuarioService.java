package br.unitins.tp2.faixas.service;

import java.util.List;

import br.unitins.tp2.faixas.dto.UsuarioDTO;
import br.unitins.tp2.faixas.dto.UsuarioResponseDTO;

public interface UsuarioService {

    public UsuarioResponseDTO insert(UsuarioDTO dto);

    public UsuarioResponseDTO update(UsuarioDTO dto, Long id);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    public List<UsuarioResponseDTO> findByAll(); 

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);
    
}