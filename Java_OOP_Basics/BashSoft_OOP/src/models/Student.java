package models;

import exceptions.DuplicateEntryInStructureException;
import exceptions.InvalidStringException;
import exceptions.KeyNotFoundException;
import io.OutputWriter;
import staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class Student {
    private String userName;
    private LinkedHashMap<String, Course> enrolledCourses;
    public LinkedHashMap<String, Double> marksByCourseName;

    public Student(String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public String getUserName() {
        return this.userName;
    }

    public void enrollInCourse(Course course) {

        try {
            if (this.enrolledCourses.containsKey(course.getName())) {
                throw new DuplicateEntryInStructureException(this.userName, course.getName());
            }

            this.enrolledCourses.put(course.getName(), course);
        } catch (DuplicateEntryInStructureException e) {
            OutputWriter.displayException(e.getMessage());
        }
    }

    public void setMarkOnCourse(String courseName, int... scores) {

        try {
            if (! this.enrolledCourses.containsKey(courseName)) {
                throw new KeyNotFoundException();
            }

            if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
                OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
                return;
            }

            double mark = this.calculateMark(scores);
            this.marksByCourseName.put(courseName, mark);

        } catch (KeyNotFoundException e) {
            OutputWriter.displayException(e.getMessage());
        }

    }

    private void setUserName(String userName) {

        if (userName == null || userName.trim().isEmpty()) {
            throw new InvalidStringException();
        }

        this.userName = userName;
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolvedExam * 4 + 2;
        return mark;
    }
}
