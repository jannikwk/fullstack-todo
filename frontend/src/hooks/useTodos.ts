import { useState, useEffect } from 'react';
import type { Todo } from '../types/Todo.type';
import { getAllTodos, createTodo, updateTodo, deleteTodoApi } from "../services/todoApi";


export function useTodos() {
    const [todos, setTodos] = useState<Todo[]>([]);

    useEffect(() => {
        getAllTodos()
            .then(setTodos)
            .catch(console.error);
    }, []);

    const addTodo = (text: string) =>
        createTodo(text)
            .then(newTodo => setTodos(prev => [...prev, newTodo]))
            .catch(console.error);

    const toggleTodo = (id: string) => {
        const todo = todos.find(t => t.id === id);
        if (!todo) return;

        updateTodo(id, { completed: !todo.completed })
            .then(updated => setTodos(prev => prev.map(t => t.id === id ? updated : t)))
            .catch(console.error);
    }

    const deleteTodo = (id: string) => {
        return deleteTodoApi(id)
        .then(() => setTodos(prev => prev.filter(t => t.id !== id))) 
        .catch(console.error);
    }

    return { todos, addTodo, toggleTodo, deleteTodo };
}