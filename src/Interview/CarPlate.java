package Interview;

import java.util.*;

/**
 *  Given: a List<Car> with Car type and Plate Number.
 *  Fill in a map with Key: String carType ->
 *  Value: List<Car>: all cars that belongs to this type
 */

class Car {
    String type;
    String number;

    Car(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return type + ": " + number;
    }
}

public class CarPlate {
    public static void main(String[] args) {
        List<Car> carGroup = new ArrayList<>();
        Map<String, List<Car>> map = new HashMap<>();

        add(carGroup);
        carGroup.forEach(System.out::println);

        setMap(carGroup, map);
        map.forEach((a,b) -> System.out.println(a + b));
    }

    public static void setMap(List<Car> carGroup, Map<String, List<Car>> carMap) {
        for (Car c: carGroup) {
            String type = c.getType();
            List<Car> temp = carMap.getOrDefault(type, new ArrayList<>());
            temp.add(c);
            temp.sort(Comparator.comparing(Car::getNumber));
            carMap.put(type, temp);
        }
    }

    public static void add(List<Car> carGroup) {
        Car a = new Car("bmw", "231");
        Car b = new Car("bmw", "4312");
        Car c = new Car("bmw", "4121");
        Car d = new Car("audi", "231");
        Car dd = new Car("audi", "131");
        carGroup.add(a);
        carGroup.add(b);
        carGroup.add(c);
        carGroup.add(d);
        carGroup.add(dd);
    }
}
