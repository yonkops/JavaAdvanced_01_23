package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.List;

public class MagicianRepositoryImpl implements MagicianRepository {
    List<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public List<Magician> getData() {
        return this.data;
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        if (data.contains(model)) {
            data.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Object findByUsername(String name) {
        for (Magician magician : data) {
            if (magician.getUsername().equals(name)) {
                return magician;
            }
        }
        return null;
    }
}
