package ObjectsAndClassesExercise.articles;

public class Article {
    //полета -> характеристики на статията
    private String title;
    private String content;
    private String author;

    //конструктор -> създава нови обекти от съответния клас
    //alt + insert - създава нов конструктор

    public Article(String title, String content, String author) {
        //нов обект
        this.title = title;
        this.content = content;
        this.author = author;
    }
    //методи -> поведение
    public void edit(String newContent){
        //съдържанието на обекта,за който е извикан метода да се промени
        this.content = newContent;
    }

    public void changeAuthor(String neuAuthor){
        this.author = neuAuthor;
    }

    public void rename (String newTitle){
        this.title = newTitle;
    }
    //има вграден метод toString -> превръща обекта в текст->{packageName}.{className}@{address}->дефолтно поведение на този метод
    //@Override -> пренаписва дефолтен метод->за да работи по начин, по който аз искам
    public String toString(){
        //title - content: author
        //return this.title + " - " + this.content + ": " + this.author;
        return String.format("%s - %s: %s",this.title,this.content,this.author);
    }
}
