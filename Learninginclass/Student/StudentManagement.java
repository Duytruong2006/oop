public class StudentManagement {
    /** Danh sách sinh viên (tối đa 100). */
    Student[] students = new Student[100];

    /** Số lượng sinh viên hiện có trong danh sách. */
    int numOfStudent = 0;

    /**
     * Thêm một sinh viên mới vào danh sách.
     */
    public void addStudent(Student newStudent) {
        students[numOfStudent] = newStudent;
        numOfStudent++;
    }

    /**
     * Kiểm tra xem hai sinh viên có cùng nhóm hay không.
     */
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    /**
     * Liệt kê danh sách sinh viên theo từng nhóm.
     */
    public String studentsByGroup() {
        StringBuilder res = new StringBuilder();
        boolean[] check = new boolean[numOfStudent];

        for (int i = 0; i < numOfStudent; i++) {
            if (!check[i]) {
                String group = students[i].getGroup();
                res.append(group).append("\n");

                for (int j = i; j < numOfStudent; j++) {
                    if (!check[j] && students[j].getGroup().equals(group)) {
                        res.append(students[j].getInfo()).append("\n");
                        check[j] = true;
                    }
                }
            }
        }
        return res.toString();
    }

    /**
     * Xóa sinh viên có mã số (ID) được chỉ định khỏi danh sách.
     */
    public void removeStudent(String id) {
        for (int i = 0; i < numOfStudent; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < numOfStudent; j++) {
                    students[j] = students[j + 1];
                }
                students[numOfStudent] = null;
                numOfStudent--;
                break;
            }
        }
    }
}
