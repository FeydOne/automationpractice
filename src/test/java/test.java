import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by dburtescu on 10/17/2017.
 */
public class test {

    public static void main(String[] args) {
        Path currentRelativePath = Paths.get("");
        System.out.println(currentRelativePath.toAbsolutePath());
    }
}
