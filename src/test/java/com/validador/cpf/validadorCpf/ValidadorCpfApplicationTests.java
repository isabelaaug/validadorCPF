package com.validador.cpf.validadorCpf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

import com.validador.cpf.validadorCpf.models.Cliente;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	@DisplayName("")
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf("71713824000");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfValidoComPontuacao() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf("717.138.240-00");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComEspacos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf(" 717.138.240 - 00 ");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf("71713824011");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontuacao() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf("717.138.240-11");
		assertEquals(false, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf(" 717.138.240 - 11 ");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfComDigitosAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf("717138240");
		assertEquals(false, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfComNumerosAMais() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf("717138240002255");
		assertEquals(false, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfComCaracterEspecial() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf("7%1713824000");
		assertEquals(false, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComLetra() {
		Cliente cliente = new Cliente();
		cliente.setNome("Isabela");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());
	}
}
