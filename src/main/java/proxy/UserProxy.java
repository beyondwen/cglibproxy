package proxy;

import dao.IUserDao;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2016/09/30.
 */
public class UserProxy implements MethodInterceptor {
    private IUserDao dao;

    public UserProxy(IUserDao dao) {
        this.dao = dao;
    }

    public IUserDao createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(dao.getClass());
        enhancer.setCallback(this);
        return (IUserDao) enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("add".equals(method.getName())) {
            System.out.println("记录日志");
            return methodProxy.invokeSuper(o, objects);
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
