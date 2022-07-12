import com.axzed.bean.AdminInfo;
import com.axzed.service.UserService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestPage {

    @Autowired
    private UserService userService;

    @Test
    public void page() {
        PageHelper.startPage(1,3);
        List<AdminInfo> adminInfos = userService.showAll();
        for (AdminInfo adminInfo : adminInfos) {
            System.out.println(adminInfo);
        }
    }

}
