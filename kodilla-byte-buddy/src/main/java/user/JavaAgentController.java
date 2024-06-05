package user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class JavaAgentController {

    @Secured("ROLE_ADMIN")
    public void createUserAndDoSomething() {
        User user = new User();
        user.doSomething();
    }

    public static void main(String[] args) {
        JavaAgentController controller = new JavaAgentController();
        controller.createUserAndDoSomething();
    }
}