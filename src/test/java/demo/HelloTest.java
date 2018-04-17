package demo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloTest {

    @Test
    public void shouldGreetingWithPassingName() {
        assertThat("hello").isNotBlank();
    }

}
