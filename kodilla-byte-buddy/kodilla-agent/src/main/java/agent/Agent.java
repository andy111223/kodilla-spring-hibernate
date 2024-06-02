package agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;
import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("Kodilla agent is running.");
        System.out.println("Is redefine classes allowed: " + instrumentation.isRedefineClassesSupported());
        System.out.println("Is retransform classes allowed: " + instrumentation.isRetransformClassesSupported());

        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("user"))
                .transform((builder, typeDescription, classLoader, module, protectionDomain) -> {
                    System.out.println("Class " + typeDescription);
                    return builder.visit(Advice.to(MyMethodMonitor.class).on(ElementMatchers.named("doSomething")));
                })
                .installOn(instrumentation);
    }

    public static void agentmain(String args, Instrumentation instrumentation) {
        premain(args, instrumentation);
    }
}
