package com.hanniel.cruddemo.dao;

import com.hanniel.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);
}
