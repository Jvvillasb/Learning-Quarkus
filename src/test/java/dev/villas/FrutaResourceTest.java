package dev.villas;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
@TestHTTPEndpoint(FrutasResource.class)
public class FrutaResourceTest {

	@Inject
	FrutaService frutasService;
	
    @Test
    public void testHelloEndpoint() {
        given()
          .when()
          .get()
          .then()
             .statusCode(200)
             .body(is("[]"));
    }
    
    @Test
    public void testListFrutas2() {
    	List<Fruta> list = frutasService.list();
    	assertTrue(list.isEmpty());
    }

}