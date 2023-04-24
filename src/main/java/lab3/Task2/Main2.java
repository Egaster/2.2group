package lab3.Task2;
import lab3.Employee;
import lab3.Measurable;

public class Main2{
    public static void main(String[] args) {
        Employee e1 = new Employee("Alex", 2);
        Employee e2 = new Employee("Marina", 0.1);
        Employee e3 = new Employee("Yura", 1);
        Measurable[] employees = {e1, e2, e3} ;
        System.out.println(largest(employees));
    }
    private static Measurable largest (Measurable[] objects){
        Measurable max = null;
        double maxSalary = 0;
        for (Measurable x: objects){
            if(maxSalary == 0){
                maxSalary = x.getMesurable();
                max = x;
            } else {
                if(maxSalary < x.getMesurable()){
                    maxSalary = x.getMesurable();
                    max = x;
                }
            }
        }
        return max;
    }
}
