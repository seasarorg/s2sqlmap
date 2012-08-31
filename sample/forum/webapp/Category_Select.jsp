<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.forum.*"%>
<%@ page import="com.example.forum.domainmodel.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%
ForumService forum = (ForumService)ComponentConfigurer.getComponent(application, "forum");

   String action = request.getParameter("action");
   int topic_index = Integer.parseInt(request.getParameter("topic_index"));

   if(action.equalsIgnoreCase("VIEW")){
%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <link rel="stylesheet" type="text/css" href="style.css" title="nexB web" />
  </head>
  <body>
      <table class="forumline" cellspacing="1" cellpadding="3" width="95%" border="0">
        <tr class="forum"> 
          <th class="forum" nowrap="nowrap">Please Select a Category</th>
        </tr>
        <tr class="forum"> 
          <td class="row1" valign="top" height="28" width="100%">
            <table class="forum" cellspacing="0" cellpadding="0" width="98%">
              <tr class="forum"> 
                <td class="forum" width="80%"> 
                  <form action="Category_Select.jsp">
                    Please select a Category for this Topic:<br>
                    <input type=radio name="parent_index" value="0">[<b>Top</b>]
                    &nbsp;&nbsp;...<a class="category" href="Category_Add.jsp?action=VIEW&category_index=0&topic_index=<%=topic_index%>">Add Subcategory</a><br>
                      <%=getCategory(forum, 0, 0, topic_index)%>
                    <input type="submit" value="Select Category">
                    <input type="hidden" name="topic_index" value="<%=topic_index%>">
                    <input type="hidden" name="action" value="SAVE">
                  <form>
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
  </body>
</html>
<%
}else if(action.equalsIgnoreCase("SAVE")){ 
    int parent_index = Integer.parseInt(request.getParameter("parent_index"));
    forum.updateCategoryOnTopic(topic_index, parent_index);
%>
<html>
<br>
<p align="center">Category was selected for your topic</p>
<p align="center"><input type="button" OnClick="window.close();" value="Close Window"></p>
</html>
<%
}
%>

<%! 
public String getCategory(ForumService forum, int parent_index, int level, int topic_index){
   String html = "";
   String indent = "";
  
   for(int i = 0; i <= level; i++){
      indent += "&nbsp;&nbsp;&nbsp;";
   }

   try {
      List categories = forum.listCategoriesByParentId(parent_index);
      Iterator i = categories.iterator();
 
      while(i.hasNext()){ 
         ForumCategory c = (ForumCategory)i.next();
         html += indent;
         html += "<input type=radio name=\"parent_index\" value=\"" + c.getIndex() + "\">";
         html += "[<b>" + c.getTitle() + "</b>]";
         html += "&nbsp;&nbsp;...<a class=\"category\" href=\"Category_Add.jsp?action=VIEW&category_index=" + c.getIndex() + "&topic_index=" + topic_index + "\">Add Subcategory</a><br>\n";
         html += getCategory(forum, c.getIndex(), ++level, topic_index);
      } /* End while() */    
   } catch (Exception e){
   } 
   
   return html;
}
%>