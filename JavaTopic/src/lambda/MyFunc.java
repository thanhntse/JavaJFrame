/* lambda: khái niệm khái quát hoá của các hàm toán học
    thí dụ: Lambda x, f : x -> 6x^2 - 5
    Cú pháp Lambda: (x) -> { biểu thức tính toán }
    Cú pháp Lambda còn được gọi là lập trình hàm, functional programming
 */
package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 *
 * @author hoang
 */
//tạo 1 interface có 1 hàm trừu tượng duy nhất (có thể có thêm các hàm đã 
//hàm 2 tham số double cho đầu ra là 1 double -> tổng quát hoá: 2 đầu vào 
public interface MyFunc<T, U, V> {

    public abstract V eval(T x, U y);

    public static void main(String[] args) {

        MyFunc<Double, Double, Double> f = new MyFunc<Double, Double, Double>() {
            @Override
            public Double eval(Double x, Double y) {
                return 5 * x * x - 6 * y + 5;
            }
        };
        System.out.println(f.eval(1.0, -1.0));

        MyFunc<Double, Double, Double> f2 = (x, y) -> {
            return 5 * x * x - 6 * y + 5;
        };
        System.out.println(f.eval(2.0, -2.0));
        //test BiPredicate: t <= u
        BiPredicate<Integer, Integer> bf = (t, u) -> {
            return t <= u; //To change body of generated lambdas, choose Tools | Templates.
        };
        System.out.println(bf.test(5, 7));
        // hàm tìm giá trị lơn nhất trong một list
        Function<List<Double>, Double> f3 = (t) -> {
            double result = Double.MIN_VALUE;
            for (Double x : t) {
                if (result < x) {
                    result = x;
                }
            }
            return result;
        };
        ArrayList<Double> L = new ArrayList();
        L.add(1.5);
        L.add(8.0);
        L.add(7.5);
        L.add(-1.5);
        L.add(10.5);
        double max = f3.apply(L);
        System.out.println(max);
    }
}// interface MyFunc
