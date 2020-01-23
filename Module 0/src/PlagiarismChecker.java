import java.io.*;
public class PlagiarismChecker {
    public static void main(String[] args) throws Exception {
        float same_counter = 0;
        float line_counter1 = 0;
        float line_counter2 = 0;
        float line_total;

        File file1 = new File("D:\\Coding\\LBYCP2D\\Module 0\\test_program1.java");
        File file2 = new File("D:\\Coding\\LBYCP2D\\Module 0\\test_program2.java");

        BufferedReader reader1 = new BufferedReader(new FileReader(file1));
        BufferedReader reader2 = new BufferedReader(new FileReader(file2));

        String text1 = reader1.readLine();
        String text2 = reader2.readLine();

        while(text1!=null&&text2!=null){
            if(text1.equalsIgnoreCase(text2)){
                same_counter++;
            }

            text1 = reader1.readLine();
            line_counter1++;
            text2 = reader2.readLine();
            line_counter2++;
        }

        line_total = (line_counter1+line_counter2)/2;
        System.out.println("Number of lines that are the same: "+same_counter);
        System.out.println("Total number of lines: "+line_total);

        float score = same_counter/line_total*100;
        System.out.println("Your plagiarism score is: "+score+"%");
    }
}
