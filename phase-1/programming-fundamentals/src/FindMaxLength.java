public class FindMaxLength {
    public static void main(String[] args) {
        String[] data = {"Kasun","Ruwan Sampath", "nuwan","Kussum","Supun Adikari"};
        findTheLongest(data);
    }
    public static void findTheLongest(String[] data){
        int maxIndex = 0;
        for (int i = 1; i < data.length ; i++){
            if (data[i].length() > data[maxIndex].length()){
                maxIndex = i;
            }

        }
        System.out.println(data[maxIndex]);

    }
}
