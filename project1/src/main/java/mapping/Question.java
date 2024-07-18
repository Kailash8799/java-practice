package mapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue
	private int question_id;
	private String question;
	@OneToOne(cascade = CascadeType.ALL)
	private Answer a;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Answer getA() {
		return a;
	}
	public void setA(Answer a) {
		this.a = a;
	}
	public Question(int question_id, String question, Answer a) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.a = a;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", question=" + question + ", a=" + a + "]";
	}
	
}
