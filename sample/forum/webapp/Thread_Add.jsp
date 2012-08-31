<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.forum.*"%>
<%@ page import="com.example.forum.domainmodel.*"%>
<%
ForumService forum = (ForumService)ComponentConfigurer.getComponent(application, "forum");
%>

<html>
<head><title>Add thread</title></head>
<body bgcolor="#C2CFDF">
<%
String action = request.getParameter("action");
int topic_index = Integer.parseInt(request.getParameter("topic_index"));

if(action.equalsIgnoreCase("VIEW")){
%>
<form method="POST" action="Thread_Add.jsp">
  <p align="center">Add a thread:</p>
  <p align="center">Title: <input type="text" name="title" size="32"></p>
  <p align="center"><input type="submit" value="Submit"></p>
  <input type="hidden" name="topic_index" value="<%=topic_index%>">
  <input type="hidden" name="action" value="SAVE">
</form>
<%
}else if(action.equalsIgnoreCase("SAVE")){ 
    String title = request.getParameter("title");
    String username  = "foobar";
    ForumThread thread = new ForumThread();
 
    thread.setTopic_index(topic_index);
    thread.setTitle(title);
    thread.setStarter(username);
    
    forum.addThread(thread);
%>
<br>
<p align="center">Thread was added sucessfully</p>
<p align="center"><input type="button" OnClick="window.close();" value="Close Window"></p>
</body>
</html>
<%
}
%>

