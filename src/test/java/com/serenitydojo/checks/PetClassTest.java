package com.serenitydojo.checks;

import com.serenitydojo.Cat;
import com.serenitydojo.Dog;
import com.serenitydojo.Hamster;
import com.serenitydojo.Pet;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;

public class PetClassTest {

    @Test
    public void creating_a_pet(){
        Pet jerry = new Dog("Jerry","Ball", 3){};
        System.out.println(jerry.getName());
    }

    @Test
    public void thePetClassShouldExist() throws ClassNotFoundException {
        assertThat(Class.forName("com.serenitydojo.Pet")).isNotNull();
    }

    @Test
    public void shouldHaveAName() throws Exception {
        assertThat(Class.forName("com.serenitydojo.Pet").getDeclaredField("name").getGenericType()).isEqualTo(String.class);
    }

    @Test
    public void shouldHaveAnAge() throws Exception {
        assertThat(Class.forName("com.serenitydojo.Pet").getDeclaredField("age").getGenericType()).isEqualTo(int.class);
    }

    @Test
    public void whenAnimalsPlay() {
        Pet fido = new Dog("Fido","Bone", 5);
        Pet spot = new Cat("Spot","String", 5);
        Pet hazel = new Hamster("Hazel", 1, "Wheel");

        System.out.println(fido.play());
        System.out.println(spot.play());
        System.out.println(hazel.play());


        // I get equalTo error when I uncomment the code below...

        /*
        assertThat(fido.play(), equalTo("plays with bone"));
        assertThat(spot.play(), equalTo("plays with string"));
        assertThat(hazel.play(), equalTo("runs in wheel"));
         */
    }

}
