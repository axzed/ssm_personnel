import com.axzed.bean.AdminInfo;
import com.axzed.service.AdminService;
import com.axzed.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestAdmin {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Test
    public void testList() {
        List<AdminInfo> adminInfos = userService.showAll();
        System.out.println(adminInfos);
    }

    @Test
    public void testLogin() {
        AdminInfo admin = adminService.login("admin", "123");
        System.out.println(admin);
    }

    @Test
    public void testSearch() {
        List<AdminInfo> adminInfos = userService.search("张");
        for (AdminInfo adminInfo : adminInfos) {
            System.out.println(adminInfo);
        }
    }

    @Test
    public void testDelete() {
        int i = userService.delete(7);
        System.out.println(i);
    }

    @Test
    public void testAdd() {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setUsername("test7");
        adminInfo.setNickname("李寻欢");
        adminInfo.setPassword("123");
        userService.add(adminInfo);
    }


}
