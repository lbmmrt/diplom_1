import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Test
    public void addIngredient() {
        final Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredient() {
        final Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredient));
    }

    @Test
    public void moveIngredient() {
        final Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        final Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0, 1);
        assertNotEquals(burger.ingredients.get(0), ingredient0);
    }

    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn(124f);
        burger.setBuns(bun);
        float actual = burger.getPrice();
        float expected = 248;
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getPriceWithIngredients() {
        Mockito.when(bun.getPrice()).thenReturn(124f);
        burger.setBuns(bun);

        final Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        float expected = ingredient.getPrice() + 248f;
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void getReceipt11() {
        Mockito.when(bun.getPrice()).thenReturn(124f);
        Mockito.when(bun.getName()).thenReturn("bigTasty");
        burger.setBuns(bun);

        final Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== bigTasty ====)\n= " + ingredient.getType().name().toLowerCase() + " " + ingredient.getName() +
                " =\n(==== bigTasty ====)\n\nPrice: 348,000000\n";
        assertEquals(expected, actual);
    }
}
