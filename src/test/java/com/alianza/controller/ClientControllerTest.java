package com.alianza.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.alianza.config.GraphQlConfig;
import com.alianza.controller.ClientController;
import com.alianza.dto.ClientDto;
import com.alianza.service.ClientServices;

@GraphQlTest(ClientController.class)
@Import(GraphQlConfig.class)
public class ClientControllerTest {
	@Autowired
	private GraphQlTester graphQlTester;

	@MockBean
	ClientServices clientService;

	@Test
	void getClients() {
		List<ClientDto> mockClientes = new ArrayList<>();
		ClientDto dto = new ClientDto();
		dto.setName("Paola");
		dto.setEmail("dsds@dsd.com");
		dto.setUser("dsds");
		dto.setPhone("31223232");
		dto.setDateAdd(LocalDate.parse("2023-01-01"));
		mockClientes.add(dto);

		Mockito.when(clientService.getAll()).thenReturn(mockClientes);
		graphQlTester.document("{ findAll { name email } }").execute().path("findAll").entityList(ClientDto.class)
				.hasSizeGreaterThan(0).satisfies(c -> {
					assert c.get(0).getName() != null;
					assert c.get(0).getEmail() != null;
				});
	}
	
	@Test
    public void testCreateClientMutation() {
        String mutation = """
            mutation CreateClient {
              createClient(clientDto: {
                user: "juan123"
                name: "Juan Pérez"
                email: "juan@example.com"
                phone: "3213213210"
                startDate: "2023-01-01"
                endDate: "2023-12-31"
              })
            }
        """;

        graphQlTester.document(mutation)
            .execute()
            .path("createClient")
            .entity(String.class)
            .isEqualTo("Registro Exitoso");
   }


}
