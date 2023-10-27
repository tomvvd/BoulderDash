package g58594.atlg3.boulderDash.model;

import java.util.Stack;

/**
 * This class is responsible for managing commands.
 */
public class CommandManager {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    /**
     * Constructor of the class
     */
    public CommandManager() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    /**
     * Executes a given command, adds the command to undostack,
     * and clears the redostack.
     * @param command Command type
     */
    public void addCommand(Command command){
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }

    /**
     * Undoes a command
     */
    public void undo(){
        if(!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.unexecute();
            redoStack.push(command);
        }
    }

    /**
     * Redoes a command
     */
    public void redo(){
        if(!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }
}
