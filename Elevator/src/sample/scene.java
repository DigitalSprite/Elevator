package sample;

import com.sun.deploy.xml.XMLable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.*;

/**
 * Created by Stephen on 4/23/2017.
 */
public class scene {
    public static Button[] button = new Button[45];
    public static Rectangle[] Rec = new Rectangle[5];
    public static Button[] button_up = new Button[9];
    public static Button[] button_down = new Button[9];
    public static Label[] Floor_Text = new Label[5];

    public Group Create_Scene(){
        Group root = new Group();
        Rectangle range_1 = new Rectangle(100, 1000);
        range_1.setX(0);
        range_1.setY(0);
        range_1.setFill(Color.ALICEBLUE);
        Rectangle range_2 = new Rectangle(1500, 60);
        range_2.setX(0);
        range_2.setY(0);
        range_2.setFill(Color.WHEAT);
        root.getChildren().add(range_2);
        Rectangle range_3 = new Rectangle(300, 1000);
        range_3.setX(1200);
        range_3.setY(0);
        range_3.setFill(Color.ALICEBLUE);
        root.getChildren().add(range_3);

        for(int i =0; i <= 4; i++){
            Floor_Text[i] = new Label("E" + String.valueOf(i + 1));
            Floor_Text[i].setFont(Font.font("Cambria", 32));
            Floor_Text[i].setLayoutX(220 + i * 200);
            Floor_Text[i].setLayoutY(10);
            root.getChildren().add(Floor_Text[i]);
        }
        root.getChildren().add(range_1);
        Label floor_1 = new Label("F9");
        floor_1.setFont(Font.font("Cambria", 32));
        floor_1.setLayoutX(40);
        floor_1.setLayoutY(70);
        floor_1.setTextAlignment(TextAlignment.CENTER);
        Label floor_2 = new Label("F8");
        floor_2.setFont(Font.font("Cambria", 32));
        floor_2.setLayoutX(40);
        floor_2.setLayoutY(140);
        Label floor_3 = new Label("F7");
        floor_3.setFont(Font.font("Cambria", 32));
        floor_3.setLayoutX(40);
        floor_3.setLayoutY(210);
        Label floor_4 = new Label("F6");
        floor_4.setFont(Font.font("Cambria", 32));
        floor_4.setLayoutX(40);
        floor_4.setLayoutY(280);
        Label floor_5 = new Label("F5");
        floor_5.setFont(Font.font("Cambria", 32));
        floor_5.setLayoutX(40);
        floor_5.setLayoutY(350);
        Label floor_6 = new Label("F4");
        floor_6.setFont(Font.font("Cambria", 32));
        floor_6.setLayoutX(40);
        floor_6.setLayoutY(420);
        Label floor_7 = new Label("F3");
        floor_7.setFont(Font.font("Cambria", 32));
        floor_7.setLayoutX(40);
        floor_7.setLayoutY(490);
        Label floor_8 = new Label("F2");
        floor_8.setFont(Font.font("Cambria", 32));
        floor_8.setLayoutX(40);
        floor_8.setLayoutY(560);
        Label floor_9 = new Label("F1");
        floor_9.setFont(Font.font("Cambria", 32));
        floor_9.setLayoutX(40);
        floor_9.setLayoutY(630);

        root.getChildren().add(floor_1);
        root.getChildren().add(floor_2);
        root.getChildren().add(floor_3);
        root.getChildren().add(floor_4);
        root.getChildren().add(floor_5);
        root.getChildren().add(floor_6);
        root.getChildren().add(floor_7);
        root.getChildren().add(floor_8);
        root.getChildren().add(floor_9);

        for(int i = 0; i <= 4; i++){
            Rec[i] = new Rectangle(100, 40, Color.BURLYWOOD);
            Rec[i].setX(220 + i * 200);
            Rec[i].setY(630);
            root.getChildren().add(Rec[i]);
        }

        int length = 200;
        for(int i = 0; i <= 4; i++){
            int height = 700;
            for(int j = 0; j <= 2; j++){
                for(int k = 0; k <= 2; k++){
                    button[i * 9 + j * 3 + k] = new Button(String.valueOf(j * 3 + k + 1));
                    button[i * 9 + j * 3 + k].setLayoutX(length + k * 50);
                    button[i * 9 + j * 3 + k].setLayoutY(height);
                    root.getChildren().add(button[i * 9 + j * 3 + k]);
                }
                height += 50;
            }
            length += 200;
        }

        for(int i = 0; i <= 8; i++){
            button_up[i] = new Button("Up");
            button_up[i].setPrefSize(70, 30);
            button_up[i].setLayoutX(1250);
            button_up[i].setLayoutY(70 * (i + 1));
            button_down[i] = new Button("Down");
            button_down[i].setPrefSize(70, 30);
            button_down[i].setLayoutX(1350);
            button_down[i].setLayoutY(70 * (i + 1));
            root.getChildren().add(button_down[i]);
            root.getChildren().add(button_up[i]);
        }
        return root;
    }
}
