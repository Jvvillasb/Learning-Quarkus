package dev.villas;

import io.quarkus.arc.DefaultBean;
import io.quarkus.arc.profile.IfBuildProfile;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;

public class IdentificadorTransacaoProducer {

    @Produces
    @DefaultBean
    @RequestScoped
    public IdentificadorTransacao produceTeste() {
        return new IdentificadorTransacao("Teste-");
    }
    
    @Produces
    @IfBuildProfile("prod")
    @RequestScoped
    public IdentificadorTransacao produceProd() {
        return new IdentificadorTransacao("Prod-");
    }
}
