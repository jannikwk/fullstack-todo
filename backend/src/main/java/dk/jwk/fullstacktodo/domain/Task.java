package dk.jwk.fullstacktodo.domain;

public class Task {
    private Long id;
    private String taskText;
    private boolean completed;

    public Task(Long id, String task, boolean completed) {
        this.id = id;
        this.taskText = task;
        this.completed = completed;
    }

    public Task(String task, boolean completed) {
        this.taskText = task;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
