<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.forum.*"%>
<%@ page import="com.example.forum.domainmodel.*"%>
<%
ForumService forum = (ForumService)ComponentConfigurer.getComponent(application, "forum");
%>

<%
String action         = request.getParameter("action");
int thread_index      = Integer.parseInt(request.getParameter("thread_index"));

if(action.equalsIgnoreCase("ADD_POST")){
    String text = request.getParameter("post");
    String user = request.getParameter("user");
    ForumPost post = new ForumPost();
    
    if (user == null || user.length() == 0){
        user="foobarhoge";
    }
    
    post.setThread_index(thread_index);
    post.setText(text);
    post.setUser(user);

    forum.addPost(post);
}else if(action.equalsIgnoreCase("UPDATE_POST")){
    int post_index = Integer.parseInt(request.getParameter("post_index"));
    String text = request.getParameter("post");
    String user = request.getParameter("user");
    ForumPost post = new ForumPost();
 
    post.setText(text);
    post.setIndex(post_index);

    forum.updatePost(post);
}

response.sendRedirect("Thread_View.jsp?thread_index="+thread_index);
%>
