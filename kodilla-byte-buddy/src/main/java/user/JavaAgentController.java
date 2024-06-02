package user;

public class JavaAgentController {

    public void createUserAndDoSomething() {
        User user = new User();
        user.doSomething();
    }

    public static void main(String[] args) {
        JavaAgentController controller = new JavaAgentController();
        controller.createUserAndDoSomething();
    }
}
