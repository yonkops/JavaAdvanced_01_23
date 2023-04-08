package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {


    private String username;

    private int health;

    private int protection;

    private boolean isAlive;

    private Magic magic;

    protected MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
        setAlive(true);
    }

    private void setUsername(String username) {
        if (username.trim().isEmpty() || username == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    private void setAlive(boolean alive) {
        isAlive = alive;
    }

    private void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }
    @Override
    public void takeDamage(int points) {
        this.protection -= points;
        if (this.protection < 0) {
            this.health += this.protection;
            this.protection = 0;
        }
        if (this.health <= 0) {
            this.health = 0;
            setAlive(false);
        }

    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public int getProtection() {
        return protection;
    }
    @Override
    public boolean isAlive() {
        return isAlive;
    }
    @Override
    public Magic getMagic() {
        return magic;
    }
    @Override
    public int getHealth() {
        return health;
    }
}
