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

import java.time.Instant;
import java.util.List;

@ApplicationScoped
public class ReviewsSimulatorService {

    
    @RestClient
    ReviewsService reviewsService;

    @RestClient
    @Inject
    GlobexStoreService globexStoreService;

    public JsonObject simulate(String catalogue) {        
        int reviewCount = 5;
        if(catalogue==null || catalogue.isEmpty()) {
            catalogue = "clothing";
        }
        List<ProductDto> productList = globexStoreService.readByCategories(catalogue, false);
        int prodCount = productList.size() > 5 ? 5: productList.size();

        createReviewsForCatalogue(productList, prodCount, reviewCount);
        return new JsonObject().put("result", "Generated " + (prodCount * reviewCount) + " product reviews for catalogue:" + catalogue);        
    }

    
    private void createReviewsForCatalogue(List<ProductDto> productList, int prodCount, int reviewCount) {
        
        for(int i=0; i < prodCount; i++) {
            for(int c=0; c < reviewCount; c++) {
                
                reviewsService.submitReview(createReview(productList.get(i)));
            }
        }
    }

    private ProductReviewDto createReview(ProductDto productDto) {
        
        ProductReviewDto review = new ProductReviewDto();
        review.setUser(ReviewsGeneratorHelper.fetchRandomUser());
        review.setProduct(productDto);
        review.setRating(5);
        review.setReviewText(ReviewsGeneratorHelper.fetchRandomReview());
        review.setTimestamp(Instant.now().toEpochMilli());
        return review;
        
    }
    
    
    

    

}
