package football.core;


import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplement;
    private Map<String, Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {
        if (fieldType.equals("ArtificialTurf")){
            Field field = new ArtificialTurf(fieldName);
            fields.put(fieldName, field);
        } else if (fieldType.equals("NaturalGrass")){
            Field field = new NaturalGrass(fieldName);
            fields.put(fieldName, field);
        } else {
            throw new NullPointerException(INVALID_FIELD_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        if (type.equals("Liquid")) {
            supplement.add(new Liquid());
        } else if (type.equals("Powdered")) {
            supplement.add(new Powdered());
        } else {
            throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_FIELD_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement s = supplement.findByType(supplementType);
        if (s == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        Field field = fields.get(fieldName);
        field.addSupplement(s);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player p;
        if (playerType.equals("Women")) {
            p = new Women(playerName, nationality, strength);
        } else if (playerType.equals("Men")) {
            p = new Men(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        Field field = fields.get(fieldName);
        String output;
        if (!playerCanPlayOnFieldType(playerType, field)){
            output = FIELD_NOT_SUITABLE;
        } else {
            field.addPlayer(p);
            output = String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD,playerType, fieldName);
        }
        return output;
    }

    private boolean playerCanPlayOnFieldType(String playerType, Field field) {
        if (playerType.equals("Women") && field.getClass().getSimpleName().equals("ArtificialTurf")) {
            return true;
        } else if (playerType.equals("Men") && field.getClass().getSimpleName().equals("NaturalGrass")){
            return true;
        }
        return false;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.get(fieldName);
        field.drag();
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.get(fieldName);
        int sum = field.getPlayers()
                .stream()
                .mapToInt(Player::getStrength)
                .sum();
        return String.format(STRENGTH_FIELD, fieldName, sum);
    }

    @Override
    public String getStatistics() {
        return fields.values()
                .stream()
                .map(Field::getInfo)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
