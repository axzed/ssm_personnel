import com.axzed.bean.AdminInfo;
import com.axzed.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAdmin {

    @Autowired
    private AdminService adminService;

    @Test
    public void testLogin() {
        AdminInfo admin = adminService.login("admin", "123");
        System.out.println(admin);
    }


}
