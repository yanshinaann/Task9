import arrayutils.ArrayUtils;

public class Task9 {
    public static void main(String[] args) throws Exception {

       fileInputOutputArray1();
       fileInputOutputArray2();
       System.out.println(result());
    }

    public static int[] Mas2toMas1(String name) {
        int[][] arr = ArrayUtils.readIntArray2FromFile(name);
        int[] arr1 = new int[arr.length * arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr1[i * arr[i].length + j] = arr[i][j];
            }
        }
        return arr1;
    }

    public static Point result() {
        int[] arrString1 = Mas2toMas1("input.txt");
        int[] arrString2 = Mas2toMas1("input1.txt");
        int temp = arrString1.length - arrString2.length;
        int i = 0, count = 0;
        boolean vis = true;
        for (int j = 0; j < arrString1.length; j++) {
            if (arrString1[j] == arrString2[i]) {
                if (vis) {
                    count = j;
                    vis = false;
                }
                if (i % arrString2.length == 1)
                    j += temp;
                else i++;
            } else {
                i = 0;
                vis = true;
            }
        }
        return new Point(count % 5 + 1, count / 5 + 1);
    }


    public static void fileInputOutputArray1() throws Exception {
        // чтения массива
        int[][] arr = ArrayUtils.readIntArray2FromFile("input.txt");
        // вывод массива в консоль
        System.out.printf("\"Прочитанный массив 1\" массив:%n%s%n", ArrayUtils.toString(arr));
        // запись массива в файл
        ArrayUtils.writeArrayToFile("output.txt", arr);
    }

    public static void fileInputOutputArray2() throws Exception {
        // чтения массива
        int[][] arr = ArrayUtils.readIntArray2FromFile("input1.txt");
        // вывод массива в консоль
        System.out.printf("\"Прочитанный массив 2\" массив:%n%s%n", ArrayUtils.toString(arr));
        // запись массива в файл
        ArrayUtils.writeArrayToFile("output.txt", arr);
    }

}
