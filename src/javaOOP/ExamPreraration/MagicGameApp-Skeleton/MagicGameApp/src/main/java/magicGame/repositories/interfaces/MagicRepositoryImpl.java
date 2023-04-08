package magicGame.repositories.interfaces;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

import java.util.ArrayList;
import java.util.Collection;

public class MagicRepositoryImpl implements MagicRepository{
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }
    @Override
    public Collection getData() {
        return data;
    }

    @Override
    public void addMagic(Magic model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        data.add(model);
    }

    @Override
    public boolean removeMagic(Magic model) {
        if (data.contains(model)) {
            data.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Object findByName(String name) {
        for (Magic magic : data) {
            if (magic.getName().equals(name)) {
                return magic;
            }
        }
        return null;
    }
}
