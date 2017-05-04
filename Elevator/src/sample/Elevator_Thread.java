package sample;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;


/**
 * Created by Stephen on 4/23/2017.
 */
public class Elevator_Thread extends Controller implements Runnable{
    private final int Elevator_Id;
    public int Moving_Direction;    //0 for still, 1 for up, 2 for down

    Elevator_Thread(int elevator_Id){
        this.Elevator_Id = elevator_Id;
        Moving_Direction = 0;
    }

    public void run(){
        try{
            while(true){
                while (Up_Call[Elevator_Id].isEmpty() && Down_Call[Elevator_Id].isEmpty()){
                    Thread.sleep(1000);
                    //System.out.println("sleep!");
                }
                //System.out.println("awake!");
                while(!Up_Call[Elevator_Id].isEmpty()){
                    while(Current_floor[Elevator_Id] < Up_Call[Elevator_Id].get(0)){
                        Move_Up();
                    }
                    Stop_Moving();
                    Up_Call[Elevator_Id].remove(0);
                }
                while(!Down_Call[Elevator_Id].isEmpty()){
                    if(!Down_Call[Elevator_Id].isEmpty() && Current_floor[Elevator_Id] < Down_Call[Elevator_Id].get(0)){
                        while(Current_floor[Elevator_Id] < Down_Call[Elevator_Id].get(0)){
                            Move_Up();
                        }
                        Stop_Moving();
                        Down_Call[Elevator_Id].remove(0);
                    }
                    while(Current_floor[Elevator_Id] != Down_Call[Elevator_Id].get(0)){
                        Move_Down();
                    }
                    Stop_Moving();
                    Down_Call[Elevator_Id].remove(0);
                }
            }
        }catch (Exception e){
            System.out.println("Error Warning!");
        }
    }

    public void Move_Up(){
        try{
            if(Current_floor[Elevator_Id] < 9){
                Thread.sleep(1000);
                Rec[Elevator_Id].setY(Rec[Elevator_Id].getY() - 70);
                Current_floor[Elevator_Id]++;
                Moving_Direction = 1;
            }
        }catch (Exception e){
            System.out.println("Moving Error");
        }
    }

    public void Move_Down(){
        try{
            if(Current_floor[Elevator_Id] > 1){
                Thread.sleep(1000);
                Rec[Elevator_Id].setY(Rec[Elevator_Id].getY() + 70);
                Current_floor[Elevator_Id]--;
                Moving_Direction = 2;
            }
        }catch (Exception e){
            System.out.println("Moving Error");
        }

    }

    public void Stop_Moving(){
        try {
            Thread.sleep(500);
            Rec[Elevator_Id].setFill(Color.GOLD);
            Thread.sleep(500);
            Rec[Elevator_Id].setFill(Color.BURLYWOOD);
            Moving_Direction = 0;
        }catch (Exception e){
            System.out.println("Stopping error");
        }
        Moving_Direction = 0;
    }
}
