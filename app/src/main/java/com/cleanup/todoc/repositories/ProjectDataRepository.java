package com.cleanup.todoc.repositories;

import android.arch.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectDataRepository {
    /**Le but du repository est vraiment d'isoler la source de données (DAO)
     * (modèle de conception Validation) du ViewModel,
     *
     */

    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public LiveData<List<Project>> getProjects() {
        return this.projectDao.getProjects();
    }


}