<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.forum.*"%>
<%@ page import="com.example.forum.domainmodel.*"%>
<%
ForumService forum = (ForumService)ComponentConfigurer.getComponent(application, "forum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="style.css" title="nexB web" />


</head>
  <body>
<%
String action      = request.getParameter("action");
int category_index = Integer.parseInt(request.getParameter("category_index"));
int topic_index    = Integer.parseInt(request.getParameter("topic_index"));

if(action.equalsIgnoreCase("VIEW")){
%>
      <table class="forumline" cellspacing="1" cellpadding="3" width="94%" border="0">
        <tr class="forum"> 
          <th class="forum" nowrap="nowrap">Please Select a Category</th>
        </tr>
        <tr class="forum"> 
          <td class="row1" valign="top" height="28" width="100%">
            <table class="forum" cellspacing="0" cellpadding="0" width="98%">
              <tr class="forum"> 
                <td class="forum" width="80%"> 
<%
    String category_title = "";

    if(category_index == 0){
        category_title = "Top";
    }else{
        category_title = forum.getCategoryName(category_index); 
    }
%>
                  <form type="post" action="Category_Add.jsp">
                    <b>Create a new subcategory for <%=category_title%><b><br>
                    Subcategory Title:<input type="text" name="title"><br>
                    <input type="submit" value="Add Subcategory">
                    <input type="hidden" name="action" value="SAVE">
                    <input type="hidden" name="category_index" value="<%=category_index%>">
                    <input type="hidden" name="topic_index" value="<%=topic_index%>">
                  </form>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr class="forum">
          <td class="spaceRow" colspan="2" height="1"><img src="images/spacer.gif" alt="" width="1" height="1" /></td>
        </tr>
        <tr class="forum" align="center">
          <td class="catBottom" colspan="2" height="28">
            <table class="forum" cellspacing="0" cellpadding="0" border="0">
		  <tr class="forum">
		    <td class="forum" align="center"><span class="gensmall"><div></div></span></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
<%
}else if(action.equalsIgnoreCase("SAVE")){ 
    String title = request.getParameter("title");
    String user = request.getParameter("user");
    ForumCategory category = new ForumCategory();
    
    category.setTitle(title);
    category.setParent_index(category_index);
    
    forum.addCategory(category);
    
    response.sendRedirect("Category_Select.jsp?topic_index=" + topic_index + "&action=VIEW");
}else{
%>
Error!
<%
}
%>
  </body>
</html>