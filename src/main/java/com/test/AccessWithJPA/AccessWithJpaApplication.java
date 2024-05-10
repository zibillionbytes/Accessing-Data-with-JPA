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
			repository.save(new Customer("Kerim", "Tekin"));
			repository.save(new Customer("Barış", "Manço"));
			repository.save(new Customer("Sertab", "Erener"));
			repository.save(new Customer("Harun", "Tekin"));
			repository.save(new Customer("Rasim", "Öztekin"));
			repository.save(new Customer("Özlem", "Tekin"));
			repository.save(new Customer("Cem", "Yılmaz"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(5L);
			log.info("Customer found with findById(5L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Tekin'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Tekin").forEach(tekin -> {
				log.info(tekin.toString());
			});
			log.info("");
		};
	}
}
