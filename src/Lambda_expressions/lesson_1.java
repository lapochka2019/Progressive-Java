package Lambda_expressions;
//лямбдв выражения позволяют передать кусок кода в метод
//позволяют обойтись без анонимных классов
//повялись в 8 версии

interface Executable{
    int execute();
}

//class ExecutableImplementation implements Executable{
//
//    @Override
//    public void execute() {
//        System.out.println("Hello!");
//    }
//}

class Runner{
    public void run(Executable e){
       int a = e.execute();
        System.out.println(a);
    }
}

public class lesson_1 {
    public static void main(String[] args) {
        //*Thread thread = new Thread(() -> System.out.println("Hello!"));*//
        //Thread thread = new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                System.out.println("Hello!");
        //            }
        //        });

        //Runner runner = new Runner();
        //runner.run(new ExecutableImplementation());
        //runner.run(new Executable() {
        //    @Override
        //    public void execute() {
        //        System.out.println("Hello");
        //    }
        //});
        //
        //runner.run(()-> System.out.println("Hello!"));

        Runner runner = new Runner();
        runner.run(new Executable() {
            @Override
            public int execute() {
                System.out.println("Hello");
                System.out.println("Good");
                return 1;
            }
        });

        runner.run(() -> {
            System.out.println("Hello");
            System.out.println("Good");
            return 6;
        });

        //runner.run(() -> 10); // просто возвращаем число
        //runner.run(x -> 10+x);//java значет тип данных Х;
        //если один аргумент, то можно не писать скобки
        //можем реализовать только 1 метод,
        //если в интерфейсе 2 и более методов, то нужно создавать ананимный класс

        /** int a = 1;
         * runner.run(x -> x+a);
         * int a=1;
         * a=2;
         * runner.run(x -> x+a); --> ERROR
         **/
        //у люмбда выражения нет области видимости (такое же как у внешенго метода)



    }
}

