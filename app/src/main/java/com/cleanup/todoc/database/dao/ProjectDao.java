package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;


@Dao
public interface ProjectDao  {
    /**ajouté  deux méthodes : Une pour créer un nouveau projet
     * (  createProject ) et une pour récupérer un projet ( getProject )
     * ((@Query définir la methode comme etant une requette SQL
     *
     */
    @Insert( onConflict = OnConflictStrategy.REPLACE )
    void createProject (Project project);

    @Query("SELECT * FROM Project")
    LiveData<List<Project>> getProjects();

    @Query("SELECT * FROM Project WHERE id = :id")
    LiveData<Project> getProject(long id);

    @Delete
    void deleteAllProject(List<Project> project);
}