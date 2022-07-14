import com.axzed.service.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDocument {

    @Autowired
    private DocumentService documentService;

    @Test
    public void testDel() {
        int delete = documentService.delete(1);
        System.out.println(delete);
    }

}
