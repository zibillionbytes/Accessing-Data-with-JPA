package com.test.AccessWithJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessWithJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessWithJpaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AccessWithJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Customer("Barış", "Manço"));
			repository.save(new Customer("Cem", "Karaca"));
			repository.save(new Customer("Erkin", "Koray"));
			repository.save(new Customer("Ahmet", "Güvenç"));
			repository.save(new Customer("Cahit", "Berkay"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Güvenç").forEach(güvenç -> {
				log.info(güvenç.toString());
			});
			log.info("");
		};
	}
}
