package dev.villas;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/frutas")
public class FrutasResource {

    @Inject
    FrutaService frutasService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruta> list() {
        return frutasService.list();
    }
    
    @POST
    public void novaFruta(InserirFrutaDTO inserirFrutaDTO) {
        frutasService.novaFruta(inserirFrutaDTO);
    }

}
