package by.bntu.fitr.povt.prostrmk.ItNews.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "Articles")
public class Article implements IArticles{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "type")
    private String type;

    @Column(name = "pathToFile")
    private String pathToFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Article() {
    }

    public Article(String title, String content, String type, String pathToFile) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.pathToFile = pathToFile;
    }

    @Override
    public int hashCode() {
        final int hashConst = 31;
        int result = 1;
        result = (int) (hashConst * result + id);
        result = hashConst * result + title.hashCode();
        result = hashConst * result + content.hashCode();
        result = hashConst * result + pathToFile.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Id - %d,\n Title- %s,\n Content - %s,\nPath to file - %s,\nType - %s", id, title, content, pathToFile, type);
    }
}
