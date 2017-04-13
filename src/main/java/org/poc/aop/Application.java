package org.poc.aop;

import javassist.Modifier;
import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import org.poc.aop.model.User;
import org.poc.aop.proxy.Proxy;
import org.poc.aop.repository.FakeJpaRepository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Application {
    public static void main(String[] args) {
        Proxy<FakeJpaRepository> fakeJpaRepositoryProxy = new Proxy<>();
        FakeJpaRepository fakeJpaRepository = fakeJpaRepositoryProxy.createMock(FakeJpaRepository.class);
        User user = fakeJpaRepository.findByUserName("Juan");
        System.out.print(user);
    }
}
