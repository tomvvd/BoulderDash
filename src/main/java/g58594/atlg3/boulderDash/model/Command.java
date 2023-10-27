package g58594.atlg3.boulderDash.model;

/**
 * This interface represents a command.
 */
public interface Command {
    /**
     * Executes a command
     */
    void execute();

    /**
     * Unexecutes a command
     */
    void unexecute();
}
