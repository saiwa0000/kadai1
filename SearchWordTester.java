import org.junit.Test;
import static org.junit.Assert.*;

public class SearchWordTester {
    @Test public void transfer() {
        Account a = new Account("sss", 1200);
        Account b = new Account("aaa", 2000);
        a.transfer(b, 1000);
        assertEquals(a.balance, 100);
    }
}
