package reflection.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import reflection.Student;
import reflection.validation.Range;

@Validated
@RestController
@RequestMapping("/v1/students")
public class StudentController {

    @PostMapping("/generate")
    public Map<Integer, String> generateStudents(
            @RequestParam(defaultValue = "20") @Range(min = 1, max = 100) int n,
            @RequestParam(defaultValue = "10") @Range(min = 1, max = 20) int z) throws NoSuchFieldException, IllegalAccessException {
        Map<Integer, String> resultMap = new HashMap<>();

        Field indexField = Student.class.getDeclaredField("indexNumber");
        indexField.setAccessible(true);

        for (int i = 0; i < n; i++) {
            Student student = new Student(z);
            String indexNumber = (String) indexField.get(student);
            resultMap.put(System.identityHashCode(student), indexNumber);
        }
        return resultMap;
    }
}