package com.collegeapp;



import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.collegeapp.model.Department;
import com.collegeapp.model.Teacher;
import com.collegeapp.service.ICollegeService;
import com.collegeapp.service.IDepartmentService;
import com.collegeapp.service.ILectureService;
import com.collegeapp.service.ITeacherService;

@SpringBootApplication
public class SpringCollegeDatajpa2Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringCollegeDatajpa2Application.class, args);
	}
	
	@Autowired
	ICollegeService collegeService;
	
	@Autowired
	ITeacherService teacherService;
	
	@Autowired
	ILectureService lectureService;
	
	@Autowired 
	IDepartmentService departmentService;

	@Override
	public void run(String... args) throws Exception {
		try {
			LocalDate date= LocalDate.of(2021, 9, 28);
//			LocalTime firstLec= LocalTime.of(10, 30, 00);
//			LocalTime secondLec= LocalTime.of(11, 30, 00);
//			LocalTime thirdLec= LocalTime.of(12, 30, 00);
//			Lecture lecture= new Lecture(date,40, "CSE B10","MECH B10", "FREE", firstLec, secondLec, thirdLec);
//			Lecture lecture1= new Lecture(date,40, "MECH B10","FREE", "FREE", firstLec, secondLec, thirdLec );
//			Lecture lecture2= new Lecture(date,40, "Free","CSE B10", "MECH B10", firstLec, secondLec, thirdLec );
//			Lecture lecture3= new Lecture(date,40,"FREE" ,"FREE","MECH B10" , firstLec, secondLec, thirdLec);
//			Teacher teacher= new Teacher("Ayan", "Java", 2,0, Arrays.asList(lecture));
//			Teacher teacher1= new Teacher("Ayush", "Python", 1,0, Arrays.asList(lecture1));
//			Teacher teacher2= new Teacher("Avinash", "Thermodynamics", 2,0,  Arrays.asList(lecture2));
//			Teacher teacher3= new Teacher("Teja", "Manufacturing", 1,0, Arrays.asList(lecture3));
//			
//			Set <Teacher> teacherList= new HashSet<>();
//			teacherList.addAll(Arrays.asList(teacher, teacher1));
//			
//			Set <Teacher> teacherList1= new HashSet<>();
//			teacherList1.addAll(Arrays.asList(teacher2, teacher3));
//			
//			Department department= new Department("CSE",teacherList);
//			Department department1= new Department("MECH", teacherList1);
//			
//			Set <Department> departmentList= new HashSet<>();
//			departmentList.addAll(Arrays.asList(department, department1));
//			
//			College college= new College("LNCT","Bhopal", 80000.0, departmentList);
//			
//			collegeService.addCollege(college);
//			
//			College college= collegeService.getById(100);
//			System.out.println(college);
				
//			List<College> collegeByCity= collegeService.getByLessFees(100000);
//			collegeByCity.forEach(System.out:: println);
//				
//				List<Teacher> teacherByDept= teacherService.showTeacherByDepartment("CSE");
//				teacherByDept.forEach(System.out:: println);
				

//				List<Teacher> teacherBySubject= teacherService.showTeacherBySubject("Java");
//				teacherBySubject.forEach(System.out:: println);
				
//			List<Lecture> lectureSchedule= lectureService.showTeacherSchedule(1);
//			lectureSchedule.forEach(System.out:: println);
//				for(Lecture l: lectureSchedule) {
//					System.out.println("first Lecture ------ "+l.getFirstLecture());
//					System.out.println("Second Lecture -------- "+l.getSecondLecture());
//					System.out.println("third Lecture --------  "+l.getThirdLecture());
//					System.out.println("first lec time------"+l.getFirstLectTime());
//					System.out.println("swecond Lecture --------  "+l.getSecondLecture());
//					System.out.println("third lec time------"+l.getThirdLectTime());
//				}
//				
//				Lecture lecture = lectureService.showTodayLecture(date, 1);
//				System.out.println(lecture.getFirstLecture());
//				System.out.println(lecture.getSecondLecture());
				//teacherService.applyLeave(date, 1);
			//Teacher teacher= teacherService.getById(3);
			//System.out.println(teacher);
//			List<Teacher> teacherByName= teacherService.getByTeacherName("Ayan");
//			teacherByName.forEach(System.out:: println);
		
//			List<Teacher> allTeacher= teacherService.getAll();
//			allTeacher.forEach(System.out:: println);
		
//			String teacherName=lectureService.getTeacherForFirstLec(date, "CSE B10");
//			System.out.println("First Lecture --"+teacherName);
//			
//			String teacherName1=lectureService.getTeacherForSecondLec(date, "CSE B10");
//			System.out.println("Second Lecture --"+teacherName1);
//			
//			String teacherName2=lectureService.getTeacherForThirdLec(date, "CSE B10");
//			System.out.println("Third Lecture --"+teacherName2);
			//departmentService.addDepartment("ECE");
			//departmentService.showDepartments().forEach(System.out:: println);
		//	teacherService.showBySubjectAndDept("Java", "CSE").forEach(System.out:: println);;
			//System.out.println(departmentService.getById(1));
			
			//teacherService.showThirdLecFreeTeacher(date).forEach(System.out:: println);
			
//			Lecture lecture= lectureService.showTodayLecture(date, 1);
//			System.out.println("First Lecture  --- "+lecture.getFirstLecture());
//			System.out.println("Second Lecture  --- "+lecture.getSecondLecture());
//			System.out.println("Third Lecture  --- "+lecture.getThirdLecture());
//			System.out.println();
//			HashMap <String, List<String>> teacherLectureList=teacherService.showTeachersFreeLectures(date, 1);
//			System.out.println(teacherLectureList);
//			teacherLectureList.entrySet().forEach( entry -> {
//			    System.out.println( entry.getKey() + " => " + entry.getValue() );
//			});
			//teacherService.showFirstLecFreeTeacher(date).forEach(System.out:: println);;
		//	teacherService.applyLeave(date, 1);
			//Department department= new Department("CSE");
			
			
//			LocalTime firstLec= LocalTime.of(10, 30, 00);
//		LocalTime secondLec= LocalTime.of(11, 30, 00);
//			LocalTime thirdLec= LocalTime.of(12, 30, 00);
//			Lecture lecture= new Lecture(date,40, "FREE","FREE", "FREE", firstLec, secondLec, thirdLec);
//			Teacher teacher1= new Teacher("Ram", "Cloud", 1,0, Arrays.asList(lecture));
//			teacherService.addTeacher(teacher1);
			
//			Department department= new Department();
//			department.setDepartmentId(2);
//		Teacher teacher=	teacherService.getById(9);
//		teacher.setDepartment(department);
//			teacherService.updateTeacher(teacher);
		}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		
		
		
		
	}

}
