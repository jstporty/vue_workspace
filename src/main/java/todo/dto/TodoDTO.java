package todo.dto;

import java.io.Serializable;

public class TodoDTO implements Serializable {

	public static final long serialVerisionUID = 35216516541L;

	public TodoDTO() {
	}

	int 순번;
	String 할일;
	String 시간;

	public int get순번() {
		return 순번;
	}

	public void set순번(int 순번) {
		this.순번 = 순번;
	}

	public String get할일() {
		return 할일;
	}

	public void set할일(String 할일) {
		this.할일 = 할일;
	}

	public String get시간() {
		return 시간;
	}

	public void set시간(String 시간) {
		this.시간 = 시간;
	}

	@Override
	public String toString() {
		return "todoDTO [순번=" + 순번 + ", 할일=" + 할일 + ", 시간=" + 시간 + "]";
	}

}
