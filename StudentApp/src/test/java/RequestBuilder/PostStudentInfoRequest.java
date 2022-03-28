package RequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.student.model.Student;


public class PostStudentInfoRequest {

    public Student buildRequestBody(){
        //for a unique email
        UUID uniqueId = UUID.randomUUID();

        //for course list
        List<String> courses = new ArrayList<String>();
        courses.add("Chemistry");
        courses.add("BioChemistry");


        Student testStudent =  Student.builder()
                .courses(courses)
                .email( uniqueId+ "email@ymail.com")
                .firstName("Sam")
                .lastName("Jay")
                .programme("Science")
                .build();

        return testStudent;
    }


}
