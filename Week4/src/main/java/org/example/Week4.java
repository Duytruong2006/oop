public class Week4 {

    public static int max2Int(int a, int b) {
        return (a > b) ? a : b;
    }

    public static int minArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Mảng không được rỗng");
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static String calculateBMI(double weight, double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Chiều cao phải > 0");
        }
        double bmi = Math.round((weight / (height * height)) * 10.0) / 10.0;

        if (bmi < 18.5) return "Thiếu cân";
        else if (bmi < 23) return "Bình thường";
        else if (bmi < 25) return "Thừa cân";
        else return "Béo phì";
    }
}
