package com.serenitydojo.checks;

import com.serenitydojo.Hamster;
import com.serenitydojo.Pet;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

public class HamsterClassTest {

    @Test
    public void creating_a_hamster(){
        Pet soni = new Hamster("Soni", 1, "GTA5");
        Hamster test = new Hamster("Test", 2, "FIFA");

        System.out.println(test.getFavoriteGame() + test.getAge() + test.getName());
        System.out.println(soni.getName() + " " + soni.getAge() + " " + ((Hamster) soni).getFavoriteGame());
    }

    @Test
    public void theDogClassShouldExist() throws ClassNotFoundException {
        assertThat(Class.forName("com.serenitydojo.Hamster")).isNotNull();
    }

    @Test
    public void shouldBeAPet() throws Exception {
        assertThat(Class.forName("com.serenitydojo.Hamster").getSuperclass().getSimpleName()).isEqualTo("Pet");
    }

    @Test
    public void theDogClassShouldHaveAFavoriteToy() throws Exception {
        assertThat(Class.forName("com.serenitydojo.Hamster").getDeclaredField("favoriteGame").getGenericType()).isEqualTo(String.class);
    }
}
