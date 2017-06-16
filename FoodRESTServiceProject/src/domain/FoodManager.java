package domain;

import java.util.Optional;

/**
 * Created by kpant on 6/16/17.
 */
public class FoodManager {
    private static FoodList list = new FoodList();
    static{
        list.add(new Food("onion", 20, "2 slices"));
        list.add(new Food("Beans", 60, "1 cup"));
        list.add(new Food("orange", 80, "1 whole"));
    }

    public static FoodList getFoods(){
        return list;
    }

    public static Food find(String name) {
        final Optional<Food> foundFood = list.stream().filter(food -> food.getName().equalsIgnoreCase(name)).findFirst();
        return foundFood.orElse(null);
    }

    public static void add(Food food) {
        list.add(food);
    }

    public static void delete(String name){
        Food food = find(name);
        list.remove(food);
    }
}
