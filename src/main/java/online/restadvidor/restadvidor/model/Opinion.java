package online.restadvidor.restadvidor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.text.DecimalFormat;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "opinion")

public class Opinion {

    private long opinionId;
    private String tittle;
    private String commentText;
    private Date publishDate;
    private DecimalFormat score;
    private int userId;
    private int branchId;

    public long getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(long opinionId) {
        this.opinionId = opinionId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public DecimalFormat getScore() {
        return score;
    }

    public void setScore(DecimalFormat score) {
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public Opinion(long opinionId, String tittle, String commentText, Date publishDate, DecimalFormat score, int userId, int branchId) {
        this.opinionId = opinionId;
        this.tittle = tittle;
        this.commentText = commentText;
        this.publishDate = publishDate;
        this.score = score;
        this.userId = userId;
        this.branchId = branchId;
    }
}
