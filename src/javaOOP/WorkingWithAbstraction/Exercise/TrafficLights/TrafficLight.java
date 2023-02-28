package javaOOP.WorkingWithAbstraction.Exercise.TrafficLights;

public enum TrafficLight {
    RED, GREEN, YELLOW;

    public String changeSignal(String signal){
        boolean foundColor = false;
        for (TrafficLight light : TrafficLight.values()){
            if (foundColor){
                return light.name();
            }
            if (light.name().equals(signal)){
                foundColor = true;
            }
        }
        return "RED";

    }
}
