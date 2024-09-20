package br.unitins.tp2.faixas.repository;

import java.util.List;

import br.unitins.tp2.faixas.model.Estado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EstadoRepository implements PanacheRepository<Estado> {

    public List<Estado> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }

    public List<Estado> findBySigla(String sigla) {
        return find("UPPER(sigla) LIKE ?1", "%"+ sigla.toUpperCase() + "%").list();
    }

    public Estado findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }
    
}
