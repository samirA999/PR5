package com.cleanup.todoc;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;
import com.cleanup.todoc.repositories.ProjectDataRepository;
import com.cleanup.todoc.repositories.TaskDataRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class TaskViewModel extends ViewModel {

    /**
     * déclaré  en variables de classe nos deux repository précédemment créés ainsi qu'une
     * variable de type Executor, qui nous facilitera l'exécution en arrière-plan de certaines méthodes.
     * Ces trois variables sont instanciées directement à partir du constructeur de la classe.
     *
     */

    // REPOSITORIES
    private final TaskDataRepository taskDataSource;
    private final ProjectDataRepository projectDataSource;
    // EXECUTOR
    private final Executor executor;
    // PROJECTS
    private LiveData<List<Project>> projects;


    public TaskViewModel(TaskDataRepository taskDataSource, ProjectDataRepository projectDataSource, Executor executor) {
        this.taskDataSource = taskDataSource;
        this.projectDataSource = projectDataSource;
        this.executor = executor;
    }

    // -------------
    // FOR PROJECT
    // -------------
    public LiveData<List<Project>> getProjects() {
        return projects;
    }

    // -------------
    // FOR TASK
    // -------------
    public LiveData<List<Task>> getTasks() {
        return taskDataSource.getTasks();
    }

    public void createTask(final Task task) {
        executor.execute(() -> taskDataSource.createTask(task));
    }

    public void deleteTask(final Task task) {
        executor.execute(() -> taskDataSource.deleteTask(task));
    }


    public void init() {
        if (projects == null) {
            projects = projectDataSource.getProjects();
        }
    }

}
