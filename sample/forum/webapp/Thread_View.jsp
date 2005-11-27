<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.forum.*"%>
<%@ page import="com.example.forum.domainmodel.*"%>
<%
ForumService forum = (ForumService)ConponentConfigurer.getComponent(application, "forum");
%>

<%@ include file="template_parts/top.jsp" %>

<%   
   String thread_index   = request.getParameter("thread_index");
   String user = null;
   String username="foobar";

   
   List list = forum.listThreads(TypeUtils.toInt(thread_index, -1));
   Iterator i=list.iterator();
%>
      <table class="forumline" cellspacing="1" cellpadding="3" width="94%" border="0">
        <tr class="forum"> 
          <th class="forum" nowrap="nowrap" width="150" height="26">Author</th>
          <th class="forum" nowrap="nowrap">Message</th>
        </tr>
<!-- BEGIN POSTS -->
<% while(i.hasNext()){
    ThreadModel t = (ThreadModel)i.next(); %>
        <tr class="forum"> 
          <td class="forum" width="150" class="row1" valign="top" align="left"> 
            <span class="name"><b> [<%=t.getUser()%>]</b></span> 
            <br /> <span class="postdetails"> <br />
            <br />
            </span> <br /> 
          </td>
          <td class="row1" valign="top" height="28" width="100%">
            <table class="forum" cellspacing="0" cellpadding="0" width="98%">
              <tr class="forum"> 
                <td class="forum" width="80%"> 
                  <span class="postdetails"> <img src="images/icon_minipost.gif" />
                    <%=t.getTimestamp()%>
                    <%--&nbsp;&nbsp;Subject: 
                    <a name="1911" id="1911">private access method</a>--%>
                  </span> 
                </td>
                <td class="forum" valign="top" width="20%" nowrap="nowrap" align="right">
<% if(username.equalsIgnoreCase(t.getUser())){%>
                  <a href="Post_Edit.jsp?post_index=<%=t.getIndex()%>">
                    <img src="images/icon_edit.gif" border="0" />
                  </a> 
<% }%>
                </td>
              </tr>
              <tr class="forum"> 
                <td class="forum" colspan="2"><hr /></td>
              </tr>
              <tr class="forum"> 
                <td class="forum" colspan="2" valign="top"> 
                  <span class="postbody">  
                    <%=t.getText()%>
                  </span> 
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr class="forum">
          <td class="spaceRow" colspan="2" height="1"><img src="images/spacer.gif" alt="" width="1" height="1" /></td>
        </tr>
<% } /* End while() */ %>
<!-- END OF POSTS -->
<!-- BEGIN ADD NEW POST -->
     <tr class="forum"> 
          <td class="forum" width="150" class="row1" valign="top" align="left"> 
            <span class="name"><b>[<%=username%>]</b></span> 
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
                      <TEXTAREA style="WIDTH: 90%" name="post" rows="14" wrap="virtual" cols="35"></TEXTAREA><br>
                      <input type="submit" value="Submit Post">
                      <input type="hidden" name="action" value="ADD_POST">
                      <input type="hidden" name="thread_index" value="<%=thread_index%>">
                      <input type="hidden" name="user" value="<%=username%>">
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

<%@ include file="template_parts/bottom.jsp" %>