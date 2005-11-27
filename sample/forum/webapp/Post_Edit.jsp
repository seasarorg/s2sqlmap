<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.forum.*"%>
<%@ page import="com.example.forum.domainmodel.*"%>
<%
ForumService forum = (ForumService)ConponentConfigurer.getComponent(application, "forum");
%>

<%@ include file="template_parts/top.jsp" %>
 
      <table class="forumline" cellspacing="1" cellpadding="3" width="94%" border="0">
        <tr class="forum"> 
          <th class="forum" nowrap="nowrap" width="150" height="26">Author</th>
          <th class="forum" nowrap="nowrap">Message</th>
        </tr>
<!-- BEGIN EDIT POST -->
<%   
   int post_index     = TypeUtils.toInt(request.getParameter("post_index"), 0);
   String referring_page = request.getParameter("referring_page");
   PostModel post        = forum.findPost(post_index);
   if(null != post){ 
%>
     <tr class="forum"> 
          <td class="forum" width="150" class="row1" valign="top" align="left"> 
            <span class="name"><b>[<%=post.getUser()%>]</b></span> 
            <br /> <span class="postdetails"> <br />
            <br />
            </span> <br /> 
          </td>
          <td class="row1" valign="top" height="28" width="100%">
            <table class="forum" cellspacing="0" cellpadding="0" width="98%">
              <tr class="forum"> 
                <td class="forum" colspan="2" valign="top"> 
                  <span class="postbody">  
                    <form type="post" action="Post_Save.jsp">
                      <TEXTAREA style="WIDTH: 90%" name="post" rows="14" wrap="virtual" cols="35"><%=post.getText()%></TEXTAREA><br>
                      <input type="submit" value="Save Changes">
                      <input type="hidden" name="action" value="UPDATE_POST">
                      <input type="hidden" name="post_index" value="<%=post_index%>">
                      <input type="hidden" name="thread_index" value="<%=post.getThread_index()%>">
                      <input type="hidden" name="referring_page" value="<%=referring_page%>">
                      <input type="hidden" name="user" value="<%=post.getUser()%>">
                    </form>
                  </span> 
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr class="forum">
          <td class="spaceRow" colspan="2" height="1"><img src="images/spacer.gif" alt="" width="1" height="1" /></td>
        </tr>
<!-- END ADD NEW POST -->

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

<%}%>
<%@ include file="template_parts/bottom.jsp" %>