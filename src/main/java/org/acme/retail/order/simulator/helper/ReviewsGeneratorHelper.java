package org.acme.retail.order.simulator.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.acme.retail.order.simulator.model.dto.UserDto;

public class ReviewsGeneratorHelper {
    
    static  ArrayList<String> reviews = new ArrayList<>(
        Arrays.asList(
            "I can't imagine my life without this product now. It has become an essential part of my daily routine.",
            "I'm extremely satisfied with this purchase. It's worth every penny and has made a noticeable difference.",
            "I highly recommend this product to everyone. It's versatile, reliable, and offers excellent performance.",
            "I'm impressed by the durability of this product. It's built to last and can withstand heavy use.",
            "The customer service for this product is outstanding. The company promptly addressed my concerns and provided a solution.",
            "This product has simplified my life. It's user-friendly and intuitive, making it easy to use for anyone.",
            "The value for money with this product is incredible. It offers exceptional features at an affordable price.",
            "I've tried many similar products, but this one stands out from the rest. It sets a new standard of excellence.",
            "I couldn't be happier with my purchase. This product has exceeded my expectations and I'm thoroughly impressed.",            
            "I can't imagine my life without this product now. It has become an essential part of my daily routine.",
            "I'm extremely satisfied with this purchase. It's worth every penny and has made a noticeable difference.",
            "I highly recommend this product to everyone. It's versatile, reliable, and offers excellent performance.",
            "I'm impressed by the durability of this product. It's built to last and can withstand heavy use.",
            "The customer service for this product is outstanding. The company promptly addressed my concerns and provided a solution.",
            "This product has simplified my life. It's user-friendly and intuitive, making it easy to use for anyone.",
            "The value for money with this product is incredible. It offers exceptional features at an affordable price.",
            "I've tried many similar products, but this one stands out from the rest. It sets a new standard of excellence.",
            "I couldn't be happier with my purchase. This product has exceeded my expectations and I'm thoroughly impressed.",
            "I was a little disappointed with this product. It didn't work as advertised",
            "I've had this product for a few weeks now, and I'm not impressed. It's not as good as I thought it would be.",
            "I'm so angry with this product. It broke after just a few uses. I'm not sure what I'm going to do now.",
            "This product is a complete rip-off. It's not worth the money. I would not recommend it to anyone.",
            "I'm so disappointed with this product. It's not what I was expecting at all. I'm going to return it as soon as possible.",
            "I'm so frustrated with this product. It's not working at all. I've tried everything, but I can't get it to work."
            )
    );

    static List<List<String>> users = new ArrayList<>();

    ReviewsGeneratorHelper() {
        
    }

    

    public static String  fetchRandomReview() {
        return reviews.get(new Random().nextInt(reviews.size()));
    }

    public static UserDto  fetchRandomUser() {
        if(users.size() < 1) { 
            loadUsers();
        }
        List<String> user = users.get(new Random().nextInt(users.size()));
        UserDto userDto = new UserDto();
        userDto.setName(user.get(0));
        userDto.setCustomer_id(user.get(1));
        userDto.setBrowser("Chrome");
        userDto.setRegion("World");
        return userDto;
    }
    
    static void loadUsers() {
        
            users.add(Arrays.asList("jchapman", "Jose Chapman"));
            users.add(Arrays.asList("mmiller", "Madeline Miller"));
            users.add(Arrays.asList("amccarthy", "Anneliese Mccarthy"));
            users.add(Arrays.asList("blee", "Blake Lee"));
            users.add(Arrays.asList("asilva", "Addison Silva"));
            users.add(Arrays.asList("etaylor", "Elise Taylor"));
        

    }

}
