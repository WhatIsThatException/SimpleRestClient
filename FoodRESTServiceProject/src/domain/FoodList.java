package domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by kpant on 6/16/17.
 */
@XmlRootElement
@XmlSeeAlso(Food.class)
public class FoodList extends ArrayList<Food> {

    public FoodList(){
        super();
    }

    public FoodList(Collection<? extends Food> c) {
        super(c);
    }

    @XmlElement(name = "Foods")
    public List<Food> getFoods(){
        return this;
    }

    public void addFoods(List<Food> foods) {
        this.addAll(foods);
    }

}
