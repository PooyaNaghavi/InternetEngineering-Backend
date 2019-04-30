package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import exceptions.NotFoundException;
import repository.Database;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private int budget;
    private long deadline;
    private long createdAt;
    private User winner;
    private ArrayList<ProjectSkill> skills;

    public Project(String title, ArrayList<ProjectSkill> skills, int budget){
        this.title = title;
        this.skills = skills;
        this.budget = budget;
    }

    public Project(){
    }

    public Project(String id, String title, String description, String imageURL, ArrayList<ProjectSkill> skills, int budget, long deadline, long createdAt, User winner) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageURL;
        this.skills = skills;
        this.budget = budget;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.winner = winner;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<ProjectSkill> getSkills() {
        return skills;
    }

    public int getBudget() {
        return budget;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSkills(ArrayList<ProjectSkill> skills) {
        this.skills = skills;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public long getDeadline() {
        return deadline;
    }

    public User getWinner() {
        return winner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    private static int calcBidValue(User biddingUser, Project project) throws NotFoundException {
        int sum = 0;
        for(ProjectSkill skill : project.getSkills()){
            sum += Math.pow((biddingUser.getSkillPoint(skill) - skill.getPoint()), 2) * 10000;
        }
        sum += project.getBudget() - Database.findUserOffer(biddingUser, project).getAmount();
        return sum;

    }

    public User findAuctionWinner(ArrayList<User> biddingUsers, Project project) throws NotFoundException{
        if(biddingUsers.size() == 0){
            throw new NotFoundException("No bid for this project");
        }
        int max = calcBidValue(biddingUsers.get(0), project);
        User maxUser = biddingUsers.get(0);
        for(User biddingUser : biddingUsers){
            if(calcBidValue(biddingUser, project) > max){
                max = calcBidValue(biddingUser, project);
                maxUser = biddingUser;
            }
        }
        return maxUser;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}

