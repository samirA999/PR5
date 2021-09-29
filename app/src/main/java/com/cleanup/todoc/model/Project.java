package com.cleanup.todoc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


@Entity
public class Project {
    /**
     * L'identifiant unique du projet
     */
    @PrimaryKey(autoGenerate = true)
    private final long id;

    /**
     * Le nom du projet
     */
    @NonNull
    private final String name;

    /**
     *Le code hexadécimal (ARGB) de la couleur associée au projet
     */
    @ColorInt
    private final int color;

    /**
     * Instancie un nouveau projet.
     *
     * @param id    the unique identifier of the project to set
     * @param name  the name of the project to set
     * @param color the hex (ARGB) code of the color associated to the project to set
     */
    public Project(long id, @NonNull String name, @ColorInt int color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    /**
     * Renvoie tous les projets de l'application.
     *
     * @return tous les projets de l'application
     */
    @NonNull
    public static Project[] getAllProjects() {
        return new Project[]{
                new Project(1L, "Projet Tartampion", 0xFFEADAD1),
                new Project(2L, "Projet Lucidia", 0xFFB4CDBA),
                new Project(3L, "Projet Circus", 0xFFA3CED2),

        };
    }

    /**
     * Renvoie le projet avec l'identifiant unique donné, ou null si aucun projet avec celui-ci
     *       l'identifiant peut être trouvé.
     *
     * @param id the unique identifier of the project to return
     * @returnle projet avec l'identifiant unique donné, ou nul s'il n'a pas été trouvé
     */
    @Nullable
    public static Project getProjectById(long id) {
        for (Project project : getAllProjects()) {
            if (project.id == id)
                return project;
        }
        return null;
    }

    /**
     * Renvoie l'identifiant unique du projet.
     *
     * @return the unique identifier of the project
     */
    public long getId() {
        return id;
    }

    /**
     * Renvoie le nom du projet.
     *
     * @return the name of the project
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     * Renvoie le code hexadécimal (ARGB) de la couleur associée au projet.
     *
     * @return the hex (ARGB) code of the color associated to the project
     */
    @ColorInt
    public int getColor() {
        return color;
    }

    @Override
    @NonNull
    public String toString() {
        return getName();
    }
}
