import java.io.*;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<String> list = List.of("toto", "tutu", "titi");
        FileOutputStream fileOutputStream
                = new FileOutputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        List<String> list2 = (List<String>) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(list2);
    }
}
