import com.quancm.exaq.dao.UserDao;
import com.quancm.exaq.model.User;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class UserDaoTest {
    private final UserDao userDao = new UserDao();
    @Test
    public void testGetUserByUsername(){
        System.out.println(userDao.getUserByUsername("duongn0206"));

    }

    @Test
    public void testAddUser(){
        User user = new User(
                "duongn0206",
                "12345678",
                "Ngo",
                "Duong",
                "student",
                new Date(2023, 10, 7)
        );

        userDao.addUser(user);
    }


    @Test
    public void testValidate(){
        User user = new User();
        user.setUsername("duongn0206abc");
        user.setPassword("12345678");

        System.out.println(userDao.validate(user));

    }


}
