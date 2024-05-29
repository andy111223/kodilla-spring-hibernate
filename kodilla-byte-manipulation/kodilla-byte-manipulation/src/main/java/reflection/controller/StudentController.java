package reflection.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import reflection.Student;


@RestController
@RequestMapping("/v1/students")
public class StudentController {

    @PostMapping("/generate")
    public Map<Integer, String> generateStudents(@RequestParam(defaultValue = "20") int n,
                                                 @RequestParam(defaultValue = "10") int z) throws NoSuchFieldException, IllegalAccessException {
        Map<Integer, String> resultMap = new HashMap<>();

        Field indexField = Student.class.getDeclaredField("indexNumber");
        indexField.setAccessible(true);

        for (int i = 0; i < n; i++) {

            Student student = new Student(z);
            String indexNumber = (String)indexField.get(student);
            resultMap.put(System.identityHashCode(student), indexNumber);
        }
        return resultMap;
    }

}
