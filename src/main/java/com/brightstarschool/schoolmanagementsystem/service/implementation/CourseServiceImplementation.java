package com.brightstarschool.schoolmanagementsystem.service.implementation;

import com.brightstarschool.schoolmanagementsystem.dto.*;
import com.brightstarschool.schoolmanagementsystem.entity.Course;
import com.brightstarschool.schoolmanagementsystem.entity.Student;
import com.brightstarschool.schoolmanagementsystem.repository.CourseRepository;
import com.brightstarschool.schoolmanagementsystem.repository.StudentRepository;
import com.brightstarschool.schoolmanagementsystem.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImplementation implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) {
        try {
            Course course = new Course(
                    courseSaveDTO.getCourseName(),
                    courseSaveDTO.getSyllabus(),
                    courseSaveDTO.getDuration()
            );

            courseRepository.save(course);
            System.out.println("\nMessage: Course Saved Successfully");

            return course.getCourseName();
        } catch(Exception ex)
        {
            System.out.println(ex.getMessage());
            throw new RuntimeException(ex);
        }

    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> getCourse = courseRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        for(Course course : getCourse)
        {
            CourseDTO courseDTO = new CourseDTO
                    (
                            course.getCourseId(),
                            course.getCourseName(),
                            course.getSyllabus(),
                            course.getDuration()
                    );
            courseDTOList.add(courseDTO);
        }

        return courseDTOList;
    }

    @Override
    public String updateCourse(long id, CourseUpdateDTO courseUpdateDTO) {
        if (courseRepository.existsById(id)) {
            Course course = courseRepository.getById(id);
            course.setCourseName(courseUpdateDTO.getCourseName());
            course.setSyllabus(courseUpdateDTO.getSyllabus());
            course.setDuration(courseUpdateDTO.getDuration());

            courseRepository.save(course);
            System.out.println("\nCourse details updated Successfully");
            return "Course details updated Successfully";
        } else {
            System.out.println("\nCourse ID not Found");
            return "Course ID not Found";
        }
    }

    @Override
    public boolean deleteCourse(long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            System.out.println("\nCourse deleted successfully");
            return true;
        } else {
            System.out.println("\nCourse ID not found");
            return false;
        }
    }


}
