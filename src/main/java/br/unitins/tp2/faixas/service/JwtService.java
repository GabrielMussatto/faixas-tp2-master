package br.unitins.tp2.faixas.service;

import br.unitins.tp2.faixas.dto.UsuarioResponseDTO;

public interface JwtService {
    public String generateJwt(UsuarioResponseDTO dto);
}
