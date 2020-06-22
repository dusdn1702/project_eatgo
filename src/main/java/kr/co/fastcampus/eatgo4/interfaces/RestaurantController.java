package kr.co.fastcampus.eatgo4.interfaces;

import kr.co.fastcampus.eatgo4.application.RestaurantService;
import kr.co.fastcampus.eatgo4.domain.MenuItem;
import kr.co.fastcampus.eatgo4.domain.MenuItemRepository;
import kr.co.fastcampus.eatgo4.domain.Restaurant;
import kr.co.fastcampus.eatgo4.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {


    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        //List<Restaurant> restaurants = new ArrayList<>();
        //Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        //restaurants.add(restaurant);
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = restaurantService.getRestaurant(id);
        //List<Restaurant> restaurants = new ArrayList<>();
        //restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        //restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant resource)
            throws URISyntaxException {
        String name = resource.getName();
        String address = resource.getAddress();

        Restaurant restaurant = new Restaurant(name, address);
        restaurantService.addRestaurant(restaurant);
        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }
}
