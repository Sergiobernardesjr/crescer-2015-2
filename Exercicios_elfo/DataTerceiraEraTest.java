

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void testarSeAnoÉBissesto(){
        DataTerceiraEra data = new DataTerceiraEra(11,02,2016);
        assertTrue(data.ehBissesto());
    }
}
