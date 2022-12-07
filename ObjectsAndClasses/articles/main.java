package ObjectsAndClassesExercise.articles;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine();
        String[] articleParts = articleData.split(", ");
        String title = articleParts[0];
        String content = articleParts[1];
        String author = articleParts[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());//брой команди
        for (int commandCount = 1; commandCount <= n; commandCount++) {
            String command = scanner.nextLine();
            if (command.contains("Edit")) {
                //трябва да променя съдържанието на моята статия с даденото
                String newContent = command.split(": ")[1];
                article.edit(newContent);
            } else if (command.contains("Rename")) {
                //променя заглавието на моята статия с даденото
                String newTitle = command.split(": ")[1];
                article.rename(newTitle);
            } else if (command.contains("ChangeAuthor")) {
                //променя автора на моята статия с дадения автор
                String newAuthor = command.split(": ")[1];
                article.changeAuthor(newAuthor);
            }
        }
         //title - content: author
        System.out.println(article.toString());
    }
}
