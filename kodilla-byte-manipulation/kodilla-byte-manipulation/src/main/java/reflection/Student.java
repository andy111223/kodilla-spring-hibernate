package reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.stream.Collectors;

public class Student {

    private static final Logger logger = LoggerFactory.getLogger(Student.class);
    private String indexNumber;

    public Student(int z) {
        this.indexNumber = generateRandomString(z);
        logger.info("Generated index number: {}", indexNumber);
    }

    private String generateRandomString(int z) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random random = new Random();
        return random.ints(z, 0, candidateChars.length())
                .mapToObj(i -> String.valueOf(candidateChars.charAt(i)))
                .collect(Collectors.joining());
    }

    public String getIndexNumber() {
        return indexNumber;
    }
}
