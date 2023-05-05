package com.mainclass.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Visitor {

@Id
private int studentId;
private String studentName;
private String visitorName1;
private String visitorName2;
private String visitorName3;
private String visitorName4;
public Visitor() {
super();
}

public Visitor(int studentId, String studentName, String visitorName1, String visitorName2, String visitorName3,
String visitorName4) {
super();
this.studentId = studentId;
this.studentName = studentName;
this.visitorName1 = visitorName1;
this.visitorName2 = visitorName2;
this.visitorName3 = visitorName3;
this.visitorName4 = visitorName4;
}

public int getStudentId() {
return studentId;
}

public void setStudentId(int studentId) {
this.studentId = studentId;
}

public String getStudentName() {
return studentName;
}

public void setStudentName(String studentName) {
this.studentName = studentName;
}

public String getVisitorName1() {
return visitorName1;
}

public void setVisitorName1(String visitorName1) {
this.visitorName1 = visitorName1;
}

public String getVisitorName2() {
return visitorName2;
}

public void setVisitorName2(String visitorName2) {
this.visitorName2 = visitorName2;
}

public String getVisitorName3() {
return visitorName3;
}

public void setVisitorName3(String visitorName3) {
this.visitorName3 = visitorName3;
}

public String getVisitorName4() {
return visitorName4;
}

public void setVisitorName4(String visitorName4) {
this.visitorName4 = visitorName4;
}

}