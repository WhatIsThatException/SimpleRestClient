package domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kpant on 6/16/17.
 */

//Data holder for food information

@XmlRootElement
public class Food {

    String name;
    int calories;
    String servingSize;

    public Food(){
        super();
    }

    public Food(String name, int calories, String servingSize) {
        super();
        this.name = name;
        this.calories = calories;
        this.servingSize = servingSize;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", servingSize='" + servingSize + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }
}
