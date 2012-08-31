<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.forum.*"%>
<%@ page import="com.example.forum.domainmodel.*"%>
<%
 ForumService forum = (ForumService)ComponentConfigurer.getComponent(pageContext.getServletContext(), "forum");
%>
<%
    int topic_index =  TypeUtils.toInt("" + request.getParameter("topic_index"), 0);
    int topic_page  = TypeUtils.toInt("" + request.getParameter("topic_page"), 0);
%>
<%@ include file="template_parts/top.jsp" %>
      <table class="forum" width="94%">
        <tr class="forum">
          <td class="forum" valign="center" align="left" width="50">
            <a href="#" OnClick='window.open("Thread_Add.jsp?topic_index=<%=topic_index%>&action=VIEW","","width=300,height=150");'>
              <img src="images/post.gif" border="0" />
            </a>
          </td>
          <td class="nav" valign="center" align="left" width="100%" colspan="">
            <span class="nav">&nbsp;&nbsp;&nbsp; 
<%
    int category_index= forum.getCategoryIdByTopicId(topic_index);
    //rs_topic.next();
    if(category_index != -1){
%>
        <%=getParentLink( forum, category_index, "mytemp")%>
<%
    }else{
%>
      <a class="nav" href="#" OnClick='window.open("Category_Select.jsp?topic_index=<%=topic_index%>&action=VIEW","","width=600,height=600");'>
      Please select parent category...
      </a>
<%
    }
%>
<%!
public String getParentLink(ForumService forum, int category_index, String templateDir) throws Exception{
    if(category_index > 0){
        ForumCategory category;
        category = forum.getCategory(category_index);
        if(category != null){
            String link = "";
            link += getParentLink(forum, category.getParent_index(), templateDir);
            link += " -&gt; <a class=\"nav\" href=\"Category_Browser.jsp?index=" + category_index + "&type=category\">";
            link += category.getTitle() + "</a>";
            return link;
        }else{
            return "";
        }
    }else{
        return "<a class=\"nav\" href=\"Category_Browser.jsp?index=0&type=category\">Top</a>";
    }
}
%>
            </span>
          </td>
          <td class="nav" valign="bottom" nowrap="nowrap" align="right">
            <span class="gensmall">

<%   
        int count = forum.countThreadsByTopicId(topic_index); 
        int max   = count;
%>
        <div>
                 Go To Page: 
<%      if(topic_page > 0){ %>
                 <a href="Topic_View.jsp?topic_index=<%=topic_index%>&topic_page=<%=(topic_page - 1)%>"><%=(topic_page - 1)%></a>, 
<%      } %>
                 <%=topic_page%>
<%      if((10 * (topic_page+1)) <= max){ %>
                 , <a href="Topic_View.jsp?topic_index=<%=topic_index%>&topic_page=<%=(topic_page + 1)%>"><%=(topic_page + 1)%></a>
<%      } %>
               </div>
 
            </span>
          </td>
        </tr>
      </table>
      <table class="forumline" cellspacing="1" cellpadding="3" width="94%" border="0">
        <tr class="forum"> 
          <th class="forum" nowrap="nowrap" align="middle" colspan="2" height="25">&nbsp;Thread&nbsp;</th>
          <th class="forum" nowrap="nowrap" align="middle" width="50">&nbsp;Posts&nbsp;</th>
          <th class="forum" nowrap="nowrap" align="middle" width="100">&nbsp;Starter&nbsp;</th>
          <th class="forum" nowrap="nowrap" align="middle" width="50">&nbsp;Views&nbsp;</th>
          <th class="forum" nowrap="nowrap" align="middle">&nbsp;Last message&nbsp;</th>
        </tr>
<%
   List list = forum.listThreadsByTopicId( topic_index , 10 * topic_page , 10);
   Iterator i = list.iterator();

   while(i.hasNext()){
      ForumThread thread = (ForumThread)i.next();
      String thread_index = ""+ thread.getIndex();
      String thread_title = thread.getTitle();
      String thread_starter = thread.getStarter();
            
      ThreadMetadata threadMeta= forum.getThreadMetadata( TypeUtils.toInt(thread_index, 0) );
      boolean has_post = null != threadMeta;
%>
        <tr>
          <td class="row1" valign="center" align="middle" width="20">
            <img src="images/folder.gif" width="19" height="18">
          </td>
	  <td class="row1" width="100%">
	    <span class="threadtitle">
              <a href="Thread_View.jsp?thread_index=<%=thread_index%>">
                <%=thread_title%>
              </a>
            </span>
          </td>
          <td class="row2" valign="center" align="middle">
            <span class="postdetails">
              <%if(has_post){%>
                <%=threadMeta.getThread_count()%>
              <%}%>
            </span>
          </td>
          <td class="row3" valign="center" align="middle">
            <span class="name">
              <%=thread_starter%></span>
          </td>
          <td class="row2" valign="center" align="middle">
            <span class="postdetails">&nbsp;</span>
          </td>
          <td class="row3" valign="center" nowrap="nowrap" align="middle">
            <span class="postdetails">
              <%if(has_post){%>
                <%=threadMeta.getTimestamp()%><br />
	        <img src="images/icon_latest_reply.gif" width="18" height="9" border="0" />
              <%}%>
            </span>
          </td>
        </tr>
        <tr class="forum">
          <td class="spaceRow" colspan="6" height="1"><img src="templates/mytemp/Forum/images/spacer.gif" alt="" width="1" height="1" /></td>
        </tr>
<%
   } /* End while() */    
%>
        <tr class="forum">
          <td class="spaceRow" colspan="6" height="1"><img src="images/spacer.gif" alt="" width="1" height="1" /></td>
        </tr>
        <tr class="forum" align="center">
          <td class="catBottom" colspan="6" height="28">
            <table class="forum" cellspacing="0" cellpadding="0" border="0">
		  <tr class="forum">
		    <td class="forum" align="center"><span class="gensmall"><div></div></span></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
<%@ include file="template_parts/bottom.jsp" %>