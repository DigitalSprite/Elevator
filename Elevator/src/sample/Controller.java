package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Controller extends scene{
    public static Thread thread[] = new Thread[5];
    public static Elevator_Thread elevator_thread[] = new Elevator_Thread[5];
    public static ArrayList<Integer>[] Up_Call = new ArrayList[5];
    public static ArrayList<Integer>[] Down_Call = new ArrayList[5];
    public static int Current_floor[] = new int[5];
    public static boolean[] Is_Prepared = new boolean[5];

    public static void Allocate_Task(){
        for(int i = 0; i <= 4; i++){
            Up_Call[i] = new ArrayList<Integer>();
            Down_Call[i] = new ArrayList<Integer>();
            Current_floor[i] = 1;
            Is_Prepared[i] = true;
            elevator_thread[i] = new Elevator_Thread(i);
            thread[i] = new Thread(elevator_thread[i]);
            thread[i].start();
        }
        MouseAdapter numButtonAction = new Elevator_Thread.numAction();
        for(int i = 0; i <= 44; i++){
            int elevator_line = i / 9;  //0~4
            int elevator_floor = i % 9 + 1;

            button[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try{
                        if(elevator_floor > Current_floor[elevator_line]){
                            Up_Call[elevator_line].add(elevator_floor);
                            Collections.sort(Up_Call[elevator_line]);
                        }
                        else if(elevator_floor < Current_floor[elevator_line]){
                            Down_Call[elevator_line].add(elevator_floor);
                            Collections.sort(Down_Call[elevator_line]);
                            Collections.reverse(Down_Call[elevator_line]);
                        }
                    } catch (Exception e){
                        System.out.println("Error!");
                    }

                }
            });
        }

        for(int i = 0; i <= 8; i++){
            int floor = 9 - i;
            button_up[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try{
                        int choose = 5;
                        int floor_distance = 10;
                        for(int j = 0; j <= 4; j++){
                            if(elevator_thread[j].Moving_Direction == 0){
                                if(Math.abs(floor - Current_floor[j]) < floor_distance){
                                    choose = j;
                                    floor_distance = Math.abs(floor - Current_floor[j]);
                                }
                            }
                            else if(elevator_thread[j].Moving_Direction == 1 && Current_floor[j] < floor){
                                if(floor - Current_floor[j] < floor_distance){
                                    floor_distance = floor - Current_floor[j];
                                    choose = j;
                                }
                            }
                        }
                        if(choose == 5){
                            Up_Call[0].add(floor);
                            Collections.sort(Up_Call[0]);
                        }
                        else {
                            if(Current_floor[choose] < floor){
                                Up_Call[choose].add(floor);
                                Collections.sort(Up_Call[choose]);
                            }
                            else{
                                Down_Call[choose].add(floor);
                                Collections.sort(Down_Call[choose]);
                                Collections.reverse(Down_Call[choose]);
                            }
                        }
                    }catch (Exception e){
                        System.out.println("Error!");
                    }
                }
            });

            button_down[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try{
                        int choose = 5;
                        int floor_distance = 10;
                        for(int j = 0; j <= 4; j++){
                            if(elevator_thread[j].Moving_Direction == 0){
                                if(Math.abs(floor - Current_floor[j]) < floor_distance){
                                    choose = j;
                                    floor_distance = floor - Current_floor[j];
                                }
                            }
                            else if(elevator_thread[j].Moving_Direction == 2 && Current_floor[j] > floor){
                                if(Current_floor[j] - floor < floor_distance){
                                    floor_distance = Current_floor[j] - floor;
                                    choose = j;
                                }
                            }
                        }
                        if(choose == 5){
                            Down_Call[0].add(floor);
                            Collections.sort(Down_Call[0]);
                        }
                        else {
                            if(Current_floor[choose] < floor){
                                Up_Call[choose].add(floor);
                                Collections.sort(Up_Call[choose]);
                            }
                            else{
                                Down_Call[choose].add(floor);
                                Collections.sort(Down_Call[choose]);
                                Collections.reverse(Down_Call[choose]);
                            }
                        }
                    }catch (Exception e){
                        System.out.println("Error!");
                    }
                }
            });
        }
    }

    public static class numAction extends MouseAdapter implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
        }
    }
}