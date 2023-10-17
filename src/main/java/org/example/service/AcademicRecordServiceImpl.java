package org.example.service;

import java.util.List;
import org.example.model.Grade;
import org.example.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademicRecordServiceImpl implements AcademicRecordService {

  private static final Logger logger = LoggerFactory.getLogger(AcademicRecordServiceImpl.class);
  private final GradeRepository gradeRepository;

  public AcademicRecordServiceImpl(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }

  @Override
  public Double calculateAverage() 
  {
    double average = 0.0, suma = 0.0;
    List<Grade> gradeList = this.gradeRepository.findAllGrades();
    for (Grade grade : gradeList) {
      suma += grade.grade();
    }
    average = suma / sumNumberOfGrades();
    return average;
  }

  @Override
  public Integer sumNumberOfGrades() {
    
    logger.info("Sumando el número de calificaciones");

    List<Grade> gradeList = this.gradeRepository.findAllGrades();
     
    return gradeList.size();

  }
}
