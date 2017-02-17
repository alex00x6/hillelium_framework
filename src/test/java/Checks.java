import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

/**
 * Created by alex00x6 on 17.02.17.
 */
public class Checks {
    @Test
    public void checkOS(){
        System.out.println(System.getProperty("os.name"));
        if (SystemUtils.IS_OS_LINUX){
            System.out.println("OS is Linux");
        }
        if (SystemUtils.IS_OS_WINDOWS) {
            System.out.println("OS is Windows");
        }
    }
}
