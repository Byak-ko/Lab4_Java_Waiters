import java.util.Objects;

public class Fork {
    private String name;
    private boolean taken; // додали змінну для відстеження стану вилки

    public Fork(String name) {
        this.name = name;
        this.taken = false; // початково вважаємо, що вилка не використовується
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTaken() { // додали метод для перевірки стану вилки
        return taken;
    }

    public void setTaken(boolean taken) { // додали метод для зміни стану вилки
        this.taken = taken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fork fork)) return false;
        return Objects.equals(getName(), fork.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
