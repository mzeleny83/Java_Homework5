import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFile {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("kvetiny.txt"))) {
            writer.println("Fialka\tPopis_fialky\t3\t2021-05-12\t2021-01-01");
            writer.println("Růže\tKrásná růže\t3\t2021-05-12\t2021-01-01");
            writer.println("Kaktus\tNenáročný\t14\t2021-05-12\t2021-01-01");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
