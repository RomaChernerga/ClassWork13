package HW13;
/*Все участники должны стартовать одновременно, несмотря на разное время  подготовки.
В тоннель не может одновременно заехать больше половины участников (условность).
Попробуйте все это синхронизировать.
Первый участник, пересекший финишную черту, объявляется победителем (в момент пересечения этой самой черты).
Победитель должен быть только один (ситуация с 0 или 2+ победителями недопустима).
Когда все завершат гонку, нужно выдать объявление об окончании.
*/

public class HomeWork13 {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
//        Race race = new Race(new Road(60), new Tunnel(80), new Road(40));
        Race race = new Race(new Tunnel(70), new Road(20), new Tunnel(60));
        makeRace(race);
    }

    private static void makeRace(Race race) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
    }
}
