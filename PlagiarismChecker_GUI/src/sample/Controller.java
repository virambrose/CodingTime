/*
---------------------------------------------------------------
Program Similarity Checker By: Ambrose BOMBITA & John SEE

Note:
The comments are for guidance and removing the "System.out"s
will result to showing the process of checking and combining
files in a specific directory.

---------------------------------------------------------------
*/

package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Controller {

    public TextField directoryText;
    public AnchorPane newPane;

    public void compute() throws Exception {
        Queue<String> masher = new LinkedList<>(); //MASHER MEANING QUEUE FOR COMBINING
        Queue<String> access_paths = new LinkedList<>(); //DIRECTORY NAMES THAT WILL BE COMPARED
        Queue<String> matrix_maker = new LinkedList<>();//FOR THE PLAGIARISM SCORES
        String[] paths = new String[100];

        //THIS IF FOR THE CHECKING FOR COMPARISON OF FILES
        double same_counter = 0;
        double line_counter1 = 0;
        double line_counter2 = 0;
        double line_total;

        // 2 CHECKERS TO CHECK IF JAVA OR C++ FILES ARE IN THE SAME FOLDER
        String check="";
        String check_front="";

        //THIS IS FOR THE GUI LAYOUT
        int spacerX;
        int spacerY = 20;

        //THIS IS FOR GETTING ALL THE JAVA FILES IN THE FOLDER
        try (Stream<Path> walk = Files.walk(Paths.get(directoryText.getText()))) {

            List<String> output = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".java")).collect(Collectors.toList());

            //FILE COMBINER FOR JAVA

            for(int i=0;i<output.size();i++) {

                if(i>0) {
                    check = output.get(i-1);
                    //System.out.println(check);
                }

                if(i<(output.size()-1)){
                    check_front = output.get(i+1);
                }

                if(check.contains(output.get(i).substring(34,53))==true){
                    masher.add(output.get(i));
                    //System.out.println("added to masher: "+output.get(i));

                    while (masher.size() > 1) {
                        PrintWriter maker = new PrintWriter("combine" + i + ".txt");

                        //System.out.print(i+" = ");
                        //System.out.println(masher.peek());

                        BufferedReader c_read1 = new BufferedReader(new FileReader(masher.remove()));
                        BufferedReader c_read2 = new BufferedReader(new FileReader(masher.remove()));

                        String filetext1 = c_read1.readLine();
                        String filetext2 = c_read2.readLine();

                        while (filetext1 != null || filetext2 != null) {
                            if (filetext1 != null) {
                                maker.println(filetext1);
                                filetext1 = c_read1.readLine();
                            }

                            if (filetext2 != null) {
                                maker.println(filetext2);
                                filetext2 = c_read2.readLine();
                            }
                        }

                        maker.flush();

                        c_read1.close();
                        c_read2.close();
                        maker.close();

                        masher.add("D:\\Coding\\PlagiarismChecker_GUI\\combine" + i + ".txt");
                        //System.out.println("added to masher: "+"D:\\Coding\\PlagiarismChecker_GUI\\combine" + i + ".txt");
                    }
                }
                else {

                    if(masher.isEmpty()==false) {
                        //System.out.println("added to access_paths: " + masher.peek());
                        access_paths.add(masher.remove());
                    }
                    else{

                        if (check_front.contains(output.get(i).substring(34, 53)) == true) {
                            masher.add(output.get(i));
                            //System.out.println("added to masher: "+output.get(i));
                        }
                        else{
                            //System.out.println("added to access_paths: " + output.get(i));
                            access_paths.add(output.get(i));
                        }

                    }
                }
                check="";
                check_front="";
            }

            //-------------------------------------------------------------------------------------------------------//

        } catch (IOException e) {
            e.printStackTrace();
        }

        //THIS IS FOR GETTING ALL THE C++ FILES IN THE FOLDER
        try (Stream<Path> walk = Files.walk(Paths.get(directoryText.getText()))) {

            List<String> output = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".cpp")).collect(Collectors.toList());

            //FILE COMBINER FOR C++

            for(int i=0;i<output.size();i++) {

                if(i>0) {
                    check = output.get(i-1);
                    //System.out.println(check);
                }

                if(i<(output.size()-1)){
                    check_front = output.get(i+1);
                }

                if(check.contains(output.get(i).substring(34,53))==true){
                    masher.add(output.get(i));
                    //System.out.println("added to masher: "+output.get(i));

                    while (masher.size() > 1) {
                        PrintWriter maker = new PrintWriter("combine 0" + i + ".txt");

                        //System.out.print(i+" = ");
                        //System.out.println(masher.peek());

                        BufferedReader c_read1 = new BufferedReader(new FileReader(masher.remove()));
                        BufferedReader c_read2 = new BufferedReader(new FileReader(masher.remove()));

                        String filetext1 = c_read1.readLine();
                        String filetext2 = c_read2.readLine();

                        while (filetext1 != null || filetext2 != null) {
                            if (filetext1 != null) {
                                maker.println(filetext1);
                                filetext1 = c_read1.readLine();
                            }

                            if (filetext2 != null) {
                                maker.println(filetext2);
                                filetext2 = c_read2.readLine();
                            }
                        }

                        maker.flush();

                        c_read1.close();
                        c_read2.close();
                        maker.close();

                        masher.add("D:\\Coding\\PlagiarismChecker_GUI\\combine 0" + i + ".txt");
                        //System.out.println("added to masher: "+"D:\\Coding\\PlagiarismChecker_GUI\\combine 0" + i + ".txt");

                        if(i==(output.size()-1)){
                            //System.out.println("added to access_paths: " + masher.peek());
                            access_paths.add(masher.remove());
                        }
                    }
                }
                else {
                    if(masher.isEmpty()==false) {
                        //System.out.println("added to access_paths: " + masher.peek());
                        access_paths.add(masher.remove());
                    }
                    else{

                        if (check_front.contains(output.get(i).substring(34, 53)) == true) {
                            masher.add(output.get(i));
                            //System.out.println("added to masher: "+output.get(i));
                        }
                        else{
                            //System.out.println("added to access_paths: " + output.get(i));
                            access_paths.add(output.get(i));
                        }
                    }
                }
                check="";
                check_front="";
            }

            //-------------------------------------------------------------------------------------------------------//

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(access_paths.size());
        int total_files = access_paths.size();

        for(int i=0;i<total_files;i++) {
            System.out.println(access_paths.peek());
            paths[i] = access_paths.remove();
        }

        for(int i=0;i<total_files;i++) {
            for (int j = 0; j < total_files; j++) {
                File file1 = new File(paths[i]);
                File file2 = new File(paths[j]);

                BufferedReader reader1 = new BufferedReader(new FileReader(file1));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2));

                String text1 = reader1.readLine();
                String text2 = reader2.readLine();

                //System.out.println(text1);

                while (text1 != null && text2 != null) {
                    if (text1.equalsIgnoreCase(text2)) {
                        same_counter++;
                    }

                    text1 = reader1.readLine();
                    text2 = reader2.readLine();
                }

                BufferedReader reader3 = new BufferedReader(new FileReader(file1));
                BufferedReader reader4 = new BufferedReader(new FileReader(file2));

                text1 = reader3.readLine();
                text2 = reader4.readLine();

                while (text1 != null) {
                    text1 = reader3.readLine();
                    line_counter1++;
                }

                while (text2 != null) {
                    text2 = reader4.readLine();
                    line_counter2++;
                }

                line_total = (line_counter1 + line_counter2) / 2;

                //System.out.println("Number of lines that are the same: " + same_counter);
                //System.out.println("Total number of lines: " + line_total);

                double score = ((same_counter / line_total)-0.5) * 2;
                if (score==1){
                    matrix_maker.add("1.00");
                }
                else if(score==-1){
                    matrix_maker.add("-1.00");
                }
                else {

                    matrix_maker.add(new DecimalFormat("#.##").format(score));
                }

                line_counter1=0;
                line_counter2=0;
                same_counter=0;
            }
        }

        //LAYOUT MAKER
        for (int c = 0; c < total_files; c++) {
            spacerX=40;

            for (int d = 0; d < total_files; d++) {
                Rectangle rect;
                Label data;
                rect = new Rectangle(spacerX-5,spacerY-2,65,30);
                rect.setStroke(Color.BLACK);
                double score = Double.parseDouble(matrix_maker.peek());
                if(score>0){
                    rect.setFill(Color.RED);
                }
                else if(score<=0){
                    rect.setFill(Color.GREEN);
                }
                data = new Label(matrix_maker.remove());
                data.setLayoutX(spacerX);
                data.setLayoutY(spacerY);
                data.setFont(new Font(18));
                newPane.getChildren().addAll(rect,data);

                spacerX = spacerX +65;
            }

            spacerY=spacerY+30;
        }
    }
}
