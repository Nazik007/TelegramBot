package default_set;

import java.util.List;

public abstract class Bank {
    protected final String commandName;
    protected String name;

    public abstract List<Exchange> getExchangeList();

    public Bank(String commandName, String name) {
        this.commandName = commandName;
        this.name = name;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
