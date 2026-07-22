import { useState } from "react";

interface TodoFormProps {
    onAdd: (text: string) => void
}

export function TodoForm({ onAdd }: TodoFormProps) {
    const [taskText, setTaskText] = useState('');

    const handleAddTask = (e: React.SubmitEvent<HTMLFormElement>) => {
        e.preventDefault();

        if (!taskText || !taskText.trim()) return;

        onAdd(taskText);
        setTaskText('');
    }

    return (
        <form className="todo-form" onSubmit={handleAddTask}>
            <input className="todo-input" type="text"
                placeholder="Enter a task..."
                value={taskText}
                name="taskInput"
                onChange={(e) => setTaskText(e.target.value)} />
            <button className="add-todo-btn" type="submit">Add Task</button>
        </form>
    );
}