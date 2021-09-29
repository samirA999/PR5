package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.model.Task;

import java.util.List;


public class TaskDataRepository {
    /**Le but du repository est vraiment d'isoler la source de données (DAO)
     * (modèle de conception Validation) du ViewModel,
     *
     */

    private final TaskDao taskDao;

    public TaskDataRepository(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    public LiveData<List<Task>> getTasks() {
        return this.taskDao.getTasks();
    }

    public void createTask(Task task) {
        taskDao.insertTask(task);
    }

    public void deleteTask(Task task) {
        taskDao.deleteTask(task);
    }

}

