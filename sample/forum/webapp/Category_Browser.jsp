<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.forum.*"%>
<%@ page import="com.example.forum.domainmodel.*"%>
<%
ForumService forum = (ForumService)ConponentConfigurer.getComponent(application, "forum");
%>
<%@ include file="template_parts/top.jsp" %>
<%
   int index = TypeUtils.toInt(request.getParameter("index"), 0);
   String type = "" + request.getParameter("type");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
  <body>
<%
   if(type.equalsIgnoreCase("category")){
%>
      <table class="forumline" cellspacing="1" cellpadding="3" width="94%" border="0">
        <tr class="forum"> 
          <th class="forum" nowrap="nowrap">&nbsp;</th>
        </tr>
        <tr class="forum"> 
          <td class="row1" valign="top" height="28" width="100%">
            <table class="forum" cellspacing="0" cellpadding="0" width="98%">
              <tr class="forum"> 
                <td class="forum" width="80%"> 
                  <%=getCategories(forum, index, 1, "mytemp")%>
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
    }else if(type.equalsIgnoreCase("topic")){
	 response.sendRedirect("Topic_View.jsp?topic_index=" + index + "&action=VIEW");
    }
%>
<%@ include file="template_parts/bottom.jsp" %>
  </body>
</html>

<%! 
    public String getCategories(ForumService forum, int parent_index, int level, String templateDir){
        String html = "";
        String indent = "";
        List rsCategory = null;
	Iterator ie;

        for(int i = 0; i <= level; i++){
            indent += "&nbsp;&nbsp;&nbsp;";
        }
	
        try {
            rsCategory = forum.listCategoriesByParentId(parent_index); 
	    ie = rsCategory.iterator();

            while(ie.hasNext()){ 
	        ForumCategory category= (ForumCategory)ie.next();
                html += indent;
                html += "<a class=\"category\" href=\"Category_Browser.jsp?index=" + category.getIndex() + "&type=category\">[<b>" + category.getTitle() + "</b>]</a>";
                html += "<br>";
                html += getCategories(forum, category.getIndex(), ++level, templateDir);
            } /* End while() */
    
            html += getTopics(forum, parent_index, level + 1, templateDir);
        } catch (Exception e){
            e.printStackTrace();
        } 
   
        return html;
    }

    public String getTopics(ForumService forum, int category_index, int level, String templateDir){
        String html = "";
        String indent = "";
        List topics;
	Iterator ie;

        for(int i = 0; i <= level; i++){
            indent += "&nbsp;&nbsp;&nbsp;";
        }

        try {
           topics = forum.listTopicsByCategoryId(category_index);
	   ie = topics.iterator();

            while(ie.hasNext()){
	       ForumTopic topic=(ForumTopic)ie.next(); 
                html += indent;
                html += "<img src=\"images/folder.gif\" width=\"19\" height=\"18\"><a class=\"category\" href=\"Category_Browser.jsp?index=" + topic.getIndex() + "&type=topic\">[<b>" + topic.getTitle() + "</b>]</a>";
                html += "<br>";
            } /* End while() */    
        } catch (Exception e){
            e.printStackTrace();
        } 
        return html;
    }
%>


