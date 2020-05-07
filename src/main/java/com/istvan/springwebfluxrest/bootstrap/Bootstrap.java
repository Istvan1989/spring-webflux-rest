package com.istvan.springwebfluxrest.bootstrap;

import com.istvan.springwebfluxrest.domain.Category;
import com.istvan.springwebfluxrest.domain.Vendor;
import com.istvan.springwebfluxrest.repositories.CategoryRepository;
import com.istvan.springwebfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count().block() == 0) {
            //load data
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("------------------------------------");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Meats").build()).block();
            categoryRepository.save(Category.builder().description("Fishes").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();

            System.out.println("Loaded categories: " + categoryRepository.count().block());

            vendorRepository.save(Vendor.builder().firstName("Dasi").lastName("Masi").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Walter").lastName("White").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Jesse").lastName("Pinkman").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Dasi").lastName("Masdasi").build()).block();
            vendorRepository.save(Vendor.builder().firstName("ddDasi").lastName("Masddi").build()).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());


        }

    }
}
