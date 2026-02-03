package lab2;

public class TestModel
{
  public static void main(String[] args)
  {
        RabbitModel1 model = new RabbitModel1();

        // Check that the initial population is 2
        System.out.println(model.getPopulation());
        System.out.println("Expected 2");

        // A year goes by...
        model.simulateYear();
        System.out.println(model.getPopulation());
        System.out.println("Expected 3");

        // Start over
        model.reset();
        System.out.println(model.getPopulation());
        System.out.println("Expected 2");

        RabbitModel2 m2 = new RabbitModel2();

        m2.simulateYear();
        m2.simulateYear();
        m2.simulateYear();
        m2.simulateYear();

        System.out.println(m2.getPopulation());
        m2.simulateYear();

        System.out.println(m2.getPopulation());

        RabbitModel3 m3 = new RabbitModel3();
        System.out.println(m3.getPopulation());
        m3.simulateYear();
        System.out.println(m3.getPopulation());
        m3.simulateYear();
        System.out.println(m3.getPopulation());


        RabbitModel r5 = new RabbitModel();
        System.out.println(r5.getPopulation());

        r5.simulateYear();
        System.out.println(r5.getPopulation());

        r5.simulateYear();
        System.out.println(r5.getPopulation());

        r5.simulateYear();
        System.out.println(r5.getPopulation());

        r5.simulateYear();
        System.out.println(r5.getPopulation());

        r5.simulateYear();
        System.out.println(r5.getPopulation());

  }
}
