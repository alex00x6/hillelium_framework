package models.jiraapi;

import base.api.RequestSender;

public class ApiRequestGroups {


    public RequestSender createIssue(String body){
        RequestConstructor requestSender = new RequestConstructor();
        requestSender.createRequest(body).post(ApiURLs.ISSUE.getUri());
        return requestSender;
    }

    public RequestSender deleteIssue(String issue){
        RequestConstructor requestSender = new RequestConstructor();
        requestSender.createEmptyRequest().delete(ApiURLs.ISSUE.getUri(issue));
        return requestSender;
    }

    public RequestSender getIssue(String issue){
        RequestConstructor requestSender = new RequestConstructor();
        requestSender.createEmptyRequest().get(ApiURLs.ISSUE.getUri(issue));
        return requestSender;
    }

    public RequestSender search(String body){
        RequestConstructor requestSender = new RequestConstructor();
        requestSender.createRequest(body).post(ApiURLs.SEARCH.getUri());
        return requestSender;
    }

    public RequestSender addCommentToIssue(String body, String issue){
        RequestConstructor requestSender = new RequestConstructor();
        requestSender.createRequest(body).post(ApiURLs.ISSUE.getUri(issue+"/comment"));
        return requestSender;
    }


}
