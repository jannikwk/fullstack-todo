import { TodoForm } from './TodoForm';
import { TodoList } from './TodoList';
import { useTodos } from '../hooks/useTodos';


export function TodoApp() {
    const { todos, addTodo, toggleTodo, deleteTodo } = useTodos();

    return (
        <main>
            <h1 className="todoPage-title">My Fullstack TodoApp</h1>
            <TodoForm onAdd={addTodo} />

            <h2 className="task-header">My tasks</h2>
            <TodoList todos={todos} onToggle={toggleTodo} onDelete={deleteTodo} />
        </main>
    )
}