package HW13;

import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Race {

    private ArrayList<HW13.Stage> stages;
    private CyclicBarrier barrier;
    private int winnerCount;
    private RaceStatus state;

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.barrier = initBarrier();
        this.state = RaceStatus.START;
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    public int getWinnerCount() {
        return winnerCount;
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    private enum RaceStatus{
        START, FINAL
    }

    private CyclicBarrier initBarrier(){
        return new CyclicBarrier(HomeWork13.CARS_COUNT, () ->{
            switch (state) {
                case FINAL -> System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                case START -> { System.out.println("\nВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"); state = RaceStatus.FINAL;}}
        });
    }

    public synchronized void finish(Car car) {
         if(winnerCount++ == 0){
            System.out.println();
            System.out.printf("ПОБЕДИТЕЛЬ %s\n", car.getName());
        } else {
            System.out.printf("%s пришел %s-й по счету\n", car.getName(), winnerCount);
        }
    }
}
