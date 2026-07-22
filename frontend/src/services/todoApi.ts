import type { Todo } from "../types/Todo.type";
import axios from "axios";

const api = axios.create({ baseURL: import.meta.env.VITE_BACKEND_API_URL });

export async function getAllTodos(): Promise<Todo[]> {
    const response = await api.get(`/api/todos`);
    return response.data;
}

export async function createTodo(taskText: string): Promise<Todo> {
    const response = await api.post(`/api/todos`, { taskText });
    return response.data;
}

export async function updateTodo(id: number, changes: Partial<Todo>): Promise<Todo> {
    const response = await api.patch(`/api/todos/${id}`, changes);
    return response.data;
}

export async function deleteTodoApi(id: number): Promise<void> {
    await api.delete(`/api/todos/${id}`);
}