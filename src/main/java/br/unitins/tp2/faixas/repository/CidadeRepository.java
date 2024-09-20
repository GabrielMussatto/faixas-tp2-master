package br.unitins.tp2.faixas.repository;

import java.util.List;

import br.unitins.tp2.faixas.model.Cidade;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CidadeRepository implements PanacheRepository<Cidade> {

    public List<Cidade> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%"+ nome.toUpperCase() + "%").list();
    }
    
    public Cidade findByNomeCompleto(String nome) {
        return find("UPPER(nome) = ?1",  nome.toUpperCase() ).firstResult();
    }

}
