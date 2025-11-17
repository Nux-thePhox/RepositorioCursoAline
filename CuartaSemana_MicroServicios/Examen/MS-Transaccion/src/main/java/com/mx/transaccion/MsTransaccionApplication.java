package com.mx.transaccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsTransaccionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTransaccionApplication.class, args);
	}

}
