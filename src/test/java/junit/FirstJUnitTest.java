package junit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

public class FirstJUnitTest  {

    @BeforeAll
    static void beforeall() {
        System.out.println("Этот метод выполняется перед всеми тестами ");
    }

    @BeforeEach
    void before() {
        System.out.println("Этот медод выполняется перед каждым тестом!");
        Selenide.open("https://google.com");
    }

    @AfterEach
    void after(){
        System.out.println("Этот медод выполняется после каждым тестом!");
        Selenide.closeWebDriver();
    }

    @AfterAll
    static void afterall () {
        System.out.println("Этот медот выполняется после всех тестов");
    }

    @Test
    void simpletest() {
            System.out.println("    Это первый тест");
    }
}
