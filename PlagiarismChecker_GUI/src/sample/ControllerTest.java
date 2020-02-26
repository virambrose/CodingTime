package sample;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    private Controller process =new Controller();

    @org.junit.jupiter.api.Test
    void make() {
        //TEST THAT THE QUEUE TO MAKE MATRIX HAS NO ERRORS
        process.matrix_maker.add("1.00");
        assertEquals("1.00",process.matrix_maker.peek());
    }

    @org.junit.jupiter.api.Test
    void getter() {
        process.getter("C:\\Users\\ambro\\Downloads\\UNZIPPED");

        //TEST IF ALL THE FILES ARE COMBINED IN THE MASHER
        assertEquals(true,process.masher.isEmpty());

        //TEST IF A FILES IS SUCCESSFULLY COMBINED
        assertEquals("D:\\Coding\\PlagiarismChecker_GUI\\combine3.txt",process.access_paths.peek());

        //TEST IF ALL THE COMBINED FILES ARE ADDED
        assertEquals(19,process.access_paths.size());


    }

    @org.junit.jupiter.api.Test
    void compare() throws Exception {
        process.directory_path=("C:\\Users\\ambro\\Downloads\\UNZIPPED");
        process.compare(process.paths);

        //TEST TO SEE IF THE SCORES ARE STORED IN THE MATRIX_MAKER QUEUE
        assertEquals(false,process.matrix_maker.isEmpty());
    }
}