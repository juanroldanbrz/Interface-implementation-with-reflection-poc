package org.poc.aop.proxy;

        import javassist.util.proxy.MethodHandler;
        import javassist.util.proxy.ProxyFactory;
        import org.poc.aop.model.User;

        import java.lang.reflect.Parameter;

public class Proxy<T> {
    public T createMock(final Class<T> clazz) {
        final ProxyFactory factory = new ProxyFactory();
        factory.setInterfaces(new Class[] { clazz });
        factory.setFilter(m -> !m.getName().equals("finalize"));
        final MethodHandler handler = createDefaultMethodHandler();
        factory.setHandler(handler);

        try {
            return (T) factory.create(new Class<?>[0], new Object[0]);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private MethodHandler createDefaultMethodHandler() {
        return (self, thisMethod, proceed, args) -> {
            System.out.println("Handling " + thisMethod
                    + " via the method handler");
            System.out.println("Accessing to the method: " + thisMethod.getName());
            Parameter[] params = thisMethod.getParameters();
            for(int i = 0; i < args.length; i++){
                System.out.println("Parameter class: " + params[i].getType());
                System.out.println("Parameter value: " + args[i].toString());
            }
            return new User("Juan", "1234");
        };
    }
}
