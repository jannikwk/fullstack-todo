import type { Todo } from "../types/Todo.type";

interface TodoItemProps {
    todo: Todo;
    onToggle: (id: number) => void;
    onDelete: (id: number) => void;
}

export function TodoItem({ todo, onToggle, onDelete }: TodoItemProps) {
    return (
        <li className="todo-item">
            <input
                type="checkbox"
                checked={todo.completed}
                onChange={() => onToggle(todo.id)}
                className="todo-checkbox" />
            <span className={`todo-text ${todo.completed ? 'completed' : ''}`}>
                {todo.taskText}
            </span>
            <button className="delete-btn" commandfor="deleteModal" command="show-modal">Delete</button>
            <dialog id="deleteModal" className="delete-modal">
                <p>Are you sure you want to delete this todo?</p>
                <div className="modal-actions">
                    <button className="cancel-btn" commandfor="deleteModal" command="close">Cancel</button>
                    <button
                        className="delete-btn"
                        onClick={() => { onDelete(todo.id); }}
                        commandfor="deleteModal"
                        command="close">Delete
                    </button>
                </div>
            </dialog>
        </li>
    );
}