package searchengine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Rafal Zawadzki
 */
public class MainControllerServiceTest {
    @Test
    public void testduplicateQuotaOne() throws Exception {
        String one = "he'j";
        String res = MainControllerService.duplicateQuota(one);

        assertEquals("he''j",res);
    }

    @Test
    public void testduplicateQuotaLast() throws Exception {
        String one = "hej'";
        String res = MainControllerService.duplicateQuota(one);

        assertEquals("hej''",res);
    }

    @Test
    public void testduplicateQuotaFirst() throws Exception {
        String one = "'hej";
        String res = MainControllerService.duplicateQuota(one);

        assertEquals("''hej",res);
    }

    @Test
    public void testduplicateQuotaMultiple() throws Exception {
        String one = "'h'ej";
        String res = MainControllerService.duplicateQuota(one);

        assertEquals("''h''ej",res);
    }

    @Test
    public void testduplicateQuotaAlone() throws Exception {
        String one = "'";
        String res = MainControllerService.duplicateQuota(one);

        assertEquals("''",res);
    }
}
