package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    private SupplementRepository supplements;
    private Map<String, Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new LinkedHashMap();
    }

    @Override
    public String addService(String type, String name) {
        if (type.equals("MainService")) {
            Service service = new MainService(name);
            services.put(name, service);
        } else if (type.equals("SecondaryService")) {
            Service service = new SecondaryService(name);
            services.put(name, service);
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        if (type.equals("PlasticArmor")) {
            Supplement supplement = new PlasticArmor();
            supplements.addSupplement(supplement);
        } else if (type.equals("MetalArmor")) {
            Supplement supplement = new MetalArmor();
            supplements.addSupplement(supplement);
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement current = supplements.findFirst(supplementType);
        if (current == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        if (services.containsKey(serviceName)){
            Service service = services.get(serviceName);
            service.addSupplement(current);
            supplements.removeSupplement(current);
            return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
        }
        return null;

    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Service service = services.get(serviceName);
        String message;
        if (robotType.equals("FemaleRobot")) {
            Robot robot = new FemaleRobot(robotName,robotKind, price);
            if (service.getClass().getSimpleName().equals("SecondaryService")) {
                service.addRobot(robot);
                message = String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
            } else {
                message = UNSUITABLE_SERVICE;
            }
        } else if (robotType.equals("MaleRobot")) {
            Robot robot = new MaleRobot(robotName,robotKind, price);
            if (service.getClass().getSimpleName().equals("MainService")) {
                service.addRobot(robot);
                message = String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
            } else {
                message = UNSUITABLE_SERVICE;
            }
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        return message;
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = services.get(serviceName);
        service.feeding();
        return String.format(FEEDING_ROBOT, service.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = services.get(serviceName);
        double priceOfRobots = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        double priceOfSupplements = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();
        double sum = priceOfSupplements + priceOfRobots;
        return String.format(VALUE_SERVICE,serviceName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Service service : services.values()) {
            stringBuilder.append(service.getStatistics()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
