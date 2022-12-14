import java.sql.SQLException;
import database.studentData;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        studentData studentData = new studentData();
        studentData.readStudent("cam.robben@student.avans.nl");
        studentData.deleteStudent("sw.dekkers@student.avans.nl");
        studentData.createStudent("sw.dekkers@student.avans.nl", "Stefan Dekkers",
                "2005-01-01", "M",
                "Lovensdijkstraat 2", "Breda", "Nederland");

        studentData.updateStudent("sw.dekkers@student.avans.nl", "sw.dekkers@student.avans.nl", "Stefan Dekkers",
                "2005-01-01", "M", "Hogeschoollaan 1", "Breda", "Netherlands");
    }
}
