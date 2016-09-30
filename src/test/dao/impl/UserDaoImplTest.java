package dao.impl;

import dao.IUserDao;
import org.junit.Test;
import proxy.UserProxy;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2016/09/30.
 */
public class UserDaoImplTest {
    @Test
    public void add() throws Exception {
        IUserDao dao = new UserDaoImpl();
        IUserDao userProxy = new UserProxy(dao).createProxy();
        userProxy.add();
        userProxy.update();
    }

    @Test
    public void update() throws Exception {

    }

}