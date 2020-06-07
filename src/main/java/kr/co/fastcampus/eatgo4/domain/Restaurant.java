package kr.co.fastcampus.eatgo4.domain;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final String address;
    private final Long id;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Object getInformation() {
        return name + " in " + address;
    }

    public Object getAddress() {
        return address;
    }

    public Object getId() {
        return id;
    }

    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }
}
