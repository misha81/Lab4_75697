public class Task2 {
    public static void main(String[] args) {
        Car car = new Car("Corolla", "Toyota", 2022, 85000.0, "Blue", 5);

        System.out.println(car.toString());

        car.sell();

        System.out.println("Model: " + car.getModel());
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Year: " + car.getYear());
        System.out.println("Price: " + car.getPrice());
        System.out.println("Color: " + car.getColor());
        System.out.println("Quantity: " + car.getQuantity());

        car.setColor("Red");
        car.setPrice(79999.99);
        car.setYear(2023);

        System.out.println(car);
    }
}