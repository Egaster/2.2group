package lab2.Task3;
public class Main3 {
    public static int modMethod(Example example, int a, int b){
        example.setA(a);
        example.setB(b);
        return example.getA();
    }

    /* Нет смысла создавать метод доступа, возвращающий тип void. Он будет менять значения только локальные переменные.
     * Любое изменение переменной, которая будет сохранять новое (измененное) значение, будет считаться действием по реализации
     * модифицирующего метода */

    public static void main(String[] args) {
        Example example = new Example();
        System.out.println(example.getA());
        System.out.println(modMethod(example,10,15));
    }
}
