import java.util.Objects;

public class Fork {
    private String name;
    private boolean taken; 

    public Fork(String name) {
        this.name = name;
        this.taken = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTaken() { 
        return taken;
    }

    public void setTaken(boolean taken) { 
        this.taken = taken;
    }
}
