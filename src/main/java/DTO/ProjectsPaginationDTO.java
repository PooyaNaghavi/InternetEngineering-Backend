package DTO;

import model.Project;

import java.util.ArrayList;

public class ProjectsPaginationDTO {
    private ArrayList<Project> projects;
    private int nextPageToken;
    private boolean showLoadMoreFlag;

    public ProjectsPaginationDTO(){ }
    public ProjectsPaginationDTO(ArrayList<Project> projects, int nextPageToken, int limit) {
        this.projects = projects;
        this.nextPageToken = nextPageToken;
        this.showLoadMoreFlag = limit != projects.size();
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public int getNextPageToken() {
        return nextPageToken;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public void setNextPageToken(int nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public boolean isShowLoadMoreFlag() {
        return showLoadMoreFlag;
    }

    public void setShowLoadMoreFlag(boolean showLoadMoreFlag) {
        this.showLoadMoreFlag = showLoadMoreFlag;
    }
}
