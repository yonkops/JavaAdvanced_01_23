package javaAdvanced.ExamPreparation.workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }
    public void addExercise(Exercise exercise){
        if (exercises.size() < exerciseCount){
            this.exercises.add(exercise);
        }
    }
    public boolean removeExercise(String name, String muscle){
       return exercises.removeIf(e -> e.getName().equals(name)&&e.getMuscle().equals(muscle));
    }
    public Exercise getExercise(String name, String muscle){
        for (Exercise exercise : exercises){
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)){
                return exercise;
            }
        }
        return null;
    }
    public Exercise getMostBurnedCaloriesExercise(){
        return this.exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories)).get();
    }
    public int getExerciseCount(){
        return exercises.size();
    }
    public String getStatistics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Workout type: ").append(this.type).append(System.lineSeparator());
        for (Exercise exercise : this.exercises){
            stringBuilder.append(exercise.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
