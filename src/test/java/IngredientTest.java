import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {


    Ingredient ingredient = new Ingredient(SAUCE, "cucumber", 200);

    @Test
    public void getPrice() {
        float actual = ingredient.getPrice();
        float expected = 200;
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getName() {
        String actual = ingredient.getName();
        String expected = "cucumber";
        assertEquals(expected, actual);
    }

    @Test
    public void getType() {
        IngredientType actual = ingredient.getType();
        IngredientType expected = SAUCE;
        assertEquals(expected, actual);
    }
}
