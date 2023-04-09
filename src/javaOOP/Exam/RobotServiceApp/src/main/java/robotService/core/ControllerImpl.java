package robotService.core;

import robotService.entities.robot.*;
import robotService.entities.services.*;
import robotService.entities.supplements.*;
import robotService.repositories.SupplementRepository;
import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller{

    private SupplementRepository supplements;
    private Map<String, Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new LinkedHashMap<>();
    }

    @Override
    public String addService(String type, String name) {
        Service service;
        if (type.equals("MainService")) {
            service = new MainService(name);
            services.put(name, service);
        } else if (type.equals("SecondaryService")) {
            service = new SecondaryService(name);
            services.put(name, service);
        } else {
            throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        Supplement supplement;
        if (type.equals("PlasticArmor")) {
            supplement = new PlasticArmor();
            supplements.addSupplement(supplement);
        } else if (type.equals("MetalArmor")) {
            supplement = new MetalArmor();
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
        BaseRobot robot;
        if (robotType.equals("FemaleRobot")) {
            robot = new FemaleRobot(robotName,robotKind, price);
        } else if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName,robotKind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        if (!robot.getService().equals(service.getClass().getSimpleName())) {
            return UNSUITABLE_SERVICE;
        }
        service.addRobot(robot);
        return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
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
