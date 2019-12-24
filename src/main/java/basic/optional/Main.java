package basic.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Main
 * <p>
 * Java 8 Optional使用
 *
 * @author xMustang
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {
        User user = new User("xMustang", "foxmail.com");
        System.out.println("orElse");
        Optional.ofNullable(user).orElse(createNewUser());

        System.out.println("orElseGet");
        Optional.ofNullable(user).orElseGet(Main::createNewUser);

        System.out.println("=============");

    }

    private static User createNewUser() {
        System.out.println("createNewUser");
        return new User("horse", "gmail.com");
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private String email;
}