import com.axzed.bean.JobInfo;
import com.axzed.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestJob {

    @Autowired
    private JobService jobService;

    @Test
    public void testShowAll() {
        List<JobInfo> jobInfos = jobService.showAll();
        for (JobInfo jobInfo : jobInfos) {
            System.out.println(jobInfo);
        }
    }

    @Test
    public void testPageByCondition() {
        JobInfo jobInfo = new JobInfo();
        List<JobInfo> jobInfos = jobService.pageByCondition(jobInfo);
        for (JobInfo info : jobInfos) {
            System.out.println(info);
        }
    }

    @Test
    public void testAdd() {
        JobInfo jobInfo = new JobInfo();
        jobInfo.setName("Golang初级工程师");
        jobInfo.setRemark("能够熟练使用go语言编程");
        jobInfo.setDeptId(1);
        jobService.add(jobInfo);
    }

    @Test
    public void testDelAll() {
        int id = 14;
        int i = jobService.delete(id);
        System.out.println(i);
    }

    @Test
    public void testModify() {
        JobInfo jobInfo = new JobInfo();
        jobInfo.setId(5);
        jobInfo.setName("架构师");
        jobInfo.setRemark("Java架构师");
        jobInfo.setDeptId(1);
        int i = jobService.modify(jobInfo);
        System.out.println(i);
    }

}
