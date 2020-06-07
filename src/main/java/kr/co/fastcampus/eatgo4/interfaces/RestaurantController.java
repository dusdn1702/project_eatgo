package kr.co.fastcampus.eatgo4.interfaces;

import kr.co.fastcampus.eatgo4.domain.MenuItem;
import kr.co.fastcampus.eatgo4.domain.MenuItemRepository;
import kr.co.fastcampus.eatgo4.domain.Restaurant;
import kr.co.fastcampus.eatgo4.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        //List<Restaurant> restaurants = new ArrayList<>();
        //Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
        //restaurants.add(restaurant);
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
        Restaurant restaurant = getRestaurantById(id);
        Restaurant restaurant = restaurantRepository.findById(id);
        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        //List<Restaurant> restaurants = new ArrayList<>();
        //restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        //restaurants.add(new Restaurant(2020L, "Cyber Food", "Seoul"));
        return restaurant;
    }
}