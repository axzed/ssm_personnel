import com.axzed.bean.DeptInfo;
import com.axzed.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDept {

    @Autowired
    private DeptService deptService;

    @Test
    public void testAdd() {
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setName("综合部");
        deptInfo.setRemark("综合部门啥都做");
        deptService.add(deptInfo);
    }

    @Test
    public void testDel() {
        int delete = deptService.delete(31);
        System.out.println(delete);
    }

    @Test
    public void testModify() {
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setId(6);
        deptInfo.setName("教育部");
        deptInfo.setRemark("负责教学");
        int i = deptService.modify(deptInfo);
        System.out.println(i);
    }

    @Test
    public void testDeptEmployee() {
        List<Map<String, Object>> maps = deptService.employeeCount();
        System.out.println(maps);
    }

}
