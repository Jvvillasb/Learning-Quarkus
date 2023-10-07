package dev.villas;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.quarkus.arc.Lock;
import io.quarkus.arc.Lock.Type;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Lock
@ApplicationScoped
public final class FrutaService {

    @Inject
    IdentificadorTransacao identificadorTransacao;
    
    @Lock(value = Type.READ, time = 3, unit = TimeUnit.SECONDS)
    public List<Fruta> list() {
        System.out.println(identificadorTransacao.getIdentificacaoTransacao());
        return Fruta.listAll();
    }
    
    @Transactional
    public void novaFruta(InserirFrutaDTO inserirFrutaDTO) {
        System.out.println(identificadorTransacao.getIdentificacaoTransacao());
        Fruta fruta = new Fruta();
        fruta.nome = inserirFrutaDTO.getNome();
        fruta.qtd = inserirFrutaDTO.getQtd();
        fruta.persist();
    }
    
}