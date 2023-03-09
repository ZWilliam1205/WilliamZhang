import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Question {
    String q;
    String correct_ans;
    String wrong1;
    String wrong2;
    String wrong3;

    public Question(String q, String correct_ans, String wrong1, String wrong2, String wrong3) {
        this.q = q;
        this.correct_ans = correct_ans;
        this.wrong1 = wrong1;
        this.wrong2 = wrong2;
        this.wrong3 = wrong3;
    }
}

class Quiz{
    ArrayList<Question> Questions;

    public Quiz() {
        Questions = new ArrayList<>();
    }

    public void printQuiz(){
        int correct_points = 0;
        for(int i = 0; i < Questions.size(); i++){
            System.out.println(Questions.get(i).q);
            Random r = new Random();
            Scanner sc = new Scanner(System.in);
            int correct_index = r.nextInt(4);
            ArrayList<String> answers = new ArrayList<>();
            answers.add(Questions.get(i).wrong1);
            answers.add(Questions.get(i).wrong2);
            answers.add(Questions.get(i).wrong3);
            answers.add(correct_index,  Questions.get(i).correct_ans);

            for(int j = 1; j <= 4; j++) {
                System.out.println(j + ". " + answers.get(j - 1));
            }

            System.out.print("Enter your answer as a number from 1-4: ");
            int answer_choice = sc.nextInt();
            if (++correct_index == answer_choice){
                System.out.println("Your answer is correct!");
                ++correct_points;
            }
            else{
                System.out.println("Sorry, Your answer is incorrect.");
            }
        }
        System.out.println("Your total score is "+correct_points+"/"+Questions.size()+".");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many questions do you want to have in your study aid? (input an integer)");
        int q_number = sc.nextInt();
        sc.nextLine();
        Quiz quiz = new Quiz();
        for (int i = 1; i <= q_number; i++) {
            System.out.println("Please input your question #"+i);
            String q = sc.nextLine();
            System.out.println("Please input the correct answer for this question.");
            String Correct = sc.nextLine();
            System.out.println("Please input your first wrong answer.");
            String W1 = sc.nextLine();
            System.out.println("Please input your second wrong answer.");
            String W2 = sc.nextLine();
            System.out.println("Please input your third wrong answer.");
            String W3 = sc.nextLine();

            Question a = new Question(q, Correct, W1, W2, W3);
            quiz.Questions.add(a);
        }
        quiz.printQuiz();
    }
}