package ro.msg.learning.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.entity.ProductCategoryEntity;
import ro.msg.learning.shop.repository.ProductCategoryRepository;

/* uncomment the annotation when you want to test it*/
//@Configuration
class LoadDatabase
{
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductCategoryRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new ProductCategoryEntity("thief", "ok")));
        };
    }
}