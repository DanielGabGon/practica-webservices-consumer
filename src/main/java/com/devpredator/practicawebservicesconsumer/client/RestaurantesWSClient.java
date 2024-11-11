/**
 * 
 */
package com.devpredator.practicawebservicesconsumer.client;


import java.util.List;

import com.devpredator.practicawebservicesconsumer.dto.RestauranteDTO;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author 4PF28LA_2004
 *
 */
public class RestaurantesWSClient {
	public static void main(String[] args) {
	
	//:::::::::::::::::::::::::::::::GET:::::::::::::::::::::::::::::::::::::::::::::::::
	Client client = ClientBuilder.newClient();
	WebTarget webTarget = client.target("http://localhost:8080/practica-webservices/dangabito/restaurantesWS")
			.path("consultarRestaurantes");

	Invocation.Builder invocatioBuilder = webTarget.request(MediaType.APPLICATION_JSON);
	Response response = invocatioBuilder.get();
	

	if (response.getStatus() == 204) {
		System.out.println("No se encontro el empleado con el número de empleado");
	}

	if (response.getStatus() == 200) {
		List<RestauranteDTO> restauranteDTO = (List<RestauranteDTO>) response.readEntity(new GenericType<List<RestauranteDTO>>() {});

		restauranteDTO.stream().forEach(res-> System.out.println(res.getNombre()));
	}
	
//	//::::::::::::::::::::::::::::::POST::::::::::::::::::::::::::::::::::::::::::::::::::::::
//	Client client = ClientBuilder.newClient();
//	WebTarget webTarget = client.target("http://localhost:8080/practica-webservices/dangabito/restaurantesWS")
//			.path("guardaRestaurante");
//
//	RestauranteDTO dto= new RestauranteDTO();
//	dto.setIdRestaurante(3L);
//	dto.setDirección("Camino a la comida");
//	dto.setNombre("El buen sazón");
//	dto.setSlogan("Lo más rico de comer");
//	
//	
//	Invocation.Builder invocatioBuilder = webTarget.request(MediaType.APPLICATION_JSON);
//	Response response = invocatioBuilder.post(Entity.entity(dto, MediaType.APPLICATION_JSON));
//	
//	if(response.getStatus()==400) {
//		String error=response.readEntity(String.class);
//		System.out.println(error);
//	}
//	
//	if(response.getStatus()==200) {
//		RestauranteDTO emp=response.readEntity(RestauranteDTO.class);
//		System.out.println(emp.getNombre());
//		System.out.println(emp.getDirección());
//	}
}

}


