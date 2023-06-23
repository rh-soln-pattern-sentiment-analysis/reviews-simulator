package org.acme.retail.order.simulator.service;

import io.vertx.core.json.JsonObject;
import org.acme.retail.order.simulator.helper.ReviewsGeneratorHelper;
import org.acme.retail.order.simulator.model.dto.ProductDto;
import org.acme.retail.order.simulator.model.dto.ProductReviewDto;
import org.acme.retail.order.simulator.rest.client.ReviewsService;
import org.acme.retail.order.simulator.rest.client.GlobexStoreService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@ApplicationScoped
public class ReviewsSimulatorService {

    private static final Logger log = LoggerFactory.getLogger(ReviewsSimulatorService.class);

    @RestClient
    ReviewsService reviewsService;

    @RestClient
    @Inject
    GlobexStoreService globexStoreService;

    public JsonObject simulate(String catalogue) {
        
        
        int count = 5;
        if(catalogue==null || catalogue.isEmpty()) {
            catalogue = "clothing";
        }
        
        createReviewsForCatalogue(catalogue, count);
        return new JsonObject().put("result", "Generated " + count + " product reviews for catalogue:" + catalogue);
         
        /* if (productId != null) {
            createReviewsForProduct(catalogue, productId, count);            
            log.info("Complete!");
            return new JsonObject().put("result", "Generated " + count + " orders for random customers");
        } */
        
        
        
    }

    
    private void createReviewsForCatalogue(String categories, int count) {
        List<ProductDto> productList = globexStoreService.readByCategories(categories, false);
        int prodCount = productList.size() > 5 ? 5: productList.size();
        
        for(int i=0; i<prodCount; i++) {
            for(int c=0; c<count; c++) {
                
                reviewsService.submitReview(createReview(productList.get(i)));
            }
        }
    }

    /* private void createReviewsForProduct(String catalogue, String productId, int count) {
        reviewsService.submitReview(null);
    } */



    private ProductReviewDto createReview(ProductDto productDto) {
        
        ProductReviewDto review = new ProductReviewDto();
        review.setUser(ReviewsGeneratorHelper.fetchRandomUser());
        review.setProduct(productDto);
        review.setRating(0);
        review.setReviewText(ReviewsGeneratorHelper.fetchRandomReview());
        review.setTimestamp(Instant.now().toEpochMilli());
        
        
        return review;
        
    }
    
    
    

    

}
