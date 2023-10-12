import com.quancm.exaq.dao.UserDao;
import com.quancm.exaq.model.User;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class UserDaoTest {
    private final UserDao userDao = new UserDao();
    @Test
    public void testGetUserByUsername(){
        System.out.println(userDao.getUserByUsername("linhlm"));

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

    @Test
    public void testGetAvatarUrl(){
        String url = userDao.getUserAvatarByUsername("quancm0406");
        System.out.println(url);

    }

    @Test
    public void testSetAvatarUrl(){
        userDao.setUserAvatarByUsername("quancm0406", "https://scontent.fdad2-1.fna.fbcdn.net/v/t39.30808-6/311589770_618655386510215_7282103052719823683_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_ohc=_jR-vkVUm-gAX8KW1An&_nc_ht=scontent.fdad2-1.fna&oh=00_AfCzX0VPsexaeZboemdSz32gLQHEKlYPT144ii23lHQpfQ&oe=652D00FE");
    }



}
