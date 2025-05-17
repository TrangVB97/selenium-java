package example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//       ArrayList<HocSinh> hocSinhList = new ArrayList<HocSinh>();
//        String[] name = {"Mai", "Lan", "Hoa", "Huong", "Huyen", "Thao", "Trang", "Thuy", "Nhung", "Ngoc"};
//    for(int i = 0; i < 10; i++){
//        int age = new Random().nextInt(18,25);
//        double diemTrungBinh = new Random().nextInt(0,10);
//        String ten =name[new Random().nextInt(name.length)];
//        hocSinhList.add(new HocSinh(ten,age,diemTrungBinh));
//    }
//    hocSinhList.stream()
//            .filter(hocsinh -> hocsinh.xepLoai().equals("Xuất sắc"))
//            .forEach(HocSinh::hienThiThongTin);
//    hocSinhList.stream()
//            .filter(hocsinh -> hocsinh.getTuoi()>20)
//            .map(HocSinh::getTen)
//            .forEach(System.out::println);

//      1. Thay ky tu @ bang ky tu _
//        String str = new Scanner(System.in).nextLine();
//        System.out.println(str.replaceAll("@","_"));

//        2. Lay 4 ky tu cuoi cua chuoi
//        String str = new Scanner(System.in).nextLine();
//        int sz = str.length();
//        if (sz <4){
//            System.out.println("Chuoi qua ngan");
//        }
//        else {
//            System.out.println(str.substring(sz-4));
//        }

//        3. Tìm ký tự không lặp lại đầu tiên của một chuối
//        4. Tìm số lớn nhất và lớn thứ 2 của một mảng
//        List<Integer> arr = Arrays.asList(20,2,-3,11,5,12,7,8,-9,10);
//        int max1 = arr.stream().max(Integer::compare).get();
//        System.out.println(max1);
//        arr = arr.stream().filter(x -> x != max1).collect(Collectors.toList());
//        int max2 = arr.stream().max(Integer::compare).get();
//        System.out.println(max2);

//        5. Tìm độ lệch lớn nhất giữa 2 phần tử trong một mảng:
//        List<Integer> list = Arrays.asList(20,2,-3,11,5,12,7,8,-9,10);
//        int max = list.stream().max(Integer::compare).get();
//        int min = list.stream().min(Integer::compare).get();
//        System.out.println(max-min);

//        6/ Tìm vị trí của các số lặp lại trong mảng:
//        int[] arr = {4,2,3,5,1,2,4};
//        for (int i =0; i < arr.length - 1; i++){
//            for (int j = i+1; j < arr.length; j++){
//                if (arr[i] == arr[j]){
//                    System.out.println("Vi tri cua so lap lai: " + i + " " + j);
//                }
//            }
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i<arr.length; i++){
//            Integer mapValue = map.get(arr[i]);
//
//            if(mapValue==null){
//                map.put(arr[i], 1);
//            }
//            else{
//                map.put(arr[i], mapValue+1);
//            }
//        }
//        System.out.println(map);
//        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()){
//            if(mapEntry.getValue()>1){
//                System.out.println("Key: "+mapEntry.getKey()+" Value:"+mapEntry.getValue());
//            }
//        }

//        7/ Đưa các số âm trong mảng lên đầu:
//        List<Integer> arr = Arrays.asList(-1,2,3,-4,-7,8);
//        arr = arr.stream().sorted().collect(Collectors.toList());
//        System.out.println(arr);

//        8/ Tìm các chuỗi con trong 1 chuổi cho trước:
//        String str = "Xin chao";
//        for (int i=0; i <str.length(); i++) {
//            for (int j = i+1; j <= str.length(); j++){
//                System.out.println(str.substring(i,j));
//            }
//        }

//        9/ In ra ký tự đầu tiên của mỗi từ trong một câu:
//        String str = "  Xin  chao cac ban";
//        String[] split = str.trim().split("\\s+");
//        for(int i=0; i<split.length; i++){
//            String word = split[i];
//            System.out.print(word.charAt(0));
//        }
        
    }
}