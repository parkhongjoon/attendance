package attendance.dto;


public class DBto {
   private int id;
   private String name;
   private String student_id;
   private String password;
   private String code;
   
   public DBto() {};
   
   public DBto(int id, String name, String student_id, String password, String code) {
	   super();
	      this.id = id;
	      this.name = name;
	      this.student_id = student_id;
	      this.password =password;
	      this.code = code;
	   }

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStudent_id() {
	return student_id;
}
public void setStudent_id(String student_id) {
	this.student_id = student_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String code() {
	   return code;
}
public void setCode(String code) {
	   this.code = code;
}

@Override
public String toString() {
	return "DBto [id=" + id + ", name=" + name + ", student_id=" + student_id + ", password=" + password + ", code="
			+ code + "]";
}


   
}
