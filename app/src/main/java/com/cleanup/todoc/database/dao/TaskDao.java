package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {
    /**ajouté  les méthodes : Une pour recuperer les taches ( getTasks ) , creer une nouvelle tache
     * (insertTask),
     * (  deleteTask) et une pour supprimer une tache
     * ((@Query définir la methode comme etant une requette SQL
     */
    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTasks();

    @Query("SELECT * FROM Task WHERE id = :id")
    LiveData<Task> getTask(long id);

    @Insert
    long insertTask(Task task);

    @Query("DELETE FROM Task WHERE id = :id")
    int deleteTask(long id);

    @Delete
    void deleteTask(Task task);
}