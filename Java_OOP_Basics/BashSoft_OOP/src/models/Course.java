package models;

import exceptions.DuplicateEntryInStructureException;
import exceptions.InvalidStringException;
import io.OutputWriter;

import java.util.LinkedHashMap;

public class Course {
    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK = 100;

    private String name;
    private LinkedHashMap<String, Student> studentsByName;

    public Course(String name) {
        this.setName(name);
        this.studentsByName = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public LinkedHashMap<String, Student> getStudentsByName() {
        return this.studentsByName;
    }

    private void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStringException();
        }

        this.name = name;
    }

    public void enrollStudent(Student student) {

        try {
            if (this.studentsByName.containsKey(student.getUserName())) {
                throw new DuplicateEntryInStructureException(student.getUserName(), this.getName());
            }

            this.studentsByName.put(student.getUserName(), student);

        } catch (DuplicateEntryInStructureException e) {
            OutputWriter.displayException(e.getMessage());
        }

    }
}
