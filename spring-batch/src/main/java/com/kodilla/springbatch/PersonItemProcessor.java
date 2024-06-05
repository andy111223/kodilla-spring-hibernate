package com.kodilla.springbatch;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PersonItemProcessor implements ItemProcessor<Person, ProcessedPerson> {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public ProcessedPerson process(final Person person) throws Exception {
        LocalDate birthDate = LocalDate.parse(person.getBirthdate(), dateFormatter);
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        ProcessedPerson processedPerson = new ProcessedPerson();
        processedPerson.setFirstName(person.getFirstName());
        processedPerson.setLastName(person.getLastName());
        processedPerson.setAge(age);

        return processedPerson;
    }
}
