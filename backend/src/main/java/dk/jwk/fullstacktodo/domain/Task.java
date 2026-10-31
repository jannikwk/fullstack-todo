package dk.jwk.fullstacktodo.domain;

import dk.jwk.fullstacktodo.domain.valueobjects.TaskContent;
import dk.jwk.fullstacktodo.domain.valueobjects.TaskId;

public class Task {
    private final TaskId id;
    private TaskContent content;
    private boolean completed;

    private Task(TaskId id, TaskContent content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public static Task create(String text) {
        return new Task(TaskId.generate(), new TaskContent(text), false);
    }

    public static Task from(TaskId id, String text, boolean completed) {
        return new Task(id, new TaskContent(text), completed);
    }

    public void complete() {
        this.completed = true;
    }

    public void reopen() {
        this.completed = false;
    }

    public void changeContent(TaskContent newContent) {
        if (newContent == null) {
            throw new IllegalArgumentException("New content object cannot be null");
        }

        this.content = newContent;
    }

    public TaskId getId() {
        return id;
    }

    public TaskContent getTaskContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }
}
