import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class TestDate {


    @Test
    public void testDate(){
        System.out.println(LocalDate.now().getYear());
        Date date = Date.valueOf(LocalDate.now());
        System.out.println(date);
    }
}
